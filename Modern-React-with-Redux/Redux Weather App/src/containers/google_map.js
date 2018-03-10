// Google maps api imported in index.html

import React, { Component } from "react";

class GoogleMap extends Component {

  // conponentDidMount is a lifecycle method that is called automatically when component is rendered to screen
  componentDidMount() {
    // google.maps.Map will render a new map inside element referenced by this.refs.map
    new google.maps.Map(this.refs.map, {
      zoom: 12,
      center: {
        lat: this.props.lat,
        lng: this.props.lon
      }
    });
  }

  render() {
    // 'ref' is used in React allows us to make reference to an HTML element that has been rendered to the page
    // We can now use 'this.refs.map' anywhere else in this component to reference this specific div
    return <div ref="map" />;
  }
}

export default GoogleMap;
