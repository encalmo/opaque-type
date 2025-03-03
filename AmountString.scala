package org.encalmo.models

import MathUtils.*

opaque type AmountString = String

object AmountString extends OpaqueStringWithPattern[AmountString, "-?[0-9]+"] {

  val ZERO = AmountString("0")

  inline def roundedUp(value: BigDecimal): AmountString =
    AmountString(value.roundToIntUp.toString())

  inline def roundedDown(value: BigDecimal): AmountString =
    AmountString(value.roundToIntDown.toString())

  inline def roundedHalfUp(value: BigDecimal): AmountString =
    AmountString(value.roundToIntHalfUp.toString())

  inline def roundedHalfDown(value: BigDecimal): AmountString =
    AmountString(value.roundToIntHalfDown.toString())

  extension (amount: AmountString)
    inline def toAmount: Amount = Amount(BigDecimal(amount).intValue())

    inline def toBigDecimal: BigDecimal = BigDecimal(amount)

    inline def toAmountDecimalString: AmountDecimalString =
      AmountDecimalString(
        BigDecimal(amount).underlying().movePointLeft(2).toString()
      )

    inline infix def plus(other: AmountString): AmountString =
      AmountString((amount.toInt + other.toInt).toString())

    inline infix def minus(other: AmountString): AmountString =
      AmountString((amount.toInt - other.toInt).toString())

    inline infix def plus(other: Int): AmountString =
      AmountString((amount.toBigDecimal + other).toString())

    inline infix def minus(other: Int): AmountString =
      AmountString((amount.toInt - other).toString())

    /** Current amount or ZERO if negative */
    inline def orZero: AmountString = max(ZERO, amount)

  inline def min(amount1: AmountString, amount2: AmountString): AmountString =
    if (amount1.toInt < amount2.toInt) then amount1 else amount2

  inline def min(amount1: AmountString, amounts: AmountString*): AmountString =
    min(amount1, amounts.minBy(_.toInt))

  inline def max(amount1: AmountString, amount2: AmountString): AmountString =
    if (amount1.toInt > amount2.toInt) then amount1 else amount2

  inline def max(amount1: AmountString, amounts: AmountString*): AmountString =
    max(amount1, amounts.maxBy(_.toInt))

  given Ordering[AmountString] = Ordering.by(_.toInt)
}
