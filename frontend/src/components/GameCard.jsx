import './GameCard.css'

function GameCard(props){
    return(
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
    )
}
export default GameCard