sukupuoli = input('Sukupuolesi (m / w):\n')
hemoglobiini = int(input('Hemoglobiinisi:\n'))

try:
    if sukupuoli == 'm' and 134 <= hemoglobiini <= 195:
        print(f'Hemoglobiinisi ({hemoglobiini}) on hyvä sukupuolellesi ({sukupuoli})')
        breakpoint
    elif hemoglobiini > 195:
        print('Hemoglobiinisi on liian korkea')
    elif hemoglobiini < 134:
        print('Hemoglobiinisi on liian matala')
            
    if sukupuoli == 'w' and 117 <= hemoglobiini <= 175:
        print(f'Hemoglobiinisi ({hemoglobiini}) on hyvä sukupuolellesi ({sukupuoli})')
    elif hemoglobiini > 175:
        print('Hemoglobiinisi on liian korkea')
    elif hemoglobiini < 117:
        print('Hemoglobiinisi on liian matala')
    
except:
    print('Virhe')