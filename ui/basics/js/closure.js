
// Make a custom map data structure
// Implementation of the "revealing module" design pattern
// https://medium.com/@Rahulx1/revealing-module-pattern-tips-e3442d4e352
function MyCustomMap() {

    let entryArray = [];

    function checkIfKeyExists(key) {
        for (let i = 0; i < entryArray.length; i+=2) {
            if (entryArray[i] == key) {
                return true;
            }
        }
    }

    function mapPut(key, value) {
        if (checkIfKeyExists) // TODO something
        entryArray.push(key);
        entryArray.push(value);
    }

    function mapGet(key) {
        for (let i = 0; i < entryArray.length; i+=2) {
            if (entryArray[i] == key) {
                return entryArray[i + 1];
            }
        }
    }

    return {
        put: mapPut,
        get: mapGet
    };

}

let myMap = new MyCustomMap();
myMap.put('key-1', 'value-1');
myMap.put('key-2', 'value-2');
myMap.put('key-3', 'value-3');
console.log(myMap.get('key-2'));
console.log(myMap);
