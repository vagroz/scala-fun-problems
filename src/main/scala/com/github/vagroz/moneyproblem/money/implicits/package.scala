package com.github.vagroz.moneyproblem.money
import Currency._


package object implicits {

  implicit def Numeric2Expression[T](x: T)
                                    (implicit ev: T => BigDecimal): NumericExpression =
    NumericExpression(x)

  implicit class Numeric2MoneyAmountOps[T](x: T)
                                          (implicit ev: T => BigDecimal) {
    def rub: MoneyAmount[Currency.RUB.type] = MoneyAmount(x, RUB)

    def usd: MoneyAmount[Currency.USD.type] = MoneyAmount(x, USD)

  }

}
