import { useState, useEffect } from 'react'
import GameCard from '../components/GameCard.jsx'
import '../App.css'


function GameLibrary() {

    const [games, setGames] = useState([]);
    const [search, setSearch] = useState('');
    const [statusFilter, setStatusFilter] = useState('All');
    const [sortBy, setSortBy] = useState("title-asc");


    useEffect(() => {
        async function loadGames() {
            const response = await fetch('http://localhost:8080/api/games');
            const data = await response.json();
            setGames(data);
        }
        loadGames();
    }, [])

    const filteredGames = games.filter((game) => {
        const matchesSearch = game.title
            .toLowerCase()
            .includes(search.toLowerCase());

        const matchesStatus =
            statusFilter === 'All' || game.status === statusFilter;

        return matchesSearch && matchesStatus;
    });

    const sortedGames = [...filteredGames].sort((a, b) => {
        if (sortBy === "title-asc") {
            return a.title.localeCompare(b.title);
        }

        if (sortBy === "title-desc") {
            return b.title.localeCompare(a.title);
        }

        if (sortBy === "rating-desc") {
            return b.rating - a.rating;
        }

        if (sortBy === "hours-desc") {
            return b.hoursPlayed - a.hoursPlayed;
        }

        if (sortBy === "hours-asc") {
            return a.hoursPlayed - b.hoursPlayed;
        }

        return 0;
    });

    return (
        <>
            <h1 className={"app-title"}>Steam    Backlog     Manager</h1>
            <p>Your games. Your ratings. Your backlog</p>

            <div className="library-controls">
                <input
                    type="text"
                    placeholder="Search games..."
                    value={search}
                    onChange={(event) => setSearch(event.target.value)}
                    className="search-bar"
                />

                <select
                    className="status-filter"
                    value={statusFilter}
                    onChange={(event) => setStatusFilter(event.target.value)}
                >
                    <option value="All">All Statuses</option>
                    <option value="Backlog">Backlog</option>
                    <option value="Playing">Playing</option>
                    <option value="Completed">Completed</option>
                    <option value="Dropped">Dropped</option>
                    <option value="Live Service">Live Service</option>
                </select>

                <select
                    className="sort-filter"
                    value={sortBy}
                    onChange={(event) => setSortBy(event.target.value)}
                >
                    <option value="title-asc">Title A-Z</option>
                    <option value="title-desc">Title Z-A</option>
                    <option value="rating-desc">Highest Rating</option>
                    <option value="hours-desc">Most Hours Played</option>
                    <option value="hours-asc">Least Hours Played</option>
                </select>

            </div>

            <div className={"game-grid"}>
                {sortedGames.map((game) => (
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
