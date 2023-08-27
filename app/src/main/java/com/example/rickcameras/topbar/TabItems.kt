package com.example.rickcameras.topbar

import androidx.compose.runtime.Composable

typealias ComposableFun = @Composable () -> Unit

sealed class TabItem(
    var title: String,
    var screen: ComposableFun
) {
    object Cameras : TabItem( "Камеры", { })
    object Doors : TabItem( "Двери", {  })
}
