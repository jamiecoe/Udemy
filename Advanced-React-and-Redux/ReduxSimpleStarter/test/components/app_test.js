import { renderComponent, expect } from '../test_helper';
import App from '../../src/components/app';

// Use describe to group together similar tests
describe('App', () => {
  let component;

  beforeEach(() => {
    component = renderComponent(App);
  });

  // Here we're just tessting that inside App component, there's something with 'comment-box' class
  // rather than testing for CommentBox component
  // This is StephenGrider technique of testing output HTML rather than component
  // This way we can change/delete CommentBox
  // but test will pass along as there's some output HTML with class 'comment-box'
  it('shows a comment box', () => {
    expect(component.find('.comment-box')).to.exist;
  });

  it('shows a comment list', () => {
    expect(component.find('.comment-list')).to.exist;
  });
});
