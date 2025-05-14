function concat(lista_nimia) {
  let tulos = "";
  for (let i = 0; i < lista_nimia.length; i++) {
    tulos += lista_nimia[i];
  }
  return tulos;
}

const lista_nimia = ["Johnny", "DeeDee", "Joey", "Marky"];
const tulos = concat(lista_nimia);
document.getElementById("tulos").textContent = tulos;
