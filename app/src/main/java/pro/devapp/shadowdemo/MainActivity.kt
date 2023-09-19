package pro.devapp.shadowdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.White
            ) {

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "menu") {
                    composable(
                        route = "menu",
                        deepLinks = listOf(navDeepLink {
                            uriPattern = "https://devapp.pro/blog/menu"
                        })
                    ) { Menu(navController) }
                    composable(
                        route = "native",
                        deepLinks = listOf(navDeepLink {
                            uriPattern = "https://devapp.pro/blog/native"
                        })
                    ) { NativeShadow() }
                    composable(
                        route = "custom",
                        deepLinks = listOf(navDeepLink {
                            uriPattern = "https://devapp.pro/blog/custom"
                        })
                    ) { CustomShadow() }
                    composable(
                        route = "advancedCustom",
                        deepLinks = listOf(navDeepLink {
                            uriPattern = "https://devapp.pro/blog/advancedCustom"
                        })
                    ) { CustomAdvancedShadow() }
                }
            }
        }
    }
}