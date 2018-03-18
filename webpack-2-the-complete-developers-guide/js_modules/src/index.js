// atm our webpack.config file is setup only to run through files that are imported into index.js

import sum from './sum';
// Because image_viewer is just DOM manip code,
// we don't need to assign it to a variable (it doesn't have an export statement anyway)
// We just want it to run at the top
import './image_viewer';

const total = sum(10, 5);

console.log(total);
