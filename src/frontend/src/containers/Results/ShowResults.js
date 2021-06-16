import React, {Component} from "react";
import axios from "axios";
import {AccordionWithPadding} from "../../components/StyledComponents";
import Loader from "react-loader-spinner";
import fisLogo from "../../assets/fis_logo.png";
import {Accordion, Card, Col, Container, ListGroup, Row} from "react-bootstrap";
import ResultsTable from "./ResultsTable";
import TeamResultsTable from "./TeamResultsTable";


class ShowResults extends Component {
    state = {
        competition: '',
        locationFlag: '',
        raceDirectorFlag: '',
    }


    componentDidMount() {
        axios.get("/api/competitions?id=" + this.props.match.params.competition)
            .then(res => {
                this.setState({
                    competition: res.data[0],
                }, () => {
                    this.loadFlag(this.state.competition.hillVersion.hill.venue.city.region.country.code)
                })
            })
            .catch(error => {
                console.log(error)
            })

    }

    loadFlag = (code) => {
        if (code !== undefined) {
            import(`../../assets/flags/${code}.png`)
                .then(res => {
                    this.setState({
                        locationFlag: res.default
                    })
                })
        }
    }


    render() {

        console.log(this.state)

        return (
            <div style={{marginLeft: "30px", paddingBottom: "10px"}}>


                {this.state.competition !== '' ?

                    <Container fluid>
                        <Row>
                            <Col sm={8}>
                                <Row>
                                    <h3 style={{margin: "auto", marginBottom: "10px"}}>
                                        <img
                                            width={64}
                                            height={64}
                                            className="mr-3"
                                            src={fisLogo}
                                            alt="Generic placeholder"
                                        /> {this.state.competition.seriesMajor.name} </h3>
                                </Row>
                                {this.state.competition.seriesMinor !== null ?
                                    <Row>
                                        <small style={{margin: "auto", marginBottom: "10px"}}>
                                            ({this.state.competition.seriesMinor.name})
                                        </small>
                                    </Row> : null}
                                <Row>
                                    {this.state.competition.team ?
                                        <TeamResultsTable results={this.state.competition.teamResults}/>
                                        : <ResultsTable results={this.state.competition.results}/>}
                                </Row>
                            </Col>

                            <Col sm={4}>
                                <div style={{
                                    borderRadius: "10px",
                                    paddingLeft: "10px",
                                }}>
                                    <div style={{marginBottom: "20px", height: "20%"}}>
                                        <AccordionWithPadding defaultActiveKey="0">
                                            <Card>
                                                <Accordion.Toggle as={Card.Header} eventKey="0">
                                                    Basic info
                                                </Accordion.Toggle>
                                                <Accordion.Collapse eventKey="0">
                                                    <ListGroup variant="flush">
                                                        <ListGroup.Item style={{fontSize: "13px"}}>
                                                            <label style={{marginRight: "5px"}}>Date:</label>
                                                            <b>{this.state.competition.date1}</b>
                                                        </ListGroup.Item>
                                                        <ListGroup.Item style={{fontSize: "13px"}}>
                                                            <label style={{marginRight: "5px"}}>City:</label>
                                                            <img
                                                                alt={this.state.competition.hillVersion.hill.venue.city.region.country.code}
                                                                src={this.state.locationFlag}
                                                                style={{height: "15px", marginRight: "2px"}}/>
                                                            <b>  {this.state.competition.hillVersion.hill.venue.city.name}</b>
                                                        </ListGroup.Item>
                                                        <ListGroup.Item style={{fontSize: "13px"}}>
                                                            <label style={{marginRight: "5px"}}>Hill:</label>
                                                            <b>{this.state.competition.hillVersion.hill.name}</b>
                                                        </ListGroup.Item>
                                                        <ListGroup.Item style={{fontSize: "13px"}}>
                                                            <label style={{marginRight: "5px"}}>K:</label>
                                                            <b>{this.state.competition.hillVersion.kPoint} m</b>
                                                        </ListGroup.Item>
                                                        {this.state.competition.hillVersion.hillSize !== null ?
                                                            <ListGroup.Item style={{fontSize: "13px"}}>
                                                                <label style={{marginRight: "5px"}}>HS:</label>
                                                                <b>{this.state.competition.hillVersion.hillSize} m</b>
                                                            </ListGroup.Item>
                                                            : null}
                                                    </ListGroup>
                                                </Accordion.Collapse>
                                            </Card>
                                            <Card>
                                                <Accordion.Toggle as={Card.Header} eventKey="3">
                                                    Detailed info
                                                </Accordion.Toggle>
                                                <Accordion.Collapse eventKey="3">
                                                    <ListGroup variant="flush">
                                                        <ListGroup.Item style={{fontSize: "13px"}}>
                                                            <label style={{marginRight: "5px"}}>Date:</label>
                                                            <b>{this.state.competition.date1}</b>
                                                        </ListGroup.Item>
                                                        {this.state.competition.date2 !== null ?
                                                        <ListGroup.Item>
                                                            <label style={{marginRight: "5px"}}>Date 2:</label>
                                                            <b>{this.state.competition.date2}</b>
                                                        </ListGroup.Item> : null}
                                                        {this.state.competition.juryCompetition.map(juryCompetition => (
                                                            <ListGroup.Item>
                                                                <label style={{marginRight: "5px"}}>{juryCompetition.jury.juryType.juryType}:</label>
                                                                <b>{juryCompetition.jury.person.firstName} {juryCompetition.jury.person.lastName}, {juryCompetition.jury.person.country.code}</b>
                                                            </ListGroup.Item>
                                                        ))}
                                                        {this.state.competition.gateFactor !== null  ?
                                                            <ListGroup.Item>
                                                                <label style={{marginRight: "5px"}}>Gate factor:</label>
                                                                <b>{this.state.competition.gateFactor}</b>
                                                            </ListGroup.Item> : null}
                                                        {this.state.competition.meterValue !== null  ?
                                                            <ListGroup.Item>
                                                                <label style={{marginRight: "5px"}}>Meter value:</label>
                                                                <b>{this.state.competition.meterValue}</b>
                                                            </ListGroup.Item> : null}
                                                        {this.state.competition.windFactorFront !== null  ?
                                                            <ListGroup.Item>
                                                                <label style={{marginRight: "5px"}}>Wind factor front:</label>
                                                                <b>{this.state.competition.windFactorFront}</b>
                                                            </ListGroup.Item> : null}
                                                        {this.state.competition.windFactorTail !== null  ?
                                                            <ListGroup.Item>
                                                                <label style={{marginRight: "5px"}}>Wind factor tail:</label>
                                                                <b>{this.state.competition.windFactorTail}</b>
                                                            </ListGroup.Item> : null}
                                                        {this.state.competition.firstRoundBaseGate !== null && this.state.competition.firstRoundBaseGate !== 0 ?
                                                            <ListGroup.Item>
                                                                <label style={{marginRight: "5px"}}>1. round base gate:</label>
                                                                <b>{this.state.competition.firstRoundBaseGate}</b>
                                                            </ListGroup.Item> : null}
                                                        {this.state.competition.firstRoundAirTempStart !== null  ?
                                                            <ListGroup.Item>
                                                                <label style={{marginRight: "5px"}}>1. round air temperature at start: </label>
                                                                <b>{this.state.competition.firstRoundAirTempStart} {"\u2103"}</b>
                                                            </ListGroup.Item> : null}
                                                        {this.state.competition.firstRoundAirTempFinish !== null  ?
                                                            <ListGroup.Item>
                                                                <label style={{marginRight: "5px"}}>1. round air temperature at finish:</label>
                                                                <b>{this.state.competition.firstRoundAirTempFinish} {"\u2103"}</b>
                                                            </ListGroup.Item> : null}
                                                        {this.state.competition.firstRoundSnowTempStart !== null  ?
                                                            <ListGroup.Item>
                                                                <label style={{marginRight: "5px"}}>1. round snow temperature at start:</label>
                                                                <b>{this.state.competition.firstRoundSnowTempStart} {"\u2103"}</b>
                                                            </ListGroup.Item> : null}
                                                        {this.state.competition.firstRoundSnowTempFinish !== null  ?
                                                            <ListGroup.Item>
                                                                <label style={{marginRight: "5px"}}>1. round snow temperature at finish:</label>
                                                                <b>{this.state.competition.firstRoundSnowTempFinish} {"\u2103"}</b>
                                                            </ListGroup.Item> : null}
                                                        {this.state.competition.firstRoundAvgWind !== null  ?
                                                            <ListGroup.Item>
                                                                <label style={{marginRight: "5px"}}>1. round average wind speed:</label>
                                                                <b>{this.state.competition.firstRoundAvgWind} m/s</b>
                                                            </ListGroup.Item> : null}
                                                        {this.state.competition.firstRoundMaxWind !== null  ?
                                                            <ListGroup.Item>
                                                                <label style={{marginRight: "5px"}}>1. round maximal wind speed:</label>
                                                                <b>{this.state.competition.firstRoundMaxWind} m/s</b>
                                                            </ListGroup.Item> : null}
                                                        {this.state.competition.firstRoundMinWind !== null  ?
                                                            <ListGroup.Item>
                                                                <label style={{marginRight: "5px"}}>1. round minimal wind speed:</label>
                                                                <b>{this.state.competition.firstRoundMinWind} m/s</b>
                                                            </ListGroup.Item> : null}
                                                        {this.state.competition.secondRoundBaseGate !== null && this.state.competition.secondRoundBaseGate !== 0 ?
                                                            <ListGroup.Item>
                                                                <label style={{marginRight: "5px"}}>2. round base gate:</label>
                                                                <b>{this.state.competition.secondRoundBaseGate}</b>
                                                            </ListGroup.Item> : null}
                                                        {this.state.competition.secondRoundAirTempStart !== null  ?
                                                            <ListGroup.Item>
                                                                <label style={{marginRight: "5px"}}>2. round air temperature at start: </label>
                                                                <b>{this.state.competition.secondRoundAirTempStart} {"\u2103"}</b>
                                                            </ListGroup.Item> : null}
                                                        {this.state.competition.secondRoundAirTempFinish !== null  ?
                                                            <ListGroup.Item>
                                                                <label style={{marginRight: "5px"}}>2. round air temperature at finish:</label>
                                                                <b>{this.state.competition.secondRoundAirTempFinish} {"\u2103"}</b>
                                                            </ListGroup.Item> : null}
                                                        {this.state.competition.secondRoundSnowTempStart !== null  ?
                                                            <ListGroup.Item>
                                                                <label style={{marginRight: "5px"}}>2. round snow temperature at start:</label>
                                                                <b>{this.state.competition.secondRoundSnowTempStart} {"\u2103"}</b>
                                                            </ListGroup.Item> : null}
                                                        {this.state.competition.secondRoundSnowTempFinish !== null  ?
                                                            <ListGroup.Item>
                                                                <label style={{marginRight: "5px"}}>2. round snow temperature at finish:</label>
                                                                <b>{this.state.competition.secondRoundSnowTempFinish} {"\u2103"}</b>
                                                            </ListGroup.Item> : null}
                                                        {this.state.competition.secondRoundAvgWind !== null  ?
                                                            <ListGroup.Item>
                                                                <label style={{marginRight: "5px"}}>2. round average wind speed:</label>
                                                                <b>{this.state.competition.secondRoundAvgWind} m/s</b>
                                                            </ListGroup.Item> : null}
                                                        {this.state.competition.secondRoundMaxWind !== null  ?
                                                            <ListGroup.Item>
                                                                <label style={{marginRight: "5px"}}>2. round maximal wind speed:</label>
                                                                <b>{this.state.competition.secondRoundMaxWind} m/s</b>
                                                            </ListGroup.Item> : null}
                                                        {this.state.competition.secondRoundMinWind !== null  ?
                                                            <ListGroup.Item>
                                                                <label style={{marginRight: "5px"}}>2. round minimal wind speed:</label>
                                                                <b>{this.state.competition.secondRoundMinWind} m/s</b>
                                                            </ListGroup.Item> : null}
                                                        {this.state.competition.thirdRoundBaseGate !== null && this.state.competition.thirdRoundBaseGate !== 0 ?
                                                            <ListGroup.Item>
                                                                <label style={{marginRight: "5px"}}>3. round base gate:</label>
                                                                <b>{this.state.competition.thirdRoundBaseGate}</b>
                                                            </ListGroup.Item> : null}
                                                        {this.state.competition.thirdRoundAirTempStart !== null  ?
                                                            <ListGroup.Item>
                                                                <label style={{marginRight: "5px"}}>3. round air temperature at start: </label>
                                                                <b>{this.state.competition.thirdRoundAirTempStart} {"\u2103"}</b>
                                                            </ListGroup.Item> : null}
                                                        {this.state.competition.thirdRoundAirTempFinish !== null  ?
                                                            <ListGroup.Item>
                                                                <label style={{marginRight: "5px"}}>3. round air temperature at finish:</label>
                                                                <b>{this.state.competition.thirdRoundAirTempFinish} {"\u2103"}</b>
                                                            </ListGroup.Item> : null}
                                                        {this.state.competition.thirdRoundSnowTempStart !== null  ?
                                                            <ListGroup.Item>
                                                                <label style={{marginRight: "5px"}}>3. round snow temperature at start:</label>
                                                                <b>{this.state.competition.thirdRoundSnowTempStart} {"\u2103"}</b>
                                                            </ListGroup.Item> : null}
                                                        {this.state.competition.thirdRoundSnowTempFinish !== null  ?
                                                            <ListGroup.Item>
                                                                <label style={{marginRight: "5px"}}>3. round snow temperature at finish:</label>
                                                                <b>{this.state.competition.thirdRoundSnowTempFinish} {"\u2103"}</b>
                                                            </ListGroup.Item> : null}
                                                        {this.state.competition.thirdRoundAvgWind !== null  ?
                                                            <ListGroup.Item>
                                                                <label style={{marginRight: "5px"}}>3. round average wind speed:</label>
                                                                <b>{this.state.competition.thirdRoundAvgWind} m/s</b>
                                                            </ListGroup.Item> : null}
                                                        {this.state.competition.thirdRoundMaxWind !== null  ?
                                                            <ListGroup.Item>
                                                                <label style={{marginRight: "5px"}}>3. round maximal wind speed:</label>
                                                                <b>{this.state.competition.thirdRoundMaxWind} m/s</b>
                                                            </ListGroup.Item> : null}
                                                        {this.state.competition.thirdRoundMinWind !== null  ?
                                                            <ListGroup.Item>
                                                                <label style={{marginRight: "5px"}}>3. round minimal wind speed:</label>
                                                                <b>{this.state.competition.thirdRoundMinWind} m/s</b>
                                                            </ListGroup.Item> : null}
                                                        {this.state.competition.fourthRoundBaseGate !== null && this.state.competition.fourthRoundBaseGate !== 0 ?
                                                            <ListGroup.Item>
                                                                <label style={{marginRight: "5px"}}>4. round base gate:</label>
                                                                <b>{this.state.competition.fourthRoundBaseGate}</b>
                                                            </ListGroup.Item> : null}
                                                        {this.state.competition.fourthRoundAirTempStart !== null  ?
                                                            <ListGroup.Item>
                                                                <label style={{marginRight: "5px"}}>4. round air temperature at start: </label>
                                                                <b>{this.state.competition.fourthRoundAirTempStart} {"\u2103"}</b>
                                                            </ListGroup.Item> : null}
                                                        {this.state.competition.fourthRoundAirTempFinish !== null  ?
                                                            <ListGroup.Item>
                                                                <label style={{marginRight: "5px"}}>4. round air temperature at finish:</label>
                                                                <b>{this.state.competition.fourthRoundAirTempFinish} {"\u2103"}</b>
                                                            </ListGroup.Item> : null}
                                                        {this.state.competition.fourthRoundSnowTempStart !== null  ?
                                                            <ListGroup.Item>
                                                                <label style={{marginRight: "5px"}}>4. round snow temperature at start:</label>
                                                                <b>{this.state.competition.fourthRoundSnowTempStart} {"\u2103"}</b>
                                                            </ListGroup.Item> : null}
                                                        {this.state.competition.fourthRoundSnowTempFinish !== null  ?
                                                            <ListGroup.Item>
                                                                <label style={{marginRight: "5px"}}>4. round snow temperature at finish:</label>
                                                                <b>{this.state.competition.fourthRoundSnowTempFinish} {"\u2103"}</b>
                                                            </ListGroup.Item> : null}
                                                        {this.state.competition.fourthRoundAvgWind !== null  ?
                                                            <ListGroup.Item>
                                                                <label style={{marginRight: "5px"}}>4. round average wind speed:</label>
                                                                <b>{this.state.competition.fourthRoundAvgWind} m/s</b>
                                                            </ListGroup.Item> : null}
                                                        {this.state.competition.fourthRoundMaxWind !== null  ?
                                                            <ListGroup.Item>
                                                                <label style={{marginRight: "5px"}}>4. round maximal wind speed:</label>
                                                                <b>{this.state.competition.fourthRoundMaxWind} m/s</b>
                                                            </ListGroup.Item> : null}
                                                        {this.state.competition.fourthRoundMinWind !== null  ?
                                                            <ListGroup.Item>
                                                                <label style={{marginRight: "5px"}}>4. round minimal wind speed:</label>
                                                                <b>{this.state.competition.fourthRoundMinWind} m/s</b>
                                                            </ListGroup.Item> : null}
                                                    </ListGroup>
                                                </Accordion.Collapse>
                                            </Card>
                                        </AccordionWithPadding>
                                    </div>
                                </div>
                            </Col>
                        </Row>

                    </Container>
                    :
                    <Loader
                        type="ThreeDots"
                        color="#00BFFF"
                        height={80}
                        width={80}
                        style={{textAlign: 'center'}}
                    />}
            </div>
        )
    }

}


export default ShowResults

