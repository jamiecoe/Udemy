import { MiddlewareConsumer, Module, ValidationPipe } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { UsersModule } from './users/users.module';
import { ReportsModule } from './reports/reports.module';
import { TypeOrmModule } from '@nestjs/typeorm';
import { User } from './users/user.entity';
import { Report } from './reports/report.entity';
import { APP_PIPE } from '@nestjs/core';
import { ConfigModule, ConfigService } from '@nestjs/config';
// eslint-disable-next-line @typescript-eslint/no-var-requires
const cookieSession = require('cookie-session');

@Module({
  imports: [
    ConfigModule.forRoot({
      isGlobal: true,
      envFilePath: `.env.${process.env.NODE_ENV}`,
    }),
    UsersModule,
    ReportsModule,
    TypeOrmModule.forRoot(),
  ],
  controllers: [AppController],
  providers: [
    AppService,
    // apply to all incoming requests
    { provide: APP_PIPE, useValue: new ValidationPipe({ whitelist: true }) },
  ],
})
export class AppModule {
  constructor(private configService: ConfigService) {}
  // called when app starts listening for incoming traffic
  configure(consumer: MiddlewareConsumer) {
    // middleware applied to requests to all routes
    consumer
      .apply(cookieSession({ keys: [this.configService.get('COOKIE_KEY')] }))
      .forRoutes('*');
  }
}
