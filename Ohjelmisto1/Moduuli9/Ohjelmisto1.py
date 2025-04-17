class _Auto:
    def __init__(self, rekisteri, huippunopeus, tämänhetkinen_nopeus=0, kilometrit=0):
        self.rekisteri = rekisteri
        self.huippunopeus = huippunopeus
        self.tämänhetkinen_nopeus = tämänhetkinen_nopeus
        self.kilometrit = kilometrit

def main():
    auto = _Auto('ABC-123', 142)
    print(f'Rekisteri: {auto.rekisteri}')
    print(auto.huippunopeus)
    print(auto.tämänhetkinen_nopeus)
    print(auto.kilometrit)

if __name__ == "__main__":
   main()