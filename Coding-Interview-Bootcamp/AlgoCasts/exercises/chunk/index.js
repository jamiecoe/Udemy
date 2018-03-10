// --- Directions
// Given an array and chunk size, divide the array into many subarrays
// where each subarray is of length size
// --- Examples
// chunk([1, 2, 3, 4], 2) --> [[ 1, 2], [3, 4]]
// chunk([1, 2, 3, 4, 5], 2) --> [[ 1, 2], [3, 4], [5]]
// chunk([1, 2, 3, 4, 5, 6, 7, 8], 3) --> [[ 1, 2, 3], [4, 5, 6], [7, 8]]
// chunk([1, 2, 3, 4, 5], 4) --> [[ 1, 2, 3, 4], [5]]
// chunk([1, 2, 3, 4, 5], 10) --> [[ 1, 2, 3, 4, 5]]

// const chunk = (array, size) => {
//   const chunkArray = [];
//   for (var i = 0; i < array.length; i += size) {
//     chunkArray.push(array.slice(i, i + size));
//   }
//   return chunkArray;
// };

const chunk = (array, size) => {
  const chunkArray = [];
  let index = 0;

  while (index < array.length) {
    chunkArray.push(array.slice(index, index + size));
    index += size;
  }
  return chunkArray;
};

// const chunk = (array, size) => {
//   const chunkArray = [];
//   for(let element of array) {
//     const last = chunkArray[chunkArray.length - 1];
//
//     if (!last || last.length === size) chunkArray.push([ element ])
//     else last.push(element)
//
//   }
//   return chunkArray;
// };

module.exports = chunk;
