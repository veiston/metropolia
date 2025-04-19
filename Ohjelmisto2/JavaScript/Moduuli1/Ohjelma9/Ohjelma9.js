let n = Number(prompt("Anna kokonaisluku"));
let onAlkuluku = n > 1;
for (let i = 2; i <= Math.sqrt(n); i++) {
  if (n % i === 0) {
    onAlkuluku = false;
    break;
  }
}
if (onAlkuluku) {
  document.body.innerHTML = `${n} on alkuluku.`;
} else {
  document.body.innerHTML = `${n} ei ole alkuluku.`;
}
