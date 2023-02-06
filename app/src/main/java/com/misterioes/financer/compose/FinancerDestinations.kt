package com.misterioes.financer.compose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.misterioes.financer.dao.entity.Transfer
import com.misterioes.financer.viewmodel.TransfersScreenViewModel

interface FinancerDestination {
    val icon: ImageVector
    val route: String
}

object TransfersList : FinancerDestination {
    override val icon: ImageVector = Icons.Filled.List
    override val route: String = "transfers"
    val screen: @Composable (viewModel: TransfersScreenViewModel) -> Unit = {viewModel -> TransfersScreen(viewModel) }
}

// Screens to be displayed in the top TabRow
val financerTabRowScreens = listOf(TransfersList)