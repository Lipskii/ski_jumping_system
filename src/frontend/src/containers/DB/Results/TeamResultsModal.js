import React, {useEffect} from "react";
import {Modal, Table} from "react-bootstrap";


const TeamResultsModal = (props) => {
    useEffect(() => console.log(props))

    return (
        <Modal show={props.show} onHide={props.onHide} size={"xl"} scrollable={true}>
            <Modal.Header closeButton>
                <Modal.Title>Results
                    of {props.results[0].competition.date1}: {props.results[0].competition.seriesMajor.name} {props.results[0].competition.seriesMinor !== null ?
                        <small>({props.results[0].competition.seriesMinor.name})</small> : null}</Modal.Title>
                <br/>
            </Modal.Header>
            <Modal.Body>
                <ul>
                    <h5>Results:</h5>
                    <Table bordered hover striped size={"sm"}>
                        <thead>
                        <tr>
                            <th>Rank</th>
                            <th>Country</th>
                            <th>Jumpers</th>
                            <th>Total points</th>
                        </tr>
                        </thead>
                        <tbody>
                        {props.results.map(result => (
                            <tr>
                                <td>
                                    {result.totalRank}
                                </td>
                                <td>
                                    {result.country.name}
                                </td>
                                <td>
                                    <ol>
                                        <li>{result.teamResultsIndividual[0] !== undefined ?
                                            <>{result.teamResultsIndividual[0].skiJumper.person.firstName} {result.teamResultsIndividual[0].skiJumper.person.lastName}</>
                                            : <>no info</>}
                                        </li>
                                        <li>{result.teamResultsIndividual[1] !== undefined ?
                                            <>{result.teamResultsIndividual[1].skiJumper.person.firstName} {result.teamResultsIndividual[1].skiJumper.person.lastName}</>
                                            : <>no info</>}
                                        </li>
                                        <li>{result.teamResultsIndividual[2] !== undefined ?
                                            <>{result.teamResultsIndividual[2].skiJumper.person.firstName} {result.teamResultsIndividual[2].skiJumper.person.lastName}</>
                                            : <>no info</>}
                                        </li>
                                        <li>{result.teamResultsIndividual[3] !== undefined ?
                                            <>{result.teamResultsIndividual[3].skiJumper.person.firstName} {result.teamResultsIndividual[3].skiJumper.person.lastName}</>
                                            : <>no info</>}
                                        </li>
                                    </ol>
                                </td>
                                <td>{result.totalPoints}</td>
                            </tr>

                        ))}
                        </tbody>
                    </Table>
                </ul>
            </Modal.Body>
        </Modal>
    )
}

export default TeamResultsModal