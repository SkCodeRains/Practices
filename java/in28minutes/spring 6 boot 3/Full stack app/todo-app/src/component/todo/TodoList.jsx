import { useEffect, useState } from "react";
import { deleteATodoByIdAndUsername, retrieveAllTodosByUsername } from "./api/TodoApiService";
import { useAuth } from "./Security/AuthContext";
import { useNavigate } from "react-router-dom";


export const TodoList = () => {

    const today = new Date();
    // const targetDate = new Date(today.getFullYear() + 12, today.getMonth(), today.getDay());

    const [todos, setTodos] = useState([]);

    const auth = useAuth();
    const userName = auth.userName;

    const navigate = useNavigate();
    /* const todos = [
        { id: 1, description: 'Learn AWS', done: false, targetDate: targetDate },
        { id: 2, description: 'Learn Full Stack Dev', done: false, targetDate: targetDate },
        { id: 3, description: 'Learn Devops', done: false, targetDate: targetDate }
    ] */
    useEffect(() => {
        refreshData(userName);
    }, [userName]);


    function refreshData(userName) {
        retrieveAllTodosByUsername(userName)
            .then((response) => {
                setTodos(response.data);
            })
            .catch((response) => { console.log(response); });
    }

    const deleteTodo = (id) => {
        deleteATodoByIdAndUsername(userName, id)
            .then((response) => {
                console.log(response);
                refreshData(userName);
            })
            .catch((response) => { console.log(response); });
    }

    const updateTodo = (id) => {
        navigate("/update-todo/" + id)
    }
    const navToAddTodo = () => {
        navigate("/update-todo/" + -1)
    }

    return (
        <>

            <div className="div p-4 mt-5">
                <h1>Things You Want To Do! !! </h1>
                <div className="card container-fluid "  >

                    <div className="row my-3 px-5 ">
                        <button className="btn btn-primary  " onClick={navToAddTodo}>Add Todo</button>
                    </div>

                    <table className="table mt-2  table-striped">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Description</th>
                                <th>Target Date</th>
                                <th>is Done</th>
                                <th>DELETE</th>
                                <th>UPDATE</th>

                            </tr>
                        </thead>
                        <tbody>
                            {
                                todos.map(
                                    todo => (
                                        <tr key={today.id + today.targetDate}>
                                            <th>{todo.id}</th>
                                            <td>{todo.description}</td>
                                            <td>{todo.targetDate.toString()}</td>
                                            <td>{todo.done.toString()}</td>
                                            <td> <button className="btn btn-warning " onClick={() => { deleteTodo(todo.id) }} >DELETE TODO</button> </td>
                                            <td> <button className="btn btn-success  " onClick={() => { updateTodo(todo.id) }} >UPDATE TODO</button> </td>
                                        </tr>
                                    )
                                )
                            }
                        </tbody>
                    </table>
                </div>
            </div>
        </>
    )
}