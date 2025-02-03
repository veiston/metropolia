import random as rand

summa = []
arpakuutiot = input("Kuinka monta arpakuutiota heitetään?\n")

for i in range(int(arpakuutiot)):
    summa.append(rand.randint(1,6))
    print(f"Heitto " + str(i+1) + ": " + str(summa[i]))

koko = 0
for i in range(len(summa)):
    koko += summa[i]

print(f"Heittojen summa: " + str(koko))