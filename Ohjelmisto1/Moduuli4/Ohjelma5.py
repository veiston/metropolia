max_yritykset = 5
oikea_kayttajatunnus = "python"
oikea_salasana = "rules"

yritykset = 0

while yritykset < max_yritykset:
    kayttajatunnus = input("Käyttäjätunnus: ")
    salasana = input("Salasana: ")
    
    if kayttajatunnus == oikea_kayttajatunnus and salasana == oikea_salasana:
        print("Tervetuloa")
        break
    else:
        print("Väärä käyttäjätunnus tai salasana")
        yritykset += 1

if yritykset == max_yritykset:
    print("Pääsy evätty")
