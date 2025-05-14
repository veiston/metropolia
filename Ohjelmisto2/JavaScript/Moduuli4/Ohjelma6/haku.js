const lomake = document.getElementById("f");
lomake.addEventListener("submit", async function (e) {
  e.preventDefault();
  const haku = document.getElementById("q").value;
  const vastaus = await fetch(
    `https://api.chucknorris.io/jokes/search?query=${haku}`
  );
  const tulos = await vastaus.json();
  const tulokset = document.getElementById("results");
  tulokset.innerHTML = "";
  if (tulos.result) {
    tulos.result.forEach((item) => {
      const artikkeli = document.createElement("article");
      artikkeli.innerHTML = `<p>${item.value}</p>`;
      tulokset.appendChild(artikkeli);
    });
  }
});
