let n = [];
while (true) {
  let l = Number(prompt("Anna luku"));
  if (l === 0) break;
  n.push(l);
}
n.sort((a, b) => b - a);
for (let i = 0; i < n.length; i++) console.log(n[i]);