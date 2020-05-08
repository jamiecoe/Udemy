import axios from 'axios'

const url = 'https://jsonplaceholder.typicode.com/todos/1'

interface Todo {
  userId: number,
  id: number,
  title: string,
  completed: boolean
}

axios.get(url).then((response) => {
  const todo: Todo = response.data

  const { userId, id, title, completed } = todo

  logToDo(userId, id, title, completed)
})

function logToDo(userId: number, id: number, title: string, completed: boolean) {
  console.log(userId, id, title, completed)
}

