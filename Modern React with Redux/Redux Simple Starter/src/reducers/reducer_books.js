// A reducer is a function that returns a piece of the application's state
// This reducer is responsible for producing the lsist of books

export default function() {
  return [
    { title: 'JS: The Good Parts', pages: 50},
    { title: 'Harry Potter', pages: 355},
    { title: 'The Dark Tower', pages: 234},
    { title: 'Eloquent Ruby', pages: 135}
  ]
}
