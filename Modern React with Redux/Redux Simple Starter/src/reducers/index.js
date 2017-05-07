import { combineReducers } from 'redux';
import BooksReducer from './reducer_books';

// Combining all our reducers to create the application's State (eg: state.books)
const rootReducer = combineReducers({
  books: BooksReducer
});

export default rootReducer;
 
