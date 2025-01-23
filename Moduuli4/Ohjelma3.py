
numerot = []

while True:
    num = input("Syötä luku:\n ")
    if num == "":
        break
    
    numero = float(num)
    numerot.append(numero)

if numerot:
    print(f"Pienin luku: {min(numerot)}")
    print(f"Suurin luku: {max(numerot)}")