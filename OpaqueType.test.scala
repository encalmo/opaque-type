package org.encalmo.models

import org.encalmo.utils.JsonUtils.*

class OpaqueTypeSpec extends munit.FunSuite {

  test("Serialize and deserialize opaque type to/from JSON") {
    assertEquals(Amount(123).writeAsJson, ujson.Num(123))
    assertEquals("123".readAs[Amount], Amount(123))
    assertEquals(Amount(123).writeAsJson.readAs[Amount], Amount(123))
  }

  test("DateOfBirth must accept 2000-03-03 format") {
    val dob = DateOfBirth("2000-03-03")
    assertEquals(dob.toString(), "2000-03-03")
  }

  test("DateOfBirth must accept 03/03/2000 format") {
    val dob = DateOfBirth("03/03/2000")
    assertEquals(dob.toString(), "2000-03-03")
  }

  test("Amount") {
    Amount(0)
    Amount(10)
    Amount(1237)
    Amount(1088998898)
    assertEquals(
      Amount(1237).toAmountString,
      AmountString("1237")
    )
    assertEquals(
      Amount(1237).toAmountDecimalString,
      AmountDecimalString("12.37")
    )
    assertEquals(
      Amount.roundedUp(BigDecimal("1234.567")),
      Amount(1235)
    )
    assertEquals(
      Amount.roundedDown(BigDecimal("1234.567")),
      Amount(1234)
    )
    assertEquals(
      Amount.roundedHalfUp(BigDecimal("1234.5")),
      Amount(1235)
    )
    assertEquals(
      Amount.roundedHalfUp(BigDecimal("1234.499")),
      Amount(1234)
    )
    assertEquals(
      Amount.roundedHalfDown(BigDecimal("1234.5")),
      Amount(1234)
    )
    assertEquals(
      Amount.roundedHalfDown(BigDecimal("1234.501")),
      Amount(1235)
    )
    assertEquals(
      Amount.min(Amount(1), Amount(2)),
      Amount(1)
    )
    assertEquals(
      Amount.min(Amount(1), Amount(2), Amount(0)),
      Amount(0)
    )
    assertEquals(
      Amount.min(Amount(0), Amount(2), Amount(3), Amount(1)),
      Amount(0)
    )
    assertEquals(
      Amount.max(Amount(1), Amount(2)),
      Amount(2)
    )
    assertEquals(
      Amount.max(Amount(1), Amount(2), Amount(0)),
      Amount(2)
    )
    assertEquals(
      Amount.max(Amount(0), Amount(2), Amount(3), Amount(1)),
      Amount(3)
    )
    assertEquals(
      Amount.max(Amount(4), Amount(2), Amount(3), Amount(1)),
      Amount(4)
    )
    assertEquals(Amount(-1).orZero, Amount.ZERO)
    assertEquals(Amount(1).orZero, Amount(1))
    assertEquals(Amount.ZERO.orZero, Amount.ZERO)
  }

  test("AmountString") {
    AmountString("0")
    AmountString("10")
    AmountString("10889988989898")
    assertEquals(
      AmountString("10").toAmount,
      Amount(10)
    )
    assertEquals(
      Amount(1237).toAmountString,
      AmountString("1237")
    )
    assertEquals(
      Amount(1237).toAmountDecimalString,
      AmountDecimalString("12.37")
    )
    assertEquals(
      AmountString.min(AmountString("1237"), AmountString("1238")),
      AmountString("1237")
    )
    assertEquals(
      AmountString
        .min(AmountString("1237"), AmountString("1238"), AmountString("238")),
      AmountString("238")
    )
    assertEquals(
      AmountString
        .min(AmountString("237"), AmountString("1238"), AmountString("238")),
      AmountString("237")
    )
    assertEquals(
      AmountString.max(AmountString("1237"), AmountString("1238")),
      AmountString("1238")
    )
    assertEquals(
      AmountString.max(AmountString("1239"), AmountString("1238")),
      AmountString("1239")
    )
    assertEquals(
      AmountString
        .max(AmountString("1237"), AmountString("1238"), AmountString("238")),
      AmountString("1238")
    )
    assertEquals(
      AmountString
        .max(AmountString("237"), AmountString("1238"), AmountString("238")),
      AmountString("1238")
    )
    assertEquals(
      AmountString
        .max(AmountString("1239"), AmountString("1238"), AmountString("238")),
      AmountString("1239")
    )
    assertEquals(AmountString("1239").orZero, AmountString("1239"))
    assertEquals(AmountString("-1239").orZero, AmountString.ZERO)
  }

  test("AmountDecimalString") {
    AmountDecimalString("0.12")
    AmountDecimalString("1.00")
    AmountDecimalString("108899.88")
    assertEquals(
      AmountDecimalString("12.37").toAmount,
      Amount(1237)
    )
    assertEquals(
      AmountDecimalString("12.37").toAmountString,
      AmountString("1237")
    )
    assertEquals(
      Amount(1237).toAmountDecimalString,
      AmountDecimalString("12.37")
    )
    assertEquals(
      AmountDecimalString.roundedDown(BigDecimal(12.3781d)),
      AmountDecimalString("12.37")
    )
    assertEquals(
      AmountDecimalString.roundedUp(BigDecimal(12.3666)),
      AmountDecimalString("12.37")
    )
    assertEquals(
      AmountDecimalString.roundedHalfUp(BigDecimal(12.375)),
      AmountDecimalString("12.38")
    )
    assertEquals(
      AmountDecimalString.roundedHalfUp(BigDecimal(12.37499)),
      AmountDecimalString("12.37")
    )
    assertEquals(
      AmountDecimalString.roundedHalfDown(BigDecimal(12.375)),
      AmountDecimalString("12.37")
    )
    assertEquals(
      AmountDecimalString.roundedHalfDown(BigDecimal(12.37501)),
      AmountDecimalString("12.38")
    )
    val s1 = "151"
    assertEquals(
      AmountDecimalString(s1),
      AmountDecimalString("151.00")
    )
    assertNotEquals(
      AmountDecimalString(s1),
      AmountDecimalString("151.01")
    )
    val s2 = "151.1"
    assertEquals(
      AmountDecimalString(s2),
      AmountDecimalString("151.10")
    )
    assertNotEquals(
      AmountDecimalString(s2),
      AmountDecimalString("151.11")
    )
    val s3 = "151.12"
    assertEquals(
      AmountDecimalString(s3),
      AmountDecimalString("151.12")
    )
    val s4 = "151.123"
    assertEquals(
      AmountDecimalString(s4),
      AmountDecimalString("151.12")
    )
    val s5 = "151.126"
    assertEquals(
      AmountDecimalString(s5),
      AmountDecimalString("151.13")
    )
    assertEquals(
      AmountDecimalString
        .min(AmountDecimalString("151.13"), AmountDecimalString("151.14")),
      AmountDecimalString("151.13")
    )
    assertEquals(
      AmountDecimalString
        .min(AmountDecimalString("151.12"), AmountDecimalString("151.14")),
      AmountDecimalString("151.12")
    )
    assertEquals(
      AmountDecimalString
        .min(
          AmountDecimalString("21.01"),
          AmountDecimalString("151.14"),
          AmountDecimalString("399.99")
        ),
      AmountDecimalString("21.01")
    )
    assertEquals(
      AmountDecimalString
        .min(
          AmountDecimalString("21.01"),
          AmountDecimalString("1.14"),
          AmountDecimalString("11.14")
        ),
      AmountDecimalString("1.14")
    )

    assertEquals(
      AmountDecimalString
        .max(AmountDecimalString("151.13"), AmountDecimalString("151.14")),
      AmountDecimalString("151.14")
    )
    assertEquals(
      AmountDecimalString
        .max(AmountDecimalString("151.15"), AmountDecimalString("151.14")),
      AmountDecimalString("151.15")
    )
    assertEquals(
      AmountDecimalString
        .max(
          AmountDecimalString("21.01"),
          AmountDecimalString("151.14"),
          AmountDecimalString("399.99")
        ),
      AmountDecimalString("399.99")
    )
    assertEquals(
      AmountDecimalString
        .max(
          AmountDecimalString("21.01"),
          AmountDecimalString("1.14"),
          AmountDecimalString("11.14")
        ),
      AmountDecimalString("21.01")
    )
    assertEquals(
      AmountDecimalString("21.01").orZero,
      AmountDecimalString("21.01")
    )
    assertEquals(AmountDecimalString("-21.01").orZero, AmountDecimalString.ZERO)
  }

  test("AmountDecimal") {
    assertEquals(
      AmountDecimal(BigDecimal("1.115")).toAmountDecimalString,
      AmountDecimalString("1.12")
    )
    assertEquals(
      Amount(12345).toAmountDecimal,
      AmountDecimal("123.45")
    )
  }

  test("Fee") {
    Fee(0)
    Fee(10)
    Fee(1237)
    Fee(1088998898)
    assertEquals(
      Fee(1237).toAmount,
      Amount(1237)
    )
    assertEquals(
      Fee.roundedUp(BigDecimal("1234.567")),
      Fee(1235)
    )
    assertEquals(
      Fee.roundedDown(BigDecimal("1234.567")),
      Fee(1234)
    )
    assertEquals(
      Fee.roundedHalfUp(BigDecimal("1234.5")),
      Fee(1235)
    )
    assertEquals(
      Fee.roundedHalfUp(BigDecimal("1234.499")),
      Fee(1234)
    )
    assertEquals(
      Fee.roundedHalfDown(BigDecimal("1234.5")),
      Fee(1234)
    )
    assertEquals(
      Fee.roundedHalfDown(BigDecimal("1234.501")),
      Fee(1235)
    )
    assertEquals(
      Fee.min(Fee(1), Fee(2)),
      Fee(1)
    )
    assertEquals(
      Fee.min(Fee(1), Fee(2), Fee(0)),
      Fee(0)
    )
    assertEquals(
      Fee.min(Fee(0), Fee(2), Fee(3), Fee(1)),
      Fee(0)
    )
    assertEquals(
      Fee.max(Fee(1), Fee(2)),
      Fee(2)
    )
    assertEquals(
      Fee.max(Fee(1), Fee(2), Fee(0)),
      Fee(2)
    )
    assertEquals(
      Fee.max(Fee(0), Fee(2), Fee(3), Fee(1)),
      Fee(3)
    )
    assertEquals(
      Fee.max(Fee(4), Fee(2), Fee(3), Fee(1)),
      Fee(4)
    )
    assertEquals(Fee(-1).orZero, Fee.ZERO)
    assertEquals(Fee(1).orZero, Fee(1))
    assertEquals(Fee.ZERO.orZero, Fee.ZERO)
  }

  test("Amount must provide basic arithmethic operations") {
    val x = Amount(13)
    val y = Amount(58)

    assert(x + y == Amount(71))
    assert(y + x == Amount(71))
    assert(x - y == Amount(-45))
    assert(y - x == Amount(45))
  }

  test("Bps must multiply a BigDecimal and result in BigDecimal") {
    assertEquals(Bps(75) ** BigDecimal(1000), BigDecimal("7.5"))
    assertEquals(Bps(75) ** BigDecimal(10000), BigDecimal("75"))
    assertEquals(Bps(75) ** BigDecimal(100), BigDecimal("0.75"))
  }

  test("Amount must add a Bps and result in an Amount") {
    assertEquals(Amount(10000) plusBps Bps(75), Amount(10075))
    assertEquals(Amount(1000) plusBps Bps(75), Amount(1008))
    assertEquals(Amount(100) plusBps Bps(75), Amount(101))
    assertEquals(Amount(10) plusBps Bps(75), Amount(10))
    assertEquals(Amount(1) plusBps Bps(75), Amount(1))
  }

  test("Amount must subtract a Bps and result in an Amount") {
    assertEquals(Amount(10000) minusBps Bps(75), Amount(9925))
    assertEquals(Amount(1000) minusBps Bps(75), Amount(993))
    assertEquals(Amount(100) minusBps Bps(75), Amount(99))
    assertEquals(Amount(10) minusBps Bps(75), Amount(10))
    assertEquals(Amount(1) minusBps Bps(75), Amount(1))
  }

  test("Amount must add a Percentage and result in an Amount") {
    assertEquals(Amount(10000) plusPercentage Percentage(75), Amount(17500))
    assertEquals(Amount(1000) plusPercentage Percentage(75), Amount(1750))
    assertEquals(Amount(100) plusPercentage Percentage(75), Amount(175))
    assertEquals(Amount(10) plusPercentage Percentage(75), Amount(18))
    assertEquals(Amount(1) plusPercentage Percentage(75), Amount(2))
  }

  test("Amount must subtract a Percentage and result in an Amount") {
    assertEquals(Amount(10000) minusPercentage Percentage(75), Amount(2500))
    assertEquals(Amount(1000) minusPercentage Percentage(75), Amount(250))
    assertEquals(Amount(100) minusPercentage Percentage(75), Amount(25))
    assertEquals(Amount(10) minusPercentage Percentage(75), Amount(3))
    assertEquals(Amount(1) minusPercentage Percentage(75), Amount(0))
  }

  test("Fee must add a Bps and result in an Fee") {
    assertEquals(Fee(10000) plusBps Bps(75), Fee(10075))
    assertEquals(Fee(1000) plusBps Bps(75), Fee(1008))
    assertEquals(Fee(100) plusBps Bps(75), Fee(101))
    assertEquals(Fee(10) plusBps Bps(75), Fee(10))
    assertEquals(Fee(1) plusBps Bps(75), Fee(1))
  }

  test("Fee must subtract a Bps and result in an Fee") {
    assertEquals(Fee(10000) minusBps Bps(75), Fee(9925))
    assertEquals(Fee(1000) minusBps Bps(75), Fee(993))
    assertEquals(Fee(100) minusBps Bps(75), Fee(99))
    assertEquals(Fee(10) minusBps Bps(75), Fee(10))
    assertEquals(Fee(1) minusBps Bps(75), Fee(1))
  }

  test("Fee must add a Percentage and result in an Fee") {
    assertEquals(Fee(10000) plusPercentage Percentage(75), Fee(17500))
    assertEquals(Fee(1000) plusPercentage Percentage(75), Fee(1750))
    assertEquals(Fee(100) plusPercentage Percentage(75), Fee(175))
    assertEquals(Fee(10) plusPercentage Percentage(75), Fee(18))
    assertEquals(Fee(1) plusPercentage Percentage(75), Fee(2))
    assertEquals(Fee(100) plusPercentage Percentage(2), Fee(102))
  }

  test("Fee must subtract a Percentage and result in an Fee") {
    assertEquals(Fee(10000) minusPercentage Percentage(75), Fee(2500))
    assertEquals(Fee(1000) minusPercentage Percentage(75), Fee(250))
    assertEquals(Fee(100) minusPercentage Percentage(75), Fee(25))
    assertEquals(Fee(10) minusPercentage Percentage(75), Fee(3))
    assertEquals(Fee(1) minusPercentage Percentage(75), Fee(0))
  }

  test("Amount must applyPercentage and result in Amount") {
    assertEquals(Amount(100).applyPercentage(Percentage(2)), Amount(2))
    assertEquals(Amount(100).applyPercentage(Percentage(15)), Amount(15))
    assertEquals(Amount(150).applyPercentage(Percentage(15)), Amount(23))
    assertEquals(Amount(130).applyPercentage(Percentage(33)), Amount(43))
  }

  test("decimal string amount must convert from/to amount") {
    assertEquals(
      Amount(12354).toAmountDecimalString,
      AmountDecimalString("123.54")
    )
    assertEquals(
      AmountDecimalString("123.54").toAmount,
      Amount(12354)
    )
  }

  test("opaque string extensions") {
    assertEquals(FirstName("alpha papa").take(5), FirstName("alpha"))
    assertEquals(LastName("  alpha ").trim, "alpha")
  }

}
