package com.github.vagroz.moneyproblem.money
import com.github.vagroz.moneyproblem.calculator._

import scala.math.BigDecimal.RoundingMode

final class MoneyAmount[C <: Currency] private[money](override val value: BigDecimal,
                                                      val currency: C,
                                                      override protected val priority: Int,
                                                      override val expression: String) extends PrioritisedExpression {
  lazy val getDouble: Double = value.setScale(2, RoundingMode.HALF_UP).toDouble

  private val moneyAmount = PrioritisedExpression.moneyAmount(this)(currency) _
  private val numericExpression = PrioritisedExpression.numericExpression(this) _

  def +(that: MoneyAmount[C]): MoneyAmount[C] = moneyAmount(Tokens.Plus, that)

  def -(that: MoneyAmount[C]): MoneyAmount[C] = moneyAmount(Tokens.Minus, that)

  def /(that: NumericExpression): MoneyAmount[C] = moneyAmount(Tokens.Div, that)

  def /(that: MoneyAmount[C]): NumericExpression = numericExpression(Tokens.Div, that)

  def *(that: NumericExpression): MoneyAmount[C] = moneyAmount(Tokens.Mult, that)
}

object MoneyAmount{
  def apply[C <: Currency](value: BigDecimal, currency: C): MoneyAmount[C] = {
    val valueRepr = value.setScale(2, RoundingMode.HALF_UP).underlying().stripTrailingZeros().toPlainString

    new MoneyAmount(value.setScale(4, RoundingMode.HALF_UP), currency = currency,
      priority = 5, expression = s"$valueRepr ${currency.entryName.toLowerCase}")
  }
}
