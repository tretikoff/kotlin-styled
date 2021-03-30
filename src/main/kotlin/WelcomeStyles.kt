import kotlinx.css.*
import styled.StyleSheet

object WelcomeStyles : StyleSheet("WelcomeStyles", isStatic = true) {
    val textContainer by css {
        padding(50.px)

        color = Color.aliceBlue
    }

    val separator by css {
        after {
            color = Color.black
            content = "\\00a0/\\00a0".quoted
        }
    }

    val textInput by css {
        margin(vertical = 5.px)

        fontSize = 14.px
    }
} 

object WelcomeStyles2: StyleSheet("WelcomeStyles2") {
    val textContainer by css {
        backgroundColor = Color.yellow
    }
}