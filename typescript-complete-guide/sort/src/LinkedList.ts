import { Sorter } from './Sorter'

class Node<T> {
  next: Node<T> | null

  constructor(public value: T, next: Node<T> | null = null) {
    this.next = next
  }
}

export class LinkedList<T> extends Sorter {
  head: Node<T> | null = null
  currentLength: number = 0  

  add(value: T): void {
    this.currentLength++

    const newNode = new Node(value)

    if (this.head === null) {
      this.head = newNode
      return
    }

    let currentNode = this.head

    while (currentNode.next !== null) {
      currentNode = currentNode.next
    }

    currentNode.next = newNode
  }

  at(index: number): Node<T> {
    if (index < 0 || index > this.currentLength - 1) {
      throw new Error('Index out of bounds')
    }

    let counter = 0
    let currentNode = this.head

    while (currentNode !== null) {
      if (counter === index) {
        return currentNode
      }

      counter++
      currentNode = currentNode.next
    }

    throw new Error('Index out of bounds')
  }

  print(): void {
    let currentNode = this.head

    while (currentNode !== null) {
      console.log('currentNode.value', currentNode.value)
      currentNode = currentNode.next
    }
  }

  swap(leftIndex: number, rightIndex: number): void {
    if (this.head === null) {
      throw new Error('List is empty')
    }

    const leftNode = this.at(leftIndex)
    const rightNode = this.at(rightIndex)

    const temp = leftNode.value
    leftNode.value = rightNode.value
    rightNode.value = temp
  }

  shouldSwap(leftIndex: number, rightIndex: number): boolean {
    if (this.head === null) {
      throw new Error('List is empty')
    }

    const leftNode = this.at(leftIndex)
    const rightNode = this.at(rightIndex)

    return leftNode.value > rightNode.value
  }

  get length(): number {
    return this.currentLength
  }

  get data(): Array<T> {
    const data = []
    let currentNode = this.head

    while (currentNode !== null) {
      data.push(currentNode.value)
      currentNode = currentNode.next
    }

    return data
  }
}
