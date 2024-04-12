package backend

abstract class Data

object None:Data() {
    override fun toString() = "None"
}

data class IntData(val value: Int) : Data() {
    override fun toString() = "$value"
}

data class StringData(val value: String) : Data() {
    override fun toString() = value.toString()
}

data class BooleanData(val value: Boolean) : Data() {
    override fun toString() = "Boolean:$value"
}

class FunctionData(val name: String, val parameters: List<String>, val body: Expr) : Data() {
    override fun toString() = "Function:$name"
}