import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Home from './Pages/Home';
import Event from './Pages/Event';

function App() {
  return (
    <BrowserRouter>
    <Routes>
      <Route path="/" element={<Home/>} exact></Route>
      <Route path="/events" element= {<Event/>} exact></Route>

    </Routes>
    </BrowserRouter>
  );
}

export default App;
