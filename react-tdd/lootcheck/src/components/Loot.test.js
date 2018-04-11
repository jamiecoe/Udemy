import React from "react";
// 'mount' is more powerful version of 'shallow'
// It will render all inner children of a component, and will fire lifecycle hooks like componentDidMount
import { mount, shallow } from "enzyme";
import { Loot } from "./Loot";

describe("Loot", () => {
  let props = { balance: 10, bitcoin: {} };
  let loot = shallow(<Loot {...props} />);

  it("renders properly", () => {
    expect(loot).toMatchSnapshot();
  });

  describe("when mounted", () => {
    const mockFetchBitcoin = jest.fn();
    // using beforeEach() seems to isolate the new rendered component (eg: `loot = mount(<Loot {...props} />)`) to this block of tests
    beforeEach(() => {
      // you need `disableLifecycleMethods: true` in setupTest.js order to assign a value to props
      props.fetchBitcoin = mockFetchBitcoin;
      // mounting component instead of shallow render, so we can test lifecycle methods
      loot = mount(<Loot {...props} />);
    });

    it("dispatches the `fetchBitcoin` method it receives from props", () => {
      expect(mockFetchBitcoin).toHaveBeenCalled();
    });
  });

  describe("when there are valid bitcoin props", () => {
    beforeEach(() => {
      props = { balance: 10, bitcoin: { bpi: { USD: { rate: "1,000" } } } };
      loot = shallow(<Loot {...props} />);
    });

    it("displays the correct bitcoin value", () => {
      expect(loot.find("h3").text()).toEqual('Bitcoin balance: 0.01');
    });
  });
});
