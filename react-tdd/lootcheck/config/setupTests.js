import requestAnimationFrame from './tempPolyfills';
 
import { configure } from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';

//The disableLifecyleMethods portion is needed to allow us to modify props through different tests.
configure({ adapter: new Adapter(), disableLifecycleMethods: true });