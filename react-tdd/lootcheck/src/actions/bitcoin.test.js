import configureMockStore from "redux-mock-store";
import thunk from "redux-thunk";
import fetchMock from "fetch-mock";
import { FETCH_BITCOIN } from "./constants";
import { fetchBitcoin } from "./bitcoin";

// pass in any middleware inside an array
const createMockStore = configureMockStore([thunk]);
// initialise the store with data, by passing in an object
const store = createMockStore({ bitcoin: {} });

const mockResponse = {
  body: {
    bpi: "bitcoin price index"
  }
};

// use fetchMock to stub out the coindesk api endpoint
// in our tests, any GET requests to this url will return the mockResponse object
fetchMock.get(
  "https://api.coindesk.com/v1/bpi/currentprice.json",
  mockResponse
);

it("creats an async action to fetch the bitcoin value", () => {
  const expectedActions = [{ bitcoin: mockResponse.body, type: FETCH_BITCOIN }];
	// mock a dispatch of our fetchBitcoin action creator, which returns a promise
	// in order to test a promise in an 'it()' block, we need to 'return' the promise inside the it() block
	// otherwise jest can't properly execute the test
  return store.dispatch(fetchBitcoin()).then(() => {
    expect(store.getActions()).toEqual(expectedActions);
  });
});
