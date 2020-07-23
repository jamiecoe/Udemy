import { dateStringToDate } from "./utils"

describe('utils', () => {
  describe('dateStringToDate', () => {
    it('should convert "01/01/2020" to a date object', () => {
      const date: Date = dateStringToDate('01/01/2020')
      expect(date.getFullYear()).toBe(2020)
      expect(date.getMonth()).toBe(0)
      expect(date.getDate()).toBe(1)
    })

    it('should convert "12/12/2010" to a date object', () => {
      const date: Date = dateStringToDate('12/12/2010')
      expect(date.getFullYear()).toBe(2010)
      expect(date.getMonth()).toBe(11)
      expect(date.getDate()).toBe(12)
    })
  })
})
