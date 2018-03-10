import { combineReducers } from "redux";
// get a special reducer from redux-form
// This saves us from having to wire up a bunch of action creators
import { reducer as formReducer } from "redux-form";
import PostsReducer from "./reducer_posts";

// formReducer MUST be assigned to a key called 'form'
const rootReducer = combineReducers({
  posts: PostsReducer,
  form: formReducer
});

export default rootReducer;
