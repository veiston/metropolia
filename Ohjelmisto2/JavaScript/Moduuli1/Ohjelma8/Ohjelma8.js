let alku = Number(prompt("Anna alkamisvuosi"));
let loppu = Number(prompt("Anna paattymisvuosi"));
let html = "<ul>";
for (let v = alku; v <= loppu; v++) {
  if ((v % 4 === 0 && v % 100 !== 0) || v % 400 === 0) {
    html += `<li>${v}</li>`;
  }
}
html += "</ul>";
document.body.innerHTML = html;
