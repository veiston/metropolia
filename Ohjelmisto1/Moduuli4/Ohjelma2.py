tuumat = -1
#

while tuumat < 0:
    tuumat = float(input('Anna negatiivinen tuumamäärä:\n'))
    sentit = tuumat * 254 / 100
    print(f'Sentteinä: {sentit}')