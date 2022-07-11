import "./navbar.css"
import { Link } from 'react-router-dom';
import logo from "./logo.svg"
import { Link as MaterialLink } from '@mui/material';
import { UserContext } from '../../context/user-context';
import PageNavigation from './page-navigation';

export default function Navbar() {

  return (
    <div className='navbar'>
        <MaterialLink component={Link} to='/'><img src={logo} className="App-logo" alt="logo" /></MaterialLink>
        <UserContext.Consumer>
          {({authenticated}) => (
            <PageNavigation authenticated = {authenticated} />
          )}
        </UserContext.Consumer>
    </div>
  );
}