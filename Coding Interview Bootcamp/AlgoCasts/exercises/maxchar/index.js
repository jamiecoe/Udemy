// --- Directions
// Given a string, return the character that is most
// commonly used in the string.
// --- Examples
// maxChar("abcccccccd") === "c"
// maxChar("apple 1231111") === "1"

function maxChar(str) {
  const maxCharObj = str.split('').reduce((acc, curr) => {
    acc[curr] ? acc[curr]++ : acc[curr] = 1;
    return acc;
  }, {});

  return Object.keys(maxCharObj).sort((a, b) => maxCharObj[b] - maxCharObj[a])[0];

}

// function maxChar(str) {
//   const chars = {};
//   for (char of str) {
//     chars[char] = chars[char]++ || 1;
//   }
//
//   let max = 0;
//   let maxChar = '';
//
//   for (var char in chars) {
//     if (chars[char] > max) {
//       max = chars[char];
//       maxChar = char;
//     }
//   }
//
//   return maxChar;
// }

module.exports = maxChar;
