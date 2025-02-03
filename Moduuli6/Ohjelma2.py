import random

viimeisin = 0
silmät = input('Kuinka monta silmää kuutiossa on: ')
def heitto(silmät):
    return random.randint(1, int(silmät))

while viimeisin != silmät:
    viimeisin = heitto(silmät)
    print(viimeisin)
    if viimeisin == int(silmät):
        print("wuhuu!!")
        break