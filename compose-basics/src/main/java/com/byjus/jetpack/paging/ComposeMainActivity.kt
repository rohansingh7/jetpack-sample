package com.byjus.jetpack.paging

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.byjus.jetpack.paging.ui.theme.JetpacksampleTheme

class ComposeMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                PreviewMessageCard()
            }
        }
    }

    @Composable
    fun MessageCard(message: Message) {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "sample image",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
            
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = "Hello ${message.name}!",
                color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.subtitle2)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Hello ${message.author}!",
                    color = MaterialTheme.colors.secondary,
                    style = MaterialTheme.typography.body2)
            }
        }
    }

    @Preview(
       uiMode = Configuration.UI_MODE_NIGHT_YES,
        showBackground = true,
        name = "Dark Mode"
    )
    @Composable
    fun PreviewMessageCard(){
        MessageCard(message  = Message("Colleague", "Hey, take a look at Jetpack Compose, it's great!"))
    }


    data class Message(val name: String, val author: String)
}

