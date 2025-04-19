function noppa(k) {
  return Math.floor(Math.random() * k) + 1;
}
let m = Number(prompt("Anna nopan sivujen määrä"));
let t = "<ul>", n;
do {
  n = noppa(m);
  t += `<li>${n}</li>`;
} while (n !== m);
t += "</ul>";
document.body.innerHTML = t;