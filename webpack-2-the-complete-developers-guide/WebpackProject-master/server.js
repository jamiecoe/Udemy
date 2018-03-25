const express = require('express');
const path = require('path');

const app = express();

// any additional routes must come ABOVE the code below, so API calls can be dealt with first!

// only use webpack if we're not in production
if (process.env.NODE_ENV !== 'production') {

  // webpackMiddleware is a piece of express middleware for intercepting certain requests (ie: for index.html etc) and handing them off to webpack
  const webpackMiddleware = require('webpack-dev-middleware');
  const webpack = require('webpack');
  const webpackConfig = require('./webpack.config');

  // our server will now run webpack with our config file, and will send our bundled files for url requests
  app.use(
    webpackMiddleware(
      webpack(webpackConfig)
    )
  );
} else {
  // if we're in production environment
  app.use(express.static('dist'));
  app.get('*', (req, res) => {
    res.sendFile(path.join(__dirname, 'dist/index.html'));
  });
}

const PORT = process.env.PORT || 3050;


app.listen(PORT, () => {
  console.log('Listening on port ' + PORT);
})
