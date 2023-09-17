import { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./LoginComponent.css"
import { useAuth } from "./Security/AuthContext";

export const LoginComponent = () => {

    const [userName, setUserName] = useState("");
    const [password, setPassword] = useState("");
    const [showErrorMessage, setShowErrorMessage] = useState(false);
    const navigate = useNavigate();
    const authContext = useAuth();

    async function handleSubmit() {

        const baToken = 'Basic ' + window.btoa(userName + ":" + password);
        try {
            const response = await executeBasicAuthenticationService(baToken)
            if (response.status == 200) {
                setAuthenticated(true)
                setUsername(username)
                return true
            } else {
                setAuthenticated(false)
                setUsername(null)
                return false
            }

        } catch (error) {

        }
        if (authContext.login(userName, password)) {
            setShowErrorMessage(false);
            authContext.setUserName(userName);
            navigate("/welcome/" + userName);
        } else {
            setShowErrorMessage(true);
            navigate("/login");
        }
    }




    /*     const handleSubmit = () => {
            if (authContext.login(userName, password)) {
                setShowErrorMessage(false);
                authContext.setUserName(userName);
                navigate("/welcome/" + userName);
            } else {
                setShowErrorMessage(true);
                navigate("/login");
            }
        } */



    const handleUserName = (event) => {
        setUserName(event.target.value);
    }
    const handlePassword = (event) => {
        setPassword(event.target.value);
    }

    /* const SuccessMessageComponent = () => {
        return showSuccessMessage ? <h5>Authentication successful</h5> : null;
    }
    
    const FailedmessageComponent = () => {
        return showErrorMessage ? <h5>Authentication failed</h5> : null;
    
    } */


    return (
        <>
            <div className="login-container ">
                <div className="main-login-form">
                    {/* <SuccessMessageComponent></SuccessMessageComponent>

                    <FailedmessageComponent></FailedmessageComponent> */}

                    {showErrorMessage && <h5>Authentication failed</h5>}
                    <form method='POST'>
                        <label htmlFor="Username">Username</label>
                        <input type="text" name="username" id="Username" className="email" placeholder="Enter your username" value={userName} onChange={handleUserName} required />

                        <label htmlFor="Password">Password</label>
                        <input type="password" name="password" id='Password' className="password" value={password} onChange={handlePassword} placeholder="Enter your password" required />

                        <input name="submit" type="button" value="Submit" onClick={handleSubmit} />
                    </form>
                </div>
            </div>
        </>
    )
}
