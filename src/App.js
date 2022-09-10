
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Button } from 'reactstrap';
import Base from './components/Base';
import { BrowserRouter,Routes,Route } from 'react-router-dom';
import Home from './pages/Home';

import Signup from './pages/Signup';
import Login from './pages/Login';
import About from './pages/About';
import Services from './pages/Services';

import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import Privateroute from './components/Privateroute';
import Userdashboard from './pages/UserRoutes/Userdashboard';
import ProfileInfo from './pages/UserRoutes/ProfileInfo';

function App() {
  return (

    <BrowserRouter>
    <Routes>
      <Route path="/" element={<Home/>}></Route>
      <Route path="/login" element={<Login/>}></Route>
      <Route path="/signup" element={<Signup/>}></Route>
      <Route path="/about" element={<About/>}></Route>
      <Route path="/services" element={<Services/>}></Route>
      
      <Route path="/user" element={<Privateroute/>}>
        <Route path="dashboard" element={<Userdashboard/>}/>
        <Route path="profile-info" element={<ProfileInfo/>}/>
      </Route> 
    </Routes>
    </BrowserRouter>
  );
}

export default App;
