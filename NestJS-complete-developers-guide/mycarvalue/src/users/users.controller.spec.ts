import { Test, TestingModule } from '@nestjs/testing';
import { AuthService } from './auth.service';
import { User } from './user.entity';
import { UsersController } from './users.controller';
import { UsersService } from './users.service';

describe('UsersController', () => {
  let controller: UsersController;
  let fakeUsersService: Partial<UsersService>;
  let fakeAuthService: Partial<AuthService>;

  beforeEach(async () => {
    fakeUsersService = {
      findOne: (id: number) =>
        Promise.resolve({
          id,
          email: 'test@test.com',
          password: '123',
        } as User),
      find: (email: string) =>
        Promise.resolve([{ id: 123, email, password: '' } as User]),
      // remove: () => {},
      // update: () => {},
    };
    fakeAuthService = {
      // signup: () => {},
      signin: (email: string, password: string) => {
        return Promise.resolve({ id: 1, email, password } as User);
      },
    };

    const module: TestingModule = await Test.createTestingModule({
      controllers: [UsersController],
      providers: [
        { provide: UsersService, useValue: fakeUsersService },
        { provide: AuthService, useValue: fakeAuthService },
      ],
    }).compile();

    controller = module.get<UsersController>(UsersController);
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
  });

  it('should return a list of users with the given email for findAllUsers', async () => {
    const users = await controller.findAllUsers('test@test.com');
    expect(users.length).toEqual(1);
    expect(users[0].email).toEqual('test@test.com');
  });

  it('should return a single user with the given id for findUser', async () => {
    const user = await controller.findUser('1');
    expect(user).toBeDefined();
  });

  it('should throw an error if user with given id is not found for findUser', async () => {
    fakeUsersService.findOne = () => null;

    await expect(controller.findUser('1')).rejects.toMatchInlineSnapshot(
      `[NotFoundException: user not found]`,
    );
  });

  it('should update session object and return user for signin', async () => {
    const session = { userId: -10 };
    const user = await controller.signin(
      { email: 'test@test.com', password: '123' },
      session,
    );

    expect(user.id).toEqual(1);
    expect(session.userId).toEqual(1);
  });
});
