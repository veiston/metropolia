class Julkaisu:
# Perusluokka
    def __init__(self, nimi):
        self.nimi = nimi

    def tulosta_tiedot(self):
        pass

class Kirja(Julkaisu):
    def __init__(self, nimi, kirjoittaja, sivumaara):
        super().__init__(nimi)
        self.kirjoittaja = kirjoittaja
        self.sivumaara = sivumaara
    def tulosta_tiedot(self):
        print(f"Nimi: {self.nimi}")
        print(f"Kirjoittaja: {self.kirjoittaja}")
        print(f"Sivumäärä: {self.sivumaara}")

class Lehti(Julkaisu):
    def __init__(self, nimi, paa_toimittaja):
        super().__init__(nimi)
        self.paa_toimittaja = paa_toimittaja
    def tulosta_tiedot(self):
        print(f"Nimi: {self.nimi}")
        print(f"Päätoimittaja: {self.paa_toimittaja}")

def main():
    julkaisu1 = Lehti("Aku Ankka", "Aki Hyyppä")
    julkaisu2 = Kirja("Hytti n:o 6", "Rosa Liksom", 200)
    julkaisu1.tulosta_tiedot()
    print("---")
    julkaisu2.tulosta_tiedot()

if __name__ == "__main__":
    main()