const output = document.getElementById("output");
const score = Number(prompt("Enter your score (0-100):"));

let grade;

if (Number.isNaN(score) || score < 0 || score > 100) {
  output.textContent = "Invalid score. Enter a number between 0 and 100.";
} else {
  if (score <= 39) {
    grade = 0;
  } else if (score <= 51) {
    grade = 1;
  } else if (score <= 63) {
    grade = 2;
  } else if (score <= 75) {
    grade = 3;
  } else if (score <= 87) {
    grade = 4;
  } else {
    grade = 5;
  }

  output.textContent = `Your grade is ${grade}.`;
}
