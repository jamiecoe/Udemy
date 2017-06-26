import React, { Component } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import { fetchWeather } from '../actions/index';

class SearchBar extends Component {

  constructor(props) {
    super(props);

    this.state = { term: '' };

    // bind onInputChange to context of 'this' (ie: SearchBar class) and replace function with this new version
    this.onInputChange = this.onInputChange.bind(this);
    // Do the same for onFormSubmit, because it's also a callback function - so need to explicitedly set 'this' to be SearchBar container
    this.onFormSubmit = this.onFormSubmit.bind(this);
  }

  onInputChange(event) {
    // In order for this.setState to refer to context of SearchBar, you must bind the function in the constructor
    this.setState({
      term: event.target.value
    });
  }

  onFormSubmit(event) {
    // This stops the <form> element automatically trying to submit search values to server when you press enter or submit button
    event.preventDefault

    this.props.fetchWeather(this.state.term);
    // this will cause the component to re-render with an empty input field
    this.setState({ term: '' });
  }

  render() {
    // We want <form> to be a 'controlled field' - where the value of the input is set by the state of our component
    return (
      <form onSubmit={this.onFormSubmit} className="input-group">
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

function mapDispatchToProps(dispatch) {
  return bindActionCreators({ fetchWeather }, dispatch);
}

// First arguement is null because this container doesn't use Redux global state anywhere
// mapDispatchToProps needs to be 2nd arguement
export default connect(null, mapDispatchToProps)(SearchBar);
