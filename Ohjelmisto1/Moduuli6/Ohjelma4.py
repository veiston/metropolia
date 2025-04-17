def main(): # Pääfunktio laskimen käyttöön
    print(laskin([1, 2, 3, 4, 5]))

def laskin(lista): # Laskin
    kokonaisluvut = 0
    for i in lista:
        kokonaisluvut += i
    return kokonaisluvut

if __name__ == "__main__": # Boiler
    main()
