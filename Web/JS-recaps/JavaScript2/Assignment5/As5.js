function sortArray(numbers, order) {
  const sorted = [...numbers].sort((a, b) => a - b);

  if (order === "laskeva") {
    sorted.reverse();
  }

  return sorted;
}

const numbers = [5, 2, 8, 1, 9];
const moreNumbers = [12, 4, 7, 3, 420, 15, 1, 69];

console.log(sortArray(numbers, "nouseva"));
console.log(sortArray(numbers, "laskeva"));
console.log(sortArray(moreNumbers, "nouseva"));
console.log(sortArray(moreNumbers, "laskeva"));
