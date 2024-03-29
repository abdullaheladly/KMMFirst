package com.example.kmmfirst.android.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.kmmfirst.Platform

@Composable
fun AboutDeviceScreen(
    onUpButtonClicked: () -> Unit
) {
    Column {
        Toolbar(onUpButtonClicked)
        ContentView()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Toolbar(
    onUpButtonClicked: () -> Unit
) {
    TopAppBar(title = { Text(text = "About Device") },
        navigationIcon = {
            IconButton(onClick = onUpButtonClicked) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Up Button")
            }
        }
    )
}

@Composable
fun ContentView() {
    val items = makeItems()
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(items) {
            RowView(it.first, it.second)
        }
    }
}

private fun makeItems(): List<Pair<String, String>> {
    val platform = Platform()
    platform.logSystemInfo()
    return listOf(
        Pair("Operating system", "${platform.osName} ${platform.osVersion}"),
        Pair("Device", platform.deviceModel),
        Pair("density", platform.density.toString())
    )
}

@Composable
private fun RowView(title: String, subTitle: String) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(text = title, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
        Text(text = subTitle, style = MaterialTheme.typography.bodyLarge)
    }
    Divider()
}