package com.github.sandokandias.brdocs.checkers

import scala.collection.Traversable

trait Checker {

  protected val NON_EMPTY_MESSAGE = "Um valor deve ser informado."
  protected val ONLY_NUMBERS_MESSAGE = "Somente caracteres numéricos devem ser informados."

  def check(value: String)

  protected def checkOrThrowError(condition: Boolean, message: String) = {
    if (!condition) throw new IllegalArgumentException(message)
  }
}

object NonNullChecker extends Checker {

  override def check(value: String) = {
    checkOrThrowError(!Option(value).isEmpty, NON_EMPTY_MESSAGE)
  }

}

object NonEmptyChecker extends Checker {

  override def check(value: String) = {

    NonNullChecker.check(value)
    checkOrThrowError(!value.isEmpty, NON_EMPTY_MESSAGE)
  }

}

object CPFPatternChecker extends Checker {

  private val REGEX = "(^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2})|(^\\d{3}\\d{3}\\d{3}\\d{2})$".r

  override def check(value: String) = {
    checkOrThrowError(!REGEX.findFirstMatchIn(value).isEmpty, NON_EMPTY_MESSAGE)
  }
}