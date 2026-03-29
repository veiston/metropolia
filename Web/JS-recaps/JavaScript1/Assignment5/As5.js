const output = document.getElementById("output");
const n = Number(prompt("Enter a positive integer:"));

if (!Number.isInteger(n) || n <= 0) {
  output.textContent = "Wroo! That won't work";
} else {
  let sum = 0;

  for (let i = 1; i <= n; i += 1) {
    sum += i;
  }

  output.textContent = `Sum from 1 to ${n}: ${sum}.`;
}
