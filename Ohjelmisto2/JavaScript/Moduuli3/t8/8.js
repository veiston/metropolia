const nappi = document.getElementById("start");
nappi.addEventListener("click", function () {
  const luku1 = parseInt(document.getElementById("num1").value);
  const luku2 = parseInt(document.getElementById("num2").value);
  const operaatio = document.getElementById("operation").value;
  let tulos;
  if (operaatio === "add") {
    tulos = luku1 + luku2;
  } else if (operaatio === "sub") {
    tulos = luku1 - luku2;
  } else if (operaatio === "multi") {
    tulos = luku1 * luku2;
  } else if (operaatio === "div") {
    tulos = Math.floor(luku1 / luku2);
  }
  document.getElementById("result").textContent = tulos;
});
