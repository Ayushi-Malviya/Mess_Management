import React from 'react'
import { Link } from 'react-router-dom';
import Button from './Button';

const Navbar2 = ({userData,onLogout,homePath}) => {
  return (
    <>
    <div className="navbar d-flex text-secondary mb-1">
            <div className="col-lg-4 col-md-4 col-12 ">
                <Link to="/">
                <img style={{ width: "10vw", marginLeft: "10px"}} src="../assets/newlogo.svg" alt="logo" srcSet="" />
                </Link>

            </div>


            <div className="nav_bar  d-flex p-lg-3 col-lg-8 col-md-8 col-12 justify-content-center" >
                <div>

                  <Link to={homePath}>
                  <Button classname="navbtn btn btn-md text-secondary" btnText="HOME" />
                  </Link>
                    
                    <Link to="/about">
                    <Button classname="navbtn btn btn-md text-secondary" btnText="ABOUT US" />
                    </Link>

                    <Link to="/contact">
                    <Button classname="navbtn btn btn-md text-secondary" btnText="CONTACT" />
                    </Link>
                    <Link to="/">
                    <Button classname="navbtn btn btn-md text-secondary" btnText="LOGOUT" onClick={onLogout}/>
                    </Link>
                    
                </div>
            </div>

        </div>
    </>
  )
}

export default Navbar2;
