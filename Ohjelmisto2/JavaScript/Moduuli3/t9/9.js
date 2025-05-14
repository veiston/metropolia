const nappi = document.getElementById("start");
nappi.addEventListener("click", function () {
  const lasku = document.getElementById("calculation").value;
  let tulos;
  if (lasku.includes("+")) {
    const osat = lasku.split("+");
    tulos = parseInt(osat[0]) + parseInt(osat[1]);
  } else if (lasku.includes("-")) {
    const osat = lasku.split("-");
    tulos = parseInt(osat[0]) - parseInt(osat[1]);
  } else if (lasku.includes("*")) {
    const osat = lasku.split("*");
    tulos = parseInt(osat[0]) * parseInt(osat[1]);
  } else if (lasku.includes("/")) {
    const osat = lasku.split("/");
    tulos = Math.floor(parseInt(osat[0]) / parseInt(osat[1]));
  }
  document.getElementById("result").textContent = tulos;
});
