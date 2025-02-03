luvut = []

while True:
    syote = input("Anna luku. (Jätä tyhjäksi lopettaaksesi): ")
    if syote == "":
        break
    luvut.append(int(syote))

luvut.sort(reverse=True)
suurimmat_viisi = luvut[:5]

print("Viisi suurinta lukua ovat:")
for luku in suurimmat_viisi:
    print(luku)