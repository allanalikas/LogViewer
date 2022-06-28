import * as React from 'react';
import "./Navbar.css"
import Button from '@mui/material/Button';
import Menu from '@mui/material/Menu';
import MenuItem from '@mui/material/MenuItem';
import { Link } from 'react-router-dom';
import logo from "./logo.svg"
import { Link as MaterialLink } from '@mui/material';

export default function Navbar() {
  const [anchorEl, setAnchorEl] = React.useState<null | HTMLElement>(null);
  const open = Boolean(anchorEl);
  const handleClick = (event: React.MouseEvent<HTMLButtonElement>) => {
    setAnchorEl(event.currentTarget);
  };
  const handleClose = () => {
    setAnchorEl(null);
  };

  return (
    <div className='navbar'>
      <MaterialLink component={Link} to='/'><img src={logo} className="App-logo" alt="logo" /></MaterialLink>
      <Button
        id="basic-button"
        aria-controls={open ? 'basic-menu' : undefined}
        aria-haspopup="true"
        aria-expanded={open ? 'true' : undefined}
        onClick={handleClick}
      >
        Dashboard
      </Button>
      <Menu
        id="basic-menu"
        anchorEl={anchorEl}
        open={open}
        onClose={handleClose}
        MenuListProps={{
          'aria-labelledby': 'basic-button',
        }}
      >
        <MaterialLink component={Link} to='/'><MenuItem onClick={handleClose}>Profile</MenuItem></MaterialLink>
        <MaterialLink component={Link} to='/login'><MenuItem onClick={handleClose}>Login</MenuItem></MaterialLink>
        <MaterialLink component={Link} to='/logview'><MenuItem onClick={handleClose}>Logs</MenuItem></MaterialLink>
      </Menu>
    </div>
  );
}