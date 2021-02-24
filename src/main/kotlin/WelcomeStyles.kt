import kotlinx.css.*
import styled.StyleSheet

object WelcomeStyles : StyleSheet("WelcomeStyles", isStatic = true) {
    val textContainer by css {
        padding(5.px)

        color = Color.aliceBlue
    }

    val textInput by css {
        margin(vertical = 5.px)

        fontSize = 14.px
    }
} 
