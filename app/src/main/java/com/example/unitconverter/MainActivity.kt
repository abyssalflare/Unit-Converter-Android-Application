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
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconverter.ui.theme.UnitConverterTheme
import kotlin.math.roundToInt

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
    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("")}
    var inputUnit by remember { mutableStateOf("Meters")}
    var outputUnit by remember { mutableStateOf("Meters")}
    var inputExpanded by remember { mutableStateOf(false)}
    var outputExpanded by remember { mutableStateOf(false)}
    var inputConversionFactor by remember { mutableStateOf( 1.00 )}
    var outputConversionFactor by remember { mutableStateOf( 1.00 )}

    fun convertUnits()
    {
        // ?: elvis operator
        // a smart and quick if else operator
        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0 //if we enter something that cannot be converted to Double,
                                                                    //0.0 is returned instead of null

        //this formula right here returns a result without all the long decimals at the back
        var result = (inputValueDouble * inputConversionFactor * 100.0 / outputConversionFactor).roundToInt() / 100.0;

        //update the outputValue mutablestate so that we can display it within our UI
        outputValue = result.toString();
    }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Within column, all the UI elements will be stacked below each other
        Text("Unit Converter");
        Spacer(modifier = Modifier.height(16.dp));
        OutlinedTextField(
            value = inputValue, //the value to be shown in the OutlinedTextField, initially, it was an empty string, hence
                                //why we couldnt even type anything as the value would always be an empty string
            onValueChange = {//when we type inside the text field, this event is called, a string, "it" is returned from the
                                    // input service, we then assigned this "it" to the inputValue variable, which is assigned to
                                    // value above, which is what gets displayed on the screen
            inputValue = it;
            convertUnits();//update the outputResult everytime you change the outlinedtextfield value
        },
            label = { Text(text = "Enter Value")}
        );
        Spacer(modifier = Modifier.height(16.dp));
        Row {
            //Within row, all the UI elements will be side by side

            //Input Box
            Box{

                //Input Button
                Button(onClick = { inputExpanded = true }) {
                    Text(text = inputUnit);
                    Icon(Icons.Default.ArrowDropDown, "Set to empty");
                }
                DropdownMenu(expanded = inputExpanded, onDismissRequest = { inputExpanded = false}) {
                    DropdownMenuItem(
                        text = { Text(text = "Centimeters") },
                        onClick = {
                            inputUnit = "Centimeters";
                            inputExpanded = false;
                            inputConversionFactor = 0.01;
                            convertUnits();
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Meters") },
                        onClick = {
                            inputUnit = "Meters";
                            inputExpanded = false;
                            inputConversionFactor = 1.0;
                            convertUnits();
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Feet") },
                        onClick = {
                            inputUnit = "Feet";
                            inputExpanded = false;
                            inputConversionFactor = 0.3048;
                            convertUnits();
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Millimeters") },
                        onClick = {
                            inputUnit = "Millimeters";
                            inputExpanded = false;
                            inputConversionFactor = 0.001;
                            convertUnits();
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.width(16.dp));

            //Output Box
            Box{

                //Output Button
                Button(onClick = { outputExpanded = true }) {
                    Text(text = outputUnit);
                    Icon(Icons.Default.ArrowDropDown, "Set to empty");
                }
                DropdownMenu(expanded = outputExpanded, onDismissRequest = { outputExpanded = false}) {
                    DropdownMenuItem(
                        text = { Text(text = "Centimeters") },
                        onClick = {
                            outputUnit = "Centimeters";
                            outputExpanded = false;
                            outputConversionFactor = 0.01;
                            convertUnits();
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Meters") },
                        onClick = {
                            outputUnit = "Meters";
                            outputExpanded = false;
                            outputConversionFactor = 1.0;
                            convertUnits();
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Feet") },
                        onClick = {
                            outputUnit = "Feet";
                            outputExpanded = false;
                            outputConversionFactor = 0.3048;
                            convertUnits();
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Millimeters") },
                        onClick = {
                            outputUnit = "Millimeters";
                            outputExpanded = false;
                            outputConversionFactor = 0.001;
                            convertUnits();
                        }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp));
        Text("Result: ${outputValue}");
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview(){
    UnitConverter();
}

