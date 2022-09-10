import Base from "../components/Base";
import { Container,Card, CardHeader,CardBody,Form,FormGroup,Input,Label } from "reactstrap";
import { Button,Row,Col } from "reactstrap";
import { useEffect, useState } from "react";
import {signUp} from "../services/user-service";
import {toast} from 'react-toastify';

const Signup = () =>{

    

    const [data,setData]=useState({
        firstName:'',
        lastName:'',
        email:'',
        password:'',
        mobile:'',
        address:'',
        dob:'',
        gender:''
        
    })

    const [error,setError]=useState({
        errors:{},
        isError:false
    })

    // useEffect(()=>{
    //     console.log(data);
    // },[data])

    //handle change
    const handleChange=(event,property)=>{
        //console.log("name changed");
        //console.log(event.target.value);
        //setting values in variable of name in above
        //dynamic setting of values
        setData({...data,[property]:event.target.value})
        
    }

    //resetting the form with all values
    const resetData=()=>{
        setData({
            firstName:'',
            lastName:'',
            email:'',
            password:'',
            mobile:'',
            address:'',
            dob:'',
            gender:''
        })
    }

    //submitting the form
    const submitForm=(event)=>{
        event.preventDefault();

        if(error.isError){
            toast.error("form data is invalid, correct all details then submit")
            return;
        }
        //console.log(data);
        //data validate

        //if valid call server api for sending data
        signUp(data).then((resp)=>{
            console.log(resp);
            console.log("success log");
            toast.success("user registered successfully !! user id ="+resp.id);
        }).catch((error)=>{
            console.log(error);
            console.log("error logged");
            setError({
                error:error,
                isError:true
            })
        })
    }

    return (

       <Base>
            <Container>

                <Row className="mt-2">
                    {JSON.stringify(data)}
                    <Col sm={{size:6,offset:3}}>
                    <Card outline color="dark" >
                    <CardHeader>
                        <h3>Fill Information to Register !</h3>
                    </CardHeader>
                    <CardBody>
                        {/* creatig form */}
                        <Form onSubmit={submitForm}>
                            {/* firstnamefield */}
                            <FormGroup>
                                <Label for="firstname">Enter First Name</Label>
                                <Input type="text" placeholder="enter here" id="firstname"
                                onChange={(e)=>{handleChange(e,'firstName')}}
                                value={data.firstName}
                                invalid={error.errors?.response?.data?.firstName?true:false}
                                />
                            </FormGroup>

                            {/* lastnamefield */}
                            <FormGroup>
                                <Label for="lastname">Enter Last Name</Label>
                                <Input type="text" placeholder="enter here" id="lastname"
                                onChange={(e)=>{handleChange(e,'lastName')}}
                                value={data.lastName}
                                invalid={error.errors?.response?.data?.lastName?true:false}
                                />
                            </FormGroup>

                            {/* emailfield */}
                            <FormGroup>
                                <Label for="email">Enter Email</Label>
                                <Input type="email" placeholder="enter here" id="email"
                                onChange={(e)=>{handleChange(e,'email')}}
                                value={data.email}
                                />
                            </FormGroup>

                            {/* password field */}
                            <FormGroup>
                                <Label for="password">Enter Password</Label>
                                <Input type="password" placeholder="enter here" id="password"
                                onChange={(e)=>{handleChange(e,'password')}}
                                value={data.password}
                                />
                            </FormGroup>

                            {/* mobile field */}
                            <FormGroup>
                                <Label for="mobile">Enter Mobile No</Label>
                                <Input type="number" placeholder="enter here" id="mobile"
                                onChange={(e)=>{handleChange(e,'mobile')}}
                                value={data.mobile}
                                />
                            </FormGroup>

                            {/* address field */}
                            <FormGroup>
                                <Label for="address">Enter Address</Label>
                                <Input type="textarea" placeholder="enter here" id="address"
                                style={{height:'150px'}}
                                onChange={(e)=>{handleChange(e,'address')}}
                                value={data.address}
                                />
                            </FormGroup>

                            {/* dob field */}
                            <FormGroup>
                                <Label for="dob">Enter Date Of Birth</Label>
                                <Input type="text" placeholder="enter here" id="dob"
                                
                                onChange={(e)=>{handleChange(e,'dob')}}
                                value={data.dob}
                                />
                            </FormGroup>

                            {/* gender field */}
                            <FormGroup>
                                <Label for="gender">Enter Gender</Label>
                                <Input type="text" placeholder="enter here" id="gender"
                                
                                onChange={(e)=>{handleChange(e,'gender')}}
                                value={data.gender}
                                />
                            </FormGroup>

                            <Container className="text-center">
                                <Button outline color="primary">Register</Button>
                                <Button color="secondary" className="ms-2" type="reset"
                                onClick={resetData}
                                >Reset</Button>
                            </Container>
                        </Form>
                    </CardBody>
                </Card>
                    </Col>
                </Row>
            </Container>
       </Base>
    );
};

export default Signup;