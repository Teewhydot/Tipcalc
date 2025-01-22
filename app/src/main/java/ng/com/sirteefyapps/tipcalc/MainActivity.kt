package ng.com.sirteefyapps.tipcalc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import ng.com.sirteefyapps.tipcalc.components.TipInputs
import ng.com.sirteefyapps.tipcalc.components.TipResult
import ng.com.sirteefyapps.tipcalc.ui.theme.AppBarColor
import ng.com.sirteefyapps.tipcalc.ui.theme.AppBarMainColor
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
    val focusManager = LocalFocusManager.current

    var totalPerPerson by remember { mutableDoubleStateOf(0.0) }
    fun calculateTotalPerPerson(amount: String = "", tipPercent: Double = 0.0, splitCount: Int = 0) {
        val billAmount = amount.toDoubleOrNull() ?: 0.0
        val tipAmount = billAmount * (tipPercent / 100)
        val totalAmount = billAmount + tipAmount
        totalPerPerson = if (splitCount > 0) {
            totalAmount / splitCount
        } else {
            totalAmount / 1
        }
    }
    Scaffold (modifier = Modifier.fillMaxSize().clickable {
        focusManager.clearFocus()
    }, containerColor = AppBarColor, topBar = {
    TopAppBar(
        title = { Text(text = "Tip Calculator") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = AppBarMainColor
        )
    )
}){ innerPadding ->
Column(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
    VerticalSpacing(10)
    TipResult(totalPerPerson = totalPerPerson)
    VerticalSpacing(30)
    TipInputs(calculateTotal = { amount, tipPercent, splitCount ->
        calculateTotalPerPerson(amount, tipPercent, splitCount)
    })
}

}
}


