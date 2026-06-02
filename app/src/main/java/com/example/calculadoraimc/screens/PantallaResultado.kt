package com.example.calculadoraimc.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PantallaResultado(
    nombre: String,
    imc: Float,
    onVolver: () -> Unit
) {

    val categoria: String
    val color: Color

    when {

        imc < 18.5 -> {
            categoria = "Bajo peso"
            color = Color.Red
        }

        imc < 25 -> {
            categoria = "Peso normal"
            color = Color.Green
        }

        imc < 30 -> {
            categoria = "Sobrepeso"
            color = Color(0xFFFF9800)
        }

        else -> {
            categoria = "Obesidad"
            color = Color.Red
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Hola $nombre, tu resultado es:"
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = String.format("%.1f", imc),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = categoria,
            color = color,
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = onVolver
        ) {
            Text("Volver")
        }
    }
}