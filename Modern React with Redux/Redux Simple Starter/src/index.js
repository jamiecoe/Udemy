import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import YTSearch from 'youtube-api-search';
import SearchBar from './components/search_bar';
const API_KEY = 'AIzaSyCfg1UFE6Ycgg9s9OW2n0_SVCMA16cwb-o';

// Create a new component, which produces some HTML
class App extends Component {

  constructor(props) {
    super(props);

    this.state = { videos: [] };

    YTSearch({key: API_KEY, term: 'surfboards'}, (videos) => {
      this.setState({ videos });
      //this.setState({ videos: vidoes });
    });
  }

  render() {
    return(
      <div>
        <SearchBar />
      </div>
    )
  }
}


// Take this componenet's HTML ans put it in the DOM
ReactDOM.render(<App />, document.querySelector('.container'));
