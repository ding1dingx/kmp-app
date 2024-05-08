package com.github.app.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.cash.redwood.composeui.RedwoodContent
import app.cash.redwood.layout.composeui.ComposeUiRedwoodLayoutWidgetFactory
import com.github.app.shared.Counter
import com.github.app.shared.MR
import com.github.app.shared.core.StringList
import com.github.app.shared.redwood.composeui.ComposeUiWidgetFactory
import com.github.app.shared.redwood.widget.SchemaWidgetSystem

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val widgetSystem = SchemaWidgetSystem(
      Schema = ComposeUiWidgetFactory,
      RedwoodLayout = ComposeUiRedwoodLayoutWidgetFactory()
    )

    setContent {
      AppTheme {
        Surface(modifier = Modifier.padding(16.dp)) {
          val labelCount = stringResource(MR.strings.label_count.resourceId)
          RedwoodContent(widgetSystem) {
            Counter(labels = StringList(listOfNotNull(labelCount)))
          }
        }
      }
    }
  }
}

@Composable
fun GreetingView(text: String) {
  Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
  AppTheme {
  }
}
