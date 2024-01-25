package com.example.nychighschools.ui.detail

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.nychighschools.ui.main.MainViewModel

@Composable
fun DetailScreen(
    navController: NavHostController,
    mainViewModel: MainViewModel,
) {
    val uiState by mainViewModel.uiState.collectAsState()

    Log.d("HIGSCHOOL", "DetailScreen: ${uiState.selectedSchool}")
    uiState.selectedSchool?.let {
        Card (
            modifier = Modifier.padding(8.dp)
        ) {
            Text (
                fontSize = 24.sp,
                text = it.schoolName
            )
            Text(
                text = it.overviewParagraph
            )
        }
    }
}