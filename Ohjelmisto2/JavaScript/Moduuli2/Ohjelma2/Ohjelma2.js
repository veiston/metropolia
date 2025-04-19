let m = Number(prompt("Osallistujien määrä"));
let n = [];
for (let i = 0; i < m; i++) n.push(prompt("Osallistujan nimi"));
n.sort();
let t = "<ol>";
for (let i = 0; i < n.length; i++) t += `<li>${n[i]}</li>`;
t += "</ol>";
document.body.innerHTML = t;