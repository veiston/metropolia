let year = Number(prompt("Anna vuosi"));
let result = "";
if ((year % 4 === 0 && year % 100 !== 0) || year % 400 === 0)
  result = "on karkausvuosi";
else result = "ei ole karkausvuosi";
document.body.innerHTML = `${year} ${result}`;
