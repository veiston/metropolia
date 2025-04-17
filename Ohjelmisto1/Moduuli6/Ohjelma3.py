def litroiksi(gallona):
    return gallona * 3.785

def main():
    while True:
        gallonat = float(input("Anna gallonat: "))
        if gallonat < 0:
            break
        litrat = litroiksi(gallonat)
        print(f"{gallonat} gallonaa on {litrat:.2f} litraa")

if __name__ == "__main__":
    main()