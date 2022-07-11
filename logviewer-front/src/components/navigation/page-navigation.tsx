import { Button, Menu, MenuItem } from "@mui/material";
import { Link } from "react-router-dom";
import { Link as MaterialLink } from '@mui/material';
import React from "react";
import { routes } from "./spa-routes";

interface NavigationProps {
    authenticated: boolean;
}

export default function PageNavigation( {authenticated} : NavigationProps) {

    const [anchorEl, setAnchorEl] = React.useState<null | HTMLElement>(null);
    const open = Boolean(anchorEl);
    const handleClick = (event: React.MouseEvent<HTMLButtonElement>) => {
      setAnchorEl(event.currentTarget);
    };
    const handleClose = () => {
      setAnchorEl(null);
    };

    const availableLinks = routes.map((route, i) => {
        if(authenticated === route.requiresAuthentication) {
            return <MaterialLink component={Link} to={route.path}><MenuItem onClick={handleClose}>{route.name}</MenuItem></MaterialLink>    
        }
    })

    return (
        <div>
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
            {availableLinks}
            </Menu>
        </div>
    );
}