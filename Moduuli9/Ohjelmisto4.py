import random

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

    def kulje(self, tunnit):
        self.kilometrit += self.tämänhetkinen_nopeus * tunnit

def main():
    autot = []
    for i in range(1, 11):
        rekisteri = f"ABC-{i}"
        huippunopeus = random.randint(100, 200)
        autot.append(Auto(rekisteri, huippunopeus))
    tunti = 0
    while True:
        tunti += 1
        for auto in autot:
            muutos = random.randint(-10, 15)
            auto.kiihdytä(muutos)
        for auto in autot:
            auto.kulje(1)
        if any(auto.kilometrit >= 10000 for auto in autot):
            break
    print(f"{'Rekisteri':<10} {'Huippunopeus':<15} {'Tämänhetkinen':<15} {'Kilometrit':<10}")
    for auto in autot:
        print(f"{auto.rekisteri:<10} {auto.huippunopeus:<15} {auto.tämänhetkinen_nopeus:<15} {auto.kilometrit:<10.2f}")

if __name__ == "__main__":
    main()