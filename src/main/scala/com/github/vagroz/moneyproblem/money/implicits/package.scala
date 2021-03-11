package com.github.vagroz.moneyproblem.money

package object implicits {

  implicit class Numeric2MoneyAmountOps[T](x: T)
                                          (implicit ev: T => BigDecimal) {
    def rub: MoneyAmount = MoneyAmount(x)
  }

}
