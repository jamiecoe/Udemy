import bodyParser from 'body-parser'
import cookieSession from 'cookie-session'
import express from 'express'
import { AppRouter } from './AppRouter'
import './controllers/LoginController'
import './controllers/RootController'

const app = express()

app.use(bodyParser.urlencoded({ extended: true }))

app.use(cookieSession({ keys: ['potato'] }))
app.use(AppRouter.getInstance())

app.listen(3000, () => {
  console.log('Listening on Port 3000')
})
