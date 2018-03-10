import _ from 'lodash';
import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import YTSearch from 'youtube-api-search';
import SearchBar from './components/search_bar';
import VideoList from './components/video_list';
import VideoDetail from './components/video_detail';

const API_KEY = '';



// Create a new component, which produces some HTML
class App extends Component {
  constructor(props) {
    super(props);

    this.state = {
      videos: [],
      selectedVideo: null
    };

    this.videoSearch('Surfboards')
  }

  videoSearch(term) {
    YTSearch({key: API_KEY, term}, (videos) => {
      // ES6 key/values with identical names only need to be written once
      this.setState({
        videos,
        selectedVideo: videos[0]
      });
      // this.setState({ videos: videos })
    });
  }

  render() {

    // We're using lodash to create a debounced version of the video search function
    // debounce takes function and returns a new one that can only be called every 300 milliseconds
    const videoSearch = _.debounce((term) => { this.videoSearch(term) }, 300);

    // Passing videos to child components is easy
    // Just define a property on component and set it to the variable
    // Passing data like this is known as passing 'props' in React (ie: we're passing prop 'videos' to the VideoList component)
    // Anytime App re-renders, VideoList will get new this.state.videos
    // In order to update selectedVideo, we pass a callback function to VideoList > VideoListItems, which updates the state of App
    // Same idea with passing an 'onSearchTermChange' function to SearchBar
    return(
      <div>
        <SearchBar onSearchTermChange={videoSearch}/>
        <VideoDetail video={this.state.selectedVideo}/>
        <VideoList
          onVideoSelect={selectedVideo => this.setState({selectedVideo}) }
          videos={this.state.videos}
        />
      </div>
    );
  }
}





// Take this component's generated html and put it in the DOM (ie: on the page)
ReactDOM.render(<App />, document.querySelector('.container'));
