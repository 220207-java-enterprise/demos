function log(message: string) {
    console.log(message);
}

let message = 'Hello, TypeScript!';

function scopingIsEnforced() {
    for (let i = 0; i <= 5; i++) {
        console.log(i);
    }

    // console.log(i);
}

// OOP features 

// enum types
enum Color {
    RED = 0,
    GREEN = 1,
    BLUE = 2
}

let backgroundColor = Color.BLUE;
console.log(backgroundColor);

// Reasons interfaces are nice

let drawPoint_1 = (x: number, y: number) => {
    // implementation here...
}

let drawPoint_2 = (point) => {
    // implementation here.
}

drawPoint_2({x: 1, y: 2});
drawPoint_2({firstName: 'Bill', lastName: 'Bailey'});


let drawPoint_3 = (point: {x: number, y: number}) => {
    // implementation here.
}

drawPoint_3({x: 1, y: 2});
// drawPoint_3({firstName: 'Bill', lastName: 'Bailey'});

interface Point {
    x: number,
    y: number
}

let drawPoint_4 = (point: Point) => {
    // implementation here.
}

drawPoint_4({x: 1, y: 2});
// drawPoint_4({firstName: 'Bill', lastName: 'Bailey'});