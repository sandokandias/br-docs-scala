package com.github.sandokandias.brdocs

object DigitCalculator {

  def calc(str: String, factor: Array[Int]): Int = {
    var sum: Int = 0
    for (i <- str.length - 1 to 0 by -1) {
      var digit: Int = str.substring(i, i + 1).toInt
      sum += digit * factor(factor.length - str.length + i);
    }
    sum = 11 - sum % 11;
    if (sum > 9) 0 else sum
  }
}