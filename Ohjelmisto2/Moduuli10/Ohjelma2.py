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

class Talo:
    def __init__(self, alin_kerros: int, ylimmäinen_kerros: int, hissien_lkm: int):
        self.alin_kerros = alin_kerros
        self.ylimmäinen_kerros = ylimmäinen_kerros
        self.hissit = []
        for i in range(hissien_lkm):
            self.hissit.append(Hissi(alin_kerros, ylimmäinen_kerros))

    def aja_hissiä(self, hissin_num: int, kohdekerros: int):
        if 0 <= hissin_num < len(self.hissit):
            self.hissit[hissin_num].siirry_kerrokseen(kohdekerros)
        else:
            print("Virheellinen hissinumero!")


def main() -> None:
    talo = Talo(0, 10, 3)
    print("Tervetuloa taloon, jossa on 3 hissiä!")
    try:
        hissinumero = 1+int(input("Anna hissin numero (1-3): "))
        kohdekerros = int(input("Anna haluamasi kerros: "))
        talo.aja_hissiä(hissinumero, kohdekerros)
    except ValueError:
        print("Virheellinen syöte! Syötä numero.")
        return
    print("Palataas lähtökerrokseen kaikilla hisseillä.")
    for his in talo.hissit:
        his.siirry_kerrokseen(talo.alin_kerros)

if __name__ == "__main__":
    main()