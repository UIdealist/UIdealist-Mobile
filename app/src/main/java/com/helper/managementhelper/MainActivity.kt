package com.helper.managementhelper

import android.graphics.ColorSpace
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.VectorConverter
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.helper.managementhelper.ui.theme.ManagementHelperTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.members_management)

        // Lets edit layout a little bit by adding custom
        // roles on it
        val membersRolesLayout : LinearLayout = findViewById(
                R.id.lytMembersRoles
        );

        val membersComposeView = ComposeView(this);
        membersRolesLayout.addView( membersComposeView );

        membersComposeView.setContent {
            Column {
                RoleFrame("Supreme Admins", Color(0xFFBFFF00))
                RoleFrame("High Admins", Color(0xFF00BF7D))
                RoleFrame("Expert Admins", Color(0xFF9040BF))
                RoleFrame("Advanced Admins", Color(0xFF4B7BFF))
                RoleFrame("Standard Admins", Color(0xFF5BFFFF))
                RoleFrame("Starting Admins", Color(0xFFFFBF00))
                RoleFrame("Special Guests", Color(0xFF4BBF4B))
            }
        }
    }
}

@Composable
fun RoleFrame(
    name: String, color: Color
) {
    Row(
        Modifier
            .fillMaxWidth()
            .background( color )
    ) {
        Text(
            text = name,
            color = color,
            fontSize = 4.em,
            textAlign = TextAlign.Center,
            style = TextStyle(
                background = Color.White,
            )
        )
        Column(
            modifier = Modifier
                .size(100.dp)
                .verticalScroll(rememberScrollState())
        ){

        }
    }
}