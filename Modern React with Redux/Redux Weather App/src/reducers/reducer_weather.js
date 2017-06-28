import { FETCH_WEATHER } from '../actions/index';

export default function (state = [], action) {
  swtich (action.type) {
    case FETCH_WEATHER :
      // To avoid state mutation, use state.concat()
      // This adds old state values along with new action.payload.data into a new array
      // ES6 syntax, same as saying return state.concat([action.payload.data]);
      return [ action.payload.data, ...state];
  }
  return state;
}
