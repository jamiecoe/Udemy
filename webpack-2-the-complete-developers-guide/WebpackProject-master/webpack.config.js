var webpack = require('webpack');
var path = require('path');
var HtmlWebpackPlugin = require('html-webpack-plugin');

const VENDOR_LIBS = [
  'react', 'lodash', 'redux', 'react-redux', 'react-dom',
  'faker', 'react-input-range', 'redux-form', 'redux-thunk'
];

module.exports = {
  // Specify multiple entry points by setting 'entry' to an object
  entry: {
    // key value specifies the filename (eg: bundle.js, vendor.js)
    bundle: './src/index.js',
    vendor: VENDOR_LIBS // we can give vendor an array of libraries we want to bundle up
  },
  output: {
    path: path.join(__dirname, 'dist'),
    // [name] means - save output file with whatever key name the entry object has (eg: bundle.js, vendor.js)
    // [chunkhash] is a hashed string of characters - it's the hash of the contents of the file so if we change even one character in that file, the hash will change
    // we add it to the file name to uniquely identify each updated version of the output filters
    // this allows us to 'bust the cache' - ie: get the browser to only download an updated version of the file
    // the browser is looking for a file with a different names, otherwise it will use the cached version of a file (if it has them already)
    filename: '[name].[chunkhash].js'
  },
  module: {
    rules: [
      {
        test: /\.js$/,
        use: 'babel-loader',
        exclude: /node_modules/ // ignore any files inside node modules folder
      },
      {
        test: /\.css$/,
        use: ['style-loader', 'css-loader']
      },
    ]
  },
  // Remember plugins are more about looking at the total sum of input / output going through Webpack
  // as opposed to loaders which are more about looking at individual files
  plugins: [
    // this plugin looks at the total sum of our project files
    // it then says any duplicate files (eg: 3rd part libraries like react / redux etc) should only be included in the 'vendor.js' output (which you specificed in the {name: 'vendor'} object you passed in)
    // they are removed from bundle.js
    // this solves the issue of double including files
    // new webpack.optimize.CommonsChunkPlugin({
    //   name: 'vendor'
    // }),

    // Webpack will often mistakenly think that when we've updated bundle.js, we've updated vendor.js too
    // To fix this, we provide an array of files to CommonsChunkPlugin
    // manifest will create a manifest.js file, which will help to tell the browser whether the vendor.js file actually got changed
    new webpack.optimize.CommonsChunkPlugin({
      names: ['vendor', 'manifest']
    }),
    // HtmlWebpackPlugin will create a new index.html with our output js files included in script tags
    // we can pass in a reference to an exsisting index.html file to use as a template
    new HtmlWebpackPlugin({
      template: 'src/index.html'
    })
  ]
};
