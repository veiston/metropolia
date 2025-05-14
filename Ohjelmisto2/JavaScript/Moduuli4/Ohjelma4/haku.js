const lomake = document.getElementById("f");
lomake.addEventListener("submit", async function (e) {
  e.preventDefault();
  const haku = document.getElementById("q").value;
  const vastaus = await fetch(`https://api.tvmaze.com/search/shows?q=${haku}`);
  const tulos = await vastaus.json();
  const tulokset = document.getElementById("results");
  tulokset.innerHTML = "";
  tulos.forEach((item) => {
    const kuva = item.show.image
      ? item.show.image.medium
      : "https://via.placeholder.com/210x295?text=Not%20Found";
    const artikkeli = document.createElement("article");
    artikkeli.innerHTML = `<img src="${kuva}" alt="${item.show.name}"><h2>${item.show.name}</h2>`;
    tulokset.appendChild(artikkeli);
  });
});
