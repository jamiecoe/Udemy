import { renderComponent, expect } from '../test_helper';
import CommentList from '../../src/components/comment_list';

describe('CommentList', () => {
  let component;

  beforeEach(() => {
    // 2nd arguement of renderComponent() is where...
    // we can specify any props our component should have
    // 3rd arguement is where we specify an initial redux state
    const intialState = { comments: ['1st comment', '2nd comment'] };
    component = renderComponent(CommentList, null, intialState);
  });

  it('shows an <li> for each comment', () => {
    // if we find every <li> inside component
    // we expect the length to equal 2 (ie: that's how many we passed in with props)
    expect(component.find('li').length).to.equal(2);
  });

  it('shows each comment provided', () => {
    expect(component).to.contain('1st comment');
    expect(component).to.contain('2nd comment');
  });
});
