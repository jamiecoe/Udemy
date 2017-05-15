import React, { Component } from 'react';

export default class SearchBar extends Component {

  constructor(props) {
    super(props);

    this.state = { term: '' };

    // bind onInputChange to context of 'this' (ie: SearchBar class) and replace function with this new version
    this.onInputChange = this.onInputChange.bind(this);
  }

  onInputChange(event) {
    // In order for this.setState to refer to context of SearchBar, you must bind the function in the constructor
    this.setState({
      term: event.target.value
    });
  }

  render() {
    return (
      <form className="input-group">
        <input
          placeholder="Get a five-day forecast in your favourite cities"
          className="form-control"
          value={this.state.term}
          onChange={this.onInputChange}
        />
        <span className="input-group-btn">
          <button type="submit" className="btn btn-secondary">Submit</button>
        </span>
      </form>
    )
  }
}
