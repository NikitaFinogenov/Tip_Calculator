package com.example.tipcalculator

import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.GraphicsLayerScope
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tipcalculator.ui.theme.TipCalculatorTheme
import kotlin.math.absoluteValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    mainScreen()
                }
            }
        }
    }
}

@Composable
fun mainScreen() {

    var Buddies by rememberSaveable() {
        mutableStateOf(1)
    }
    var Tip_General by rememberSaveable() {
        mutableStateOf(15)
    }
    var bill = remember { mutableStateOf("") }
    //val phone = remember { mutableStateOf("") }
    /*var tip by rememberSaveable() {
        mutableStateOf(0)
    }*/
    var CardColor = Color.LightGray
    var tip = bill.value + Tip_General
    if (isSystemInDarkTheme() == true) {
        CardColor = Color.DarkGray
    } else {
        CardColor = Color.LightGray
    }

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "${
                if (bill.value == "") {
                    0
                } else {
                    bill.value.toInt() * Tip_General / 100 / Buddies
                }
            }₽", fontWeight = FontWeight.Medium, fontSize = 48.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Per Buddy", fontWeight = FontWeight.Normal, fontSize = 40.sp)
        Spacer(modifier = Modifier.height(24.dp))



        Spacer(modifier = Modifier.height(16.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f), backgroundColor = CardColor
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Total Bill(₽)", fontSize = 32.sp, fontWeight = FontWeight.Normal)
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    bill.value,
                    { bill.value = it },
                    textStyle = TextStyle(fontSize = 28.sp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )

                Spacer(modifier = Modifier.weight(1f))
                Text(text = "Generouse Tip", fontSize = 32.sp, fontWeight = FontWeight.Normal)
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Spacer(modifier = Modifier.width(24.dp))
                    IconButton(onClick = {
                        if (Tip_General == 0) {
                        } else {
                            Tip_General -= 5
                        }
                    }) {
                        Icon(imageVector = Icons.Filled.KeyboardArrowLeft, contentDescription = "")
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "$Tip_General%",
                        fontWeight = FontWeight.Normal,
                        fontSize = 48.sp
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(onClick = { Tip_General += 5 }) {
                        Icon(imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = "")
                    }
                    Spacer(modifier = Modifier.width(24.dp))
                }

                Spacer(modifier = Modifier.weight(2f))
                Text(text = "Buddies", fontSize = 32.sp, fontWeight = FontWeight.Normal)
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Spacer(modifier = Modifier.width(24.dp))
                    IconButton(onClick = {
                        if (Buddies == 1) {
                        } else {
                            Buddies--
                        }
                    }) {
                        Icon(imageVector = Icons.Filled.KeyboardArrowLeft, contentDescription = "")
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "$Buddies",
                        fontWeight = FontWeight.Normal,
                        fontSize = 48.sp
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(onClick = { Buddies++ }) {
                        Icon(imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = "")
                    }
                    Spacer(modifier = Modifier.width(24.dp))
                }
                Spacer(modifier = Modifier.weight(3f))


                //Spacer(modifier = Modifier.height(48.dp))
            }


        }

    }


}

/*
Text(
text = "${
if (bill.value == "") {
    0
} else {
    bill.value.toInt() * Tip_General / 100
}
}$", fontSize = 64.sp, fontWeight = FontWeight.Medium
)

*/