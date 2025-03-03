package org.encalmo.models

opaque type PhoneNumber = String

object PhoneNumber extends SimpleOpaqueString[PhoneNumber] {

  def apply(prefix: PhoneNumberCountryPrefix, local: LocalPhoneNumber): PhoneNumber =
    PhoneNumber(s"+$prefix$local")

  extension (pn: PhoneNumber)

    def toLocalPhoneNumber: Option[LocalPhoneNumber] =
      val n = pn.toString().dropWhile(_ == '+')
      PhoneNumberCountryPrefix.phoneNumberPrefixesDescending
        .find(n.startsWith)
        .map(prefix => LocalPhoneNumber(n.drop(prefix.size)))

    def toPhoneNumberCountryPrefix: Option[PhoneNumberCountryPrefix] =
      val n = pn.toString().dropWhile(_ == '+')
      PhoneNumberCountryPrefix.phoneNumberPrefixesDescending
        .find(n.startsWith)
        .map(prefix => PhoneNumberCountryPrefix(prefix))

    def toCountryCode: Option[Country] =
      val n = pn.toString().dropWhile(_ == '+')
      PhoneNumberCountryPrefix.phoneNumberPrefixesDescending
        .find(n.startsWith)
        .map(prefix => Country(PhoneNumberCountryPrefix.phoneNumberPrefix2CountryCodeMap(prefix)))

    def split: Option[(PhoneNumberCountryPrefix, LocalPhoneNumber)] =
      val n = pn.toString().dropWhile(_ == '+')
      PhoneNumberCountryPrefix.phoneNumberPrefixesDescending
        .find(n.startsWith)
        .map(prefix => (PhoneNumberCountryPrefix(prefix), LocalPhoneNumber(n.drop(prefix.size))))
}
