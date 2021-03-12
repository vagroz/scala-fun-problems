package com.github.vagroz.moneyproblem.money
import com.github.vagroz.moneyproblem.calculator._

import scala.collection.immutable.Queue
import scala.math.BigDecimal.RoundingMode

class MoneyAmount private(_queue: Queue[Token]) {
  private val queue: Queue[Token] = _queue

  def +(that: MoneyAmount): MoneyAmount = {
    new MoneyAmount(
      queue
        .enqueueAll(that.queue)
        .enqueue(Tokens.Plus)
    )
  }

  def -(that: MoneyAmount): MoneyAmount = {
    new MoneyAmount(
      queue
        .enqueueAll(that.queue)
        .enqueue(Tokens.Minus)
    )
  }

  def /(that: BigDecimal): MoneyAmount = {
    new MoneyAmount(
      queue
        .enqueue(Tokens.Value(that))
        .enqueue(Tokens.Div)
    )
  }

  def *(that: BigDecimal): MoneyAmount = {
    new MoneyAmount(
      queue
        .enqueue(Tokens.Value(that))
        .enqueue(Tokens.Mult)
    )
  }

  lazy val getValue: BigDecimal = Calculator.solveReversePolishNotation(queue)

  lazy val getInfixExpr: String = Calculator.makeInfixExpression(queue)
}

object MoneyAmount{
  def apply(value: BigDecimal): MoneyAmount =
    new MoneyAmount(Queue(Tokens.Value(value.setScale(4, RoundingMode.HALF_UP))))
}
