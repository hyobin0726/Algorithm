const fs = require('fs');
const input = fs.readFileSync("/dev/stdin").toString().split('\n');
const [n,d,k,c] =input[0].split(' ').map(Number);
const s = input.slice(1).map(Number);

let right = k;
let left = 0;

let answer = 0;

while (left < n) {
    const a = new Set();
    
    for ( let i = left; i<right; i++){
        a.add(s[i%n]);
    }
    if (! a.has(c)) {
        a.add(c);
    }
    answer = Math.max( answer, a.size);
    left ++;
    right ++;
}

console.log(answer);