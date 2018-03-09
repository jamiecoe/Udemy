import _ from 'lodash';
import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import YTSearch from 'youtube-api-search';
import SearchBar from './components/search_bar';
import VideoList from './components/video_list';
import VideoDetail from './components/video_detail';
require('env2')('config.env');
const API_KEY = process.env.YT_API_KEY;


// Create a new component, which produces some HTML
class App extends Component {

  constructor(props) {
    super(props);

    this.state = {
      videos: [],
      selectedVideo: null
    };

    this.videoSearch('surboards');
  }

  videoSearch(term) {
    YTSearch({key: API_KEY, term: term}, (videos) => {
      // this.setState({ videos }); //Same as writing: this.setState({ videos: vidoes });
      this.setState({
        videos: videos,
        selectedVideo: videos[0]
      })
    });
  }

  render() {
    // use lodash.debounce function to put a 300ms delay on the term => this.videoSearch(term) function
    // ie: you can only call new function videoSearch once every 300ms, it won't crash if you try but just will only work once within 300ms period
    const videoSearch = _.debounce(term => {this.videoSearch(term)}, 300);

    return(
      <div>
        <SearchBar onSearchTermChange={videoSearch} />
        <VideoDetail video={this.state.selectedVideo} />
        <VideoList
          videos={this.state.videos}
          onVideoSelect={selectedVideo => this.setState({selectedVideo}) }/>
      </div>
    )
  }
}


// Take this componenet's HTML ans put it in the DOM
ReactDOM.render(<App />, document.querySelector('.container'));
