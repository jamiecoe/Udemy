import React from "react";
import ReactDOM from "react-dom";
import { Provider } from "react-redux";
import { createStore, applyMiddleware } from "redux";
// BrowserRouter interacts with History library and decides exactly what to do based on a change in the url
// The term BrowserRouter in particular is saying 'I want ReactRouter to look at the entire url when deciding what components to show on the screen'
import { BrowserRouter, Route, Switch } from "react-router-dom";
import promise from "redux-promise";

import reducers from "./reducers";
import PostsIndex from "./components/posts_index";
import PostsNew from "./components/posts_new";
import PostsShow from "./components/posts_show";

const createStoreWithMiddleware = applyMiddleware(promise)(createStore);

// Switch stops unwanted components rendering due to React's fuzzy matching
// It will only render the first Route which matches URL
// You want the more specific urls to come first

// Route will pass through some extra props to it's component, eg: this.props.history 
ReactDOM.render(
  <Provider store={createStoreWithMiddleware(reducers)}>
    <BrowserRouter>
      <div>
        <Switch>
          <Route path="/posts/new" component={PostsNew} />
          <Route path="/posts/:id" component={PostsShow} />
          <Route path="/" component={PostsIndex} />
        </Switch>
      </div>
    </BrowserRouter>
  </Provider>,
  document.querySelector(".container")
);
