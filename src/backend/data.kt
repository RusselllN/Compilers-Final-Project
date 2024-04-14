package backend

abstract class Data {
    abstract val type: Type
}

object None : Data() {
    override val type: Type = Type.NONE
    override fun toString() = "None"
}

data class IntData(val value: Int) : Data() {
    override val type: Type = Type.NUMBER
    override fun toString() = "$value"
}

data class StringData(val value: String) : Data() {
    override val type: Type = Type.STRING
    override fun toString() = value.toString()
}

data class BooleanData(val value: Boolean) : Data() {
    override val type: Type = Type.BOOL
    override fun toString() = "Boolean:$value"
}

data class ListData(val value: MutableList<Int>) : Data() {
    override val type: Type = Type.LIST
    override fun toString() = "[" + value.joinToString(", ") + "]"
}

class FunctionData(
    val name: String,
    val parameters: List<String>,
    val body: Expr,
    val returnType: Type
) : Data() {
    override val type: Type = returnType
    override fun toString() = "Function:$name"
}