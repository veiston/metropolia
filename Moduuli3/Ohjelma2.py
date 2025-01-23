hyttiluokat = ['Lux', 'A', 'B', 'C']

print('''
    LUX on parvekkeellinen hytti yläkannella.
    A on ikkunallinen hytti autokannen yläpuolella.
    B on ikkunaton hytti autokannen yläpuolella.
    C on ikkunaton hytti autokannen alapuolella.
''')
hytti = input(f'Valitse hyttiluokka vaihtoehdoista: {hyttiluokat}\n')

if hytti in hyttiluokat:
    print(f'Valitsemasi hyttiluokka on: {hytti}')

