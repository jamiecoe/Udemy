import { renderComponent, expect } from '../test_helper';
import CommentBox from '../../src/components/comment_box';

describe('CommentBox', () => {
  let component;

  // beforeEach is a function that runs before each it() statement
  // good for doing setup
  beforeEach(() => {
    component = renderComponent(CommentBox);
  });

  it('has the correct class', () => {
    expect(component).to.have.class('comment-box');
  });

  it('has a text area', () => {
    // renderComponent returns a jquery object that contains your React component
    // So we can then use jquery methods on returned object (eg: find())
    // This allows us to make assertions on the HTML our components produce
    expect(component.find('textarea')).to.exist;
  });

  it('has a button', () => {
    expect(component.find('button')).to.exist;
  });

  // you can nest a new describe() inside a describe(), to group sub-related tests
  describe('entering some text', () => {
    // this beforeEach() will only run before the nested it()
    // the previous beforeEach() will also run before each of these nested it()
    // the top beforeEach() will run first, then the nested beforeEach()
    beforeEach(() => {
      // find textarea html element inside component
      // then 'simulate' a 'change' event (ie: when user enters new text)
      // so simulate 'change' event with text 'new comment'
      component.find('textarea').simulate('change', 'new comment');
    });

    it('shows text that is entered', () => {
      expect(component.find('textarea')).to.have.value('new comment');
    });

    it('when submitted, clears the input', () => {
      component.simulate('submit');
      expect(component.find('textarea')).to.have.value('');
    });
  });
});
