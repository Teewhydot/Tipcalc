package ng.com.sirteefyapps.tipcalc

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ng.com.sirteefyapps.tipcalc.ui.theme.AppBarColor
import ng.com.sirteefyapps.tipcalc.ui.theme.ContainerColor
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
Scaffold (modifier = Modifier.fillMaxSize(), containerColor = ContainerColor, topBar = {
    TopAppBar(
        title = { Text(text = "Tip Calculator") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = AppBarColor
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

@Composable
fun TipInputs() {
    Surface(modifier = Modifier.fillMaxWidth().height(150.dp)) { }
}

@Composable
fun TipResult() {
    Surface(modifier = Modifier.fillMaxWidth().height(190.dp).padding(20.dp), shape = RoundedCornerShape(20.dp)) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Total Per Person", modifier = Modifier.padding(10.dp), style = Typography.titleLarge)
            Text(text = "$0.00", modifier = Modifier.padding(10.dp), style = Typography.bodyLarge)
        }
    }

}
