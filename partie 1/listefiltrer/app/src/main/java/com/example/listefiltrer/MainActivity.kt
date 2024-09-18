package com.example.listefiltrer

import NumberAdapter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.listefiltrer.ui.theme.ListefiltrerTheme
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {

    private lateinit var adapter: NumberAdapter
    private val numberList = (1..100).toList()  // Générer une liste de nombres de 1 à 100


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // getting the recyclerview by its id
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val editTextFilter = findViewById<EditText>(R.id.editTextFilter)
        // Configurer le RecyclerView
        adapter = NumberAdapter(numberList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Ajouter un TextWatcher au EditText pour filtrer les nombres
        editTextFilter.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val seuil = s.toString().toIntOrNull() ?: 0
                filtrerNombres(seuil)
            }

            override fun afterTextChanged(s: Editable?) {}
        })
//        enableEdgeToEdge()
//        setContent {
//            ListefiltrerTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
//        }
    }

    // Fonction pour filtrer la liste de nombres
    private fun filtrerNombres(seuil: Int) {
        val filteredList = numberList.filter { it > seuil }
        adapter.updateList(filteredList)
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
    ListefiltrerTheme {
        Greeting("Android")
    }
}