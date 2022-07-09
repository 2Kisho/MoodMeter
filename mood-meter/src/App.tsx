import { BrowserRouter, Route, Routes } from "react-router-dom";
import "./App.css";
import DashboardView from "./pages/Dashboard";
import RateView from "./pages/RateView";
function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/">
            <Route index element={<DashboardView />} />
            <Route path="rate/:questionId" element={<RateView />} />
            <Route path="*" element={<DashboardView />} />
          </Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
