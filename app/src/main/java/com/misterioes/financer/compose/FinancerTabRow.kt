package com.misterioes.financer.compose

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import java.util.*

@Composable
fun FinancerTabRow(
    allScreens: List<FinancerDestination>,
    onTabSelected: (FinancerDestination) -> Unit,
    currentScreen: FinancerDestination,
) {
    Surface(
        Modifier
            .height(56.dp)
            .fillMaxWidth()
    ) {
        Row(Modifier.selectableGroup()) {
            allScreens.forEach { screen ->
                FinancerTab(
                    text = screen.route,
                    icon = screen.icon,
                    onSelected = { onTabSelected(screen) },
                    selected = currentScreen == screen
                )
            }
        }
    }
}

@Composable
fun FinancerTab(
    text: String,
    icon: ImageVector,
    onSelected: () -> Unit,
    selected: Boolean,
) {
    Row(Modifier
        .padding(16.dp)
        .height(56.dp)
        .selectable(
            selected = selected,
            onClick = onSelected,
            role = Role.Tab
        )) {
        Icon(imageVector = icon, contentDescription = text)
        if (selected) {
            Spacer(Modifier.width(12.dp))
            Text(text = text)
        }
    }
}