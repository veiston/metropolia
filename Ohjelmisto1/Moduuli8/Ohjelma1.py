import mariadb

icaokoodi = input("Anna lentoaseman ICAO-koodi: ").strip()

try:
    yhteys = mariadb.connect(
        user="root",         # vaihda käyttäjätiedot
        password="1234",      # vaihda salasana
        host="localhost",         # vaihda palvelin, jos tarpeen
        port=3306,                # vaihda portti, jos tarpeen
        database="airportdb"      # vaihda tietokannan nimi, jos tarpeen
    )
    kursori = yhteys.cursor()

    kysely = "SELECT name, municipality FROM airport WHERE ident = ?"
    kursori.execute(kysely, (icaokoodi,))
    rivi = kursori.fetchone()

    if rivi:
        kenttanimi, kunta = rivi
        print(f"Lentokenttä: {kenttanimi}, Sijaintikunta: {kunta}")
    else:
        print("Lentokenttää ei löytynyt.")
except mariadb.Error as virhe:
    print("Tietokantavirhe:", virhe)
finally:
    if yhteys:
        yhteys.close()
