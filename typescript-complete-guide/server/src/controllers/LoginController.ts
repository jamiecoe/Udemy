import { Request, Response, NextFunction } from 'express'
import { get, controller, use, post, bodyValidator } from './decorators'

function logger(req: Request, res: Response, next: NextFunction) {
  console.log('Request was made')
  next()
}

@controller('/auth')
class LoginController {
  @get('/login')
  @use(logger)
  getLogin(req: Request, res: Response): void {
    res.send(`
      <form method="POST">
        <div>
          <label>Email</label>
          <input name="email" />
        </div>
        <div>
          <label>Password</label>
          <input name="password" type="password" />
        </div>
        <input type="submit" />
      </form>
    `)
  }

  @bodyValidator('email', 'password')
  @post('/login')
  postLogin(req: Request, res: Response) {
    const { email, password } = req.body

    if (email === 'hi@hi.com' && password === 'password') {
      req.session = { loggedIn: true }
      res.redirect('/')
    } else {
      res.send('Invalid email or password')
    }
  }

  @get('/logout')
  logout(req: Request, res: Response) {
    req.session = null
    res.redirect('/')
  }
}
