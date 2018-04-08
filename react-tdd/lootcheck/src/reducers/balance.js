import * as constants from '../actions/constants';
// We're using sfcookies to store the balance in a cookie on FE
// That way, it will persit even when refreshing
import { read_cookie, bake_cookie } from 'sfcookies';

const balance = (state = 0, action) => {
  let balance;
  
  switch(action.type) {
    case constants.SET_BALANCE:
      balance = action.balance;
      break;
    case constants.DEPOSIT:
      balance = state + action.deposit; 
      break;
    case constants.WITHDRAW:
      balance = state - action.withdraw;   
      break;
    default:
      // read_cookie is function that will try to read a cookie based on string that's passed in
      // need to make sure that we convert value of read_cookie(BALANCE_COOKIE) to a number, or if it's a falsy value then just use state
      balance = parseInt(read_cookie(constants.BALANCE_COOKIE)) || state;
      break;
  };
  
  // bake_cookie will create or update a cookie based on it's name and a value to pass in
  bake_cookie(constants.BALANCE_COOKIE, balance);

  return balance;
};

export default balance;