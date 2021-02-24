
rootProject.name = "test"

includeBuild("../kotlin-wrappers") {
    dependencySubstitution {
//        substitute(module("rg.jetbrains:kotlin-css")).with(project("kotlin-css"))
//        substitute(module("rg.jetbrains:kotlin-css-js")).with(project("kotlin-css:kotlin-css-js"))
//        substitute(module("rg.jetbrains:kotlin-css-jvm")).with(project("kotlin-css:kotlin-css-jvm"))
        substitute(module("org.jetbrains:kotlin-styled")).with(project(":kotlin-styled"))
        substitute(module("org.jetbrains:kotlin-react-dom")).with(project(":kotlin-react-dom"))
        substitute(module("org.jetbrains:kotlin-react")).with(project(":kotlin-react"))
    }
}
