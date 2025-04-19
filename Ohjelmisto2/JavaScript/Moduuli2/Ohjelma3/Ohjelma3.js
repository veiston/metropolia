let k = [];
for (let i = 0; i < 6; i++) k.push(prompt("Koiran nimi"));
k.sort().reverse();
let t = "<ul>";
for (let i = 0; i < k.length; i++) t += `<li>${k[i]}</li>`;
t += "</ul>";
document.body.innerHTML = t;