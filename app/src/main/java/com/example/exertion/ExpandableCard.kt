package com.example.exertion

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exertion.ui.theme.ExertionTheme
import com.example.exertion.ui.theme.Shapes
import kotlin.math.exp

@Composable
fun ExpandableCard(modifier: Modifier = Modifier) {
    var expanded_state by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expanded_state) 180f else 0f
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = Shapes.medium,
        onClick = {
            expanded_state = !expanded_state
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(2.dp, Color.Yellow)
                .padding(12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .weight(6f),
                    text = "My Title",
                    style = MaterialTheme.typography.titleSmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                IconButton(
                    modifier = Modifier
                        .alpha(0.3f)
                        .weight(1f)
                        .rotate(rotationState),
                onClick = {
                    expanded_state = !expanded_state
                }) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop-Down Arrow"
                    )
                }
            }
            if (expanded_state)
            {
                Text(
                    text = "Aquinas defends the Filioque with several distinct" +
                            "lines of reasoning. The “argument from relative " +
                            "opposition” is the one most often cited (he uses the " +
                            "logic of relations in the Trinity: if the Son did not " +
                            "spirate the Spirit, then the Son would stand opposed to " +
                            "the Spirit as one who does not give origin.",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
@Preview
fun ExpandableCardPreview() {
    ExertionTheme {
        ExpandableCard()
    }
}