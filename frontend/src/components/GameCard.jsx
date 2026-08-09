function GameCard(props){
    return(
        <div>
            <p>{props.title}</p>
            <p>{props.hoursPlayed} Hours</p>
        </div>
    )
}
export default GameCard