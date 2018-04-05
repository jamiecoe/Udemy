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
