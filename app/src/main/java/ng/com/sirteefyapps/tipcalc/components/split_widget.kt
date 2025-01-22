package ng.com.sirteefyapps.tipcalc.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import ng.com.sirteefyapps.tipcalc.ui.theme.Purple80

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