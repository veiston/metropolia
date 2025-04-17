lentoasemat = {}

while True:
    print("Valitse toiminto:")
    print("1. Syötä uusi")
    print("2. Hae lnentoasemaa")
    print("3. Lopeta")
    valinta = input("Mitä valitset?: ")

    if valinta == "1":
        icao = input("Anna lentoaseman ICAO-koodi: ")
        nimi = input("Anna lentoaseman nimi: ")
        lentoasemat[icao] = nimi
        print("Tieto tallennettu")

    elif valinta == "2":
        icao = input("Anna haettavan lentoaseman ICAO-koodi: ")
        if icao in lentoasemat:
            print(f"Lentoaseman nimi: {lentoasemat[icao]}")

        else:
            print("Lentoasemaa ei löydy.")

    elif valinta == "3":
        print("Lopetetaan")
        break

    else:
        print("Virhe. Yritä uudelleen.")