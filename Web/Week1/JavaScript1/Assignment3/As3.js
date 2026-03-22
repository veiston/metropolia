const output = document.getElementById("output");

const a = Number(prompt("Enter side a:"));
const b = Number(prompt("Enter side b:"));
const c = Number(prompt("Enter side c:"));

if (
  Number.isNaN(a) ||
  Number.isNaN(b) ||
  Number.isNaN(c) ||
  a <= 0 ||
  b <= 0 ||
  c <= 0
) {
  output.textContent = "Invalid input. Side lengths must be positive numbers.";
} else if (a + b <= c || a + c <= b || b + c <= a) {
  output.textContent = "These side lengths do not form a valid triangle.";
} else {
  let triangleType = "";

  if (a === b && b === c) {
    triangleType = "equilateral";
  } else if (a === b || b === c || a === c) {
    triangleType = "isosceles";
  } else if (!(a === b) && !(b === c) && !(a === c)) {
    triangleType = "scalene";
  }

  output.textContent = `The triangle is ${triangleType}.`;
}
