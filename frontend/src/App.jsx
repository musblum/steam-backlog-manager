import './App.css'
import {Route, Routes} from "react-router-dom";
import GameLibrary from "./pages/GameLibrary.jsx";
import GameDetails from "./pages/GameDetails.jsx";

function App() {
  return (
      <Routes>
          <Route path="/" element={<GameLibrary />} />
          <Route path="/games/:id" element={<GameDetails />} />
      </Routes>
  )
}

export default App
