let dbConfig = {
  synchronize: false,
  migrations: ['migrations/*.js'],
  cli: {
    migrationsDir: 'migrations',
  },
};

switch (process.env.NODE_ENV) {
  case 'development':
    dbConfig = {
      ...dbConfig,
      type: 'sqlite',
      database: 'db.sqlite',
      entities: ['**/*.entity.js'],
    };
    break;
  case 'test':
    dbConfig = {
      ...dbConfig,
      type: 'sqlite',
      database: 'test.sqlite',
      entities: ['**/*.entity.ts'],
      migrationsRun: true,
    };
    break;
  case 'production':
    dbConfig = {
      ...dbConfig,
      type: 'postgres',
      url: process.env.DATABASE_URL,
      migrationsRun: true,
      entities: ['**/*.entity.js'],
      ssl: {
        rejectUnauthorized: false,
      },
    };
    break;
  default:
    throw new Error('Unknown Node Environment');
}

module.exports = dbConfig;
