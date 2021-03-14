package com.github.vagroz.moneyproblem.money

import enumeratum._

sealed abstract class Currency(val code: String) extends EnumEntry

object Currency extends Enum[Currency] {

  val values: IndexedSeq[Currency] = findValues

  case object RUB extends Currency("643")
  case object USD extends Currency("840")

}
