import { createContext, useContext, useState } from "react";

const AuthContext = createContext();
export default AuthContext;

export const useAuth = () => useContext(AuthContext);



export function AuthProvider({ children }) {


    const [number, setNumber] = useState(0);

    const [isAuthenticated, setAuthenticated] = useState(false);
    const [userName, setUserName] = useState(false);
    function login(userName, password) {
        if (userName === "superadmin" && password === "Test@123") {
            setAuthenticated(true);
            return true;
        } else {
            setAuthenticated(false);
            return false;
        }
    }

    const logout = () => {
        AuthContext.logout();
    }
    setInterval(() => setNumber(number + 1), 10000)
    return (
        <AuthContext.Provider value={{ number, isAuthenticated, setAuthenticated, userName, setUserName, login, logout }}>
            {children}
        </AuthContext.Provider>
    )
}