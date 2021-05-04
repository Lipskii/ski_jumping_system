import React from "react";
import {Button, Form, Modal} from "react-bootstrap";
import {Formik} from "formik"
import * as Yup from 'yup';
import FormikTextInputForm from "../CommonForms/FormikTextInputForm";
import FormikSelectInputForm from "../CommonForms/FormikSelectInputForm";


const EditHillModal = (props) => {

    return (
        <Modal show={props.show} onHide={props.onHide} size={"lg"} centered>
            <Modal.Header closeButton>
                <Modal.Title>Edit name of {props.name}</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <Formik
                    initialValues={{
                        name: props.name,
                        sizeOfHillId: props.sizeOfHill.id
                    }}
                    validationSchema={Yup.object({
                        name: Yup.string().required('Required'),
                        sizeOfHillId: Yup.number().required('Required')
                        }
                    )}

                    onSubmit={(values) => {
                        props.onSubmit(values)
                    }}
                >
                    {({
                          handleSubmit,
                      }) => (
                          <Form onSubmit={(e) => {
                              e.preventDefault()
                              handleSubmit()
                          }}>
                              <FormikTextInputForm
                                name="name"
                                label={"New name:"}
                              />

                              <FormikSelectInputForm
                                  name="sizeOfHillId"
                                  label="Size of hill*:"
                              >
                                  <option value={""} disabled>Choose...</option>
                                  {props.sizesOfHill.map(sizeOfHill => (
                                      <option key={sizeOfHill.id} value={sizeOfHill.id}>{sizeOfHill.designation}</option>
                                  ))}
                              </FormikSelectInputForm>
                              <div style={{textAlign: "right"}}>
                              <Button type={"submit"}>Update</Button>
                              </div>
                          </Form>
                        )}

                </Formik>

            </Modal.Body>

        </Modal>
        )

}

export default EditHillModal