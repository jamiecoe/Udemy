import { Analyzer } from './interfaces/Analyzer'
import { OutputTarget } from './interfaces/OutputTarget'
import { MatchData } from './types'

export class Summary {
  constructor(public analyzer: Analyzer, public outputTarget: OutputTarget) {}

  buildAndPrintReport(matches: MatchData[]): void {
    const report = this.analyzer.run(matches)
    this.outputTarget.print(report)
  }
}
