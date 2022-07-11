import { BrowserRouter } from 'react-router-dom';
import './App.css';
import Navbar from './components/navigation/Navbar';
import SpaRoutes from './components/navigation/spa-routes';
import { User, UserContext } from './context/user-context';

export default function App() {

  const user = new User("asda", false)

  return (
      <div className="App">
        <UserContext.Provider value={user}>
          <BrowserRouter>
            <Navbar />
            <SpaRoutes />
          </BrowserRouter>
        </UserContext.Provider>
      </div>
  );
}
