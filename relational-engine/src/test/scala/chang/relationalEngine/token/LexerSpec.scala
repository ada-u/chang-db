package chang.relationalEngine.token

import org.scalatest.freespec.AnyFreeSpecLike
import org.scalatest.matchers.should.Matchers

class LexerSpec extends AnyFreeSpecLike with Matchers {

  val lexer = new Lexer()

  "Lexer" - {
    "parse" in {
      val sql = "SELECT id, name, email FROM 'users.csv'"
      val tokens = lexer.parse(sql)
      tokens shouldBe List("SELECT", "id", ",", "name", "FROM", "'users.csv'")
    }
  }

}
