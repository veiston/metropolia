def main(): # Pääfunktio laskimen käyttöön
    lista = [1, 2, 3, 4, 5]
    print(lista)
    print(karsin(lista))

def karsin(lista): # Laskin
    parilliset = []
    
    for i in lista:
        if i % 2 == 0:
            parilliset.append(i)
    return parilliset

if __name__ == "__main__": # Boiler
    main()
