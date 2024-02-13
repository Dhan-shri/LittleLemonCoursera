package com.example.littlelemon

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemon.ui.theme.LittleLemonColor
import com.example.littlelemon.ui.theme.LittleLemonTheme

@Composable
fun ThemeLayout() {
    Box (
        modifier = Modifier.fillMaxSize(),
    ) {
        // Scrollable GridLayout
        AppScreen2()
    }
}



@Composable
fun AppScreen2() {
    Box (
        modifier = Modifier.fillMaxSize(),
    ) {
        LittleLemonTheme (){
            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Spacer(modifier = Modifier.width(35.dp))

                AnimatedVisibility(visible = true) {
                    Text(text = "Little Lemon")
                }
                Text(text = "Chicago")
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Button 1")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Button 2")
                }
                
                OutlinedButton(onClick = { /*TODO*/ }) {
                    Text(text = "Outllined Button")
                }

                Slider(value = 5f, onValueChange = {})


                //Changing text appereance

                Text(text = "Little Lemon", style = TextStyle(
                    color = LittleLemonColor.yellow,
                    fontSize = 24.sp,
                ),
                modifier = Modifier.width(300.dp)
                )

                Spacer(modifier = Modifier.width(15.dp))

                Text(text = "Little Lemon2", style = TextStyle(
                    color = LittleLemonColor.yellow,
                    fontSize = 24.sp,
                    fontFamily = FontFamily.Monospace
                ),
                    modifier = Modifier.width(300.dp)
                )

                Spacer(modifier = Modifier.width(15.dp))

                Text(text = "Little Lemon3", style = TextStyle(
                    color = LittleLemonColor.yellow,
                    fontSize = 24.sp,
                    fontFamily = FontFamily.Monospace,
                    letterSpacing = 4.sp,
                ),
                    modifier = Modifier.width(300.dp)
                )

                Spacer(modifier = Modifier.width(15.dp))

                Text(text = "Little Lemon4", style = TextStyle(
                    color = LittleLemonColor.yellow,
                    fontSize = 24.sp,
                    fontFamily = FontFamily.Monospace,
                    letterSpacing = 4.sp,
                    shadow = Shadow(
                        color = Color.Black,
                        offset = Offset(8f,8f),
                        blurRadius = 4f
                    )
                ),
                    modifier = Modifier.width(300.dp)
                )

                Spacer(modifier = Modifier.width(15.dp))
                Text(text = "Little Lemon4", style = TextStyle(
                    color = LittleLemonColor.yellow,
                    fontSize = 24.sp,
                    fontFamily = FontFamily.Monospace,
                    letterSpacing = 4.sp,
                    shadow = Shadow(
                        color = Color.Black,
                        offset = Offset(8f,8f),
                        blurRadius = 4f
                    ),
                    textAlign = TextAlign.Start,
                    textDecoration = TextDecoration.Underline
                ),
                    modifier = Modifier.width(300.dp)
                )


                // Customizing Individual Letters
                Text(
                    buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = LittleLemonColor.yellow,
                                fontSize = 20.sp,
                            )
                        ){
                            append("L")
                        }
                        append("ittle ")
                    }
                )

                AnimateLogo()

            }
        }
    }
}


@Composable
fun AnimateLogo(){
    var alfaImg by remember {
        mutableStateOf(0f)
    }

    val animateAlfaImg by animateFloatAsState(
        targetValue = alfaImg,
        animationSpec = tween(
            durationMillis = 1000
        ), label = ""
    )
   Box (
       modifier = Modifier
           .fillMaxSize()
           .clickable {
                      alfaImg += 1f
           },
       contentAlignment = Alignment.Center
   ){
       Image(painter = painterResource(id = R.drawable.littlelemonimgtxt_nobg),
           contentDescription = "Lemon Dessert",
           modifier = Modifier.align(Alignment.Center)
       )
       Image(painter = painterResource(id = R.drawable.lemondessert),
           contentDescription = "Lemon Dessert",
           modifier = Modifier
               .align(Alignment.Center)
               .alpha(animateAlfaImg)
       )
   }
}
@Preview(showBackground = true)
@Composable
fun AnimateLogoPreview() {
    AnimateLogo()
}


//Day mode preview
@Preview(showBackground = true)
@Composable
fun AppScreen2Preview() {
    AppScreen2()
}
//NIGHT MODE PREVIEW

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun AppScreen2PreviewNightMode() {
    AppScreen2()
}


/** Themes allow you to separate application design details from the UI structure and behaviour
 *   We can have two screen containing the same composable, header text, description text image, and two button.
 *
 *   Appearence can be controlled by theme and style
 *
 *   THEME
 *
 *   Represent font size, shape, typography, color, spacing
 *   Used by composable, style, layout.
 *
 *
 */


// ARGB  - Alpha, Red, Green, Blue  0x00495e57
// 0x - Hexadecimal
// 00 - Alpha  how transparent the color is opacity
// 49 - Red
// 5e - Green
// 57 - Blue


