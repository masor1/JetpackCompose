package com.masorone.jetpackcompose.lesson.l_3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun ScaffoldSample() {
    ModalNavigationDrawer(
        drawerContent = {
            Column(modifier = Modifier
                .fillMaxHeight()
                .background(Color.White)) {
                repeat(15) {
                    Text(text = "Item $it")
                }
            }
        }
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(title = { Text(text = "TopAppBar Title") })
            },
            bottomBar = {
                NavigationBar {
                    listOf("Item A", "Item B", "Item C").forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = index == 0,
                            onClick = { },
                            label = { Text(text = item) },
                            icon = { Icon(imageVector = Icons.Filled.AccountCircle, contentDescription = null) }
                        )
                    }
                }
            }
        ) {
            Text(
                text = "package com.masorone.jetpackcompose.lesson.l_3\n" +
                        "\n" +
                        "import androidx.compose.foundation.layout.fillMaxSize\n" +
                        "import androidx.compose.foundation.layout.padding\n" +
                        "import androidx.compose.material3.ExperimentalMaterial3Api\n" +
                        "import androidx.compose.material3.Scaffold\n" +
                        "import androidx.compose.material3.Text\n" +
                        "import androidx.compose.runtime.Composable\n" +
                        "import androidx.compose.ui.Modifier\n" +
                        "import androidx.compose.ui.tooling.preview.Preview\n" +
                        "\n" +
                        "@OptIn(ExperimentalMaterial3Api::class)\n" +
                        "@Composable\n" +
                        "@Preview\n" +
                        "fun ScaffoldSample() {\n" +
                        "    Scaffold(\n" +
                        "        modifier = Modifier.fillMaxSize()\n" +
                        "    ) {\n" +
                        "        Text(\n" +
                        "            text = \"\", \n" +
                        "            modifier = Modifier.padding(it)\n" +
                        "        )\n" +
                        "    }\n" +
                        "}",
                modifier = Modifier.padding(it)
            )
        }
    }
}