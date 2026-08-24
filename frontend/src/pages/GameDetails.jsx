import {useParams, Link} from "react-router-dom";
import {useEffect, useState} from "react";
import './GameDetails.css'

function GameDetails() {
    const {id} = useParams();
    const [game, setGame] = useState(null);
    const [notes, setNotes] = useState("")

    useEffect(() => {
        async function loadGame() {
            const response = await fetch(`http://localhost:8080/api/games/${id}`);
            const data = await response.json();
            setGame(data);
            setNotes(data.notes || "");
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
                notes: notes
            })
        })


        const updatedGame = await response.json()
        setGame(updatedGame)
    }

    async function updateStatus(newStatus) {
        const response = await fetch(`http://localhost:8080/api/games/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                title: game.title,
                rating: game.rating,
                status: newStatus,
                hoursPlayed: game.hoursPlayed,
                notes: notes,
            })
        });

        const updatedGame = await response.json();
        setGame(updatedGame);
    }

    async function saveNotes() {
        const response = await fetch(`http://localhost:8080/api/games/${id}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                title: game.title,
                rating: game.rating,
                hoursPlayed: game.hoursPlayed,
                status: game.status,
                notes: notes
            })
        });

        const updatedGame = await response.json();

        setGame(updatedGame);
        setNotes(updatedGame.notes || "");
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
                    <div className="game-info">
                        <h1 className="details-title">{game.title}</h1>
                        <p>{game.hoursPlayed} Hours Played</p>
                    </div>

                    <div className="status-control">
                        <label htmlFor="status">Status:</label>

                        <select
                            id="status"
                            value={game.status}
                            onChange={(event) =>
                                updateStatus(event.target.value)
                            }
                        >
                            <option value="Backlog">Backlog</option>
                            <option value="Playing">Playing</option>
                            <option value="Completed">Completed</option>
                            <option value="Dropped">Dropped</option>
                            <option value="Live-Service">Live Service</option>
                        </select>
                    </div>

                    <div className="details-rating">
                        {[...Array(10)].map((_, index) => (
                            <span
                                key={index}
                                className={
                                    index < game.rating
                                        ? "heart filled"
                                        : "heart"
                                }
                                onClick={() => updateRating(index + 1)}
                            >
                        ♥
                    </span>
                        ))}
                    </div>

                    <div className="notes-section">
                        <h3>Notes</h3>

                        <textarea
                            value={notes}
                            onChange={(event) =>
                                setNotes(event.target.value)
                            }
                            onKeyDown={(event) => {
                                if (event.key === "Enter" && !event.shiftKey) {
                                    event.preventDefault();
                                    saveNotes();
                                }
                            }}
                            placeholder="Write a note about this game..."
                        />
                        <button
                            className="save-notes-button"
                            onClick={saveNotes}
                        >
                            Save Notes
                        </button>
                    </div>
                </div>
            </div>
        </div>    );
}

export default GameDetails;