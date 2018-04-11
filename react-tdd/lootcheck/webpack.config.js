const path = require('path');
const webpack = require('webpack');
var HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
	entry: './src/index.js',
	output: {
		path: path.resolve(__dirname, 'build'),
		filename: 'bundle.js',
	},
	module: {
		rules: [
			{
        test: /\.js$/,
				use: 'babel-loader',
				exclude: ['node_modules']
			},
			{
        test: /\.css$/,
        use: ['style-loader', 'css-loader']
			},
			{
        test: /\.(jpe?g|png|gif|svg)$/,
        use: [
          // remember loaders are run from end to beginning of array
          // object instead of string for additional options
          {
            loader: 'url-loader',
            options: { limit: 40000 }
            // if image is less than 40,000 bytes, include it into bundle.js
            // Otherwise, save it as a seperate file
          },
          'image-webpack-loader' // image-webpack-loader compresses file size of image
        ]
      }
		]
	},
	plugins: [
		new HtmlWebpackPlugin({
      template: 'index.html'
    }),
		new webpack.DefinePlugin({
      'process.env.NODE.ENV': JSON.stringify(process.env.NODE_ENV)
    })
	]
}
