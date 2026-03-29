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
  output.textContent = "Wroo! That won't work";
} else if (a + b <= c || a + c <= b || b + c <= a) {
  output.textContent = "Nope. That don't make a triangle.";
} else {
  let triangleType = "";

  if (a === b && b === c) {
    triangleType = "Equilateral";
  } else if (a === b || b === c || a === c) {
    triangleType = "Isosceles";
  } else if (!(a === b) && !(b === c) && !(a === c)) {
    triangleType = "Scalene";
  }

  output.textContent = `Triangle type: ${triangleType}.`;
}
