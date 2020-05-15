// --- Directions
// Write a function that accepts a positive number N.
// The function should console log a step shape
// with N levels using the # character.  Make sure the
// step has spaces on the right hand side!
// --- Examples
//   steps(2)
//       '# '
//       '##'
//   steps(3)
//       '#  '
//       '## '
//       '###'
//   steps(4)
//       '#   '
//       '##  '
//       '### '
//       '####'

// function steps(n) {

//   for (let column = 0; column < n; column++) {
//     let rowStr = ''

//     for (let row = 0; row < n; row++) {
//       if (column >= row) {
//         rowStr += '#'
//       } else {
//         rowStr += ' '
//       }
//     }

//     console.log(rowStr)
//   }
// }

function steps(n, hashes = 1) {
  if (hashes > n) {
    return
  }

  let rowStr = ''
  
  for (let i = 0; i < n; i++) {
    if (hashes > i) {
      rowStr += '#'
    } else {
      rowStr += ' '
    }
  }

  console.log(rowStr)

  steps(n, hashes + 1)
}

module.exports = steps;
