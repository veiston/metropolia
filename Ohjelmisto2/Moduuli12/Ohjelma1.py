import requests

# Paskakoodia
# 4 riviä tho'
joke = requests.get(r'https://api.chucknorris.io/jokes/random').json()['value']
välimerkit = '-'*(len(joke) + 2)
print(f'{välimerkit} \n{joke} \n{välimerkit}')


