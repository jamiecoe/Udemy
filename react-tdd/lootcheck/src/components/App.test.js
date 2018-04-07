import React from 'react';
import { shallow } from 'enzyme';
import App from './App';

describe('App', () => {
	const app = shallow(<App />);

	it('renders properly', () => {
		expect(app).toMatchSnapshot();
	});

	it('contains a connected Wallet componet', () => {
		// debug() is an enzyme method for checking out the rendered JSX of a component
		//console.log(app.debug());
		
		expect(app.find('Connect(Wallet)').exists()).toBe(true);
	})
});