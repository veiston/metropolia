// array for todo list
const todoList = [
  {
    id: 1,
    task: 'Learn HTML',
    completed: true,
  },
  {
    id: 2,
    task: 'Learn CSS',
    completed: true,
  },
  {
    id: 3,
    task: 'Learn JS',
    completed: false,
  },
  {
    id: 4,
    task: 'Learn TypeScript',
    completed: false,
  },
  {
    id: 5,
    task: 'Learn React',
    completed: false,
  },
];

const listElement = document.querySelector('ul');
const addItemButton = document.querySelector('#add-item-btn');
const dialog = document.querySelector('#add-item-dialog');
const form = document.querySelector('#add-item-form');
const input = document.querySelector('#new-item-input');
const cancelButton = document.querySelector('#cancel-item-btn');

const getNextId = () => Math.max(0, ...todoList.map(item => item.id)) + 1;

const createTodoElement = todo => {
  const li = document.createElement('li');
  const checkbox = document.createElement('input');
  const label = document.createElement('label');
  const deleteButton = document.createElement('button');

  checkbox.type = 'checkbox';
  checkbox.id = `todo-${todo.id}`;
  checkbox.checked = todo.completed;
  label.htmlFor = checkbox.id;
  label.textContent = todo.task;

  deleteButton.type = 'button';
  deleteButton.textContent = 'Delete';

  checkbox.addEventListener('change', () => {
    const item = todoList.find(entry => entry.id === todo.id);
    item.completed = checkbox.checked;
    console.log(todoList);
  });

  deleteButton.addEventListener('click', () => {
    const index = todoList.findIndex(entry => entry.id === todo.id);
    todoList.splice(index, 1);
    listElement.removeChild(li);
    console.log(todoList);
  });

  li.append(checkbox, label, deleteButton);
  return li;
};

todoList.forEach(todo => {
  listElement.append(createTodoElement(todo));
});

addItemButton.addEventListener('click', () => {
  dialog.showModal();
  input.focus();
});

cancelButton.addEventListener('click', () => {
  dialog.close();
});

form.addEventListener('submit', event => {
  event.preventDefault();
  const task = input.value.trim();
  if (!task) {
    return;
  }

  const newTodo = {
    id: getNextId(),
    task,
    completed: false,
  };

  todoList.push(newTodo);
  listElement.append(createTodoElement(newTodo));
  console.log(todoList);

  input.value = '';
  dialog.close();
});
