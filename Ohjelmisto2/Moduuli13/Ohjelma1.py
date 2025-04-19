from flask import Flask, jsonify

sovellus = Flask(__name__)

@sovellus.route('/alkuluku/<int:luku>')
def tarkista_alkuluku(luku):
    if luku > 1:
        for i in range(2, luku):
            if (luku % i) == 0:
                return jsonify({"Number": luku, "isPrime": False})
        return jsonify({"Number": luku, "isPrime": True})
    else:
        return jsonify({"Number": luku, "isPrime": False})

if __name__ == '__main__':
    sovellus.run(port=3000)