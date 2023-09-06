import React from 'react';
import PropTypes from 'prop-types'

const Navbar = (props) => {
    return (
        <header className="d-flex text-white px-3 bg-dark flex-wrap align-items-center py-3 mb-4 border-bottom">
            <div className="   ">
                <h5>{props.title}</h5>
            </div>

            <ul className="nav text-white  ms-3   justify-content-center ">
                <li><a href="/" className="nav-link text-white ">Home</a></li>
                <li><a href="/" className="nav-link text-white px-2">Features</a></li>
                <li><a href="/" className="nav-link text-white px-2">Pricing</a></li>
                <li><a href="/" className="nav-link text-white px-2">FAQs</a></li>
                <li><a href="/" className="nav-link text-white px-2">About</a></li>
            </ul>

            <div className="col-md-3 flex-fill text-end">
                <button type="button" className="btn btn-outline-primary text-white me-2">Login</button>
                <button type="button" className="btn btn-primary text-white">Sign-up</button>
            </div>
        </header>
    );
}

export default Navbar;



Navbar.propTypes = {
    title: PropTypes.string.isRequired
}