// // atm our webpack.config file is setup only to run through files that are imported into index.js
//
// import sum from './sum';
// // Because image_viewer is just DOM manip code,
// // we don't need to assign it to a variable (it doesn't have an export statement anyway)
// // We just want it to run at the top
// import './image_viewer';
//
// const total = sum(10, 5);
//
// console.log(total);

const button = document.createElement('button');
button.innerText = 'Click me';

button.onclick = () => {
  // System is a global variable inside JS
  // System.import is special function from ES2015/ES6 module spec
  // We give it path to module we're looking for, it will reach out to our server and try to find this module
  // Server send back requested file, which can then be executed
  // System.import is async, it returns a promise
  System.import('./image_viewer')
    .then((module) => {
      // Call the image_viewer function assigned to default
      module.default();
    });

  // Adding a System.import call is what tells Webpack we're using code splitting
  // Webpack will create a seperate bundle.js file for any files imported in with System.import()
};

document.body.appendChild(button);
