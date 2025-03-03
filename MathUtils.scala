package org.encalmo.models

object MathUtils {

  extension (value: BigDecimal) {
    inline def roundTo(decimalPlace: Int): BigDecimal =
      try (value.underlying().intValueExact())
      catch {
        case e: ArithmeticException =>
          java.math
            .BigDecimal(
              value
                .underlying()
                .movePointRight(decimalPlace)
                .add(BigDecimal("0.5").underlying())
                .intValue()
            )
            .movePointLeft(decimalPlace)
      }

    inline def roundToIntHalfUp: Int =
      try (value.underlying().intValueExact())
      catch {
        case e: ArithmeticException =>
          value.underlying().add(BigDecimal("0.5").underlying()).intValue()
      }

    inline def roundToIntHalfDown: Int =
      try (value.underlying().intValueExact())
      catch {
        case e: ArithmeticException =>
          value.underlying().add(BigDecimal("0.499999").underlying()).intValue()
      }

    inline def roundToIntUp: Int =
      try (value.underlying().intValueExact())
      catch {
        case e: ArithmeticException =>
          value.underlying().add(BigDecimal("1").underlying()).intValue()
      }

    inline def roundToIntDown: Int =
      try (value.underlying().intValueExact())
      catch {
        case e: ArithmeticException =>
          value.underlying().intValue()
      }

    inline def movePointRight(p: Int): BigDecimal =
      value.underlying().movePointRight(p)

    inline def movePointLeft(p: Int): BigDecimal =
      value.underlying().movePointLeft(p)

    inline def toPlainString(): String =
      value.underlying().toPlainString()
  }

  extension (value: Int) {
    inline def movePointLeft(p: Int): BigDecimal =
      BigDecimal(value).underlying().movePointLeft(p)
  }
}
