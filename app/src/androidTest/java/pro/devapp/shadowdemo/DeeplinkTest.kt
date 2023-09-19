package pro.devapp.shadowdemo

import android.app.Application
import android.content.Intent
import android.net.Uri
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LaunchAppTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun openNativeDeeplinkTest() {
        val context = ApplicationProvider.getApplicationContext<Application>()
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://devapp.pro/blog/native")).apply {
            setPackage("pro.devapp.shadowdemo")
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }

        context.startActivity(intent)
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithTag("NativeShadowScreen").assertIsDisplayed()
    }
}
