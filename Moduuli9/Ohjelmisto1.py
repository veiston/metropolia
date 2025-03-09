def auto(rekisteri, huippunopeus):
    rekisteritunnus = rekisteri
    max_nopeus = huippunopeus
    tämänhetkinen_nopeus = 0
    kilometrit = 0
    return rekisteritunnus, max_nopeus, tämänhetkinen_nopeus, kilometrit

def main():
    rekisteri = input("syötä auton rekisteritunnus: ")
    huippunopeus = int(input("syötä auton huippunopeus (km/h): "))
    rekisteritunnus, max_nopeus, tämänhetkinen_nopeus, kilometrit = auto(rekisteri, huippunopeus)
    print("Rekkari on", rekisteritunnus)
    print("Huippunopeus on", max_nopeus, "km/h")
    print("Tämänhetkinen nopeus on", tämänhetkinen_nopeus, "km/h")
    print("Ajetut kilometrit ovat", kilometrit, "km")

if __name__ == "__main__":
   main()