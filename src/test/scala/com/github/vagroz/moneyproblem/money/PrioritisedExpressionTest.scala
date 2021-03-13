package com.github.vagroz.moneyproblem.money
import org.scalatest._
import flatspec._
import matchers._
import com.github.vagroz.moneyproblem.money.implicits._

class PrioritisedExpressionTest extends AnyFlatSpec with should.Matchers {
  "MoneyAmount" should "show correct infix expression" in {
    val expr = (150.rub + 250.rub) / 100.rub * 80.usd
    expr.getDouble shouldEqual 320.0
    expr.expression shouldBe "(150 rub + 250 rub)/(100 rub)*(80 usd)"
  }

  "NumericExpression" should "show corret infix expression" in {
    val expr = 4 + 10 * (2.01.rub / 2.rub)
    expr.value.toDouble shouldEqual 14.05
    expr.expression shouldBe "4 + 10*(2.01 rub)/(2 rub)"
  }
}
