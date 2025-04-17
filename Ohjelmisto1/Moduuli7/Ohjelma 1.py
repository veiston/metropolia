def main():
    kuu = ("talvi", "talvi", "kevät", "kevät", "kevät", "kesä", "kesä", "kesä", "syksy", "syksy", "syksy", "talvi")
    kuukausi = int(input("Anna kukausi numerona 1-12): "))
    
    if 1 <= kuukausi <= 12:
        print(f"numeron kuukautta vastaava vuodenaika on: {kuu[kuukausi - 1]}")
    else:
        print("Virhe 404, kuukautta ei löydetty")

if __name__ == "__main__":
    main()
