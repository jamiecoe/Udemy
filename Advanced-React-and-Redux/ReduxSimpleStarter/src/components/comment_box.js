import React, { Component } from 'react';
import { connect } from 'react-redux';
import saveComment from '../actions';

class CommentBox extends Component {
  constructor(props) {
    super(props);
    this.state = { comment: '' };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    this.setState({ comment: event.target.value });
  }

  handleSubmit(event) {
    event.preventDefault();
    this.props.saveComment(this.state.comment);
    this.setState({ comment: '' });
  }

  render() {
    return (
      <form onSubmit={this.handleSubmit} className="comment-box">
        <h1>Add a comment</h1>
        <div>
          <textarea
            value={this.state.comment}
            onChange={this.handleChange}
          />
        </div>
        <button action="submit">Submit comment</button>
      </form>
    );
  }
}

export default connect(null, { saveComment })(CommentBox);
