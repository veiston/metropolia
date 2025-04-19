const lomake = document.getElementById("f");
lomake.addEventListener("submit", async function (e) {
  e.preventDefault();
  const haku = document.getElementById("q").value;
  const vastaus = await fetch(`https://api.tvmaze.com/search/shows?q=${haku}`);
  const tulos = await vastaus.json();
  const tulokset = document.getElementById("tälläset löytyy");
  tulokset.innerHTML = "";
  for (const sarja of tulos) {
    const artikkeli = document.createElement("article");
    const otsikko = document.createElement("h2");
    otsikko.textContent = sarja.show.name;

    const linkki = document.createElement("a");

    linkki.href = sarja.show.url;
    linkki.target = "_blank";
    linkki.textContent = sarja.show.url;
    const kuva = document.createElement("img");
    kuva.src = sarja.show.image?.medium;
    kuva.alt = sarja.show.name;
    const yhteenveto = document.createElement("div");
    yhteenveto.innerHTML = sarja.show.summary;

    artikkeli.appendChild(otsikko);
    artikkeli.appendChild(kuva);
    artikkeli.appendChild(linkki);
    artikkeli.appendChild(yhteenveto);
    tulokset.appendChild(artikkeli);
  }
});
