package com.example.a10__thun_mengse_pvh_oop_practice003.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Cancel
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a10__thun_mengse_pvh_oop_practice003.data.CheckCategory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowSheet(isSheet: Boolean, getSheet : (Boolean) -> Unit){
    var showSheet = isSheet
    val sheetState = rememberModalBottomSheetState()
    if (showSheet) {
        ModalBottomSheet(
            onDismissRequest = {
                showSheet = false
                getSheet(showSheet)
            },
            sheetState = sheetState,
            dragHandle = null
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(75.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Icon(
                        imageVector = Icons.Rounded.Cancel,
                        contentDescription = "Close bottom sheet",
                        modifier = Modifier
                            .clickable{
                                showSheet = false
                                getSheet(showSheet)
                            }
                    )

                    Text(
                        text = "Filters",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "         ",
                    )
                }

                FilterSection( "Categories", checkCategory)

                Spacer(modifier = Modifier.height(15.dp))

                FilterSection( "Brand", checkBrand)
            }
        }
    }
}

val checkCategory = listOf(
    CheckCategory(id = 1, name = "Eggs"),
    CheckCategory(id = 2, name = "Noodles & Pasta"),
    CheckCategory(id = 3, name = "Chips & Crips"),
    CheckCategory(id = 4, name = "Fast Food"),
)

val checkBrand = listOf(
    CheckCategory(id = 1, name = "Individual Collection"),
    CheckCategory(id = 2, name = "Cocola"),
    CheckCategory(id = 3, name = "Ifad"),
    CheckCategory(id = 4, name = "Kazi Farmas"),
)

@Composable
fun FilterSection(title: String, checkList: List<CheckCategory>){
    Text(
        text = title,
        fontWeight = FontWeight.Medium,
        fontSize = 23.sp
    )

    Spacer(modifier = Modifier.height(15.dp))

    val isCategory = remember {
        mutableStateListOf(*Array(checkList.size) { false })
    }

    LazyColumn {
        itemsIndexed(checkList, key = { _,item -> item.id}){index, item->
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Checkbox(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp)),
                    checked = isCategory[index],
                    onCheckedChange = {
                        isCategory[index] = !isCategory[index]
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color(0xFF53B074)
                    )
                )

                Text(
                    text = item.name,
                    modifier = Modifier
                        .clickable{
                            isCategory[index] = !isCategory[index]
                        },
                    fontSize = 18.sp,
                )
            }
        }
    }
}