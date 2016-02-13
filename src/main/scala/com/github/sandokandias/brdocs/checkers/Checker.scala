package com.github.sandokandias.brdocs.checkers

import scala.collection.Traversable

trait Checker {

  protected val NON_EMPTY_MESSAGE = "Um valor deve ser informado."
  protected val ONLY_NUMBERS_MESSAGE = "Somente caracteres numéricos devem ser informados."

  def check[A](value: A)

  protected def checkOrThrowError(condition: Boolean, message: String) = {
    if (!condition) throw new IllegalArgumentException(message)
  }
}

object NonNullChecker extends Checker {

  override def check[A](value: A) = {
    checkOrThrowError(!Option(value).isEmpty, NON_EMPTY_MESSAGE)
  }

}

object NonEmptyChecker extends Checker {

  override def check[A](value: A) = {

    NonNullChecker.check(value)

    value match {
      case v: String           => checkOrThrowError(!v.isEmpty, NON_EMPTY_MESSAGE)
      case c: Traversable[Any] => checkOrThrowError(!c.isEmpty, NON_EMPTY_MESSAGE)
    }
  }

}

object OnlyNumbersChecker extends Checker {

  override def check[A](value: A) = {
    try {
      value.toString.toLong
    } catch {
      case ex: NumberFormatException =>
        throw new IllegalArgumentException(ONLY_NUMBERS_MESSAGE)
    }
  }

}