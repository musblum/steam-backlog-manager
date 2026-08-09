import './App.css'
import GameCard from './components/GameCard.jsx'
import {useState, useEffect} from "react";

function App() {

    const [games, setGames] = useState([]);

    useEffect(() => {
        async function loadGames() {
            const response = await fetch('http://localhost:8080/api/games');
            const data = await response.json();
            setGames(data);
        }
        loadGames();
    })

  return (
      <>
        <h1>Steam Backlog Manager</h1>
        <p>Your games. Your ratings. Your backlog</p>

          {games.map((game) => (
              <GameCard
                  key={game.id}
                  title={game.title}
                  hoursPlayed={game.hoursPlayed}
              />
          ))}
      </>

  )
}

export default App
