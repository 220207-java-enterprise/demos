import { Flashcard } from "../models/flashcard";
import { appClient } from "./app-client";

export const getAllCards = async () => {
    return await appClient.get<Flashcard[]>('/flashcards');
}
