package chang.relationalEngine.token

import chang.relationalEngine.token.sql99.SQL99

import scala.util.parsing.combinator._

trait SQLTokens extends token.Tokens {

  case class Delimiter(chars: String) extends Token

}

class Lexer extends RegexParsers with SQLTokens {

  // https://ronsavage.github.io/SQL/sql-99.bnf.html#nondelimiter%20token
  lazy val nonDelimiterToken = ???

  // https://ronsavage.github.io/SQL/sql-99.bnf.html#delimiter%20token
  // delimiter token ::=
  //     SQL special character
  //  |  not equals operator
  //  |  greater than or equals operator
  //  |  less than or equals operator
  //  |  right arrow
  //  |  left bracket trigraph
  //  |  right bracket trigraph
  //  |  double colon
  //  |  double period
  lazy val delimiterToken: Parser[Token] = {
    val delims = SQL99.specialChars ++ Set(
      SQL99.Operators.notEquals,
      SQL99.Operators.greaterThanOrEquals,
      SQL99.Operators.lessThanOrEquals,
      SQL99.Operators.concatenation,
      SQL99.Arrows.rightArrow,
      SQL99.Trigraph.leftBracket,
      SQL99.Trigraph.rightBracket,
      SQL99.doubleColon,
      SQL99.doublePeriod
    )
    delims
      .map { delim =>
        accept(delim.toList) ^^^ Delimiter(delim)
      }
      .foldRight(failure("delimiter not matched"): Parser[Token]) { (x, y: Parser[Token]) =>
        y | x
      }
  }

  def parse(sql: String): Either[LexerError, List[String]] = {
    parse(rep(".*".r <~ delimiterToken), sql) match {
      case NoSuccess(message, next) =>
        Left(LexerError(Location(next.pos.line, next.pos.column), message))
      case Success(result, _) => Right(result)
    }
  }

}
