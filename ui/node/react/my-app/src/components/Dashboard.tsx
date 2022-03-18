import { useEffect, useState } from "react";
import { Navigate } from "react-router-dom";
import { Flashcard } from "../models/flashcard";
import { Principal } from "../models/principal";
import { getAllCards } from "../remote/card-service";

interface IDashboardProps {
    currentUser: Principal | undefined
}

function Dashboard(props: IDashboardProps) {

    // This is not a piece of component state
    // Changing its value will not force a re-render of the component
    // let cards: Flashcard[] = [];
    const [cards, updateCards] = useState<any[]>([]);

    // a function that will fire off each time the component
    // is rendered
    useEffect(() => {
        if (cards.length == 0) {
            getAllCards().then(resp => {
                updateCards(resp.data);
            });
        }
    });

    return (
        !props.currentUser ? <Navigate to="/login"/> :
        <>
            <h1>Welcome, {props.currentUser.username}!</h1>
            {cards.map((card, idx) => {
                return (
                    <div key={idx}>
                        <h4>Card Id: {card.id}</h4>
                        <h5>Question: {card.questionText}</h5>
                        <h5>Answer: {card.answerText}</h5>
                        <h5>Creator: {card.creator.username}</h5>
                        <h5>Category: {card.category.categoryName}</h5>
                        <hr/>
                    </div>
                )
            })}
        </>
    )
}

export default Dashboard;