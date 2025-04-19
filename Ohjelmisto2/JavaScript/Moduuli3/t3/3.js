'use strict';
const names = ['John', 'Paul', 'Jones'];

const k = document.getElementById('target');
let t = '';
for (let i = 0; i < names.length; i++) t += `<li>${names[i]}</li>`;
k.innerHTML = t;
