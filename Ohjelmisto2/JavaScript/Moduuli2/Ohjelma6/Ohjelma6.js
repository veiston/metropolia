function noppa() {
  return Math.floor(Math.random() * 6) + 1;
}
let t = "<ul>", n;
do {
  n = noppa();
  t += `<li>${n}</li>`;
} while (n !== 6);
t += "</ul>";
document.body.innerHTML = t;