let v = confirm("Lasketaanko neliöjuuri?");
if (v) {
  let kpl = Number(prompt("Kuinka monta noppaa?"));
  let summa = 0;
  for (let i = 0; i < kpl; i++) {
    summa += Math.floor(Math.random() * 6) + 1;
  }
  document.body.innerHTML = `Noppien summa: ${summa}`;
} else {
  document.body.innerHTML = "Neliöjuurta ei lasketa.";
}
