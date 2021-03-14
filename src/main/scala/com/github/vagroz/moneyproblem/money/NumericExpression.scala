package com.github.vagroz.moneyproblem.money

import com.github.vagroz.moneyproblem.calculator.{Operator, Tokens}

final class NumericExpression private[money](
                                              override val value: BigDecimal,
                                              override protected val priority: Int,
                                              override val expression: String
                                            ) extends PrioritisedExpression {
  private def moneyAmount[C <: Currency](op: Operator, that: MoneyAmount[C]) =
    PrioritisedExpression.moneyAmount(this)(that.currency)(op, that)
  private val numericExpression = PrioritisedExpression.numericExpression(this) _

  def +(that: NumericExpression): NumericExpression = numericExpression(Tokens.Plus, that)

  def -(that: NumericExpression): NumericExpression = numericExpression(Tokens.Minus, that)

  def /(that: NumericExpression): NumericExpression = numericExpression(Tokens.Div, that)

  def *[C <: Currency](that: MoneyAmount[C]): MoneyAmount[C] = moneyAmount(Tokens.Mult, that)

  def *(that: NumericExpression): NumericExpression = numericExpression(Tokens.Mult, that)
}

object NumericExpression {
  def apply(value: BigDecimal): NumericExpression = new NumericExpression(
    value = value, priority = Int.MaxValue, expression = value.underlying().stripTrailingZeros().toPlainString)
}