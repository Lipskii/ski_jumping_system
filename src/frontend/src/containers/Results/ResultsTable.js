import {Table} from "react-bootstrap";
import React, {useState} from "react";
import ResultsTableAthleteData from "./ResultsTableAthleteData";
import DetailedResultsModal from "./DetailedResultsModal";

const ResultsTable = (props) => {

    const [showModal, setShowModal] = useState(false)
    const [resultToModal, setResultToModal] = useState(false)

    const showDetailsModal = (result) => {
        setResultToModal(result)
        setShowModal(true)
    }

    let bestScore
    if (props.results.length > 0) {
        bestScore = props.results[0].totalPoints
    }
    return (
        <div style={{marginTop: "20px", width: "100%"}}>

            {showModal ?
                <DetailedResultsModal show={showModal} onHide={() => setShowModal(false)} result={resultToModal}/>
                : null }

            {props.results.length > 0 ? <Table bordered hover striped size={"sm"}>
                <th style={{width: "15px", textAlign: "center"}}>Rank</th>
                <th/>
                <th>1. Round</th>
                {props.results[0].secondRoundDistance !== 0 && props.results[0].secondRoundDistance !== null ?
                    <th>2. Round</th> : null}
                {props.results[0].thirdRoundDistance !== 0 && props.results[0].thirdRoundDistance !== null ?
                    <th>3. Round</th> : null}
                {props.results[0].fourthRoundDistance !== 0 && props.results[0].fourthRoundDistance !== null ?
                    <th>4. Round</th> : null}
                <th>Total Score</th>
                <th>Difference</th>
                <tbody>
                {props.results.map(result => (
                        <tr key={result.id} id={result.id}>
                            <td style={{textAlign: "center"}}>{result.totalRank !== 999 ? <div>{result.totalRank}.</div> :
                                <div>DSQ</div>}</td>

                            <ResultsTableAthleteData result={result}/>

                            <td>{result.firstRoundDistance !== 0 ? <div>{result.firstRoundDistance} m</div> :
                                <div>-</div>}

                            </td>

                            {props.results[0].secondRoundDistance !== 0 && props.results[0].secondRoundDistance !== null ?
                                <td>{result.secondRoundDistance !== 0 ? <div>{result.secondRoundDistance} m</div> :
                                    <div>-</div>}
                                </td>
                                : null}

                            {props.results[0].thirdRoundDistance !== 0 && props.results[0].thirdRoundDistance !== null ?
                                <td>{result.thirdRoundDistance !== 0 ? <div>{result.thirdRoundDistance} m</div> :
                                    <div>-</div>}
                                </td>
                                : null}

                            {props.results[0].fourthRoundDistance !== 0 && props.results[0].fourthRoundDistance !== null ?
                                <td>{result.fourthRoundDistance !== 0 ? <div>{result.fourthRoundDistance} m</div> :
                                    <div>-</div>}
                                </td>
                                : null}

                            <td>
                                <b>{result.totalPoints !== 0 ? <div>{result.totalPoints} p.</div> : <div>DSQ</div>}
                                </b>
                                <a onClick={() => showDetailsModal(result)}>details</a>
                            </td>
                            <td>{result.totalPoints === bestScore ? <div/> :
                                <div>-{(bestScore - result.totalPoints).toFixed(1)}</div>}</td>
                        </tr>
                    )
                )}
                </tbody>
            </Table> : <small>No results yet</small>}


        </div>


    )
}

export default ResultsTable

