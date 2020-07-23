import { DataReader } from './interfaces/DataReader'
import { MatchData } from './types'
import { dateStringToDate } from './utils'
import { MatchResult } from './MatchResult'

export class MatchReader {
  matches: MatchData[] = []

  constructor(public reader: DataReader) {}

  load(filepath: string): MatchData[] {
    return this.reader
      .read(filepath)
      .map((row: string[]): MatchData => this.convertRowToMatchData(row))
  }

  private convertRowToMatchData(row: string[]): MatchData {
    return [
      dateStringToDate(row[0]),
      row[1],
      row[2],
      parseInt(row[3]),
      parseInt(row[4]),
      row[5] as MatchResult,
      row[6]
    ]
  }
}
