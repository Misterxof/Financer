package com.misterioes.financer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.misterioes.financer.compose.FinancerDestination
import com.misterioes.financer.compose.TransfersList
import com.misterioes.financer.compose.financerTabRowScreens
import com.misterioes.financer.ui.theme.FinencerTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.misterioes.financer.compose.FinancerTabRow
import com.misterioes.financer.viewmodel.TransfersScreenViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinancerApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FinancerApp() {
    FinencerTheme {
        val navController = rememberNavController()
        val currentBackStack by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStack?.destination
        val currentScreen = financerTabRowScreens.find { it.route == currentDestination?.route } ?: TransfersList
        Scaffold(
            topBar = {
                FinancerTabRow(allScreens = financerTabRowScreens,
                    onTabSelected = { newScreen ->
                        navController
                            .navigateSingleTopTo(newScreen.route)
                    },
                    currentScreen = currentScreen)
            }
        ) { innerPadding ->
            Box(Modifier.padding(innerPadding)) {
                FinancerNavHost(navController = navController)
            }
        }


    }
}

@Composable
fun FinancerNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = TransfersList.route,
        modifier = modifier
    ) {
        composable(route = TransfersList.route) {
            val transferScreenViewModel: TransfersScreenViewModel by viewModel()
            TransfersList.screen(transferScreenViewModel)
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) { launchSingleTop = true }

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FinencerTheme {
        Greeting("Android")
    }
}