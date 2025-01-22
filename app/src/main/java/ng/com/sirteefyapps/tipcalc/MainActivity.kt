package ng.com.sirteefyapps.tipcalc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ng.com.sirteefyapps.tipcalc.ui.theme.AppBarColor
import ng.com.sirteefyapps.tipcalc.ui.theme.ContainerColor
import ng.com.sirteefyapps.tipcalc.ui.theme.Purple80
import ng.com.sirteefyapps.tipcalc.ui.theme.Typography
import ng.com.sirteefyapps.tipcalc.ui.theme.VerticalSpacing

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           TipCalcHome()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun TipCalcHome() {
Scaffold (modifier = Modifier.fillMaxSize(), containerColor = AppBarColor, topBar = {
    TopAppBar(
        title = { Text(text = "Tip Calculator") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = ContainerColor
        )
    )
}){ innerPadding ->
Column(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
    VerticalSpacing(10)
    TipResult()
    VerticalSpacing(30)
    TipInputs()
}

}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TipInputs() {
    val inputText by remember { mutableStateOf("") }

    Surface(modifier = Modifier.fillMaxWidth().padding(horizontal = 30.dp, vertical = 10.dp).border(width = 1.dp, color = Purple80), shape = RoundedCornerShape(10.dp)) {
        Column {
            TextField(
                leadingIcon = { Text("$", style = Typography.bodyLarge) },
                value = inputText,
                onValueChange = {

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
            Row(modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Split",
                    style = Typography.bodyLarge,
                    modifier = Modifier.weight(1f)
                )
                SplitIcon(icon = Icons.Default.Add, onClick = {})
                SplitIcon(icon = Icons.Default.ArrowDropDown, onClick = {})

            }
        }
    }
}

@Composable
fun SplitIcon(icon: ImageVector, onClick: () -> Unit) {
    Surface(
        modifier = Modifier.height(60.dp).width(60.dp).padding(10.dp),
        shape = CircleShape,
        color = Purple80,
        onClick = onClick
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier.padding(10.dp)
        )
    }
}


@Composable
fun TipResult() {
    Surface(modifier = Modifier.fillMaxWidth().height(190.dp).padding(horizontal = 30.dp, vertical = 10.dp), shape = RoundedCornerShape(20.dp)) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Total Per Person", modifier = Modifier.padding(10.dp), style = Typography.titleLarge)
            Text(text = "$0.00", modifier = Modifier.padding(10.dp), style = Typography.bodyLarge.copy(fontWeight = FontWeight.Bold), fontSize = 30.sp)
        }
    }

}
