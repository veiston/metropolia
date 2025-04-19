let a = Number(prompt("Ensimmäinen kokonaisluku"));
let b = Number(prompt("Toinen kokonaisluku"));
let c = Number(prompt("Kolmas kokonaisluku"));

let sum = a + b + c;
let product = a * b * c;
let average = sum / 3;

document.body.innerHTML = `
  Numeroiden summa: ${sum}<br>
  Numeroiden tulo: ${product}<br>
  Numeroiden keskiarvo: ${average}
`;
