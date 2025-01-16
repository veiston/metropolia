

# Ohjelma painon laskemiseen vanhanaikaisten yksiköiden avulla
leiviskät = int(input('Anna leiviskät: '))
naulat = int(input('Anna naulat: '))
luodit = int(input('Anna luodit: '))

paino = (leiviskät * 20 * 32 + naulat * 32 + luodit) * 13.3

kilogrammat = int(paino // 1000) #
grammat = paino % 1000 #modulo

print(f'Massa nykymittojen mukaan:')
print(f'{kilogrammat:.2f} kg')
print(f'{grammat:.2f} g')
