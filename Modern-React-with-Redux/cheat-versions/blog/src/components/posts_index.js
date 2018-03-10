import _ from "lodash";
import React, { Component } from "react";
import { connect } from "react-redux";
import { Link } from "react-router-dom";
import { fetchPosts } from "../actions";

class PostsIndex extends Component {
  // componentDidMount() is a React lifecycle method - a funciton on a React component class which is automatically called by React
  // componentDidMount() will be called immediately by React as soon as this component has shown up inside the DOM
  // Great for if we want to do something as soon as component loads
  componentDidMount() {
    // fetchPosts() is an Action creator which will do an API call to get all posts
    this.props.fetchPosts();
  }

  renderPosts() {
    // this.props.posts is an object (with objects inside), so we use lodash's map function to loop over it, and it'll return an array (which React will render)
    // first arguement is object, second is function for what you want you want to do to each sub object
    return _.map(this.props.posts, post => {
      return (
        <li className="list-group-item" key={post.id}>
          <Link to={`/posts/${post.id}`}>
            {post.title}
          </Link>
        </li>
      );
    });
  }

  render() {
    return (
      <div>
        <div className="text-xs-right">
          <Link className="btn btn-primary" to="/posts/new">
            Add a Post
          </Link>
        </div>
        <h3>Posts</h3>
        <ul className="list-group">
          {this.renderPosts()}
        </ul>
      </div>
    );
  }
}

function mapStateToProps(state) {
  return { posts: state.posts };
}

// Little shortcut - we can just pass fetchPosts action-creator straight into connect(), wrapped in an object
// This means we don't need a mapDispatchToProps function, which can be useful if you want to do some computation on exactly how you want to call the action creator ahead of time
// In this shortcut, connect() is still sorting out the dispatch bit (eg: sending action to all reducers)
export default connect(mapStateToProps, { fetchPosts })(PostsIndex);
