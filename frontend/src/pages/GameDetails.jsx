import { useParams, Link } from "react-router-dom";
import { useEffect, useState } from "react";
import './GameDetails.css'

function GameDetails() {
    const { id } = useParams();
    const [game, setGame] = useState(null);

    useEffect(() => {
        async function loadGame() {
            const response = await fetch(`http://localhost:8080/api/games/${id}`);
            const data = await response.json();
            setGame(data);
        }

        loadGame();
    }, [id]);

    if (!game) {
        return <p>Loading...</p>;
    }

    async function updateRating(newRating) {
        const response = await fetch(`http://localhost:8080/api/games/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                title: game.title,
                rating: newRating,
                status: game.status,
                hoursPlayed: game.hoursPlayed,
            })
        })

        const updatedGame = await response.json()
        setGame(updatedGame)
    }

    return (
        <div className="game-details-page">

            <Link to="/" className="back-link">
                ← Back to Library
            </Link>

            <div className="game-details">

                <img
                    className="details-cover"
                    src={game.imageUrl}
                    alt={game.title}
                />

                <div className="details-info">
                    <h1 className="details-title">{game.title}</h1>

                    <p>{game.hoursPlayed} Hours Played</p>

                    <p>Status: {game.status}</p>

                    <div className="details-rating">
                        {[...Array(10)].map((_, index) => (
                            <span
                                key={index}
                                className={index < game.rating ? "heart filled" : "heart"}
                                onClick={() => updateRating(index + 1)}
                            >
            ♥
        </span>
                        ))}
                    </div>
                </div>

            </div>
        </div>
    );
}

export default GameDetails;