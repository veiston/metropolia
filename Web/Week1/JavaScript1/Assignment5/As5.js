const output = document.getElementById("output");
const n = Number(prompt("Enter a positive integer:"));

if (!Number.isInteger(n) || n <= 0) {
  output.textContent = "Invalid input. Please enter a positive integer.";
} else {
  let sum = 0;

  for (let i = 1; i <= n; i += 1) {
    sum += i;
  }

  output.textContent = `The sum of natural numbers from 1 to ${n} is ${sum}.`;
}
