// Containers are special components that you nominate to connect Redux state data
// Usually you want to nominate the most parent component that needs to know specific data

import React, { Component } from 'react';
// You need this 'connect' function to connect React and Redux
import { connect } from 'react-redux';

// For containers, we don't want to export the component anymore - we want to export the container (at the bottom of page)
class BookList extends Component {

  renderList() {
    // Don't forget - you need unique value for 'key' attribute (we're using book.title)
    return this.props.books.map((book) => <li key={book.title} className="list-group-item">{book.title}</li>);
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

// If our application state ever changes, this conainer will instantly re-render with the new list of books, and assigned to this.props

// Export container - passing in mapStateToProps function and BookList Component
export default connect(mapStateToProps)(BookList);
