import random

viimeisin = 0

def heitto():
    return random.randint(1, 6)

while viimeisin != 6:
    viimeisin = heitto()
    print(viimeisin)
    if viimeisin == 6:
        print("wuhuu!!")
        break