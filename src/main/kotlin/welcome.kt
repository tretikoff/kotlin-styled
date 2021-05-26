import kotlinx.css.*
import kotlinx.css.properties.*
import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import org.w3c.dom.HTMLInputElement
import react.*
import styled.*

external interface WelcomeProps : RProps {
    var name: String
}

data class WelcomeState(val name: String, var isGreen: Boolean) : RState

@JsExport
class Welcome(props: WelcomeProps) : RComponent<WelcomeProps, WelcomeState>(props) {
    init {
        state = WelcomeState(props.name, true)
    }

    override fun RBuilder.render() {
        val isGreen = state.isGreen
        outer(if (isGreen) Color.bisque else Color.aliceBlue)
        styledDiv {
            css {
                +WelcomeStyles.textContainer
                firstChild {
                    backgroundColor = Color.violet
                }

                backgroundColor = Color.green
                fontFamily = "Verdana"
            }
            +"Hello, ${state.name}"
            styledDiv {
                +"Ampersand"
                css {
                    +WelcomeStyles.separator
                }
            }
            styledDiv {
                +"Hello, innner"
                css {
                    backgroundColor = if (isGreen) {
                        Color.green
                    } else {
                        Color.red
                    }
                    color = Color.white
                }
            }
            styledDiv {
                +"Hello, innner2"
                css {
                    backgroundColor = Color.red
                    color = Color.white
                }
            }
        }
        statisticsButton()
        styledInput {
            css {
                +WelcomeStyles.textInput
                backgroundColor = Color.blue
                animation(5.s, Timing.linear, iterationCount = IterationCount.infinite) {
                    from {
                        transform {
                            rotate(0.deg)
                        }
                    }
                    to {
                        transform {
                            rotate(360.deg)
                        }
                    }
                }
            }
            attrs {
                type = InputType.text
                value = state.name
                onChangeFunction = { event ->
                    setState(
                        WelcomeState(name = (event.target as HTMLInputElement).value, isGreen = !state.isGreen)
                    )
                }
            }
        }
    }
}

external interface OuterProps : RProps {
    var color: Color
}

class PureOuter(props: OuterProps) : RPureComponent<OuterProps, RState>(props) {
    override fun RBuilder.render() {
//        console.log("outer rerender")
        styledDiv {
            css {
                backgroundColor = props.color
            }
            +"outer pure"
            styledDiv {
//                console.log("inner rerender")
                css {
                    backgroundColor = Color.pink
                    height = 50.px
                    width = 120.px
                }
            }
        }
    }
}

fun RBuilder.outer(color: Color) = child(PureOuter::class) { attrs.color = color }
