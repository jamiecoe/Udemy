import { Analyzer } from '../interfaces/Analyzer'
import { MatchData } from '../types'
import { MatchResult } from '../MatchResult'

export class WinsAnalysis implements Analyzer {
  constructor(public teamName: string) {}

  run(matches: MatchData[]): string {
    const totalWins = matches.reduce(
      (manUtdWins: number, currentMatch: MatchData): number => {
        const homeTeam = currentMatch[1]
        const awayTeam = currentMatch[2]
        const winningTeam = currentMatch[5]

        if (
          (homeTeam === this.teamName &&
            winningTeam === MatchResult.HOME_WIN) ||
          (awayTeam === this.teamName && winningTeam === MatchResult.AWAY_WIN)
        ) {
          manUtdWins++
        }

        return manUtdWins
      },
      0
    )

    return `Team ${this.teamName} won ${totalWins} games`
  }
}
