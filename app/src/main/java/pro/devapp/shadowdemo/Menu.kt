package pro.devapp.shadowdemo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun Menu(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Button(onClick = { navController.navigate("native") }) {
            Text(text = "Native")
        }
        Button(onClick = { navController.navigate("custom") }) {
            Text(text = "Line")
        }
        Button(onClick = { navController.navigate("advancedCustom") }) {
            Text(text = "Advanced")
        }
    }
}