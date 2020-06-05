import { Sorter } from './Sorter'

export class CharactersCollection extends Sorter {
  constructor(public data: string) {
    super()
  }

  swap(leftIndex: number, rightIndex: number): void {
    const charArray = this.data.split('')

    const temp = charArray[leftIndex]
    charArray[leftIndex] = charArray[rightIndex]
    charArray[rightIndex] = temp

    this.data = charArray.join('')
  }

  shouldSwap(leftIndex: number, rightIndex: number): boolean {
    return (
      this.data[leftIndex].toLowerCase() > this.data[rightIndex].toLowerCase()
    )
  }

  get length(): number {
    return this.data.length
  }
}
