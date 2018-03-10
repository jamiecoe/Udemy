// --- Directions
// Given a string, return a new string with the reversed
// order of characters
// --- Examples
//   reverse('apple') === 'leppa'
//   reverse('hello') === 'olleh'
//   reverse('Greetings!') === '!sgniteerG'

// function reverse(str) {
//   return str.split('').reverse().join('');
// }

// function reverse(str) {
//   let reverse = '';
//   for (let letter of str) {
//     reverse = letter + reverse;
//   }
//   return reverse;
// }

function reverse(str) {
  debugger;
  return str.split('').reduce((acc, curr) => curr + acc);
}

reverse('asdf');

module.exports = reverse;
