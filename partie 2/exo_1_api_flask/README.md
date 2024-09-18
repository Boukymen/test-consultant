


# exo_1_api_flask pour utilise cet api il faut suivre les étapes suivantes:

``` pip install flask ```

# lancer le serveur:

``` python app.py ```

# pour tester l'api:

si vous avez postman, importer le fichier exo_1_api_flask.postman_collection.json et lancer les requêtes.
 si vous n'avez pas postman, vous pouvez utiliser curl:
# pour /numbers
``` 
curl -X POST http://localhost:5000/numbers -H "Content-Type: application/json" -d '{"numbers": [1, 2, 3, 4, 5, 6]}'
```
# pour /sum

```
curl -X POST http://localhost:5000/sum -H "Content-Type: application/json" -d '{"num1": 10, "num2": 20}'

```
