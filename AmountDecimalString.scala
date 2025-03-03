package org.encalmo.models

import MathUtils.*
import java.text.NumberFormat
import java.text.DecimalFormat

opaque type AmountDecimalString = String

object AmountDecimalString
    extends OpaqueStringWithPattern[
      AmountDecimalString,
      "-?[0-9]+\\.[0-9][0-9]"
    ] {

  val numberFormat: NumberFormat = DecimalFormat("0.00")

  val ZERO = AmountDecimalString("0.00")

  inline override def preformat(value: String): String =
    numberFormat.format(BigDecimal(value).roundTo(2).underlying())

  inline def roundedUp(value: BigDecimal): AmountDecimalString =
    AmountDecimalString(
      value.movePointRight(2).roundToIntUp.movePointLeft(2).toPlainString()
    )

  inline def roundedDown(value: BigDecimal): AmountDecimalString =
    AmountDecimalString(
      value.movePointRight(2).roundToIntDown.movePointLeft(2).toPlainString()
    )

  inline def roundedHalfUp(value: BigDecimal): AmountDecimalString =
    AmountDecimalString(
      value.movePointRight(2).roundToIntHalfUp.movePointLeft(2).toPlainString()
    )

  inline def roundedHalfDown(value: BigDecimal): AmountDecimalString =
    AmountDecimalString(
      value
        .movePointRight(2)
        .roundToIntHalfDown
        .movePointLeft(2)
        .toPlainString()
    )

  extension (amount: AmountDecimalString)
    inline def toBigDecimal: BigDecimal =
      BigDecimal(amount)

    inline def toAmount: Amount = Amount(
      BigDecimal(amount.replace(".", "")).intValue()
    )

    inline def toAmountString: AmountString =
      AmountString(amount.replace(".", ""))

    inline def toAmountDecimal: AmountDecimal =
      AmountDecimal(amount.toBigDecimal)

    inline infix def plus(other: AmountDecimalString): AmountDecimalString =
      AmountDecimalString(
        (amount.toBigDecimal + other.toBigDecimal).toPlainString()
      )

    inline infix def minus(other: AmountDecimalString): AmountDecimalString =
      AmountDecimalString(
        (amount.toBigDecimal - other.toBigDecimal).toPlainString()
      )

    inline infix def plus(other: BigDecimal): AmountDecimalString =
      roundedHalfUp(amount.toBigDecimal + other)

    inline infix def minus(other: BigDecimal): AmountDecimalString =
      roundedHalfUp(amount.toBigDecimal - other)

    inline infix def plus(other: Int): AmountDecimalString =
      AmountDecimalString((amount.toBigDecimal + other).toPlainString())

    inline infix def minus(other: Int): AmountDecimalString =
      AmountDecimalString((amount.toBigDecimal - other).toPlainString())

    /** Current amount or ZERO if negative */
    inline def orZero: AmountDecimalString = max(ZERO, amount)

  inline def min(
      amount1: AmountDecimalString,
      amount2: AmountDecimalString
  ): AmountDecimalString =
    if (amount1.toBigDecimal < amount2.toBigDecimal) then amount1 else amount2

  inline def min(
      amount1: AmountDecimalString,
      amounts: AmountDecimalString*
  ): AmountDecimalString =
    min(amount1, amounts.minBy(_.toBigDecimal))

  inline def max(
      amount1: AmountDecimalString,
      amount2: AmountDecimalString
  ): AmountDecimalString =
    if (amount1.toBigDecimal > amount2.toBigDecimal) then amount1 else amount2

  inline def max(
      amount1: AmountDecimalString,
      amounts: AmountDecimalString*
  ): AmountDecimalString =
    max(amount1, amounts.maxBy(_.toBigDecimal))

  given Ordering[AmountDecimalString] = Ordering.by(_.toBigDecimal)

}
