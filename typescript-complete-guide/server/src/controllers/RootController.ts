import { get, controller, use } from './decorators'
import { Request, Response, NextFunction } from 'express'

const requireAuth = (req: Request, res: Response, next: NextFunction): void => {
  if (req.session && req.session.loggedIn) {
    next()
    return
  }

  res.status(403)
  res.send('Unauthorised')
}

@controller('')
class RootController {
  @get('/')
  getRoot(req: Request, res: Response) {
    if (req.session && req.session.loggedIn) {
      res.send(`    
        <div>
          <div>you are logged in</div>
          <a href="/auth/logout">Logout</a>
        </div>        
      `)
    } else {
      res.send(`    
        <div>
          <div>you are logged out</div>
          <a href="/auth/login">Login</a>
        </div>        
      `)
    }
  }

  @get('/protected')
  @use(requireAuth)
  getProtected(req: Request, res: Response) {
    res.send(`    
      <div>
        <div>Welcome to Protected Route</div>      
      </div>        
  `)
  }
}
