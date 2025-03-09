import mariadb
from geopy.distance import distance

def hae_icao(icao):
    try:
        # Tietokanta
        yhteys = mariadb.connect(
            user="root",
            password="1234",
            host="localhost",
            port=3306,
            database="airportdb"
        )

        kursori = yhteys.cursor()
        kysely = "SELECT latitude_deg, longitude_deg FROM airport WHERE ident = ?"
        kursori.execute(kysely, (icao,))
        
        rivi = kursori.fetchone()
        
        yhteys.close()
        
        return rivi
    
    except mariadb.Error as err:
        print(f"Tietokantaongelma: {err}")
        return None
    except Exception as err:
        print(f"Yleinen virhe: {err}")
        return None

def etaisyys(coords1, coords2):

    # Geopy odottaa koordinaatteja muodossa (lat, lon)
    return distance(coords1[::-1], coords2[::-1]).km


def main():

    icao1 = input("Anna ensimmäisen lentokentän ICAO-koodi: ").strip().upper()
    icao2 = input("Anna toisen lentokentän ICAO-koodi: ").strip().upper()
    
    coords1 = hae_icao(icao1)
    coords2 = hae_icao(icao2)
    
    if coords1 is None or coords2 is None:
        print("\nVirhe: Jompaakumpaa kenttää ei löytynyt tai tietokantaan ei saada yhteyttä.")
        return
    
    # Lasketaan etäisyys
    etaisyys = etaisyys(coords1, coords2)
    
    if etaisyys is None:
        print("\nVirhe: Etäisyyden laskussa tapahtui virhe.")
        return
        
    print(f"\nEtäisyys kenttien {icao1} ja {icao2} välillä on noin {etaisyys:.1f} km.")
    

if __name__ == "__main__":
    main()