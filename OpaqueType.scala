package org.encalmo.models

import ujson.Num
import ujson.Str
import ujson.Value
import upickle.default.*

import java.util.UUID
import scala.compiletime.*
import scala.util.Try

import ops.string.*
import MathUtils.*

trait OpaqueType[O, T]:

  def apply(value: T): O

  def show(value: O): T

  inline def unapply(value: O): Option[T] = Some(show(value))

  extension (value: O)
    inline def existsIn(values: O*): Boolean =
      values.contains(value)

end OpaqueType

trait AutoShow[O, T]:
  self: OpaqueType[O, T] =>
  given Conversion[O, T] with
    inline def apply(value: O): T = self.show(value)

trait AutoApply[T, O]:
  self: OpaqueType[O, T] =>
  given Conversion[T, O] with
    inline def apply(value: T): O = self.apply(value)

trait OpaqueString[O <: String] extends OpaqueType[O, String] with AutoShow[O, String]:
  given ReadWriter[O] = readwriter[String].bimap(show(_), apply(_))
  given Function[O, Value] = (v: O) => Str(show(v))

trait SimpleOpaqueString[O <: String] extends OpaqueString[O]:
  inline def apply(value: String): O = value.asInstanceOf[O]
  inline def show(value: O): String = value.asInstanceOf[String]

  extension (value: O)
    inline def take(n: Int): O = apply(show(value).take(n))
    inline def takeRight(n: Int): O = apply(show(value).takeRight(n))
    inline def drop(n: Int): O = apply(show(value).drop(n))
    inline def dropRight(n: Int): O = apply(show(value).dropRight(n))
    inline def head: O = apply(show(value).head.toString())
    inline def tail: O = apply(show(value).tail)
    inline def last: O = apply(show(value).last.toString())
    inline def init: O = apply(show(value).init)

trait OpaqueStringWithValidator[O <: String] extends OpaqueString[O]:
  def validate(value: String): O
  def apply(value: String): O = validate(value)
  inline def show(value: O): String = value.asInstanceOf[String]

trait OpaqueStringWithPattern[O <: String, P <: String & Singleton] extends OpaqueString[O]:

  inline def apply(value: String): O = {
    inline constValueOpt[value.type] match {
      case Some(_) =>
        inline if (!constValue[Matches[value.type, P]]) {
          val preformatted = preformat(value)
          inline constValueOpt[P] match {
            case Some(regex) =>
              if (preformatted.matches(regex))
              then preformatted.asInstanceOf[O]
              else
                error(
                  "Value " + codeOf(
                    value
                  ) + " should match pattern " + constValue[P]
                )
            case None =>
              value.asInstanceOf[O]
          }
        } else {
          value.asInstanceOf[O]
        }

      case None =>
        inline constValueOpt[P] match {
          case Some(regex) =>
            if (value.matches(regex))
            then value.asInstanceOf[O]
            else
              val preformatted = preformat(value)
              if (preformatted.matches(regex))
              then preformatted.asInstanceOf[O]
              else
                throw new IllegalArgumentException(
                  "Value " + value + " should match pattern " + regex
                )
          case None =>
            value.asInstanceOf[O]
        }
    }
  }

  inline def show(value: O): String = value.asInstanceOf[String]

  def preformat(value: String): String = value

  inline def validate(value: String): Option[O] =
    Try(apply(value)).toOption

end OpaqueStringWithPattern

trait OpaqueUUIDString[O <: String] extends OpaqueString[O]:

  inline val uuidPattern =
    "[a-z0-9]{8}-[a-z0-9]{4}-[a-z0-9]{4}-[a-z0-9]{4}-[a-z0-9]{12}"

  inline def apply(value: String): O = {
    inline constValueOpt[value.type] match {
      case Some(_) =>
        inline if constValue[Matches[value.type, uuidPattern.type]]
        then value.asInstanceOf[O]
        else {
          error(
            "Value "
              + codeOf(value)
              + " should match UUID pattern."
          )
        }

      case None =>
        UUID.fromString(value).toString().asInstanceOf[O]
    }
  }

  inline def show(value: O): String = value.asInstanceOf[String]

end OpaqueUUIDString

trait OpaqueBigDecimal[O] extends OpaqueType[O, BigDecimal]:

  inline def of(value: scala.BigDecimal): O =
    apply(value.underlying())

  inline def of(value: Int): O =
    apply(BigDecimal(value))

  inline def apply(value: String): O = {
    try { apply(BigDecimal(value)) }
    catch {
      case e: NumberFormatException =>
        throw new NumberFormatException(
          s"Expected decimal number but got $value"
        )
    }
  }

  given ReadWriter[O] =
    readwriter[Value].bimap(
      value => Num(show(value).doubleValue()),
      {
        case Num(value) => apply(BigDecimal(value))
        case Str(value) => apply(BigDecimal(value))
        case other =>
          throw new Exception(s"Expected number or string but got $other")
      }
    )

  given Function[O, Value] = (v: O) => Num(show(v).doubleValue())

  private val half = BigDecimal("0.5").underlying()

  extension (value: O)
    inline def +(n: Int): O = apply(
      show(value).underlying().add(BigDecimal(n).underlying())
    )
    inline def -(n: Int): O = apply(
      show(value).underlying().subtract(BigDecimal(n).underlying())
    )
    inline def *(n: Int): O = apply(
      show(value).underlying().multiply(BigDecimal(n).underlying())
    )
    inline def /(n: Int): O = apply(
      show(value).underlying().divide(BigDecimal(n).underlying())
    )
    inline def *(n: Double): O = apply(
      show(value).underlying().multiply(BigDecimal(n).underlying())
    )
    inline def /(n: Double): O = apply(
      show(value).underlying().divide(BigDecimal(n).underlying())
    )
    inline def +(n: O): O = apply(
      show(value).underlying().add(show(n).underlying())
    )
    inline def -(n: O): O = apply(
      show(value).underlying().subtract(show(n).underlying())
    )
    inline def *(n: scala.BigDecimal): O =
      apply(show(value).underlying().multiply(n.underlying()))
    inline def /(n: scala.BigDecimal): O =
      apply(show(value).underlying().divide(n.underlying()))

    inline def toBigDecimal: scala.BigDecimal = show(value)
    inline def toDouble: Double = show(value).doubleValue()
    inline def toLong: Long = show(value).underlying().longValueExact()
    inline def toInt: Int = show(value).underlying().intValueExact()
    inline def integral: O = apply(BigDecimal(show(value).intValue()))
    inline def roundTo(decimalPlace: Int): O = apply(
      java.math
        .BigDecimal(
          show(value)
            .underlying()
            .movePointRight(decimalPlace)
            .add(half)
            .intValue()
        )
        .movePointLeft(decimalPlace)
    )
    inline def roundToInt: Int =
      show(value).underlying().add(half).intValue()

    inline def roundToIntUp: Int =
      show(value).underlying().add(BigDecimal("1").underlying()).intValue()

    inline def roundToIntDown: Int =
      show(value).underlying().intValue()

  inline given Ordering[O] = Ordering.by(show)

end OpaqueBigDecimal

trait OpaqueInteger[O] extends OpaqueType[O, Int]:

  inline def of(value: Double): O =
    apply(value.toInt)

  inline def of(value: scala.BigDecimal): O =
    apply(value.toInt)

  given ReadWriter[O] =
    readwriter[Value].bimap(
      value => Num(show(value).toInt),
      {
        case Num(value) => apply(value.toInt)
        case Str(value) => apply(value.toInt)
        case other =>
          throw new Exception(s"Expected number or string but got $other")
      }
    )

  given Function[O, Value] = (v: O) => Num(show(v).toDouble)

  extension (value: O)
    inline def +(n: Int): O = apply(show(value) + n)
    inline def -(n: Int): O = apply(show(value) - n)
    inline def *(n: Int): O = apply(show(value) * n)
    inline def /(n: Int): O = apply(show(value) / n)
    inline def +(n: O): O = apply(show(value) + show(n))
    inline def -(n: O): O = apply(show(value) - show(n))
    inline def *(n: scala.BigDecimal): O =
      apply(
        BigDecimal(show(value))
          .underlying()
          .multiply(n.underlying())
          .roundToIntUp
      )
    inline def /(n: scala.BigDecimal): O =
      apply(
        BigDecimal(show(value)).underlying().divide(n.underlying()).roundToIntUp
      )
    inline def *(n: Double): O =
      apply(
        BigDecimal(show(value))
          .underlying()
          .multiply(BigDecimal(n).underlying())
          .roundToIntUp
      )
    inline def /(n: Double): O =
      apply(
        BigDecimal(show(value))
          .underlying()
          .divide(BigDecimal(n).underlying())
          .roundToIntUp
      )
    inline def toInt: Int = show(value)
    inline def toBigDecimal: BigDecimal = BigDecimal(show(value))

  inline given Ordering[O] = Ordering.by(show)

end OpaqueInteger

trait SimpleOpaqueInteger[O <: Int] extends OpaqueInteger[O]:

  val ZERO = apply(0)

  inline def roundedUp(value: BigDecimal): O =
    apply(value.roundToIntUp)

  inline def roundedDown(value: BigDecimal): O =
    apply(value.roundToIntDown)

  inline def roundedHalfUp(value: BigDecimal): O =
    apply(value.roundToIntHalfUp)

  inline def roundedHalfDown(value: BigDecimal): O =
    apply(value.roundToIntHalfDown)

  extension (value: O) {

    inline infix def plus(other: O): O =
      apply(value + other)

    inline infix def minus(other: O): O =
      apply(value - other)

    /** Current value or ZERO if negative */
    inline def orZero: O = max(ZERO, value)

  }

  inline def min(value1: O, value2: O): O =
    if (value1 < value2) then value1 else value2

  inline def min(value1: O, values: O*): O =
    min(value1, values.min)

  inline def max(value1: O, value2: O): O =
    if (value1 > value2) then value1 else value2

  inline def max(value1: O, values: O*): O =
    max(value1, values.max)

end SimpleOpaqueInteger
