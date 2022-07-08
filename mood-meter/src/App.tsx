import React from "react";
// import logo from './logo.svg';

import './App.css';
import Example from './pages/dashboarduser'
import Sprint from './pages/sprint'
import Test from './pages/test'
function App() {
  return (
    <div className="App">

        {/* <Example></Example> */}
        {/* <Test width={500} height={500}></Test> */}
        <Sprint width={500} height={500}></Sprint>
    </div>
  );
}

export default App;
