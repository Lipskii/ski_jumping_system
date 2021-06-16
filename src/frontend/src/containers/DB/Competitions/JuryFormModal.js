import React, { useState} from "react";
import {Header3, StyledDiv2Right1200} from "../../../components/StyledComponents";
import {Button, Modal,} from "react-bootstrap";
import SelectInputForm from "../../../components/CommonForms/SelectInputForm";
import AddingModal from "../../../components/Modals/AddingModal";
import axios from "axios";
import CompletedModal from "../../../components/Modals/CompletedModal";


const JuryFormModal = (props) => {
    const [competition, setCompetition] = useState(props.competition)
    const [selectedJuryId, setSelectedJuryId] = useState("")
    const [showAddingModal, setShowAddingModal] = useState(false)
    const [showCompletedModal, setShowCompletedModal] = useState(false)
    const [completedModalText, setCompletedModalText] = useState("")
    const [completedModalStatus, setCompletedModalStatus] = useState(true)

    const addJuryCompetition = () => {
        setShowAddingModal(true)
        axios.post("/api/juryCompetition", {
            jury: props.jury.find(jury => jury.id === parseInt(selectedJuryId)),
            competition: competition
        })
            .then(res => {
                console.log(res.data)
                axios.get("/api/competitions?id=" + competition.id)
                    .then((res) => {
                        setCompetition(res.data[0])
                        setCompletedModalText("Jury added successfully.")
                        setCompletedModalStatus(true)
                        setShowAddingModal(false)
                        setShowCompletedModal(true)
                    })
                    .catch(e => console.log(e))

            })
            .catch(e => {
                console.log(e)
                setCompletedModalText("Something went wrong. Please, try again.")
                setCompletedModalStatus(false)
                setShowAddingModal(false)
                setShowCompletedModal(true)
            })
    }
    const deleteJuryCompetition = (id) => {
        setShowAddingModal(true)
        axios.delete("/api/juryCompetition/" + id)
            .then(res => {
                console.log(res.data)
                axios.get("/api/competitions?id=" + competition.id)
                    .then((res) => {
                        setCompetition(res.data[0])
                        setCompletedModalText("Jury deleted successfully.")
                        setCompletedModalStatus(true)
                        setShowAddingModal(false)
                        setShowCompletedModal(true)
                    })
                    .catch(e => console.log(e))

            })
            .catch(e => {
                console.log(e)
                setCompletedModalText("Something went wrong. Please, try again.")
                setCompletedModalStatus(false)
                setShowAddingModal(false)
                setShowCompletedModal(true)
            })
    }

    return (
        <React.Fragment>

            <AddingModal show={showAddingModal}/>
            <CompletedModal
                show={showCompletedModal}
                text={completedModalText}
                onHide={() => setShowCompletedModal(false)}
                status={completedModalStatus}
            />
            <Modal show={props.show} size={"xl"} scrollable={true} onHide={props.onHide}>
                <Modal.Header closeButton>
                    <Header3>Jury
                        for {props.competition.date1} {props.competition.seriesMajor.name} in {props.competition.hillVersion.hill.venue.city.name}</Header3>
                </Modal.Header>
                <Modal.Body>
                    <p>Current jury for competition: </p>
                    <ul>
                        {competition.juryCompetition.map(juryCompetition => (
                            <div>
                            <li>
                                <strong>{juryCompetition.jury.juryType.juryType}</strong> {juryCompetition.jury.person.firstName} {juryCompetition.jury.person.lastName}
                            </li>
                                <Button
                                    variant={"outline-danger"}
                                    size="sm"
                                    onClick={() => deleteJuryCompetition(juryCompetition.id)}
                                >
                                    Remove
                                </Button>
                            </div>
                        ))
                        }
                    </ul>
                    <bl/>
                    <SelectInputForm
                        title={"New jury:"}
                        defaultValue={""}
                        onChange={e => {
                            setSelectedJuryId(e.target.value)
                        }}
                    >
                        <option value={""} disabled>Choose</option>
                        {props.jury.map(jury =>
                            <option key={jury.id} value={jury.id}>
                                {jury.person.firstName} {jury.person.lastName}, {jury.juryType.juryType}
                            </option>)}
                    </SelectInputForm>

                    <StyledDiv2Right1200>
                        <Button onClick={() => addJuryCompetition()} disabled={selectedJuryId === ''}>Add Jury</Button>
                    </StyledDiv2Right1200>
                </Modal.Body>
            </Modal>

        </React.Fragment>
    )
}

export default JuryFormModal