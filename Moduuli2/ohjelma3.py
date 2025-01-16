#Suorakulmuion piirin ja pinta-alan laskuri

width = int(input('Anna suorakulmion kannan pituus (cm): \n'))
height = int(input('Anna suorakulmion korkeus (cm): \n'))

area = width * height
circ = width*2 + height*2
print(f'Pinta-ala on: {area}')
print(f'Piiri on: {circ}')