package com.example.littlelemon

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LazyLayoutScreen (){
    Box (
        modifier = Modifier.fillMaxSize(),
    ) {
        // Lazy Layout Explanation
        AppScreen()
    }
}





@Composable
@Preview
fun LazyLayoutScreenPreview() {
    LazyLayoutScreen()
}


@Composable
private fun AppScreen(){
    LazyGrid()
}
@Composable
fun LazyGrid(){
    LazyVerticalGrid(columns = GridCells.Adaptive(140.dp)){
//    LazyVerticalGrid(columns = GridCells.Fixed(2)){
        items(1000){
            // item
            GalleryCell()
        }
    }
}



/**   LAZY LAYOUT  -   these lists and grids you have learned about are normally used when you have a small number of items. But if you need to have a large number of items or items of unknown length, they can cause performance issues because all the items are composed at the same time. To fix this problem, Jetpack Compose provides components such as lazy row, lazy column, and lazy grid, which only composes that which is visible in viewport rather than composing it all at once

*    LAZY ROW -- create a Horizontal scrollable list
 *
 *
 *    LAZY COLUMN -- create a Vertical scrollable list
 *
 *
 *    COMPOSE API ---  Compose API can provide a single item using an item block or multiple items using item blocks.
 *
 *
 */