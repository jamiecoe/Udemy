import React from 'react';
import ReactDOM from 'react-dom';

import SearchBar from './components/search_bar';

const API_KEY = 'AIzaSyCfg1UFE6Ycgg9s9OW2n0_SVCMA16cwb-o';

// Create a new component, which produces some HTML
const App = () => {
  return(
    <div>
      <SearchBar />
    </div>
  )
}


// Take this componenet's HTML ans put it in the DOM
ReactDOM.render(<App />, document.querySelector('.container'));
