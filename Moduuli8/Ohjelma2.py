import csv
import mariadb
from cred import path

def laske_lentokentat_maatunnuksella(maakoodi):
    # polku
    csv_path = path()
    tulokset = {}
    with open(csv_path, encoding="utf-8") as csvfile:
        lukija = csv.DictReader(csvfile)
        for rivi in lukija:
            # Jos rivi on kyseisestä maasta
            if rivi.get("iso_country", "").upper() == maakoodi.upper():
                kentta_tyyppi = rivi.get("type", "").strip()
                if kentta_tyyppi in tulokset:
                    tulokset[kentta_tyyppi] += 1
                else:
                    tulokset[kentta_tyyppi] = 1
    return tulokset

def hae_icao_tiedot(icao):
    try:
        yhteys = mariadb.connect(
            user="root",         # vaihda käyttäjätiedot
            password="1234",      # vaihda salasana
            host="localhost",     # vaihda palvelin, jos tarpeen
            port=3306,            # vaihda portti, jos tarpeen
            database="airportdb"  # vaihda tietokannan nimi, jos tarpeen
        )
        kursori = yhteys.cursor()
        kysely = "SELECT name, municipality FROM airport WHERE ident = ?"
        kursori.execute(kysely, (icao,))
        tulos = kursori.fetchone()
        yhteys.close()
        return tulos
    except mariadb.Error as err:
        print(f"Tietokantaongelma: {err}")
        return None

if __name__ == "__main__":
    # Osa 1: Maakoodi ja lentokenttien tyypitys
    maakoodi = input("Anna maakoodi (esim. FI): ").strip()
    kentta_lkm = laske_lentokentat_maatunnuksella(maakoodi)
    print(f"\nLentokenttien lukumäärät maassa {maakoodi.upper()}:")
    for tyyppi, lkm in kentta_lkm.items():
        print(f"  {tyyppi}: {lkm} kappaletta")
