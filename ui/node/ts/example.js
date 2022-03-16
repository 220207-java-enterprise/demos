function log(message) {
    console.log(message);
}
var message = 'Hello, TypeScript!';
function scopingIsEnforced() {
    for (var i = 0; i <= 5; i++) {
        console.log(i);
    }
    // console.log(i);
}
// OOP features 
// enum types
var Color;
(function (Color) {
    Color[Color["RED"] = 0] = "RED";
    Color[Color["GREEN"] = 1] = "GREEN";
    Color[Color["BLUE"] = 2] = "BLUE";
})(Color || (Color = {}));
var backgroundColor = Color.BLUE;
console.log(backgroundColor);
// Reasons interfaces are nice
var drawPoint_1 = function (x, y) {
    // implementation here...
};
var drawPoint_2 = function (point) {
    // implementation here.
};
drawPoint_2({ x: 1, y: 2 });
drawPoint_2({ firstName: 'Bill', lastName: 'Bailey' });
var drawPoint_3 = function (point) {
    // implementation here.
};
drawPoint_3({ x: 1, y: 2 });
var drawPoint_4 = function (point) {
    // implementation here.
};
drawPoint_4({ x: 1, y: 2 });
// drawPoint_4({firstName: 'Bill', lastName: 'Bailey'});
