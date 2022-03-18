import { User } from "./user";

export class Flashcard {

    id: string;
    questionText: string;
    answerText: string;
    creator: User;
    category: string;

    constructor(id: string, questionText: string, answer: string, creator: User, category: {id: string, categoryName: string}) {
        this.id = id;
        this.questionText = questionText;
        this.answerText = answer;
        this.creator = creator;
        this.category = category.categoryName;
    }

}