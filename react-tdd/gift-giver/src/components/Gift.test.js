import React from 'react';
import { shallow } from 'enzyme';
import Gift from './Gift';

describe('Gift', () => {
  // jest.fn() creates a mock function
  const mockRemove = jest.fn();
  const id = 1;
  const props = {
    gift: { id },
    // we assign pass down mockRemove as the removeGift prop
    removeGift: mockRemove
  };
  // pass the props in to the shallowly rendered component
  const gift = shallow(<Gift {...props} />);

  it('renders properly', () => {
    expect(gift).toMatchSnapshot();
  });

  it('initializes a person and present in `state`', () => {
    expect(gift.state()).toEqual({ person: '', present: '' });
  });

  describe('when typing into the person input', () => {
    const person = 'Uncle';

    beforeEach(() => {
      // we simulate a 'change' event on an input element
      // we also have to provide an 'event' object, with a nested 'target' object 
      // this 'target' object has a 'value' key with whatever value we want to simulate has been typed 
      gift.find('.input-person').simulate('change', { target: { value: person } });
    });

    it('updates the person in `state`', () => {
      expect(gift.state().person).toEqual(person);
    })
  });

  describe('when typing into the present input', () => {
    const present = 'Golf Clubs';

    beforeEach(() => {
      // we simulate a 'change' event on an input element
      // we also have to provide an 'event' object, with a nested 'target' object 
      // this 'target' object has a 'value' key with whatever value we want to simulate has been typed 
      gift.find('.input-present').simulate('change', { target: { value: present } });
    });

    it('updates the present in `state`', () => {
      expect(gift.state().present).toEqual(present);
    })
  });
  
  describe('when clicking the `Remove Gift` button', () => {
    beforeEach(() => {
      gift.find('.btn-remove').simulate('click');
    });

    it('calls the removeGift callback', () => {
      expect(mockRemove).toHaveBeenCalledWith(id);
    });
  });
});