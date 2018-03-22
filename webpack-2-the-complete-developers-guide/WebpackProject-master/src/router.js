import React from 'react';
import { Router, Route, IndexRoute, hashHistory } from 'react-router';

import Home from './components/Home';
import ArtistMain from './components/artists/ArtistMain';
// don't need to import the ArtistEdit, ArtistCreate, ArtistEdit up here anymore
// we import them in below with Sytem.import so we can split them into seperate bundle files

// in order to codesplit the routes, we need to define them in an object rather than JSX (ultimately this is what JSX is doing anyway)
const componentRoutes = {
  component: Home,
  path: '/',
  indexRoute: { component: ArtistMain },
  childRoutes: [
    {
      path: 'artists/new',
      // in order to aschronously load the component (ie: only loading it when we go to that route), we need to use the getComponent() function
      getComponent(location, cb) {
        // Tell webpack to split this module off into a seperate bundle
        System.import('./components/artists/ArtistCreate')
          .then((module) => {
            // first arguement is for errors, so we pass in null
            // remember module is entire JS module, so we only want the exported code on module.default
            cb(null, module.default)
          })
      }
    },
    {
      path: 'artists/:id',
      getComponent(location, cb) {
        System.import('./components/artists/ArtistDetail')
          .then((module) => {
            cb(null, module.default)
          })
      }
    },
    {
      path: 'artists/:id/edit',
      getComponent(location, cb) {
        System.import('./components/artists/ArtistEdit')
          .then((module) => {
            cb(null, module.default)
          })
      }
    }
  ]
};

const Routes = () => {
  // pass your componentRoutes object into a routes props
  return (
    <Router history={hashHistory} routes={componentRoutes} />
  );
};

export default Routes;
