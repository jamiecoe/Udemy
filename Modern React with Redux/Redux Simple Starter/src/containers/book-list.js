// Containers are special components that you nominate to connect Redux state data
// Usually you want to nominate the most parent component that needs to know specific data

import React, { Component } from 'react';
// You need this 'connect' function to connect React and Redux
import { connect } from 'react-redux';

// This is our action creator
import { selectBook } from '../actions/index';
// This function makes sure our action actually ends up flowing through all our reducers
import { bindActionCreators } from 'redux';

// For containers, we don't want to export the component anymore - we want to export the container (at the bottom of page)
class BookList extends Component {

  renderList() {
    // Don't forget - you need unique value for 'key' attribute (we're using book.title)
    return this.props.books.map((book) =>
      <li
        key={book.title}
        onClick={() => this.props.selectBook(book)}
        className="list-group-item">
          {book.title}
      </li>
    );
  }

  render() {
    return (
      <ul className="list-group col-sm-4">
        {this.renderList()}
      </ul>
    )
  }
}

function mapStateToProps(state) {
  // Whatever is returned will show up as props inside of BookList (eg: this.props.books)
  return {
    books: state.books
  };
}

// Anything retured from this function will end up as props on the BookList container
// This is why we specifically pass in object into bindActionCreators, and what allows bindActionCreators to know when we have called selectBook
function mapDispatchToProps(dispatch) {
  // Whenever selectBook is called, the result should be passed to all of our reducers
  // bindActionCreators takes action creator (eg: selectBook) as first arguement
  // then whenever selectBook gets called - run the result through 'dispatch' which sends it through all the reducers
  return bindActionCreators({ selectBook: selectBook }, dispatch);
}

// If our application state ever changes, this container will instantly re-render with the new list of books, and assigned to this.props

// Export container - passing in mapStateToProps function and BookList Component
// Promote BookList from a component to a container
// It needs to know about this new dispatch method 'selectBook'
// Make it available as a prop
export default connect(mapStateToProps, mapDispatchToProps)(BookList);
