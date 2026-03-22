function sortArray(numbers) {
  return [...numbers].sort((a, b) => a - b);
}

const numbers = [5, 2, 8, 1, 9];
const sortedNumbers = sortArray(numbers);

console.log("Original:", numbers);
console.log("Sorted:", sortedNumbers);
