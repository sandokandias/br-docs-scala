package com.github.sandokandias.brdocs.checkers

trait Checker {

  protected val INVALID_MESSAGE = s"Documento inválido."

  def check(value: String)

  protected def checkOrThrowError(condition: Boolean, message: String) = {
    if (!condition) throw new IllegalArgumentException(message)
  }
}

object NonNullChecker extends Checker {

  override def check(value: String) = {
    checkOrThrowError(!Option(value).isEmpty, INVALID_MESSAGE)
  }

}

object NonEmptyChecker extends Checker {

  override def check(value: String) = {

    NonNullChecker.check(value)
    checkOrThrowError(!value.isEmpty, INVALID_MESSAGE)
  }

}

object CPFPatternChecker extends Checker {

  private val REGEX = "^(\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2})$".r

  override def check(value: String) = {
    checkOrThrowError(!REGEX.findFirstMatchIn(value).isEmpty, INVALID_MESSAGE)
  }
}

object CNPJPatternChecker extends Checker {

  private val REGEX = "^(\\d{2}\\.?\\d{3}\\.?\\d{3}\\/?\\d{4}-?\\d{2})$".r

  override def check(value: String) = {
    checkOrThrowError(!REGEX.findFirstMatchIn(value).isEmpty, INVALID_MESSAGE)
  }
}