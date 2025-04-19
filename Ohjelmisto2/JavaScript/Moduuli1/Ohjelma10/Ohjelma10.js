let n = Number(prompt("Kuinka monta noppaa sulla on?"));
let s = Number(prompt("Mikä silmälukujen summa?"));
let kerrat = 10000;
let osumat = 0;
for (let i = 0; i < kerrat; i++) {
  let summa = 0;
  for (let j = 0; j < n; j++) {
    summa += Math.floor(Math.random() * 6) + 1;
  }
  if (summa === s) osumat++;
}
let todennakoisyys = (osumat / kerrat) * 100;
document.body.innerHTML = `Todennäköisyys saada summa ${s}, ${n} nopalla on ${todennakoisyys.toFixed(
  2
)}%`;
