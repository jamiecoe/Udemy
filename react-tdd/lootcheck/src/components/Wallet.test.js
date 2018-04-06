import React from 'react';
import { shallow } from 'enzyme';
import { Wallet } from './Wallet';

describe('Wallet', () => {
  const props = { balance: 20 }
  const wallet = shallow(<Wallet {...props}/>);

  it('renders properly', () => {
    expect(wallet).toMatchSnapshot();
  });

  it('diesplays the balance from props', () => {
    // text() is a function on shallowly rendered components
    // it will get you any inner text inside a component
    expect(wallet.find('.balance').text()).toEqual(`Wallet balance: ${props.balance}`);
  })
});