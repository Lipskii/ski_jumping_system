import {Modal, Table} from "react-bootstrap";
import React from "react";

const DetailedResultsModal = (props) => {

    return (
        <Modal show={props.show} size={"m"} scrollable={true} onHide={props.onHide}>
            <Modal.Header closeButton>
                <h3 style={{textAlign: "center"}}>
                    {props.result.totalRank}. {props.result.skiJumper.person.firstName} {props.result.skiJumper.person.lastName}
                </h3>
            </Modal.Header>
            <Table striped hover>
                <tbody>

                {props.result.firstRoundSpeed !== null ?
                    <tr>
                        <td>1. round speed</td>
                        <td>{props.result.firstRoundSpeed} km/h</td>
                    </tr> : null
                }
                {props.result.firstRoundDistance !== null ?
                    <tr>
                        <td>1. round distance</td>
                        <td>{props.result.firstRoundDistance} m</td>
                    </tr> : null
                }
                {props.result.firstRoundDistancePoints !== null ?
                    <tr>
                        <td>1. round distance points</td>
                        <td>{props.result.firstRoundDistancePoints} p.</td>
                    </tr> : null
                }
                {props.result.firstRoundGate !== null ?
                    <tr>
                        <td>1. round gate</td>
                        <td>{props.result.firstRoundGate}</td>
                    </tr> : null
                }

                <tr>
                    <td>1. round gate coach request</td>
                    <td>{props.result.firstRoundGateCoachRequest ? <div>yes</div> : <div>no</div>}</td>
                </tr>

                {props.result.firstRoundJudgeA !== null ?
                    <tr>
                        <td>1. round judge A score</td>
                        <td>{props.result.firstRoundJudgeA} p.</td>
                    </tr>
                    :
                    null
                }
                {props.result.firstRoundJudgeB !== null ?
                    <tr>
                        <td>1. round judge B score</td>
                        <td>{props.result.firstRoundJudgeB} p.</td>
                    </tr>
                    :
                    null
                }
                {props.result.firstRoundJudgeC !== null ?
                    <tr>
                        <td>1. round judge D score</td>
                        <td>{props.result.firstRoundJudgeC} p.</td>
                    </tr>
                    :
                    null
                }

                {props.result.firstRoundJudgeD !== null ?
                    <tr>
                        <td>1. round judge D score</td>
                        <td>{props.result.firstRoundJudgeD} p.</td>
                    </tr>
                    :
                    null
                }

                {props.result.firstRoundJudgeE !== null ?
                    <tr>
                        <td>1. round judge E score</td>
                        <td>{props.result.firstRoundJudgeE} p.</td>
                    </tr>
                    :
                    null
                }

                {props.result.firstRoundJudgePoints !== null ?
                    <tr>
                        <td>1. round sum of judge points</td>
                        <td>{props.result.firstRoundJudgePoints} p.</td>
                    </tr>
                    :
                    null
                }

                {props.result.firstRoundWind !== null ?
                    <tr>
                        <td>1. round wind</td>
                        <td>{props.result.firstRoundWind}</td>
                    </tr>
                    :
                    null
                }

                {props.result.firstRoundWindPoints !== null ?
                    <tr>
                        <td>1. round wind points</td>
                        <td>{props.result.firstRoundWindPoints}</td>
                    </tr>
                    :
                    null
                }
                {props.result.firstRoundTotal !== null ?
                    <tr>
                        <td>1. round total points</td>
                        <td>{props.result.firstRoundTotal} p.</td>
                    </tr>
                    :
                    null
                }

                {props.result.firstRoundRank !== null && props.result.firstRoundRank !== 0 ?
                    <tr>
                        <td>1. round rank</td>
                        <td>{props.result.firstRoundRank}</td>
                    </tr>
                    :
                    null
                }
                {props.result.secondRoundDistance !== null && props.result.secondRoundDistance !== 0 ?
                    <>
                {props.result.secondRoundSpeed !== null ?
                    <tr>
                        <td>2. round speed</td>
                        <td>{props.result.secondRoundSpeed} km/h</td>
                    </tr> : null
                }
                    <tr>
                        <td>2. round distance</td>
                        <td>{props.result.secondRoundDistance} m</td>
                    </tr>

                {props.result.secondRoundDistancePoints !== null ?
                    <tr>
                        <td>2. round distance points</td>
                        <td>{props.result.secondRoundDistancePoints} p.</td>
                    </tr> : null
                }
                {props.result.secondRoundGate !== null ?
                    <tr>
                        <td>2. round gate</td>
                        <td>{props.result.secondRoundGate}</td>
                    </tr> : null
                }

                <tr>
                    <td>2. round gate coach request</td>
                    <td>{props.result.secondRoundGateCoachRequest ? <div>yes</div> : <div>no</div>}</td>
                </tr>

                {props.result.secondRoundJudgeA !== null ?
                    <tr>
                        <td>2. round judge A score</td>
                        <td>{props.result.secondRoundJudgeA} p.</td>
                    </tr>
                    :
                    null
                }
                {props.result.secondRoundJudgeB !== null ?
                    <tr>
                        <td>2. round judge B score</td>
                        <td>{props.result.secondRoundJudgeB} p.</td>
                    </tr>
                    :
                    null
                }
                {props.result.secondRoundJudgeC !== null ?
                    <tr>
                        <td>2. round judge D score</td>
                        <td>{props.result.secondRoundJudgeC} p.</td>
                    </tr>
                    :
                    null
                }

                {props.result.secondRoundJudgeD !== null ?
                    <tr>
                        <td>2. round judge D score</td>
                        <td>{props.result.secondRoundJudgeD} p.</td>
                    </tr>
                    :
                    null
                }

                {props.result.secondRoundJudgeE !== null ?
                    <tr>
                        <td>2. round judge E score</td>
                        <td>{props.result.secondRoundJudgeE} p.</td>
                    </tr>
                    :
                    null
                }

                {props.result.secondRoundJudgePoints !== null ?
                    <tr>
                        <td>2. round sum of judge points</td>
                        <td>{props.result.secondRoundJudgePoints} p.</td>
                    </tr>
                    :
                    null
                }

                {props.result.secondRoundWind !== null ?
                    <tr>
                        <td>2. round wind</td>
                        <td>{props.result.secondRoundWind}</td>
                    </tr>
                    :
                    null
                }

                {props.result.secondRoundWindPoints !== null ?
                    <tr>
                        <td>2. round wind points</td>
                        <td>{props.result.secondRoundWindPoints}</td>
                    </tr>
                    :
                    null
                }
                {props.result.secondRoundTotal !== null ?
                    <tr>
                        <td>2. round total points</td>
                        <td>{props.result.secondRoundTotal} p.</td>
                    </tr>
                    :
                    null
                }

                {props.result.secondRoundRank !== null && props.result.secondRoundRank !== 0 ?
                    <tr>
                        <td>2. round rank</td>
                        <td>{props.result.secondRoundRank}</td>
                    </tr>
                    :
                    null
                }
                    </> : null}

                {props.result.thirdRoundDistance !== null && props.result.thirdRoundDistance !== 0 ?
                    <>
                        {props.result.thirdRoundSpeed === null ?
                            <tr>
                                <td>3. round speed</td>
                                <td>{props.result.thirdRoundSpeed} km/h</td>
                            </tr> : null
                        }

                            <tr>
                                <td>3. round distance</td>
                                <td>{props.result.thirdRoundDistance} m</td>
                            </tr>
                        }
                        {props.result.thirdRoundDistancePoints !== null ?
                            <tr>
                                <td>3. round distance points</td>
                                <td>{props.result.thirdRoundDistancePoints} p.</td>
                            </tr> : null
                        }
                        {props.result.thirdRoundGate !== null ?
                            <tr>
                                <td>3. round gate</td>
                                <td>{props.result.thirdRoundGate}</td>
                            </tr> : null
                        }

                        <tr>
                            <td>3. round gate coach request</td>
                            <td>{props.result.thirdRoundGateCoachRequest ? <div>yes</div> : <div>no</div>}</td>
                        </tr>

                        {props.result.thirdRoundJudgeA !== null ?
                            <tr>
                                <td>3. round judge A score</td>
                                <td>{props.result.thirdRoundJudgeA} p.</td>
                            </tr>
                            :
                            null
                        }
                        {props.result.thirdRoundJudgeB !== null ?
                            <tr>
                                <td>3. round judge B score</td>
                                <td>{props.result.thirdRoundJudgeB} p.</td>
                            </tr>
                            :
                            null
                        }
                        {props.result.thirdRoundJudgeC !== null ?
                            <tr>
                                <td>3. round judge D score</td>
                                <td>{props.result.thirdRoundJudgeC} p.</td>
                            </tr>
                            :
                            null
                        }

                        {props.result.thirdRoundJudgeD !== null ?
                            <tr>
                                <td>3. round judge D score</td>
                                <td>{props.result.thirdRoundJudgeD} p.</td>
                            </tr>
                            :
                            null
                        }

                        {props.result.thirdRoundJudgeE !== null ?
                            <tr>
                                <td>3. round judge E score</td>
                                <td>{props.result.thirdRoundJudgeE} p.</td>
                            </tr>
                            :
                            null
                        }

                        {props.result.thirdRoundJudgePoints !== null ?
                            <tr>
                                <td>3. round sum of judge points</td>
                                <td>{props.result.thirdRoundJudgePoints} p.</td>
                            </tr>
                            :
                            null
                        }

                        {props.result.thirdRoundWind !== null ?
                            <tr>
                                <td>3. round wind</td>
                                <td>{props.result.thirdRoundWind}</td>
                            </tr>
                            :
                            null
                        }

                        {props.result.thirdRoundWindPoints !== null ?
                            <tr>
                                <td>3. round wind points</td>
                                <td>{props.result.thirdRoundWindPoints}</td>
                            </tr>
                            :
                            null
                        }
                        {props.result.thirdRoundTotal !== null ?
                            <tr>
                                <td>3. round total points</td>
                                <td>{props.result.thirdRoundTotal} p.</td>
                            </tr>
                            :
                            null
                        }

                        {props.result.thirdRoundRank !== null && props.thirdRoundRank !== 0 ?
                            <tr>
                                <td>3. round rank</td>
                                <td>{props.result.thirdRoundRank}</td>
                            </tr>
                            :
                            null
                        }
                    </>: null}

                {props.result.fourthRoundDistance !== null && props.result.fourthRoundDistance !== 0 ?
                    <>
                        {props.result.fourthRoundSpeed === null ?
                            <tr>
                                <td>4. round speed</td>
                                <td>{props.result.fourthRoundSpeed} km/h</td>
                            </tr> : null
                        }

                        <tr>
                            <td>4. round distance</td>
                            <td>{props.result.fourthRoundDistance} m</td>
                        </tr>
                        }
                        {props.result.fourthRoundDistancePoints !== null ?
                            <tr>
                                <td>4. round distance points</td>
                                <td>{props.result.fourthRoundDistancePoints} p.</td>
                            </tr> : null
                        }
                        {props.result.fourthRoundGate !== null ?
                            <tr>
                                <td>4. round gate</td>
                                <td>{props.result.fourthRoundGate}</td>
                            </tr> : null
                        }

                        <tr>
                            <td>4. round gate coach request</td>
                            <td>{props.result.fourthRoundGateCoachRequest ? <div>yes</div> : <div>no</div>}</td>
                        </tr>

                        {props.result.fourthRoundJudgeA !== null ?
                            <tr>
                                <td>4. round judge A score</td>
                                <td>{props.result.fourthRoundJudgeA} p.</td>
                            </tr>
                            :
                            null
                        }
                        {props.result.fourthRoundJudgeB !== null ?
                            <tr>
                                <td>4. round judge B score</td>
                                <td>{props.result.fourthRoundJudgeB} p.</td>
                            </tr>
                            :
                            null
                        }
                        {props.result.fourthRoundJudgeC !== null ?
                            <tr>
                                <td>4. round judge D score</td>
                                <td>{props.result.fourthRoundJudgeC} p.</td>
                            </tr>
                            :
                            null
                        }

                        {props.result.fourthRoundJudgeD !== null ?
                            <tr>
                                <td>4. round judge D score</td>
                                <td>{props.result.fourthRoundJudgeD} p.</td>
                            </tr>
                            :
                            null
                        }

                        {props.result.fourthRoundJudgeE !== null ?
                            <tr>
                                <td>4. round judge E score</td>
                                <td>{props.result.fourthRoundJudgeE} p.</td>
                            </tr>
                            :
                            null
                        }

                        {props.result.fourthRoundJudgePoints !== null ?
                            <tr>
                                <td>4. round sum of judge points</td>
                                <td>{props.result.fourthRoundJudgePoints} p.</td>
                            </tr>
                            :
                            null
                        }

                        {props.result.fourthRoundWind !== null ?
                            <tr>
                                <td>4. round wind</td>
                                <td>{props.result.fourthRoundWind}</td>
                            </tr>
                            :
                            null
                        }

                        {props.result.fourthRoundWindPoints !== null ?
                            <tr>
                                <td>4. round wind points</td>
                                <td>{props.result.fourthRoundWindPoints}</td>
                            </tr>
                            :
                            null
                        }
                        {props.result.fourthRoundTotal !== null ?
                            <tr>
                                <td>4. round total points</td>
                                <td>{props.result.fourthRoundTotal} p.</td>
                            </tr>
                            :
                            null
                        }

                        {props.result.fourthRoundRank !== null && props.fourthRoundRank !== 0 ?
                            <tr>
                                <td>4. round rank</td>
                                <td>{props.result.fourthRoundRank}</td>
                            </tr>
                            :
                            null
                        }
                    </>: null}


                </tbody>


            </Table>

        </Modal>
    )

}

export default DetailedResultsModal