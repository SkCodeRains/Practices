import { BrowserRouter, Navigate, Route, Routes } from "react-router-dom";
import HeaderComponent from "./HeaderComponent";
import { FooterComponent } from "./FooterComponent.jsx";
import { LoginComponent } from "./LoginComponent";
import { WelcomeComponent } from "./WelcomeComponent";
import { TodoList } from "./TodoList";
import { LogoutComponent } from "./LogoutComponent";
import { AuthProvider, useAuth } from "./Security/AuthContext";
import { ErrorComponent } from "./ErrorComponent";
import { TodoComponent } from "./TodoComponent";
function AuthenticatedRoute({ children }) {
    const authContext = useAuth();
    const isAuthenticated = authContext.isAuthenticated;
    if (isAuthenticated) {
        return children;
    }
    return <Navigate to="/" />
}

const TodoApp = props => {
    return (
        <>
            <div className="main-app">

                <AuthProvider>
                    <BrowserRouter>
                        <HeaderComponent />

                        <Routes>
                            <Route path='/' element={<LoginComponent />} />
                            <Route path='/login' element={<LoginComponent />} />
                            <Route path='/welcome/:username' element={<AuthenticatedRoute><WelcomeComponent /></AuthenticatedRoute>} />

                            <Route path='/todolist' element={<AuthenticatedRoute><TodoList /></AuthenticatedRoute>} />

                            <Route path='/update-todo/:id' element={<AuthenticatedRoute><TodoComponent /></AuthenticatedRoute>} />

                            <Route path='/logout' element={<AuthenticatedRoute><LogoutComponent /></AuthenticatedRoute>} />



                            <Route path='*' element={<ErrorComponent />} />
                        </Routes>
                        <FooterComponent />

                    </BrowserRouter>
                </AuthProvider>

            </div>
        </>
    )
}
export default TodoApp;

