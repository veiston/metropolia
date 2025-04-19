let n = [];
while (true) {
  let l = Number(prompt("Anna luku"));
  if (n.includes(l)) break;
  n.push(l);
}
n.sort((a, b) => a - b);
for (let i = 0; i < n.length; i++) console.log(n[i]);