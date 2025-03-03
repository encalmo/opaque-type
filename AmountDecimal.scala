package org.encalmo.models

import org.encalmo.models.MathUtils.roundToIntHalfUp

opaque type AmountDecimal <: BigDecimal = BigDecimal

object AmountDecimal extends OpaqueBigDecimal[AmountDecimal]:

  inline def apply(value: Int): AmountDecimal = BigDecimal.apply(value)
  inline def apply(value: BigDecimal): AmountDecimal = value
  inline def show(value: AmountDecimal): BigDecimal = value

  extension (amount: AmountDecimal)
    inline def toString(): String =
      amount.toAmountDecimalString

    inline def toAmount: Amount =
      Amount((amount * 100).roundToIntHalfUp)

    inline def toAmountString: AmountString =
      AmountString((amount * 100).roundToIntHalfUp.toString())

    inline def toAmountDecimalString: AmountDecimalString =
      AmountDecimalString.roundedHalfUp(amount)
