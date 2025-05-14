async function haeVitsi() {
  const vastaus = await fetch("https://api.chucknorris.io/jokes/random");
  const tulos = await vastaus.json();
  console.log(tulos.value);
}

haeVitsi();
