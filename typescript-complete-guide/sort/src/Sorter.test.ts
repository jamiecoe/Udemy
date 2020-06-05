import { NumbersCollection } from './NumbersCollection'
import { CharactersCollection } from './CharactersCollection'
import { LinkedList } from './LinkedList'

describe('Sorter', () => {
  it('should sort an array of numbers', () => {
    const numbers = new NumbersCollection([3, 5, 2, -1])    
    numbers.sort()
    expect(numbers.data).toEqual([-1, 2, 3, 5])
  })

  it('should sort a string of characters', () => {
    const characterCollection = new CharactersCollection('badc')
    characterCollection.sort()
    expect(characterCollection.data).toEqual('abcd')
  })

  it('should sort a linked list', () => {
    const linkedList = new LinkedList<number>()
    linkedList.add(5)
    linkedList.add(2)
    linkedList.add(7)
    linkedList.add(-1)

    linkedList.sort()
    expect(linkedList.data).toEqual([-1, 2, 5, 7])
  })
})
