const fs = require('fs');
const input = fs.readFileSync("/dev/stdin").toString().split('\n');

const A = parseInt(input[0]);
const B = parseInt(input[1]);


console.log(A*(B%10));
console.log((A*parseInt((B%100)/10)));
console.log((A*parseInt(B/100)));
console.log(A*B);