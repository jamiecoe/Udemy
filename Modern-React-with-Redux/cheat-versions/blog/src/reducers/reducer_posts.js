import _ from "lodash";
import { FETCH_POSTS, FETCH_POST, DELETE_POST } from "../actions";

export default function(state = {}, action) {
  switch (action.type) {
    case DELETE_POST:
      // omit() takes in an object and a key (eg: state and action.payload)
      // it will return a new object, but the key (and associated value) you provided will be omitted
      return _.omit(state, action.payload);
    case FETCH_POST:
      // ES6 syntax - putting brackets around action.payload.data.id tells it to make a new key on the object
      return { ...state, [action.payload.data.id]: action.payload.data };
    case FETCH_POSTS:
      // action.payload.data will come through as an array, eg: [ { id: 1, text: 'hello' }, { id: 2, text: 'goodbye' } ]
      // we want to convert it into an object using the id property as a key, eg: { 1: { id: 1, text: 'hello' }, 2: { id: 2, text: 'goodbye' } }
      // lodash has nice function for doing this, mapKeys()
      // First arguement is array we want to covert, second arguement is property that we want to make the key
      return _.mapKeys(action.payload.data, "id");
    default:
      return state;
  }
}
