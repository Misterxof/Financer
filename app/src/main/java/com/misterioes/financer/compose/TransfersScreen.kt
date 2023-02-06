package com.misterioes.financer.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.misterioes.financer.dao.entity.Transfer
import com.misterioes.financer.viewmodel.TransfersScreenViewModel
import java.util.Date

@Composable
fun TransfersScreen(
//    transfersList: List<Transfer>,
    viewModel: TransfersScreenViewModel,
    modifier: Modifier = Modifier
) {
    val transfersList by viewModel.transfersList.observeAsState(listOf())
    val lazyListState = rememberLazyListState()
    Column(modifier = modifier) {
        LazyColumn(state = lazyListState) {
            items(transfersList) { transfer ->
                TransferRow(amount = transfer.amount, isBill = transfer.isBill, date = transfer.date)
            }
        }
        FloatingActionButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Rounded.Add, contentDescription = "Added new transfer FAB")
        }
    }
}

@Composable
fun TransferRow(
    amount: Int,
    isBill: Boolean,
    date: Date,
    modifier: Modifier = Modifier
) {
    val color = if (isBill) Color.Red else Color.Green

    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(text = "$amount", color = color)
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "$date")
    }
}