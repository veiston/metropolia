import time #aika

class Hissi:
    def __init__(self, alin_kerros: int, ylimmäinen_kerros: int):
        self.ylimmäinen_kerros = ylimmäinen_kerros
        self.alin_kerros = alin_kerros
        self.kerros = alin_kerros

    def siirry_kerrokseen(self, uusi_kerros: int):
        if uusi_kerros < self.alin_kerros or uusi_kerros > self.ylimmäinen_kerros:
            print("Tota kerrosta ei ole!")
            return
        while self.kerros < uusi_kerros:
            time.sleep(0.2) # Pikkuvenaus
            self.kerros_ylös()
        while self.kerros > uusi_kerros:
            time.sleep(0.2)
            self.kerros_alas()

    def kerros_ylös(self):
        if self.kerros < self.ylimmäinen_kerros:
            self.kerros += 1
            print(f"Hissi on nyt kerroksessa {self.kerros}.")
        else:
            print("Hissi on jo ylimmässä kerroksessa.")

    def kerros_alas(self):
        if self.kerros > self.alin_kerros:
            self.kerros -= 1
            print(f"Hissi on nyt kerroksessa {self.kerros}.")
        else:
            print("Hissi on jo alimmassa kerroksessa.")

def main() -> None:
    hissi = Hissi(alin_kerros=0, ylimmäinen_kerros=10)
    print("Tervetuloa hissiin!")
    try:
        haluttu = int(input("Anna haluamasi kerros: "))
        hissi.siirry_kerrokseen(haluttu)
    except ValueError:
        print("Virheellinen syöte! Syötä kokonaisluku.")
        return
    print("Palataan alimpaan kerrokseen.")
    hissi.siirry_kerrokseen(hissi.alin_kerros)

if __name__ == "__main__":
    main()