// we do have to specify the file extention for anything non-js

// url-loader does special thing with 'big' import statement
// It prepends it with publicPath property, named in config.output (webpack config file)
// This means the image will have the right src path to import it in
//import big from '../assets/big.jpg';

import small from '../assets/small.jpg';
import '../styles/image_viewer.css';

export default () => {
  const image = document.createElement('img');
  image.src = small;

  document.body.appendChild(image);
};



// const bigImage = document.createElement('img');
// bigImage.src = big;
//
// document.body.appendChild(bigImage);
