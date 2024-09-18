from flask import Flask, request, jsonify

app = Flask(__name__)


@app.route('/')
def hello_world():  # put application's code here
    return 'Hello World!'


# Endpoint /numbers : renvoie uniquement les nombres pairs d'une liste donnée
@app.route('/numbers', methods=['POST'])
def filter_even_numbers():
    data = request.get_json()
    if not data or 'numbers' not in data:
        return jsonify({"error": "Veuillez fournir une liste de nombres."}), 400

    numbers = data['numbers']

    if not isinstance(numbers, list):
        return jsonify({"error": "Les nombres doivent être dans une liste."}), 400

    # Filtrer les nombres pairs
    pair_numbers = [num for num in numbers if isinstance(num, (int, float)) and num % 2 == 0]

    return jsonify({"pair_numbers": pair_numbers}), 200

# Endpoint /sum : renvoie la somme de deux nombres
@app.route('/sum', methods=['POST'])
def sum_two_numbers():
    # Récupérer les nombres à partir des données JSON
    data = request.get_json()

    if not data or 'num1' not in data or 'num2' not in data:
        return jsonify({"error": "Veuillez fournir deux nombres (num1 et num2)."}), 400

    num1 = data['num1']
    num2 = data['num2']

    # Vérifier que les deux nombres sont des types numériques (int ou float)
    if not isinstance(num1, (int, float)) or not isinstance(num2, (int, float)):
        return jsonify({"error": "Les deux valeurs doivent être des nombres."}), 400

    # Calculer la somme
    result = num1 + num2

    return jsonify({"sum": result}), 200

if __name__ == '__main__':
    app.run(debug=True)


if __name__ == '__main__':
    app.run()
