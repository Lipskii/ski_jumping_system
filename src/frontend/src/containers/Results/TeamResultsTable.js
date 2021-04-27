import {Table} from "react-bootstrap";
import React from "react";
import ResultsTableAthleteRow from "./ResultsTableAthleteRow";
import TeamResultsTableCountryRow from "./TeamResultsTableCountryRow";
import {LinkContainer} from "react-router-bootstrap";

const TeamResultsTable = (props) => {

    const bestScore = props.results[0].totalPoints

    return (
        <div style={{marginTop: "20px", width: "100%"}}>

            <Table bordered hover striped size={"sm"}>
                <th style={{width: "15px", textAlign: "center"}}>Rank</th>
                <th/>
                <th>Jumpers</th>
                <th>Total Score</th>
                <th>Difference</th>
                <tbody>
                {props.results.map(result => (
                        <tr key={result.id} id={result.id}>
                            <td style={{textAlign: "center"}}>
                                <div>{result.totalRank}.</div>
                            </td>
                            <TeamResultsTableCountryRow country={result.country}/>
                            <td>
                                <ul>
                                    {result.teamResultsIndividual[0] !== undefined ?
                                        <LinkContainer to={"/skiJumper/" + result.teamResultsIndividual[0].skiJumper.id}
                                                       style={{cursor: "pointer"}}>
                                            <li>
                                                {result.teamResultsIndividual[0].skiJumper.person.firstName} {result.teamResultsIndividual[0].skiJumper.person.lastName}
                                            </li>
                                        </LinkContainer> : null}
                                    {result.teamResultsIndividual[1] !== undefined ?
                                        <LinkContainer to={"/skiJumper/" + result.teamResultsIndividual[1].skiJumper.id}
                                                       style={{cursor: "pointer"}}>
                                            <li>
                                                {result.teamResultsIndividual[1].skiJumper.person.firstName} {result.teamResultsIndividual[1].skiJumper.person.lastName}
                                            </li>
                                        </LinkContainer> : null}
                                    {result.teamResultsIndividual[2]!== undefined ?
                                        <LinkContainer to={"/skiJumper/" + result.teamResultsIndividual[2].skiJumper.id}
                                                       style={{cursor: "pointer"}}>
                                            <li>
                                                {result.teamResultsIndividual[2].skiJumper.person.firstName} {result.teamResultsIndividual[2].skiJumper.person.lastName}
                                            </li>
                                        </LinkContainer> : null}
                                    {result.teamResultsIndividual[3] !== undefined ?
                                        <LinkContainer to={"/skiJumper/" + result.teamResultsIndividual[3].skiJumper.id}
                                                       style={{cursor: "pointer"}}>
                                            <li>
                                                result.teamResultsIndividual[3].skiJumper.person.firstName} {result.teamResultsIndividual[3].skiJumper.person.lastName}
                                            </li>
                                        </LinkContainer> : null}
                                </ul>
                            </td>
                            <td><b>{result.totalPoints !== 0 ? <div>{result.totalPoints} p.</div> : <div>DSQ</div>}</b></td>
                            <td>{result.totalPoints === bestScore ? <div/> :
                                <div>-{(bestScore - result.totalPoints).toFixed(1)}</div>}</td>
                        </tr>
                    )
                )}
                </tbody>
            </Table>


        </div>


    )
}

export default TeamResultsTable

