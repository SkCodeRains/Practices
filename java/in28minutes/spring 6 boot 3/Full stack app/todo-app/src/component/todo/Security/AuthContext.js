import { createContext, useContext, useState } from "react";
import { executeBasicAuthenticationService } from "../api/TodoApiService";
import { apiClient } from "../api/ApiCient";

const AuthContext = createContext();
export default AuthContext;

export const useAuth = () => useContext(AuthContext);





export function AuthProvider({ children }) {


    const [number, setNumber] = useState(0);

    const [isAuthenticated, setAuthenticated] = useState(false);
    const [userName, setUserName] = useState(false);
    const [token, setToken] = useState("");



    async function login(userName, password) {

        try {
            const response = await executeBasicAuthenticationService(userName, password);
            if (response.status === 200) {
                const baToken = `Bearer ${response.data.token}`
                console.log(baToken);
                setAuthenticated(true);
                setUserName(userName);
                setToken(baToken);
                apiClient.interceptors.request.use(
                    (config) => {
                        config.headers.Authorization = baToken;
                        return config;
                    }
                )
                return true;
            } else {
                setUserName(null);
                setAuthenticated(false);
                return false;
            }

        } catch (error) {
            setUserName(null);
            setAuthenticated(false);
            return false;
        }
    }



    const logout = () => {
        AuthContext.logout();
    }
    setInterval(() => setNumber(number + 1), 10000)
    return (
        <AuthContext.Provider value={{ number, isAuthenticated, setAuthenticated, userName, setUserName, login, logout, token }}>
            {children}
        </AuthContext.Provider>
    )
}