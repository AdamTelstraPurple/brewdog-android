package com.example.brewdog.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.brewdog.R
import com.example.brewdog.ui.theme.BrewdogTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen (
    brewDogViewModel: BrewDogViewModel = viewModel(),
    modifier: Modifier
) {
    val brewDogUiState by brewDogViewModel.uiState.collectAsState()
    var text by rememberSaveable { mutableStateOf("") }
    var expanded by rememberSaveable { mutableStateOf(false) }

    Column (Modifier.padding(horizontal = 8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        SearchBar(
            modifier = Modifier.fillMaxWidth(),
            inputField = {
                SearchBarDefaults.InputField(
                    query = text,
                    onQueryChange = {text = it},
                    onSearch = {expanded = false},
                    expanded = expanded,
                    onExpandedChange = {expanded = it},
                    placeholder = { Text("Search for beers or food pairings") },
                    leadingIcon = { Icon( Icons.Filled.Search, contentDescription = null) },
                    trailingIcon = { Icon(painterResource(R.drawable.mic_24dp), contentDescription = null) }
                )
            },
            expanded = expanded,
            onExpandedChange = {expanded = it}
        ) { }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Heading(
                name = "Beer"
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(painterResource(R.drawable.more_horiz_24dp), contentDescription = null)
        }

        FilledTonalButton(onClick = { /*do something*/ }, modifier = Modifier.fillMaxWidth()) {
            Icon(painterResource(R.drawable.casino_24dp), contentDescription = "shopping cart")
            Text("Spin the bottle")
        }
        Card(Modifier) {
            LazyColumn(Modifier.padding(horizontal = 16.dp)) {
                items(5) {
                        index ->  RowItem()
                }
            }
        }

    }
}

@Composable
fun Heading(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        modifier = modifier,
        fontSize = 28.sp
    )
}
@Composable
fun RowItem(modifier: Modifier = Modifier){
    Row(Modifier.fillMaxWidth().padding(vertical = 8.dp), verticalAlignment = Alignment.CenterVertically) {
        Image(painterResource(R.drawable._05), "Beer 5", modifier = modifier.height(36.dp).width(36.dp))
        Column {
            Text("Beer 1")
            Text("Description", color = Color.Gray)
        }
        Spacer(modifier = Modifier.weight(1f))
        Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, "ArrowRight")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RowItem()
}