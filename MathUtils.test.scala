package org.encalmo.models

import MathUtils.*

class MathUtilsSpec extends munit.FunSuite {

  test("roundTo") {
    assertEquals(BigDecimal(1.234567890).roundTo(1), BigDecimal(1.2))
    assertEquals(BigDecimal(1.234567890).roundTo(2), BigDecimal(1.23))
    assertEquals(BigDecimal(1.234567890).roundTo(3), BigDecimal(1.235))
    assertEquals(BigDecimal(1.234567890).roundTo(4), BigDecimal(1.2346))
    assertEquals(BigDecimal(1.234567890).roundTo(5), BigDecimal(1.23457))
    assertEquals(BigDecimal(1.234567890).roundTo(6), BigDecimal(1.234568))
    assertEquals(BigDecimal(1.234567890).roundTo(7), BigDecimal(1.2345679))
    assertEquals(BigDecimal(1.234567890).roundTo(8), BigDecimal(1.23456789))
    assertEquals(BigDecimal(1.234567890).roundTo(9), BigDecimal(1.234567890))
  }

  test("roundToIntUp") {
    assertEquals(BigDecimal(99).roundToIntUp, 99)
    assertEquals(BigDecimal(100).roundToIntUp, 100)
    assertEquals(BigDecimal(100.0).roundToIntUp, 100)
    assertEquals(BigDecimal(100.001).roundToIntUp, 101)
    assertEquals(BigDecimal(101).roundToIntUp, 101)
    assertEquals(BigDecimal(1).roundToIntUp, 1)
    assertEquals(BigDecimal(1.1).roundToIntUp, 2)
    assertEquals(BigDecimal(1.9).roundToIntUp, 2)
    assertEquals(BigDecimal(10.0).roundToIntUp, 10)
    assertEquals(BigDecimal(10.01).roundToIntUp, 11)
    assertEquals(BigDecimal(10.999999).roundToIntUp, 11)
  }

  test("roundToIntDown") {
    assertEquals(BigDecimal(99).roundToIntDown, 99)
    assertEquals(BigDecimal(100).roundToIntDown, 100)
    assertEquals(BigDecimal(100.0).roundToIntDown, 100)
    assertEquals(BigDecimal(100.001).roundToIntDown, 100)
    assertEquals(BigDecimal(101).roundToIntDown, 101)
    assertEquals(BigDecimal(1).roundToIntDown, 1)
    assertEquals(BigDecimal(1.1).roundToIntDown, 1)
    assertEquals(BigDecimal(1.9).roundToIntDown, 1)
    assertEquals(BigDecimal(10.0).roundToIntDown, 10)
    assertEquals(BigDecimal(10.01).roundToIntDown, 10)
    assertEquals(BigDecimal(10.999999).roundToIntDown, 10)
  }

  test("roundToIntHalfDown") {
    assertEquals(BigDecimal(99).roundToIntHalfDown, 99)
    assertEquals(BigDecimal(100).roundToIntHalfDown, 100)
    assertEquals(BigDecimal(100.0).roundToIntHalfDown, 100)
    assertEquals(BigDecimal(100.001).roundToIntHalfDown, 100)
    assertEquals(BigDecimal(101).roundToIntHalfDown, 101)
    assertEquals(BigDecimal(1).roundToIntHalfDown, 1)
    assertEquals(BigDecimal(1.1).roundToIntHalfDown, 1)
    assertEquals(BigDecimal(1.9).roundToIntHalfDown, 2)
    assertEquals(BigDecimal(1.5).roundToIntHalfDown, 1)
    assertEquals(BigDecimal(1.51).roundToIntHalfDown, 2)
    assertEquals(BigDecimal(10.0).roundToIntHalfDown, 10)
    assertEquals(BigDecimal(10.01).roundToIntHalfDown, 10)
    assertEquals(BigDecimal(10.50).roundToIntHalfDown, 10)
    assertEquals(BigDecimal(10.51).roundToIntHalfDown, 11)
    assertEquals(BigDecimal(10.999999).roundToIntHalfDown, 11)
  }

  test("roundToIntHalfUp") {
    assertEquals(BigDecimal(99).roundToIntHalfUp, 99)
    assertEquals(BigDecimal(100).roundToIntHalfUp, 100)
    assertEquals(BigDecimal(100.0).roundToIntHalfUp, 100)
    assertEquals(BigDecimal(100.001).roundToIntHalfUp, 100)
    assertEquals(BigDecimal(101).roundToIntHalfUp, 101)
    assertEquals(BigDecimal(1).roundToIntHalfUp, 1)
    assertEquals(BigDecimal(1.1).roundToIntHalfUp, 1)
    assertEquals(BigDecimal(1.9).roundToIntHalfUp, 2)
    assertEquals(BigDecimal(1.5).roundToIntHalfUp, 2)
    assertEquals(BigDecimal(1.51).roundToIntHalfUp, 2)
    assertEquals(BigDecimal(10.0).roundToIntHalfUp, 10)
    assertEquals(BigDecimal(10.01).roundToIntHalfUp, 10)
    assertEquals(BigDecimal(10.50).roundToIntHalfUp, 11)
    assertEquals(BigDecimal(10.51).roundToIntHalfUp, 11)
    assertEquals(BigDecimal(10.999999).roundToIntHalfUp, 11)
  }
}
