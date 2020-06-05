export abstract class Sorter {
  abstract swap(leftIndex: number, rightIndex: number): void

  abstract shouldSwap(leftIndex: number, rightIndex: number): boolean

  abstract length: number  

  sort(): void {
    for (let i = 0; i < this.length; i++) {
      for (let j = 1; j < this.length - i; j++) {
        if (this.shouldSwap(j - 1, j)) {
          this.swap(j - 1, j)
        }
      }
    }
  }
}
