// --- Directions
// Write a function that accepts a positive number N.
// The function should console log a pyramid shape
// with N levels using the # character.  Make sure the
// pyramid has spaces on both the left *and* right hand sides
// --- Examples
//   pyramid(1)
//       '#'
//   pyramid(2)
//       ' # '
//       '###'
//   pyramid(3)
//       '  #  '
//       ' ### '
//       '#####'

// function pyramid(rows) {
//   const columns = rows * 2 - 1
//   for (let i = 1; i <= rows; i++) {
//     let result = ''
//     for (let j = 1; j <= columns; j++) {
//       const middleColumn = Math.floor(columns * 0.5) + 1
//       if (j > (middleColumn - i) && j < (middleColumn + i)) {
//         result += '#'
//       } else {
//         result += ' '
//       }
//     }
//     console.log(result)
//   }
// }

const isWithinHashRowRange = (currentIndex, middleColumn, hashes) =>
  (currentIndex > middleColumn - hashes) && (currentIndex < middleColumn + hashes)

function pyramid(rows, hashes = 1) {
  if (hashes > rows) {
    return
  }

  const columns = rows * 2 - 1
  let result = ''

  for (let i = 1; i <= columns; i++) {
    const middleColumn = Math.floor(columns * 0.5) + 1
    if (isWithinHashRowRange(i, middleColumn, hashes)) {
      result += '#'
    } else {
      result += ' '
    }
  }

  console.log(result)

  pyramid(rows, hashes + 1)
}

module.exports = { pyramid }
