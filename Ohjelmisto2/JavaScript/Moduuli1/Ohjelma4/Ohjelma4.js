let name = prompt("Anna nimesi");
let houseNum = Math.floor(Math.random() * 4) + 1;
let house = "";
if (houseNum === 1) house = "Gryffindor";
else if (houseNum === 2) house = "Slytherin";
else if (houseNum === 3) house = "Hufflepuff";
else house = "Ravenclaw";
document.body.innerHTML = `${name}, you are ${house}.`;
