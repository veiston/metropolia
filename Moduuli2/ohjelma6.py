import random as rand

koodi1 = [0,0,0]
koodi2 = [0,0,0,0]

for i in range(3): 
    koodi1[i] = rand.randint(0,9)

for i in range(4): 
    koodi2[i] = rand.randint(1,6)

print(f'Koodi 1: {koodi1} \nKoodi 2: {koodi2}')



