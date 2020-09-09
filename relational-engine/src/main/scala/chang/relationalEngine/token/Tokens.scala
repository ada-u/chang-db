package chang.relationalEngine.token

object Tokens {
  // https://ronsavage.github.io/SQL/sql-99.bnf.html#SQL%20special%20character
  val specialChars: Set[String] = Set(
    " ", "\"", "%", "&", "'",
    "(", ")", "*", "+", ",",
    "-", ".", "/", ":", ";",
    "<", "=", ">", "?",
    "[", "]", "^", "_",
    "|", "{", "}"
  )

}
