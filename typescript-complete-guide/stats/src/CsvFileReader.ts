import fs from 'fs'

import { DataReader } from './interfaces/DataReader'

export class CsvFileReader implements DataReader {
  read(filePath: string): string[][] {
    return fs
      .readFileSync(filePath, {
        encoding: 'utf-8'
      })
      .split('\n')
      .map((row: string): string[] => row.split(','))
  }
}
