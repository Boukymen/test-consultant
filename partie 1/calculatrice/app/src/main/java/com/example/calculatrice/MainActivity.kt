package com.example.calculatrice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculatrice.ui.theme.CalculatriceTheme
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // Références aux éléments de l'interface utilisateur
        val editTextNumber1: EditText = findViewById(R.id.editTextNumber1)
        val editTextNumber2: EditText = findViewById(R.id.editTextNumber2)
        val buttonAdd: Button = findViewById(R.id.buttonAdd)
        val buttonSubtract: Button = findViewById(R.id.buttonSubtract)
        val buttonMultiply: Button = findViewById(R.id.buttonMultiply)
        val buttonDivide: Button = findViewById(R.id.buttonDivide)
        val textViewResult: TextView = findViewById(R.id.textViewResult)

        // Fonction pour récupérer les nombres entrés
        fun getNumbers(): Pair<Double?, Double?> {
            val number1 = editTextNumber1.text.toString().toDoubleOrNull()
            val number2 = editTextNumber2.text.toString().toDoubleOrNull()
            return Pair(number1, number2)
        }

        // Gestion du clic sur le bouton "+" (Addition)
        buttonAdd.setOnClickListener {
            val (number1, number2) = getNumbers()
            if (number1 != null && number2 != null) {
                val result = number1 + number2
                textViewResult.text = "Résultat : $result"
            } else {
                textViewResult.text = "Veuillez entrer deux nombres valides."
            }
        }

        // Gestion du clic sur le bouton "-" (Soustraction)
        buttonSubtract.setOnClickListener {
            val (number1, number2) = getNumbers()
            if (number1 != null && number2 != null) {
                val result = number1 - number2
                textViewResult.text = "Résultat : $result"
            } else {
                textViewResult.text = "Veuillez entrer deux nombres valides."
            }
        }

        // Gestion du clic sur le bouton "x" (Multiplication)
        buttonMultiply.setOnClickListener {
            val (number1, number2) = getNumbers()
            if (number1 != null && number2 != null) {
                val result = number1 * number2
                textViewResult.text = "Résultat : $result"
            } else {
                textViewResult.text = "Veuillez entrer deux nombres valides."
            }
        }

        // Gestion du clic sur le bouton "/" (Division)
        buttonDivide.setOnClickListener {
            val (number1, number2) = getNumbers()
            if (number1 != null && number2 != null) {
                if (number2 != 0.0) {
                    val result = number1 / number2
                    textViewResult.text = "Résultat : $result"
                } else {
                    textViewResult.text = "Erreur : Division par zéro"
                }
            } else {
                textViewResult.text = "Veuillez entrer deux nombres valides."
            }
        }
//        enableEdgeToEdge()
//        setContent {
//            CalculatriceTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
//        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculatriceTheme {
        Greeting("Android")
    }
}