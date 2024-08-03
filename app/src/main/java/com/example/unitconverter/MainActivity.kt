package com.example.unitconverter

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter();
                }
            }
        }
    }
}

@Composable
fun UnitConverter()
{
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Within column, all the UI elements will be stacked below each other
        Text("Unit Converter");
        Spacer(modifier = Modifier.height(15.dp));
        OutlinedTextField(value = "", onValueChange = {//insert code when value in text field changes

        });
        Spacer(modifier = Modifier.height(15.dp));
        Row {
            //Within row, all the UI elements will be side by side
            Box{
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Select");
                    Icon(Icons.Default.ArrowDropDown, "Set to empty");
                }
            }
            Box{
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Select");
                    Icon(Icons.Default.ArrowDropDown, "Set to empty");
                }
            }
        }
        Spacer(modifier = Modifier.height(15.dp));
        Text("Result:");
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview(){
    UnitConverter();
}

