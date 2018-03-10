// JSDOM allows you to 'fake' DOM and HTML in the commandline
import jsdom from 'jsdom';
import _$ from 'jquery';
import TestUtils from 'react-addons-test-utils';
import ReactDOM from 'react-dom';
// We're only importing react in to avoid 'react-in-jsx-scope' linter error
import React from 'react';
import chai, { expect } from 'chai';
import { Provider } from 'react-redux';
import { createStore } from 'redux';
import chaiJquery from 'chai-jquery';
import reducers from '../src/reducers';


// Set up testing environment to run like a browser in the command line
// in node.js, we use 'global' instead of 'window'
// this sets up our 'fake browser'
// gives jquery a fake 'document' to access
global.document = jsdom.jsdom('<!DOCTYPE html><html><body></body></html>');
// set up a fake 'window'
global.window = global.document.defaultView;
// define new instance of jquery which just uses global.window
const $ = _$(global.window);

// Build 'renderComponent' helper that should render a given react class
const renderComponent = (ComponentClass, props, state) => {
  // Use TestUtils.renderIntoDocument to render instance of React component into fake dom
  // Remember that using JSX syntax creates an instance of React component
  // We need to wrap the component inside <Provider>
  // Also need to create a new Redux store
  //
  const componentInstance = TestUtils.renderIntoDocument(
    <Provider store={createStore(reducers, state)}>
      <ComponentClass {...props} />
    </Provider>
  );
  // Use ReactDOM to access the html from componentInstance
  // Wrap this inside $() to get access to useful jquery matchers
  return $(ReactDOM.findDOMNode(componentInstance));
};

// Build helper for simulating events
// $.fn allows us to add a new function to this jquery instance
// Had to use a es5 function (instead of arrow) otherwise 'this' doesn't point to correct thing
$.fn.simulate = function simulate(eventName, value) {
  // 'this' is a reference to an array of elements that you've selected with jquery
  // eg: $('div') gets you all the divs

  // val() is a jquery method for setting the value of a HTML element
  if (value) this.val(value);

  // Use TestUtils.Simulate to simulate DOM events
  // we have eventName we want to simulate as an arguemnt
  // we then access it with Simulate[eventName]
  // we only want first element so we use this[0]
  TestUtils.Simulate[eventName](this[0]);
};

// Set up chai-jquery
chaiJquery(chai, chai.util, $);

export { renderComponent, expect };
