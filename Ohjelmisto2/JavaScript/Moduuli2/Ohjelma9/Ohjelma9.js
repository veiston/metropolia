function even(numerot) {
  const parilliset = [];
  for (let i = 0; i < numerot.length; i++) {
    if (numerot[i] % 2 === 0) {
      parilliset.push(numerot[i]);
    }
  }
  return parilliset;
}

const numerot = [2, 7, 4];
const parilliset = even(numerot);
console.log(numerot);
console.log(parilliset);
