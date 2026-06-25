package com.ranggacikal.moviedbapps.feature.movie.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmarks
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarView(
    title: String,
    icon: ImageVector = Icons.Default.Bookmarks,
    isShowBackButton: Boolean = false,
    isShowRightIcon: Boolean = true,
    onClickBackButton: () -> Unit = {},
    onIconClick: () -> Unit = {}
) {
    CenterAlignedTopAppBar(
        title = {
            Text(title)
        },
        actions = {
            if (isShowRightIcon) {
                IconButton(
                    onClick = {
                        onIconClick()
                    }
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = "bookmarkIcons"
                    )
                }
            }
        },
        navigationIcon = {
            if (isShowBackButton) {
                IconButton(
                    onClick = onClickBackButton
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        }
    )
}