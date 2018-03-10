// This is an action creator
// It's just a function that returns an object
// The actual object itself is what we call an 'action'
// The object usually has 2 keys - 'type' (describes purpose of the action, MUST HAVE THIS) and 'payload' (further describes conditions of the action)

export function selectBook(book) {
    return {
      type: 'BOOK_SELECTED',
      payload: book
    }
}
