// single line comment

/*
    multi
    line
    comment
*/

/**
 * documentation comment
 */

"use strict"; // directive that tells the compiler to enforce type assignments and other syntax rules that are usually "loose"

/*
    JavaScript is a loosely-typed language, not untyped!

        Primitive types:
            - string
            - number
            - boolean
            - null (represents the lack of an object value; primitive root value)
            - undefined (an uninitialized value)
            - bigint
            - Symbol (always unique, even if they contain the same value; excellent for UUIDs)

        Structural types:
            - object
                + Array
                + Set
                + Date
                + Map
                + Function
                + user-defined types
 */
let id_1 = Symbol('test');
let id_2 = Symbol('test');
console.log(id_1 == id_2);

let a_1; // declared, but uninitialzed. value = undefined
let b_1 = null;
let c_1 = undefined;

// standard/named function declarations
function functionA() {
    console.log('This is a named function declaration!');
    return 5;
}

functionA(); // invokes the function named "functionA"

// Because functions are "first-class members" in JS, which means:
//  - we can function declarations to variables (those variables can be used to invoke the function)
//  - pass a function to another function as an argument
//  - return a function from another function
//
// Those last two are examples of what are called "higher-order functions"

// myCallbackFunctions(functionB); // throws ReferenceError, since functionB has no value at this point
// myCallbackFunctions(functionZ); // throws ReferenceError, since there is no declaration with the name "functionZ"

// anonymous function declarations
let functionB = function () {
    console.log('This is an anoynmous function declaration!');
}

functionB(); 

function myCallbackFunctions(someOtherFunction) {
    console.log('This is an example of a callback function (a function that is passed another function as a parameter).');
    someOtherFunction();
}

myCallbackFunctions(functionA);
// myCallbackFunctions(functionA()); // passes the result of functionA as a param to myCallbackFunctions
myCallbackFunctions(functionB);

function functionC() {
    console.log('functionC logic here');
    functionD();
}

functionC();

function functionD() {
    console.log('functionD logic here');
}

function varScopeExample(x) {
    console.log('varScopeExample (1): ' + greeting); // prints undefined
    if (x % 2 == 0) {
        var greeting = 'hello!';
        console.log('varScopeExample (2): ' + greeting); // prints 'hello!'
    }
    console.log('varScopeExample (3): ' + greeting); // prints 'hello!'
}

varScopeExample(2);

console.log('+-----------------------------+');

function varScopeExample_whatsActuallyHappening(x) {
    var greeting;
    console.log('varScopeExample_whatsActuallyHappening (1): ' + greeting); // undefined
    if (x % 2 == 0) {
        greeting = 'hello!';
        console.log('varScopeExample_whatsActuallyHappening (2): ' + greeting); // if x is even, greeting = 'hello!'
    }
    console.log('varScopeExample_whatsActuallyHappening (3): ' + greeting); // if x is even, greeting = 'hello!'
}

varScopeExample_whatsActuallyHappening(2);

console.log('+-----------------------------+');

function letScopeExample(x) {
    // console.log('letScopeExample (1): ' + greeting); // ReferenceError, variables declared using let are not hoisted and therefore greeting is unknown
    if (x % 2 == 0) {
        let greeting = 'hello';
        console.log('letScopeExample (2): ' + greeting);
    }
    // console.log('letScopeExample (3): ' + greeting); // ReferenceError, variables declared using let are not hoisted and therefore greeting is unknown
}

letScopeExample(2);

console.log('+-----------------------------+');

function constScopeExample(x) {
    // console.log('constScopeExample (1): ' + greeting); // ReferenceError, variables declared using const are not hoisted and therefore greeting is unknown
    if (x % 2 == 0) {
        const greeting = 'hello';
        console.log('constScopeExample (2): ' + greeting);
    }
    // console.log('constScopeExample (3): ' + greeting); // ReferenceError, variables declared using const are not hoisted and therefore greeting is unknown
}

constScopeExample(2);

console.log('+-----------------------------+');

// Const
const meaningOfLife = 42;
// meaningOfLife = 43; // TypeError, cannot reassign constant variables

// const willAssignLater; // SyntaxError: Missing initializer in const declaration

let objectA = {
    greeting: 'hello, javascript!!',
    printGreeting: function () {
        console.log('objectA.printGreeting invoked!');
        console.log(this);
        console.log(this.greeting);
    }
}

objectA.printGreeting();

console.log('+-----------------------------+');

let objectB = {
    greeting: 'bonjour!',
    // arrow function (alternative to anonymous function, with a small difference)
    printGreeting: () => {
        console.log('objectB.printGreeting invoked!');
        console.log(this); // refers to the global object (provided by either the browser or NodeJS)
    }
}

objectB.printGreeting();

console.log('+-----------------------------+');

let objectC = {
    greeting: 'hola!',
    greeter: {
        printGreeting: () => {
            console.log('objectC.greeter.printGreeting invoked!');
            console.log(this); // still refers to the global object
        }
    }
}

objectC.greeter.printGreeting();

console.log('+-----------------------------+');

let objectD = {
    greeting: 'hey!',
    greeter: {
        printGreeting: function() {
            console.log('objectD.greeter.printGreeting invoked!');
            console.log(this); 
        }
    }
}

objectD.greeter.printGreeting();

const immutableMaybe = {
    someValue: 10,
    anotherValue: 'test',
    nestedObject: {
        nestedValue: 100
    }
}

console.log(immutableMaybe); // value of immutableMaybe.someValue: 10
immutableMaybe.someValue = 20;
console.log(immutableMaybe); // value of immutableMaybe.someValue: 20


// Error handling
try {
    immutableMaybe = {};
} catch (e) {
    console.log(typeof(e));
    console.error('caught error with message: ' + e.message); // no intellisense to save you in pure JS environments :) 
} finally {
    console.log('this will always execute');
}

// Creating a JS constructor function (can be used with the new keyword)
function Car(make, model, color, year) {

    // Properties/fields
    this.make = make || 'Ford';
    this.model = model || 'Expedition';
    this.color = color || 'Black';
    this.year = year || '2015';

    // Methods
    this.honk = function() {
        console.log("BEEP!");
    }

}

let defaultCar = new Car();
console.log(defaultCar);
let myCar = new Car('Nissan', 'Rogue', 'Grey');
myCar.honk();


// In ECMAScript (ES) v6, the "class" keyword was introduced
// It does nothing new. It's only "sugar syntax"
class Truck {

    // JS Classes can only have one constructor
    constructor(make, model, color, year) {
        this.make = make || 'Ford';
        this.model = model || 'Expedition';
        this.color = color || 'Black';
        this.year = year || '2015';
    }

    honk() {
        console.log('HONK!');
    }

}

let myTruck = new Truck();
myTruck.honk();

console.log('+-----------------------------+');

/*
    Type Coercion and Truthy/Falsy Values

    Falsy Values:
        - ''/"" (empty string)
        - 0, -0, +0, 0n
        - null
        - undefined
        - false
        - NaN
 */


console.log(7 + '7' + 7); // prints: '777'
console.log(7 + 7 + '7'); // prints: '147'

let username = 'wsingleton';
let password = 'password';

if (username != null && username != "") {
    console.log('username is not null or empty. aka truthy!');   
}

if (password) {
    console.log('password is truthy!');   
}

function login(un, pw) {
    console.log('username: ' + un);
    console.log('password: ' + pw);
}

// Guard operator
(username && password) && login(username, password);

console.log('+-------------------------+'); // the above is the exact same (functionally) as the below

if (username && password) {
    login(username, password);
}

console.log('+-------------------------+');

// Default operator
function returnSomeValue(x) {
    return (x % 2 == 0) ? {a: 1} : null;
}

let someValue = returnSomeValue(3) || {b: 2};
console.log(someValue);

// Template literals (simplified string "interpolation"; also respects whitespace within the string)
console.log('The username ' +



'is: ' + username);
console.log(`The password 



is: ${password}`);
console.log(`1 + 4 = ${1 + 4}`);

// Aggregate structures (arrays, maps, sets, etc.)
let numbers = [1, 2, 3, 4, 5] ; // array literal
let myArray = new Array(16); // Array constructor
console.log(numbers);
console.log(myArray);
console.log(numbers[2]);
console.log(numbers.pop());
numbers.push(6);
console.log(numbers);
console.log(numbers[numbers.length - 1]);

// Arrays in JS are not required to be homogenous (though, you should probably avoid this)
let randomValues = [1, 'a', true, {}, {a: 1}, [1, 2, 3], function() {}];

function isEven(number) {
    return number % 2 == 0;
}

let evenNumbers = numbers.filter(isEven);
console.log(evenNumbers);

let oddNumbers = numbers.filter(function(number) {
    return number % 2 != 0;
})
console.log(oddNumbers);

let sameOddNumbers = numbers.filter(number => number % 2 != 0);
console.log(sameOddNumbers);

let timesTenValues = evenNumbers.map(num => num * 10);
console.log(timesTenValues);

let sum = timesTenValues.reduce((accumulator, currentVal) => accumulator + currentVal);
console.log(sum);

console.log(numbers);

let someMap = new Map();
someMap.set('wsingleton', {firstName: 'Wezley', lastName: 'Singleton'});
someMap.set('wsingleton', {firstName: 'Tester', lastName: 'McTesterson'}); // will overwrite the old value associated with the key 'wsingleton'
someMap.set('another', {firstName: 'Another', lastName: 'Yoozer'});
console.log(someMap.get('wsingleton'));

for (let i = 0; i < 10; i++) {
    console.log(i);
}

console.log('+------------------------------+');

// for..of loop (iterates over iterable objects [strings, arrays, maps, etc.])
for (let value of numbers) {
    console.log(typeof(value)); // number
    console.log(value); // prints as a number
}

console.log('+------------------------------+');
// Apparently maps in JS are pure associative arrays (even indexes are keys, odds are values)
for (let entry of someMap) {
    console.log(entry);
}

console.log('+------------------------------+');
// for..in loop (used iterate over the keys of some object) (not typical to use with arrays)
for (let value in numbers) {
    console.log(typeof(value)); // string
    console.log(value); // prints as a string, rather than a number
}

console.log('+------------------------------+');

let me = {
    'firstName': 'Wezley', // legal, but not really required (makes no difference)
    lastName: 'Singleton',
    email: 'wezley.singleton@revature.com',
    username: 'wsingleton',
    '1a': 'but why?',
    'more common': 'you\'ll see this from time to time'
}

me.username; // dot notation access
me["more common"] // bracket notation access

// very useful for iterating over object keys
for (let prop in me) {
    console.log(`${prop}: ${me[prop]}`) // access object members dynamically
}