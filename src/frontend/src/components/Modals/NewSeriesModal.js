import React, {Component} from "react";
import {Form, Formik} from "formik";
import axios from "axios";
import * as Yup from 'yup';
import {Button, Modal} from "react-bootstrap";
import FormikSelectInputForm from "../CommonForms/FormikSelectInputForm";
import {Header3, StyledDiv2Right1200} from "../StyledComponents";
import FormikTextInputForm from "../CommonForms/FormikTextInputForm";
import AddingModal from "./AddingModal";
import CompletedModal from "./CompletedModal";

class NewSeriesModal extends Component {

    state = {
        completedModalStatus: true,
        countries: this.props.series,
        pointsScales: [],
        showAddingModal: false,
        showCompletedModal: false,
    }


    componentDidMount() {
        axios.get("/api/pointsScales")
            .then(res => this.setState({
                pointsScales: res.data
            }))
            .catch(error => console.log(error))
    }

    onSubmit = (values) => {
        axios.post("/api/series", {
            name: values.name,
            pointsScale: this.state.pointsScales.find(pointsScale => pointsScale.id = values.pointsScaleId)
        })
            .then(() => {
                this.setState({
                    showAddingModal: false,
                    showCompletedModal: true,
                    completedModalStatus: true,
                    completedModalText: values.name + " added!"
                })
            })
            .catch(error => {
                console.log(error)
                this.setState({
                    showAddingModal: false,
                    showCompletedModal: true,
                    completedModalStatus: false,
                    completedModalText: "Ups, something went wrong. Try again."
                })
            } )
    }


    render() {
        console.log(this.state)
        return (
            <React.Fragment>
                <AddingModal
                    show={this.state.showAddingModal}
                    onHide={() => this.setState({
                        showAddingModal: false
                    })}
                />
                <CompletedModal
                    show={this.state.showCompletedModal}
                    text={this.state.completedModalText}
                    onHide={() => this.setState({
                        showCompletedModal: false,
                        completedModalText: ""
                    })}
                    status={this.state.completedModalStatus}
                />
                <Formik
                    isInitialValid={false}
                    initialValues={{
                        name: '',
                        pointsScaleId: ''
                    }}
                    validationSchema={Yup.object({
                        name: Yup.string()
                            .required('Required'),
                        points_scaleId: Yup.number()
                    })}
                    onSubmit={values =>{
                        this.setState({
                            showAddingModal: true
                        }, () =>  this.onSubmit(values))
                    }}>
                    {({
                          handleSubmit

                      }) => (
                        <Modal show={this.props.show} onHide={this.props.onHide}>
                            <Modal.Header closeButton>
                                <Header3>New city</Header3>
                            </Modal.Header>
                            <Modal.Body>
                                <small>Fields with (*) are mandatory</small>
                                <Form style={{marginTop: "10px"}} onSubmit={e => {
                                    e.preventDefault()
                                    handleSubmit()
                                }}>

                                    <FormikTextInputForm
                                        name="name"
                                        label="Name*:"
                                    />

                                    <FormikSelectInputForm
                                        name="pointsScaleId"
                                        label="Points scale:"
                                    >
                                        <option value={""}>Choose...</option>
                                        {this.state.pointsScales.map(pointScale => (
                                            <option key={pointScale.id} value={pointScale.id}>
                                                {pointScale.pointsScaleValues[0].points}, {pointScale.pointsScaleValues[1].points}, {pointScale.pointsScaleValues[2].points}, ...
                                            </option>
                                        ))}
                                    </FormikSelectInputForm>

                                    <StyledDiv2Right1200>
                                        <Button type={"submit"}>Submit</Button>
                                    </StyledDiv2Right1200>

                                </Form>
                            </Modal.Body>
                        </Modal>
                    )}
                </Formik>
            </React.Fragment>
        )
    }

}

export default NewSeriesModal