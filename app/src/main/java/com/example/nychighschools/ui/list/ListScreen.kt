package com.example.nychighschools.ui.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.nychighschools.ui.main.MainViewModel
import com.example.nychighschools.ui.nav.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    navController: NavHostController,
    mainViewModel: MainViewModel
) {
    val uiState by mainViewModel.uiState.collectAsState()

    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            modifier = Modifier
                .padding(4.dp),
            fontSize = 24.sp,
            text = "List"
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(uiState.highSchools.size) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                        .clickable {
                            mainViewModel.selectHighSchool(uiState.highSchools[it])
                            navController.navigate(Screens.DETAIL.name)
                        },
                ) {
                    Text(
                        modifier = Modifier.padding(4.dp),
                        text = "${uiState.highSchools[it].dbn}: ${uiState.highSchools[it].schoolName}"
                    )
                }
            }
        }
    }
}