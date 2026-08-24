import './App.css'
import {Route, Routes, Link} from "react-router-dom";
import GameLibrary from "./pages/GameLibrary.jsx";
import GameDetails from "./pages/GameDetails.jsx";
import StatsDashboard from "./pages/StatsDashboard";


function App() {
  return (
      <>
          <nav className="main-nav">
              <Link to="/">Library</Link>
              <Link to="/stats">Stats</Link>
          </nav>
          <Routes>
              <Route path="/" element={<GameLibrary />} />
              <Route path="/games/:id" element={<GameDetails />} />
              <Route path="/stats" element={<StatsDashboard />} />
          </Routes>
      </>
  )
}

export default App
