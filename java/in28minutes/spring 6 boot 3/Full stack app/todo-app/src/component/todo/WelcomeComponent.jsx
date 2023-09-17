import { Link, useParams } from "react-router-dom";

export const WelcomeComponent = () => {

    const { username } = useParams();

    return (
        <>
            <h1>Welcome {username}</h1>
            <h5>Manage your Todos <Link className="text-white " to={"/todolist"}> Goto Todo List </Link> </h5>
        </>
    )
}
