function kysyEhdokkaat() {
  const ehdokkaat = [];
  const ehdokasMaara = parseInt(prompt("Kuinka monta ehdokasta?"));
  for (let i = 0; i < ehdokasMaara; i++) {
    const nimi = prompt(`Ehdokkaan ${i + 1} nimi:`);
    ehdokkaat.push({ nimi, aanet: 0 });
  }
  return ehdokkaat;
}

function aanesta(ehdokkaat) {
  const aanestajaMaara = parseInt(prompt("Kuinka monta äänestäjää?"));
  for (let i = 0; i < aanestajaMaara; i++) {
    const aanestys = prompt(`Äänestäjä ${i + 1}, ketä äänestät?`);
    const ehdokas = ehdokkaat.find((e) => e.nimi === aanestys);
    if (ehdokas) {
      ehdokas.aanet++;
    }
  }
}

function tulostaTulos(ehdokkaat) {
  ehdokkaat.sort((a, b) => b.aanet - a.aanet);
  console.log(
    `Voittaja on ${ehdokkaat[0].nimi} ${ehdokkaat[0].aanet} äänellä.`
  );
  console.log("Tulokset:");
  ehdokkaat.forEach((e) => console.log(`${e.nimi}: ${e.aanet} ääntä`));
}

const ehdokkaat = kysyEhdokkaat();
aanesta(ehdokkaat);
tulostaTulos(ehdokkaat);
