package ng.com.sirteefyapps.tipcalc.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import ng.com.sirteefyapps.tipcalc.ui.theme.Purple80
import ng.com.sirteefyapps.tipcalc.ui.theme.Typography
import ng.com.sirteefyapps.tipcalc.ui.theme.VerticalSpacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TipInputs(calculateTotal:(String, Double, Int) -> Unit = { _, _, _ -> }) {
    var inputText by remember { mutableStateOf("") }
    var tipPercent by remember { mutableDoubleStateOf(0.0) }
    var splitCount by remember { mutableIntStateOf(1) }

    fun updateSplitCount(operation: String) {
        if (operation == "ADD") {
            splitCount++
        } else if (operation == "SUBTRACT" && splitCount > 1) {
            splitCount--
        }
    }

    Surface(modifier = Modifier.fillMaxWidth().padding(horizontal = 30.dp, vertical = 10.dp), shape = RoundedCornerShape(10.dp)) {
        Column {
            TextField(
                leadingIcon = { Text("$", style = Typography.bodyLarge) },
                value = inputText,
                onValueChange = {
                    inputText = it
                    calculateTotal(
                        inputText,
                        tipPercent,
                        splitCount
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                label = { Text("Bill Amount", style = Typography.bodyLarge) },
                modifier = Modifier.fillMaxWidth().padding(10.dp).border(
                    width = 1.dp,
                    color = Purple80,
                    shape = RoundedCornerShape(10.dp),
                ), colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    containerColor = Color.Transparent
                )
            )
            VerticalSpacing(10)
            Row(modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Split",
                    style = Typography.bodyLarge,
                )
                SplitIcon(icon = Icons.Default.KeyboardArrowUp, onClick = {
                    updateSplitCount("ADD")
                    calculateTotal(
                        inputText,
                        tipPercent,
                        splitCount
                    )
                })
                Text(
                    text = splitCount.toString(),
                    style = Typography.bodyLarge,
                )
                SplitIcon(icon = Icons.Default.KeyboardArrowDown, onClick = {
                    updateSplitCount("SUBTRACT")
                    calculateTotal(
                        inputText,
                        tipPercent,
                        splitCount
                    )
                })

            }
            VerticalSpacing(10)
            Text(
                text = "Tip ${tipPercent.toInt()}%",
                style = Typography.bodyLarge,
                modifier = Modifier.padding(10.dp).align(Alignment.CenterHorizontally)
            )
            VerticalSpacing(10)
            Slider(
                value = tipPercent.toFloat(),
                onValueChange = {
                    tipPercent = it.toDouble()
                    calculateTotal(
                        inputText,
                        tipPercent,
                        splitCount
                    )
                },
                valueRange = 0f..100f,
                modifier = Modifier.fillMaxWidth().padding(10.dp)
            )
        }
    }
}

