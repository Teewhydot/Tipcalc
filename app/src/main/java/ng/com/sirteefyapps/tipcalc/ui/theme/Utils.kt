package ng.com.sirteefyapps.tipcalc.ui.theme

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Common repeated utilities
@Composable
fun VerticalSpacing(height: Int) {
    Spacer(modifier = Modifier.height(height.dp))
}

@Composable
fun HorizontalSpacing(width: Int) {
    Spacer(modifier = Modifier.height(width.dp))
}