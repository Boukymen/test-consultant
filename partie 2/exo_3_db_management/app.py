import sqlite3

# Connexion à la base de données SQLite (ou création de la base de données si elle n'existe pas)
conn = sqlite3.connect('employees.db')

# Création d'un curseur pour interagir avec la base de données
cursor = conn.cursor()

# Création de la table 'employees' si elle n'existe pas déjà
cursor.execute('''
    CREATE TABLE IF NOT EXISTS employees (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        name TEXT NOT NULL,
        salary REAL NOT NULL
    )
''')

# Insertion de données dans la table 'employees'
cursor.executemany('''
    INSERT INTO employees (name, salary) 
    VALUES (?, ?)
''', [
    ('Maimouna', 60000),
    ('Ichaka', 45000),
    ('Bakary', 55000),
    ('Moussa', 30000),
    ('Adama', 75000)
])

# Sauvegarder les modifications
conn.commit()

# Récupérer et afficher les employés ayant un salaire supérieur à 50,000
cursor.execute('''
    SELECT name, salary FROM employees WHERE salary > 50000
''')

# Afficher les résultats
resultats = cursor.fetchall()

for row in resultats:
    print(f"Employé: {row[0]}, Salaire: {row[1]}")

# Fermer la connexion à la base de données
conn.close()
