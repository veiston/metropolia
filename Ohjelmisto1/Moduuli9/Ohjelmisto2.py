class Auto:
    def __init__(self, rekisteri, huippunopeus, tämänhetkinen_nopeus=0, kilometrit=0):
        self.rekisteri = rekisteri
        self.huippunopeus = huippunopeus
        self.tämänhetkinen_nopeus = tämänhetkinen_nopeus
        self.kilometrit = kilometrit

    def kiihdytä(self, kiihtyvyys):
        uusi_nopeus = self.tämänhetkinen_nopeus + kiihtyvyys
        if uusi_nopeus > self.huippunopeus:
            self.tämänhetkinen_nopeus = self.huippunopeus
        elif uusi_nopeus < 0:
            self.tämänhetkinen_nopeus = 0
        else:
            self.tämänhetkinen_nopeus = uusi_nopeus

def main():
    auto = Auto('ABC-123', 142)
    auto.kiihdytä(30)
    auto.kiihdytä(70)
    auto.kiihdytä(50)
    print(f"Tämänhetkinen nopeus: {auto.tämänhetkinen_nopeus}")
    auto.kiihdytä(-200)
    print(f"Uusi nopeus hätäjarrutuksen jälkeen: {auto.tämänhetkinen_nopeus}")

if __name__ == "__main__":
   main()