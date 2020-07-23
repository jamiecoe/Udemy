import fs from 'fs'

export abstract class CsvFileReader<T> {
  data: T[] = []

  read(filePath: string): CsvFileReader<T> {
    this.data = fs
      .readFileSync(filePath, {
        encoding: 'utf-8'
      })
      .split('\n')
      .map((row: string): string[] => row.split(','))
      .map((row: string[]): T => this.mapRow(row))

    return this
  }

  abstract mapRow(row: string[]): T

  getData(): T[] {
    return this.data
  }
}
