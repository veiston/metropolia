class Koira:
    def __init__(self, nimi = 'iines'):
        self.nimi = nimi

    def hauku(self):
        print(f"{self.nimi}: Hau! Hau!")

    def anna_nimi(self):
        return self.nimi
iines = Koira()
iines.nimi = "Moi"
iines.hauku()