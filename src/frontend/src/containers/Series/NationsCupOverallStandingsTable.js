import {Table} from "react-bootstrap";
import React from "react";
import Loader from "react-loader-spinner";

const NationsCupOverallStandingsTable = (props) => {

    let bestScore = 0

    if (props.overallStandings.length > 0) {
        bestScore = props.overallStandings[0].points
    }


    return (
        <div>
            {!props.filterLoading ?
                <div>
                    <h3>
                        Nations Cup Standings
                    </h3>
                    {props.overallStandings.length > 0 ? <Table borderless hover striped size={"sm"}>
                            <th style={{textAlign: "center"}}>Rank</th>
                            <th/>
                            <th/>
                            <th/>
                            <tbody>
                            {props.overallStandings.map(overallStanding => (
                                        <tr key={overallStanding.id} id={overallStanding.id}>
                                            <td >{overallStanding.ranking !== 0 ? <div style={{textAlign: "center"}}>{overallStanding.ranking}.</div> :
                                                <div style={{textAlign: "center"}}>-</div>}</td>
                                            <td>
                                                <img
                                                    className="mr-3"
                                                    src={props.photos['flag_' + overallStanding.country.code]}
                                                    alt={overallStanding.country.code}
                                                />
                                            </td>
                                            <td>{overallStanding.country.name}</td>
                                            <td>{overallStanding.points}</td>
                                            <td>{overallStanding.points !== bestScore ?
                                                <small>- {(bestScore - overallStanding.points).toFixed(1)}</small> : null}</td>

                                        </tr>
                                )
                            )}
                            </tbody>
                        </Table>
                        :
                        <p>No standings yet</p>}
                </div>
                : <Loader
                    type="ThreeDots"
                    color="#00BFFF"
                    height={80}
                    width={80}
                    style={{textAlign: 'center'}}
                />}


        </div>


    )
}

export default NationsCupOverallStandingsTable