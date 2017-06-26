// Module for making AJAX requests
import axios from 'axios';

const API_KEY = '3e24441c9c0801638b721673ee4bc791';
const ROOT_URL = `http://api.openweathermap.org/data/2.5/forecast?appid=${API_KEY}`;

export const FETCH_WEATHER = 'FETCH_WEATHER';


export function fetchWeather(city) {
  const url = `${ROOT_URL}&q=${city},us`;
  // GET request will return a promise which we'll call 'request'
  const request = axios.get(url);  

  return {
    type: FETCH_WEATHER,
    payload: request
  }
}
