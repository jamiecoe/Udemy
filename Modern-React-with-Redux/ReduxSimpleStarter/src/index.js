import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux';
import { createStore, applyMiddleware } from 'redux';
// BrowserRouter interacts with the History library and decides what to do based on a change in the url
// The term BrowserRouter in particular is saying 'I want ReactRouter to look at the entire url when deciding what components to show on the screen'
import { BrowserRouter, Route, Switch } from 'react-router-dom';

import App from './components/app';
import reducers from './reducers';

const createStoreWithMiddleware = applyMiddleware()(createStore);

class Hello extends React.Component {
  render() {
    return <div>Hello!</div>
  }
}

class Goodbye extends React.Component {
  render() {
    return <div>Goodybye!</div>
  }
}

// Switch stops unwanted components rendering due to React's fuzzy matching
// You want the more specific urls to come first  
ReactDOM.render(
  <Provider store={createStoreWithMiddleware(reducers)}>
    <BrowserRouter>
      <div>
        <Switch>
          <Route path="/goodbye" component={Goodbye}/>
          <Route path="/" component={Hello} />
        </Switch>
      </div>
    </BrowserRouter>
  </Provider>
  , document.querySelector('.container'));
