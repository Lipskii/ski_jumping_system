import {Button, Col, Form, Modal, Row} from "react-bootstrap";
import {Formik} from "formik";
import * as Yup from "yup";
import React from "react";
import {ErrorLabel} from "../../../components/StyledComponents";

const FILE_SIZE = 500000 * 1024;
const SUPPORTED_FORMATS = [
    "image/jpg",
    "image/jpeg",
    "image/gif",
    "image/png"
];

const UploadHillPhotoModal = (props) => {

    return (
        <Modal show={props.show} onHide={props.onHide} size={"lg"} centered>
            <Modal.Header closeButton>
                <Modal.Title>Upload photo for {props.hill.name}</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <Formik
                    initialValues={{
                        file: '',
                        hill: props.hill
                    }}
                    validationSchema={Yup.object({
                        file: Yup.mixed()
                            .required("A file is required")
                            .test(
                                "fileSize",
                                "File too large",
                                value => value && value.size <= FILE_SIZE
                            )
                            .test(
                                "fileFormat",
                                "Unsupported Format",
                                value => value && SUPPORTED_FORMATS.includes(value.type)
                            )
                        }
                    )}

                    onSubmit={(values) => {
                        props.onSubmit(values)
                    }}
                >
                    {({
                          handleSubmit,
                          setFieldValue,
                          touched,
                          errors
                      }) => (
                        <Form onSubmit={(e) => {
                            e.preventDefault()
                            handleSubmit()
                        }}>
                            <Form.Group as={Row}>
                                <Form.Label column sm={2}>Photo:</Form.Label>
                                <Col sm={10}>
                                    <input id="file" name="file" type="file" onChange={(event) => {
                                        setFieldValue("file", event.currentTarget.files[0]);
                                    }}/>
                                    {touched.file && errors.file ? (
                                        <ErrorLabel>{errors.file}</ErrorLabel>
                                    ) : null}
                                </Col>
                            </Form.Group>
                            <div style={{textAlign: "right"}}>
                                <Button type={"submit"}>Upload photo</Button>
                            </div>
                        </Form>
                    )}

                </Formik>

            </Modal.Body>

        </Modal>
    )

}

export default UploadHillPhotoModal