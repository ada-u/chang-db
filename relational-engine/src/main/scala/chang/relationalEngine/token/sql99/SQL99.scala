package chang.relationalEngine.token.sql99


object SQL99 {

  object Operators {
    val lessThan: String = "<"
    val equals: String = "="
    val greaterThan: String = ">"
    val notEquals: String = lessThan + greaterThan
    val greaterThanOrEquals: String = greaterThan + equals
    val lessThanOrEquals: String = lessThan + equals
    val concatenation: String = "||"
  }

  object Arrows {
    val rightArrow: String = "->"
  }

  object Trigraph {
    val leftBracket: String = "??("
    val rightBracket: String = "??)"
  }

  // https://ronsavage.github.io/SQL/sql-99.bnf.html#SQL%20special%20character
  val specialChars: Set[String] = Set(
    " ", "\"", "%", "&", "'",
    "(", ")", "*", "+", ",",
    "-", ".", "/", ":", ";",
    "<", "=", ">", "?",
    "[", "]", "^", "_",
    "|", "{", "}"
  )

  val doubleColon = "::"

  val doublePeriod = ".."


}

