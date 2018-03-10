// --- Directions
// Check to see if two provided strings are anagrams of eachother.
// One string is an anagram of another if it uses the same characters
// in the same quantity. Only consider characters, not spaces
// or punctuation.  Consider capital letters to be the same as lower case
// --- Examples
//   anagrams('rail safety', 'fairy tales') --> True
//   anagrams('RAIL! SAFETY!', 'fairy tales') --> True
//   anagrams('Hi there', 'Bye there') --> False

const anagrams = (stringA, stringB) => cleanAndSortString(stringA) === cleanAndSortString(stringB);


const cleanAndSortString = string =>
  string
    .replace(/[^\w]/g, "")
    .toLowerCase()
    .split("")
    .sort()
    .join("");

// const covertToSortedObjectMap = string =>
//   string
//     .replace(/[^\w]/g, "")
//     .toLowerCase()
//     .split("")
//     .sort()
//     .reduce((acc, curr) => {
//       acc[curr] ? acc[curr]++ : (acc[curr] = 1);
//       return acc;
//     }, {});

const anagrams = (stringA, stringB) =>
  JSON.stringify(covertToSortedObjectMap(stringA)) ===
  JSON.stringify(covertToSortedObjectMap(stringB));

// const anagrams = (stringA, stringB) => {
//   const objectMapA = covertToSortedObjectMap(stringA);
//   const objectMapB = covertToSortedObjectMap(stringB);
//
//   if(Object.keys(objectMapA).length !== Object.keys(objectMapB).length) return false;
//
//   for (var key in objectMapA) {
//     if(objectMapA[key] !== objectMapB[key]) return false;
//   }
//
//   return true;
// }

module.exports = anagrams;
