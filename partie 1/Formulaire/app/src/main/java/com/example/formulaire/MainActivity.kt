package com.example.formulaire

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.formulaire.ui.theme.FormulaireTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nameInput: EditText = findViewById(R.id.nameInput)
        val emailInput: EditText = findViewById(R.id.emailInput)
        val submitButton: Button = findViewById(R.id.submitButton)
        val message: TextView = findViewById(R.id.message)

        submitButton.setOnClickListener {
            val email = emailInput.text.toString()

            if (isValidEmail(email)) {
                message.text = "Email valide. Formulaire soumis avec succès!"
                message.setTextColor(getColor(android.R.color.holo_green_dark))
            } else {
                message.text = "Erreur: Veuillez entrer un email valide."
                message.setTextColor(getColor(android.R.color.holo_red_dark))
            }
        }
    }

    private fun isValidEmail(email: String): Boolean {
        // Regex pour la validation de l'email
        val emailPattern = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$"
        return email.matches(emailPattern.toRegex())
    }
//        enableEdgeToEdge()
//        setContent {
//            FormulaireTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
//        }
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
    FormulaireTheme {
        Greeting("Android")
    }
}
