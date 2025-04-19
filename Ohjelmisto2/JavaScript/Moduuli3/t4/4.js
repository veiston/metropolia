'use strict';
const students = [
  {
    name: 'John',
    id: '2345768',
  },
  {
    name: 'Paul',
    id: '2134657',
  },
  {
    name: 'Jones',
    id: '5423679',
  },
];

const k = document.getElementById('target');
for (let i = 0; i < students.length; i++) {
  const o = document.createElement('option');
  o.value = students[i].id;
  o.textContent = students[i].name;
  k.appendChild(o);
}
