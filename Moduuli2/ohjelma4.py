# Ohjelma perus laskutoimituksiin
luku1 = int(input("Anna ensimmäinen kokonaisluku: "))
luku2 = int(input("Anna toinen kokonaisluku: "))
luku3 = int(input("Anna kolmas kokonaisluku: "))

summa = luku1 + luku2 + luku3
tulo = luku1 * luku2 * luku3
keskiarvo = summa / 3

print(f"Lukujen summa: {summa}")
print(f"Lukujen tulo: {tulo}")
print(f"Lukujen keskiarvo: {keskiarvo:.2f}")