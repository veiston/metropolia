let laske = confirm("Lasketaanko neliöjuuri?");
if (laske) {
  let luku = Number(prompt("Anna luku"));
  if (luku < 0) {
    document.body.innerHTML = "Negatiivisen luvun neliöjuuri ei ole määritelty";
  } else {
    document.body.innerHTML = `Neliöjuuri on ${Math.sqrt(luku)}`;
  }
} else {
  document.body.innerHTML = "Neliöjuurta ei lasketa.";
}
