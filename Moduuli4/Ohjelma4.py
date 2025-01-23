import random

arvattava_luku = random.randint(1, 10)
arvattu_oikein = False

print("Arvaa kokonaisluku väliltä 1-10")

while not arvattu_oikein:
    arvaus = int(input("Arvaus: "))

    if arvaus < arvattava_luku:
        print("Liian pieni arvaus")
    elif arvaus > arvattava_luku:
        print("Liian suuri arvaus")
    else:
        print("Oikein")
        arvattu_oikein = True
