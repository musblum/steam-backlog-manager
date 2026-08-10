import './GameCard.css'
import {Link} from "react-router-dom";

function GameCard(props){
    return(
        <Link to={`/games/${props.id}`} className="game-card-link">
            <div className="game-card">
                <div className='game-card'>
                    <img
                        className="game-cover"
                        src={props.imgUrl}
                        alt={props.title}
                    />
                    <div className='game-info'>
                        <p className="game-title">{props.title}</p>
                        <p className='game-hours'>{props.hoursPlayed} Hours</p>
                        <p className='game-status'>{props.status}</p>
                    </div>
                    <div className="game-rating">
                        {[...Array(10)].map((_, index) => (
                            <span
                                key={index}
                                className={index < props.rating ? "heart filled" : "heart"}
                            >
            ♥
        </span>
                        ))}
                    </div>
                </div>
            </div>
        </Link>
    )
}
export default GameCard