import { MatchData } from '../types'

export interface Analyzer {
  run(matches: MatchData[]): string
}
