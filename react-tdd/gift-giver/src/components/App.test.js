import React from 'react';
// we can create a mock version of components with 'shallow'
// we can shallowly render a component,
// this means if the component has any inner child components - it will only render the outer jsx
// for that inner child component, but not its full inner content
import { shallow } from 'enzyme';
import App from './App';

// shallow() takes in JSX as arguement, and returns an object which represents our component in the react test envirnoment
const app = shallow(<App />);

it('renders correctly', () => {
  expect(app).toMatchSnapshot();
});

// use `` to note that something is special object or variable
it('initialises the `state` with an empty list of gifts', () => {
  expect(app.state().gifts).toEqual([]);
});

it('adds a new gift to `state` when clicking the `add gift` button', () => {
  // you can find child elements by their class name or jsx name
  // you can simulate events on shallowly rendered components eg: click
  app.find('.btn-add').simulate('click');

  // after a click, we expect that state.gifts should have a object inside with an id of 1
  expect(app.state().gifts).toEqual([{ id: 1 }]);
});

it('adds a new gift to the rendered list when clicking the `add gift` button', () => {
  // simulate a click on the button
  app.find('.btn-add').simulate('click');

  // enzyme provides a 'children()' function which can be called on found node
  // it will return an array of all the child nodes
  // after a click, we expect our gift-list node to have one child node
  expect(app.find('.gift-list').children()).toHaveLength(1);
});
