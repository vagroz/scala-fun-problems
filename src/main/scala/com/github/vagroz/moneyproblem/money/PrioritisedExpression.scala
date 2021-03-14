package com.github.vagroz.moneyproblem.money

import com.github.vagroz.moneyproblem.calculator.{Calculator, Operator}
import com.github.vagroz.moneyproblem.calculator.Tokens._

trait PrioritisedExpression {
  protected def priority: Int

  def value: BigDecimal

  def expression: String
}

object PrioritisedExpression {


  private def f(op: Operator): (BigDecimal, BigDecimal) => BigDecimal = {
    op match {
      case Plus => _ + _
      case Minus => _ - _
      case Mult => _ * _
      case Div => _ / _
    }
  }


  def moneyAmount[C <: Currency](a: PrioritisedExpression)(currency: C)
                                (op: Operator, b: PrioritisedExpression): MoneyAmount[C] = {
    new MoneyAmount[C](
      value = f(op)(a.value, b.value),
      currency = currency,
      priority = op.priority,
      expression = Calculator.concatenateExpressions(op, a.expression, a.priority, b.expression, b.priority)
    )
  }

  def numericExpression(a: PrioritisedExpression)
                       (op: Operator, b: PrioritisedExpression): NumericExpression = {
    new NumericExpression(
      value = f(op)(a.value, b.value),
      priority = op.priority,
      expression = Calculator.concatenateExpressions(op, a.expression, a.priority, b.expression, b.priority)
    )
  }


}
