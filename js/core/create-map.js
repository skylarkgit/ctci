// Create a new method in array that simulates [].map functionality

Array.prototype.map2 = function(mapper) {
    var mapped = [];
    for (var i = 0; i<this.length; i++) {
        mapped.push(mapper(this[i]));
    }
    return mapped;
}

console.log([5, 8, 2, 6, 1].map2(k => k*2));