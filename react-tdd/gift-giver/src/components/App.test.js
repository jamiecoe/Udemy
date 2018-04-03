import React from 'react';
// we can create a mock version of components with 'shallow'
// we can shallowly render a component,
// this means if the component has any inner child components - it will only render the outer jsx
// for that inner child component, but not its full inner content
import { shallow } from 'enzyme';
import App from './App';

describe('App', () => {

  // shallow() takes in JSX as arguement, and returns an object which represents our component in the react test envirnoment
  const app = shallow(<App />);

  it('renders correctly', () => {
    expect(app).toMatchSnapshot();
  });
  
  // use `` to note that something is special object or variable
  it('initialises the `state` with an empty list of gifts', () => {
    expect(app.state().gifts).toEqual([]);
  });
  
  describe('when clicking the `add-gift` button', () => {
    const id = 1;
    // before each of these tests, simulate a click on the `btn-add` button
    beforeEach(() => {
      // you can find child elements by their class name or jsx name
      // you can simulate events on shallowly rendered components eg: click
      app.find('.btn-add').simulate('click');
    });

    // After each test, reset state so the gifts array is empty
    afterEach(() => {
      app.setState({ gifts: [] });
    });

    it('adds a new gift to `state`', () => {
      // after a click, we expect that state.gifts should have a object inside with an id of 1
      expect(app.state().gifts).toEqual([{ id }]);
    });
    
    it('adds a new gift to the rendered list', () => {          
      // enzyme provides a 'children()' function which can be called on found node
      // it will return an array of all the child nodes
      // after a click, we expect our gift-list node to have one child node
      expect(app.find('.gift-list').children()).toHaveLength(1);
    });

    it('creates a Gift component', () => {
      expect(app.find('Gift').exists()).toBe(true);
    });

    describe('and the user wants to remove the added gift', () => {
      beforeEach(() => {
        // we get an instance of the shallow component with .instance()
        // This allows us to call component class methods 
        app.instance().removeGift(id);
      });

      it('removes the gift crom `state`', () => {
        expect(app.state().gifts).toEqual([]);
      });
    });
  });

});

