package com.angie.extraniandote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.angie.extraniandote.ui.theme.ExtraniandoteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExtraniandoteTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ButtonPanel()
                }
            }
        }
    }
}

@Composable
fun ButtonPanel() {
    var count by remember { mutableStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF607D8B)) // Gris azulado
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(top = 50.dp), // Agregar un espacio adicional desde arriba
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top // Alineación de los elementos hacia la parte superior
        ) {
            // Contador
            Text(text = "Conteo: $count", style = MaterialTheme.typography.titleLarge)

            Spacer(modifier = Modifier.height(20.dp))

            // Botón de incremento
            IncrementButton { count++ }

            Spacer(modifier = Modifier.height(20.dp))

            // Botón de reset
            ResetButton { count = 0 }
        }
    }
}

@Composable
fun IncrementButton(onClick: () -> Unit) {
    Button(onClick = onClick, modifier = Modifier.padding(10.dp)) {
        Text("Incrementar")
    }
}

@Composable
fun ResetButton(onClick: () -> Unit) {
    Button(onClick = onClick, modifier = Modifier.padding(10.dp)) {
        Text("Resetear")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ExtraniandoteTheme {
        ButtonPanel()
    }
}
