package com.example.a10__thun_mengse_pvh_oop_practice003.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.a10__thun_mengse_pvh_oop_practice003.screen.home.bottomBarItems

//@Preview
@Composable
fun NectarBottomBar() {
    Surface(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
    ) {
        NavigationBar {
            Row(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.inverseOnSurface)
                    .padding(10.dp)
                    .clip(RoundedCornerShape(20.dp))
            ) {
                bottomBarItems.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = index == 0,
                        onClick = {},
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.label,
                            )
                        },
                        label = {
                            Text(
                                text = item.label,
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color(0xFF53B175),
                            selectedTextColor = Color(0xFF53B175),
                            indicatorColor = Color.Transparent
                        )
                    )
                }
            }
        }
    }
}