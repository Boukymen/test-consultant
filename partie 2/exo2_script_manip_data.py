def filtrer_prenoms_valides(prenoms):
    prenoms_valides = []

    for prenom in prenoms:
        if prenom.startswith('A'):
            print(f"{prenom} : Prénom valide")
            prenoms_valides.append(prenom)
        else:
            print(f"{prenom} : Prénom invalide")

    return prenoms_valides

# Exemple d'utilisation
prenoms = ["Mamadou", "Aissata", "Ousmane", "Bakary", "Amidou", "Alima"]
prenoms_valides = filtrer_prenoms_valides(prenoms)

print("Liste des prénoms valides :", prenoms_valides)
