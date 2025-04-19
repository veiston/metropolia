const lomake = document.getElementById("f");
lomake.addEventListener("submit", async function (e) {
  e.preventDefault();
  const haku = document.getElementById("q").value;
  const vastaus = await fetch(`https://api.tvmaze.com/search/shows?q=${haku}`);
  const tulos = await vastaus.json();
  console.log(tulos);
});
