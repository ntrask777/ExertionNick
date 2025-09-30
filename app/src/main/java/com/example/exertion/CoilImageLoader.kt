package com.example.exertion

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

// Note: We should use memoization here for the images, so we don't encounter unnecessary loads
// Obviously I need to change the placeholder image to be same size as logo
// Also need an .error() placeholder
@Composable
fun CoilImage() {
    Box(
        modifier = Modifier
            .height(150.dp)
            .width(150.dp),
        contentAlignment = Alignment.Center
    ) {
        val context = LocalContext.current
        val painter = rememberAsyncImagePainter(
            ImageRequest.Builder(context)
                .data(R.drawable.exertion_logo)
                .crossfade(true)
                .crossfade(1000)
                .placeholder(R.drawable.placeholder)
                .build()
        )
        val painter_state = painter.state
        Image(painter = painter, contentDescription = "Exertion Logo Image")
        if (painter_state is AsyncImagePainter.State.Loading) {
            CircularProgressIndicator()
        }
    }
}