package chang.relationalEngine.token

case class Location(line: Int, column: Int) {
  override def toString = s"$line:$column"
}
