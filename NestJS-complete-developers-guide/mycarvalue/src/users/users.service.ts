import { Injectable, NotFoundException } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { User } from './user.entity';

@Injectable()
export class UsersService {
  constructor(@InjectRepository(User) private repo: Repository<User>) {}

  create(email: string, password: string) {
    const user = this.repo.create({
      email,
      password,
    });

    return this.repo.save(user);
  }

  findOne(id: number) {
    if (!id) {
      return null;
    }

    return this.repo.findOne(id);
  }

  find(email: string) {
    return this.repo.find({ email });
  }

  async update(id: number, attrs: Partial<User>) {
    const userToUpdate = await this.findOne(id);

    if (!userToUpdate) {
      throw new NotFoundException('user not found');
    }

    return this.repo.save({ ...userToUpdate, ...attrs });
  }

  async remove(id: number) {
    const userToRemove = await this.findOne(id);

    if (!userToRemove) {
      throw new NotFoundException('user not found');
    }

    return this.repo.remove(userToRemove);
  }
}
