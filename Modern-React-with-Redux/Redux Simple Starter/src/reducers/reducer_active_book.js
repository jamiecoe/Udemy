// All reducers get two arguements - 'state' and 'action'
// reducers are only ever called when an action occurs
// 'state' arguement is not application state, only the state this reducer is responsible for

// We need to handle when app is first booted up and no book has been selected
// 'state' will be undefined which Redux can't handle, we must always return a non undefined value
// To handle this, we'll use ES6 syntax to make state's default value null if it's undefined

// State shouldn't be mutated! We always want to return a fresh object

export default function(state = null, action) {
  switch (action.type) {
    case 'BOOK_SELECTED':
      return action.payload;
    // if we don't care about the current action, just pass the same state through
    default:
      return state;
  }
}
