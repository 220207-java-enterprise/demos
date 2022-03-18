import { useState } from 'react';
import { Routes, Route } from 'react-router-dom'

import './App.css';
import Login from './components/Login';
import { Principal } from './models/principal';
import Dashboard from './components/Dashboard';

function App() {

  let [authUser, setAuthUser] = useState<Principal>();

  return (
    <Routes>
      <Route path="/login" element={<Login currentUser={authUser} setCurrentUser={setAuthUser}/>}/>
      <Route path="/dashboard" element={<Dashboard currentUser={authUser}/>}/>
    </Routes>
  );
}

export default App;
