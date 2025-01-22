package ng.com.sirteefyapps.tipcalc.components
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ng.com.sirteefyapps.tipcalc.ui.theme.Typography


@SuppressLint("DefaultLocale")
@Composable
fun TipResult(totalPerPerson: Double) {
    val formattedTotalPerPerson = String.format("%.0f", totalPerPerson)
    Surface(modifier = Modifier.fillMaxWidth().height(190.dp).padding(horizontal = 30.dp, vertical = 10.dp), shape = RoundedCornerShape(20.dp)) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Total Per Person", modifier = Modifier.padding(10.dp), style = Typography.titleLarge)
            Text(text = "$$formattedTotalPerPerson", modifier = Modifier.padding(10.dp), style = Typography.bodyLarge.copy(fontWeight = FontWeight.Bold), fontSize = 30.sp)
        }
    }

}

