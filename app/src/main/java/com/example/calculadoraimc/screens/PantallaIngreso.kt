package com.example.calculadoraimc.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun PantallaIngreso(
    onCalcular: (String, Float) -> Unit
) {

    var nombre by remember { mutableStateOf("") }
    var peso by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }

    var error by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Calculadora IMC",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre del usuario") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = peso,
            onValueChange = { peso = it },
            label = { Text("Peso (kg)") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = altura,
            onValueChange = { altura = it },
            label = { Text("Altura (m)") }
        )

        Spacer(modifier = Modifier.height(10.dp))


        if (error) {
            Text(
                text = "Por favor, ingresa valores válidos",
                color = Color.Red
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {

                    val pesoNum = peso.toFloatOrNull()
                    val alturaNum = altura.toFloatOrNull()

                    if (
                        pesoNum != null &&
                        alturaNum != null &&
                        pesoNum > 0 &&
                        alturaNum > 0
                    ) {

                        val imc =
                            pesoNum / (alturaNum * alturaNum)

                        error = false

                        onCalcular(nombre, imc)

                        nombre = ""
                        peso = ""
                        altura = ""

                    } else {
                        error = true
                    }
                }
            ) {
                Text("Calcular")
            }
        }
    }
}
