import React from "react";
// import logo from './logo.svg';
import "./App.css";
import RateView from "./pages/rateView";

function App() {
  return (
    <div className="App">
      <div className="container mx-auto px-20">
        <RateView question="Wie fandest du den Sprint?" />
      </div>
      {/* <Example></Example> */}
    </div>
  );
}

export default App;
