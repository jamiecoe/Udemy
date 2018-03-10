import React, { Component } from 'react';

// By extending it, SearchBar has access to all functionality of Component
// Props can be used in a class based component, as this.props
class SearchBar extends Component {

  // Initialising state in a class-based component
  // constructor() is a special function which gets called automatically whenever a new instance of the class is created
  // contructor() does some special setup inside of our class (eg: initialising variables and state)
  constructor(props) {
    // super() is the constructor function on Component class
    super(props);
    // we set state to be a JS object with any properties we want to record (eg: 'term' will be our yt searchterm)
    // This is the only time we will set the state in this way! The rest of the time we use this.setState()
    this.state = { term: '' };
  }

  // Every class based component must have a render() method
  // This is what returns the JSX
  // We making a controlled component by setting the value of the input with this.state (not the otherway around!)
  // This makes it very easy to access the value of the input! It's just this.state.term
  render() {
    return (
      <div className="search-bar">
        <input
          value={this.state.term}
          onChange={event => this.onInputChange(event.target.value)} />
      </div>
    );
  }

  onInputChange(term) {
    // We update state using the this.setState, and pass in a new object with the new value we want
    this.setState({term});
    this.props.onSearchTermChange(term);
  }
}

export default SearchBar;
