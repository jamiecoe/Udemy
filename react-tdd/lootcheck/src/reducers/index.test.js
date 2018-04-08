import rootReducer from './index';

describe('rootReducer', () => {
  it('initializes the default state', () => {
    // if we call our rootReducer with an empty state {} and action {}, 
    // we should get back an object with the default values of our two reducers
    expect(rootReducer({}, {})).toEqual({ balance: 0, bitcoin: {} });
  });
});