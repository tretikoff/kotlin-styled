import kotlinx.css.*
import kotlinx.css.properties.*
import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import org.w3c.dom.HTMLInputElement
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import styled.animation
import styled.css
import styled.styledDiv
import styled.styledInput

external interface WelcomeProps : RProps {
    var name: String
}

data class WelcomeState(val name: String) : RState

fun CSSBuilder.shimmer() {
    background = "linear-gradient(to right, #eff1f3 4%, #e2e2e2 25%, #eff1f3 36%);"
    backgroundSize = "1000px, 100%"
    animation(duration = 2.s, iterationCount = IterationCount.infinite) {
        0 { backgroundPosition = "-1000px 0" }
        100 { backgroundPosition = "1000px 0" }
    }
}

@JsExport
class Welcome(props: WelcomeProps) : RComponent<WelcomeProps, WelcomeState>(props) {

    init {
        state = WelcomeState(props.name)
    }

    override fun RBuilder.render() {
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
            }
            styledDiv {
                +"Hello, innner"
                css {
                    backgroundColor = Color.red
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
                        WelcomeState(name = (event.target as HTMLInputElement).value)
                    )
                }
            }
        }
    }
}
