import { Login } from "@mui/icons-material";
import { Routes, Route } from "react-router-dom";
import HomePage from "../homepage/homepage";
import LogView from "../logview/LogView";

export const routes = [
    {path:"/" , component:<HomePage/>, name:"Homepage", requiresAuthentication: false},
    {path:"/login" , component:<Login/>, name:"Login", requiresAuthentication: false},
    {path:"/logview" , component:<LogView/>, name:"LogView", requiresAuthentication: true},
]

export default function SpaRoutes() {
    
    //TOOD: Filter authenticated routes

    const availableRoutes = routes.map((route, i) => {
        return <Route path={route.path} element={route.component} />
    })

    return (
        <Routes>
            {availableRoutes}
        </Routes>
    );
  }
  