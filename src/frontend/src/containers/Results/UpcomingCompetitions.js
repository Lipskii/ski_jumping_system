import {Accordion, Card, ListGroup} from "react-bootstrap";
import React from "react";

const UpcomingCompetitions = (props) => {

    return (
        <div>

                <Card style={{
                    margin: 'auto',
                    borderRadius: "15px",
                }}>
                    <Accordion.Toggle as={Card.Header} eventKey={props.eventKey}>
                        Upcoming competitions
                    </Accordion.Toggle>
                    {/*<Card.Header></Card.Header>*/}
                    <Accordion.Collapse eventKey={props.eventKey}>
                    <ListGroup variant="flush">
                        {props.competitions.slice(0, 5).reverse().map(competition => (
                            <ListGroup.Item style={{fontSize: "14px"}}
                                            key={competition.id}><b>{competition.date1} </b> {competition.seriesMajor.name} - {competition.hillVersion
                                .hill.venue.city.name} <img
                                    alt={competition.hillVersion.hill.venue.city.region.country.code}
                                    src={'./flags/' + competition.hillVersion.hill.venue.city.region.country.code + '.png'}
                                    style={{height: "15px", marginRight: "5px"}}/>
                                <small> (HS:{competition.hillVersion.hillSize} m)</small></ListGroup.Item>
                        ))}
                    </ListGroup>
                    </Accordion.Collapse>
                </Card>
        </div>

    )
}

export default UpcomingCompetitions

