# opaque-type

This Scala 3 library provides a support to easily define opaque types serializable using [upickle](https://github.com/com-lihaoyi/upickle).

## Usage

Use with SBT

    libraryDependencies += "org.encalmo" %% "opaque-type" % "0.9.0"

or with SCALA-CLI

    //> using dep org.encalmo::opaque-type:0.9.0

## Example

A number of common opaque types is included as an example:

- [Amount](Amount.scala)
- [AmountDecimal](AmountDecimal.scala)
- [AmountDecimalString](AmountDecimalString.scala)
- [AmountString](AmountString.scala)
- [Bps](Bps.scala)
- [City](City.scala)
- [Country](Country.scala)
- [Currency](Currency.scala)
- [DateOfBirth](DateOfBirth.scala)
- [EmailAddress](EmailAddress.scala)
- [Fee](Fee.scala)
- [FirstName](FirstName.scala)
- [IsoDateString](IsoDateString.scala)
- [LastName](LastName.scala)
- [LocalPhoneNumber](LocalPhoneNumber.scala)
- [Percentage](Percentage.scala)
- [PhoneNumber](PhoneNumber.scala)
- [PhoneNumberCountryPrefix](PhoneNumberCountryPrefix.scala)