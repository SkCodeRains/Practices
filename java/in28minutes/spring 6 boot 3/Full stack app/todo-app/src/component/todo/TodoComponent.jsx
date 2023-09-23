import React, { useEffect, useState } from 'react'
import { createTodo, retrieveTodoByIdAndUsername, updateTodoByIdAndUsername } from './api/TodoApiService';
import { useNavigate, useParams } from 'react-router-dom';
import { useAuth } from './Security/AuthContext';
import { Field, Formik } from 'formik';

export const TodoComponent = () => {

    const [todo, setTodo] = useState({});
    const auth = useAuth();
    const userName = auth.userName;
    const { id } = useParams();


    const navigate = useNavigate()

    useEffect(
        () => {
            getTodoById(userName, id);
        },
        [userName, id]
    );

    function getTodoById(userName, id) {
        if (id > -1)
            retrieveTodoByIdAndUsername(userName, id).then((response) => {
                setTodo(response.data);
            }).catch((error) => {
                console.log(error);
            });
    }

    function updatedTodo(values) {
        if (+id > -1) {
            updateTodoByIdAndUsername(userName, values, id).then((response) => {
                if (response.data.success) {
                    navigate("/todolist");
                }

            }).catch((error) => {
                console.log(error);
            });
        } else {
            createTodo(userName, values).then((response) => {
                if (response.data.success) {
                    navigate("/todolist");
                }

            }).catch((error) => {
                console.log(error);
            });
        }
    }



    function onSubmit({ values }) {
        console.log(values);
        updatedTodo(values);
    }
    function validate(values) {
        console.log(values);
    }


    return (
        <div className='container mt-5 col-6 '>
            <div>
                <div className="card text-start">
                    <div className="card">
                        <div className="card-header">
                            Update Todo
                        </div>
                        <div className="card-body">

                            <div className="container">
                                <Formik
                                    onSubmit={onSubmit}
                                    validate={validate}
                                    initialValues={todo}
                                    enableReinitialize={true}
                                    validateOnBlur={false}
                                    validateOnChange={false}
                                >


                                    {
                                        (props) => (
                                            <form>
                                                <fieldset className="mb-3 row">
                                                    <label htmlFor="description" className="col-4 col-form-label">Description : </label>
                                                    <div className="col-8">
                                                        <Field type="text" className="form-control" name="description" id="description" placeholder="Description" />
                                                    </div>
                                                </fieldset>

                                                <fieldset className="mb-3 row">
                                                    <label htmlFor="targetDate" className="col-4 col-form-label">Date : </label>
                                                    <div className="col-8">
                                                        <Field type="date" className="form-control" name="targetDate" id="targetDate" />
                                                    </div>
                                                </fieldset>

                                                <div>
                                                    <button type='submit' className="btn btn-primary"  onClick={(event)=>{event.preventDefault();onSubmit(props)}} >Submit</button>
                                                </div>
                                            </form>
                                        )
                                    }
                                </Formik>

                            </div>


                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}
