import { Test } from '@nestjs/testing';
import { AuthService } from './auth.service';
import { User } from './user.entity';
import { UsersService } from './users.service';

describe('AuthService', () => {
  let service;
  let fakeUsersService: Partial<UsersService>;

  beforeEach(async () => {
    // Create a fake copy of the users service
    const users: User[] = [];

    fakeUsersService = {
      find: (email: string) => {
        const filteredUsers = users.filter((user) => user.email === email);
        return Promise.resolve(filteredUsers);
      },
      create: (email: string, password: string) => {
        const newUser = {
          id: Math.floor(Math.random() * 9999999),
          email,
          password,
        } as User;

        users.push(newUser);
        return Promise.resolve(newUser);
      },
    };

    const module = await Test.createTestingModule({
      providers: [
        AuthService,
        { provide: UsersService, useValue: fakeUsersService },
      ],
    }).compile();

    service = module.get(AuthService);
  });

  it('can create an instance of auth service', async () => {
    expect(service).toBeDefined();
  });

  it('creates a new user with a salted and hashed password', async () => {
    const user = await service.signup('test@test.com', 'test-password');

    expect(user.password).not.toEqual('test-password');
    const [salt, hash] = user.password.split('.');
    expect(salt).toBeDefined();
    expect(hash).toBeDefined();
  });

  it('should throw an error if user signs up with email that is in use', async () => {
    await service.signup('test@test.com', '1234');

    await expect(
      service.signup('test@test.com', '1234'),
    ).rejects.toMatchInlineSnapshot(`[BadRequestException: email in use]`);
  });

  it('should throw an error if signin is called with an unused email', async () => {
    await expect(
      service.signin('test@test.com', '1234'),
    ).rejects.toMatchInlineSnapshot(`[NotFoundException: user does not exist]`);
  });

  it('should throw an error if signin is called with an invalid password', async () => {
    await service.signup('test@test.com', '1234');
    await expect(
      service.signin('test@test.com', 'wrong-password'),
    ).rejects.toMatchInlineSnapshot(`[BadRequestException: bad password]`);
  });

  it('should return a user if signin is called with a correct password', async () => {
    await service.signup('test@test.com', '1234');

    const user = await service.signin('test@test.com', '1234');
    expect(user).toBeDefined();
  });
});
