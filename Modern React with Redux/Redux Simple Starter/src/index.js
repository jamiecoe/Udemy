import React from 'react';
import ReactDOM from 'react-dom';

// Create a new component, which produces some HTML
const App = () => <div>Hi!</div>;


// Take this componenet's HTML ans put it in the DOM
ReactDOM.render(<App />, document.querySelector('.container'));
