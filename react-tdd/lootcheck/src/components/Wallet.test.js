import React from "react";
import { shallow } from "enzyme";
// We can't test the Redux connected Wallet component, so we also export the unconnected class Wallet component
// This is what we're importing here
import { Wallet } from "./Wallet";

describe("Wallet", () => {
  // create a mock function for the deposit action creator
  const mockDeposit = jest.fn();
  const mockWithdraw = jest.fn();
  const props = { balance: 20, deposit: mockDeposit, withdraw: mockWithdraw };
  const wallet = shallow(<Wallet {...props} />);

  it("renders properly", () => {
    expect(wallet).toMatchSnapshot();
  });

  it("diesplays the balance from props", () => {
    // text() is a function on shallowly rendered components
    // it will get you any inner text inside a component
    expect(wallet.find(".balance").text()).toEqual(
      `Wallet balance: ${props.balance}`
    );
  });

  it("creates an input to deposit into or withdraw from the balance", () => {
    expect(wallet.find(".input-wallet").exists()).toBe(true);
  });

  describe("when the user types into the wallet input", () => {
    const userBalance = "25";

    beforeEach(() => {
      wallet
        .find(".input-wallet")
        // remember that to simulate the user typing text into an input - we use 'change' event and pass in a fake event object
        .simulate("change", { target: { value: userBalance } });
    });

    it("updates the local wallet balance in `state` and converts it to a number", () => {
      expect(wallet.state().balance).toEqual(parseInt(userBalance));
    });

    describe("and the user wants to make a desposit", () => {
      beforeEach(() => wallet.find(".btn-deposit").simulate("click"));

      it("dispatches the `desposit()` it receives from props with the local balance", () => {
        expect(mockDeposit).toHaveBeenCalledWith(parseInt(userBalance));
      });
    });

    describe("and the user wants to make a withdrawal", () => {
      beforeEach(() => wallet.find(".btn-withdraw").simulate("click"));

      it("dispatches the `withdraw()` it receives from props with the local balance", () => {
        expect(mockWithdraw).toHaveBeenCalledWith(parseInt(userBalance));
      });
    });
  });
});
