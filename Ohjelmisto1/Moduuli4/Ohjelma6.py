import random

yritykset = int(input("Anna arvottavien pisteiden määrä: "))
ympyran_pisteet = 0

for _ in range(yritykset):
    x = random.uniform(-1, 1)
    y = random.uniform(-1, 1)
    if x**2 + y**2 < 1:
        ympyran_pisteet += 1

pi_likiarvo = 4 * ympyran_pisteet / yritykset
print(f"Piin likiarvo on noin: {pi_likiarvo}")
