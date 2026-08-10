import { useState, useEffect } from 'react'
import GameCard from '../components/GameCard.jsx'
import '../App.css'


function GameLibrary() {

    const [games, setGames] = useState([]);

    useEffect(() => {
        async function loadGames() {
            const response = await fetch('http://localhost:8080/api/games');
            const data = await response.json();
            setGames(data);
        }
        loadGames();
    }, [])

    return (
        <>
            <h1 className={"app-title"}>Steam    Backlog     Manager</h1>
            <p>Your games. Your ratings. Your backlog</p>

            <div className={"game-grid"}>
                {games.map((game) => (
                    <GameCard
                        key={game.id}
                        title={game.title}
                        hoursPlayed={game.hoursPlayed}
                        imgUrl={game.imageUrl}
                        rating={game.rating}
                        status={game.status}
                        id={game.id}
                    />

                ))}
            </div>
        </>

    )
}

export default GameLibrary;
