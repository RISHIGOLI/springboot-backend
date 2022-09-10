import { Navbar,NavbarBrand,NavbarToggler,Collapse,Nav,NavItem,NavLink,DropdownMenu,NavbarText,UncontrolledDropdown,DropdownToggle,DropdownItem  } from "reactstrap";
import { NavLink as ReactLink, useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";
import {doLogOut, getCurrentUserDetail, isLoggedIn} from "../auth";
// import { loginUser,user } from "../services/user-service";

const CustomNavbar=()=>{

    let navigate=useNavigate()

     const [isOpen,setIsOpen]=useState(false)

     const [login,setLogin] = useState(false)
      const [user,setUser] = useState(undefined)
     //const [rushi,setRushi] = useState(undefined)
     

     useEffect(()=>{
      
        setLogin(isLoggedIn())
        setUser(getCurrentUserDetail())
     },[login])

     const logout=()=>{
      doLogOut(()=>{
        //loggedout
        setLogin(false);
        navigate("/")
      });
      
     };

    return(
        <div>
        <Navbar 
            color="secondary"
            dark
            expand="md"
            fixed=""
            className="px-4"
            
            >
          <NavbarBrand tag={ReactLink} to="/">RideEzy</NavbarBrand>
          <NavbarToggler  onClick={()=>setIsOpen(!isOpen)}/>
          <Collapse  isOpen={isOpen} navbar>
            <Nav className="me-auto" navbar>

            <NavItem>
                <NavLink tag={ReactLink} to="/">Home</NavLink>
              </NavItem>

              <NavItem>
                <NavLink tag={ReactLink} to="/about">About</NavLink>
              </NavItem>

              <NavItem>
                <NavLink tag={ReactLink} to="/services">Services</NavLink>
              </NavItem>
              
              <UncontrolledDropdown nav inNavbar>
                <DropdownToggle nav caret>
                  More
                </DropdownToggle>
                <DropdownMenu end>
                  <DropdownItem tag={ReactLink} to="/services">ContactUs</DropdownItem>
                  <DropdownItem>FaceBook</DropdownItem>
                  <DropdownItem divider />
                  <DropdownItem>Youtube</DropdownItem>
                  <DropdownItem>Instagram</DropdownItem>
                  <DropdownItem>LinkedIn</DropdownItem>
                </DropdownMenu>
              </UncontrolledDropdown>
            </Nav>
            <Nav navbar>
              {
                login && (
                  <>
                    <NavItem>
                      <NavLink tag={ReactLink} to="/user/dashboard">
                      {user.email}
                      </NavLink>
                    </NavItem>
                    
                    <NavItem>
                      <NavLink tag={ReactLink} to="/user/profile-info">
                      profile info
                      </NavLink>
                    </NavItem>

                    <NavItem>
                      <NavLink onClick={logout}>
                      Logout
                      </NavLink>
                    </NavItem>

                  </>
              
                )
                
              }

              {
                !login && (
                 <>
                   <NavItem>
                    <NavLink tag={ReactLink} to="/login">
                      Login
                    </NavLink>
                  </NavItem>
                  <NavItem>
                <   NavLink tag={ReactLink} to="/signup">
                      Signup
                    </NavLink>
                  </NavItem>
                 </>
                )
              }
            </Nav>
            {/* <NavbarText>Youtube</NavbarText> */}
          </Collapse>
        </Navbar>
      </div>
    );
}

export default CustomNavbar;