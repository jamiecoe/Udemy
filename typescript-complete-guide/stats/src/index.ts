import { MatchReader } from './MatchReader'
import { CsvFileReader } from './CsvFileReader'
import { Summary } from './Summary'
import { WinsAnalysis } from './analysers/WinsAnalysis'
import { HtmlReport } from './reportTargets/HtmlReport'

const matches = new MatchReader(new CsvFileReader()).load('football.csv')

const winsSummary = new Summary(
  new WinsAnalysis('Man United'),
  new HtmlReport()
)
winsSummary.buildAndPrintReport(matches)
