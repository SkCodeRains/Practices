
import { Link } from 'react-router-dom';
import { useAuth } from './Security/AuthContext';



const HeaderComponent = () => {
    // const authContext = useContext(AuthContext);
    const authContext = useAuth();
    const isAuthenticated = authContext.isAuthenticated;
    const username = authContext.userName; 

    const logout = () => { 
        authContext.logout();
    }

    return (
        <>


            <nav className="navbar navbar-expand-lg navbar-dark  bg-dark ">
                <Link className="navbar-brand" to="#">Navbar</Link>
                <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarNav">
                    <ul className="navbar-nav d-flex w-100 me-5">


                        <li className="nav-item d-flex active">
                            <Link className='nav-link' to={"/welcome/" + username}>Home</Link>
                        </li>
                        {
                            isAuthenticated &&
                            <li className="nav-item d-flex active">
                                <Link className='nav-link' to={"/todolist"}>Todo List</Link>
                            </li>
                        }
                        <div className='flex-fill '></div>
                        {
                            (!isAuthenticated) &&
                            <li className="nav-item d-flex active">
                                <Link className='nav-link' to={"/login"}>Login</Link>
                            </li>
                        }


                        {
                            isAuthenticated &&
                            <li className="nav-item d-flex active">
                                <Link className='nav-link' to={"/logout"} onClick={logout} >Logout</Link>
                            </li>
                        }


                    </ul>
                </div>
            </nav>
        </>
    )
}
export default HeaderComponent;