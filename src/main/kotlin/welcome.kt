import kotlinx.css.*
import kotlinx.css.properties.*
import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import org.w3c.dom.HTMLInputElement
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import styled.*

external interface WelcomeProps : RProps {
    var name: String
}

data class WelcomeState(val name: String) : RState


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
                css {
                    +WelcomeStyles.separator
                }
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
//        styledButton {
//            attrs {
//                onClick = {
//                    event ->
//                    setState()
//                }
//            }
//        }
    }
}
