import { useEffect, useState } from "react";
import "./StatsDashboard.css";

function StatsDashboard() {
    const [stats, setStats] = useState(null);

    useEffect(() => {
        fetch("http://localhost:8080/api/games/stats")
            .then((response) => response.json())
            .then((data) => setStats(data));
    }, []);

    if (!stats) {
        return <p>Loading...</p>;
    }

    return (
        <div className="stats-dashboard">
            <h1>Library Stats</h1>

            <div className="stats-grid">
                <div className="stat-card featured-stat">
                    <h2>Total Games</h2>
                    <p>{stats.totalGames}</p>
                </div>

                <div className="stat-card featured-stat">
                    <h2>Total Hours</h2>
                    <p>{stats.totalHours}</p>
                </div>

                <div className="stat-card">
                    <h2>Backlog</h2>
                    <p>{stats.backlog}</p>
                </div>

                <div className="stat-card">
                    <h2>Playing</h2>
                    <p>{stats.playing}</p>
                </div>

                <div className="stat-card">
                    <h2>Completed</h2>
                    <p>{stats.completed}</p>
                </div>

                <div className="stat-card">
                    <h2>Dropped</h2>
                    <p>{stats.dropped}</p>
                </div>

                <div className="stat-card">
                    <h2>Live Service</h2>
                    <p>{stats.liveService}</p>
                </div>
            </div>
        </div>
    );

}

export default StatsDashboard;