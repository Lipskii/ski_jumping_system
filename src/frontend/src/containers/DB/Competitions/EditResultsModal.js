import React, {useEffect} from "react";
import {Modal} from "react-bootstrap";
import EditableTable from "./EditResultsTable";

const EditResultsModal = (props) => {
    useEffect(() => console.log(props))

    return (
        <Modal show={props.show} onHide={props.onHide} size={"xl"} scrollable={true}>
            <Modal.Header closeButton>
                <Modal.Title>
                    Results
                </Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <EditableTable competition={props.competition}/>
            </Modal.Body>
        </Modal>
    )
}

export default EditResultsModal