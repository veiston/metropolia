const output = document.getElementById("output");

const x1 = Number(prompt("Enter x1:"));
const y1 = Number(prompt("Enter y1:"));
const x2 = Number(prompt("Enter x2:"));
const y2 = Number(prompt("Enter y2:"));

if (
  Number.isNaN(x1) ||
  Number.isNaN(y1) ||
  Number.isNaN(x2) ||
  Number.isNaN(y2)
) {
  output.textContent =
    "Invalid input. Please enter numbers for all coordinates.";
} else {
  const dx = x2 - x1;
  const dy = y2 - y1;
  const distance = Math.sqrt(dx * dx + dy * dy);

  output.innerHTML = `
    <p>Point 1: (${x1}, ${y1})</p>
    <p>Point 2: (${x2}, ${y2})</p>
    <p>Distance: ${distance.toFixed(4)}</p>
  `;
}
