
def laske_yksikkohinta(halkaisija_cm, hinta_euro): #Laskin
    sade_m = (halkaisija_cm / 2) / 100
    pinta_ala = 3.14 * (sade_m ** 2) 
    yksikköhinta = float(hinta_euro) / float(pinta_ala) 
    return yksikköhinta

def main(): # pääfunktio
    halkaisija1 = float(input("Anna ensimmäisen pizzan halkaisija:\n"))
    hinta1 = float(input("Anna ensimmäisen pizzan hinta:\n"))
    halkaisija2 = float(input("Anna toisen pizzan halkaisija:\n"))
    hinta2 = float(input("Anna toisen pizzan hinta:\n"))

    yksikkohinta1 = laske_yksikkohinta(halkaisija1, hinta1)
    yksikkohinta2 = laske_yksikkohinta(halkaisija2, hinta2)

    if yksikkohinta1 < yksikkohinta2:
        print("Ensimmäinen pizza on wörtimpi")
    elif yksikkohinta1 > yksikkohinta2:
        print("Toinen pizza on wörtimpi")
    else:
        print("Molemmat pizzat ovat yhtä wörttejä")

if __name__ == "__main__": # BOiler
    main()