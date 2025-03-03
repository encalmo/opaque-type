package org.encalmo.models

import upickle.default.*

opaque type Currency = String

object Currency extends OpaqueString[Currency]:
  inline def apply(currency: String): Currency =
    assert(ISO4217.codes.contains(currency))
    currency

  inline def show(currency: Currency): String = currency

  val USD = Currency("USD")
  val EUR = Currency("EUR")
  val PHP = Currency("PHP")
  val MXN = Currency("MXN")
  val PAB = Currency("PAB")

  val ADP = Currency("ADP")
  val AED = Currency("AED")
  val AFA = Currency("AFA")
  val AFN = Currency("AFN")
  val ALK = Currency("ALK")
  val ALL = Currency("ALL")
  val AMD = Currency("AMD")
  val ANG = Currency("ANG")
  val AOA = Currency("AOA")
  val AOK = Currency("AOK")
  val AON = Currency("AON")
  val AOR = Currency("AOR")
  val ARA = Currency("ARA")
  val ARP = Currency("ARP")
  val ARS = Currency("ARS")
  val ARY = Currency("ARY")
  val ATS = Currency("ATS")
  val AUD = Currency("AUD")
  val AWG = Currency("AWG")
  val AYM = Currency("AYM")
  val AZM = Currency("AZM")
  val AZN = Currency("AZN")
  val BAD = Currency("BAD")
  val BAM = Currency("BAM")
  val BBD = Currency("BBD")
  val BDT = Currency("BDT")
  val BEC = Currency("BEC")
  val BEF = Currency("BEF")
  val BEL = Currency("BEL")
  val BGJ = Currency("BGJ")
  val BGK = Currency("BGK")
  val BGL = Currency("BGL")
  val BGN = Currency("BGN")
  val BHD = Currency("BHD")
  val BIF = Currency("BIF")
  val BMD = Currency("BMD")
  val BND = Currency("BND")
  val BOB = Currency("BOB")
  val BOP = Currency("BOP")
  val BOV = Currency("BOV")
  val BRB = Currency("BRB")
  val BRC = Currency("BRC")
  val BRE = Currency("BRE")
  val BRL = Currency("BRL")
  val BRN = Currency("BRN")
  val BRR = Currency("BRR")
  val BSD = Currency("BSD")
  val BTN = Currency("BTN")
  val BUK = Currency("BUK")
  val BWP = Currency("BWP")
  val BYB = Currency("BYB")
  val BYN = Currency("BYN")
  val BYR = Currency("BYR")
  val BZD = Currency("BZD")
  val CAD = Currency("CAD")
  val CDF = Currency("CDF")
  val CHC = Currency("CHC")
  val CHE = Currency("CHE")
  val CHF = Currency("CHF")
  val CHW = Currency("CHW")
  val CLF = Currency("CLF")
  val CLP = Currency("CLP")
  val CNY = Currency("CNY")
  val COP = Currency("COP")
  val COU = Currency("COU")
  val CRC = Currency("CRC")
  val CSD = Currency("CSD")
  val CSJ = Currency("CSJ")
  val CSK = Currency("CSK")
  val CUC = Currency("CUC")
  val CUP = Currency("CUP")
  val CVE = Currency("CVE")
  val CYP = Currency("CYP")
  val CZK = Currency("CZK")
  val DDM = Currency("DDM")
  val DEM = Currency("DEM")
  val DJF = Currency("DJF")
  val DKK = Currency("DKK")
  val DOP = Currency("DOP")
  val DZD = Currency("DZD")
  val ECS = Currency("ECS")
  val ECV = Currency("ECV")
  val EEK = Currency("EEK")
  val EGP = Currency("EGP")
  val ERN = Currency("ERN")
  val ESA = Currency("ESA")
  val ESB = Currency("ESB")
  val ESP = Currency("ESP")
  val ETB = Currency("ETB")
  val FIM = Currency("FIM")
  val FJD = Currency("FJD")
  val FKP = Currency("FKP")
  val FRF = Currency("FRF")
  val GBP = Currency("GBP")
  val GEK = Currency("GEK")
  val GEL = Currency("GEL")
  val GHC = Currency("GHC")
  val GHP = Currency("GHP")
  val GHS = Currency("GHS")
  val GIP = Currency("GIP")
  val GMD = Currency("GMD")
  val GNE = Currency("GNE")
  val GNF = Currency("GNF")
  val GNS = Currency("GNS")
  val GQE = Currency("GQE")
  val GRD = Currency("GRD")
  val GTQ = Currency("GTQ")
  val GWE = Currency("GWE")
  val GWP = Currency("GWP")
  val GYD = Currency("GYD")
  val HKD = Currency("HKD")
  val HNL = Currency("HNL")
  val HRD = Currency("HRD")
  val HRK = Currency("HRK")
  val HTG = Currency("HTG")
  val HUF = Currency("HUF")
  val IDR = Currency("IDR")
  val IEP = Currency("IEP")
  val ILP = Currency("ILP")
  val ILR = Currency("ILR")
  val ILS = Currency("ILS")
  val INR = Currency("INR")
  val IQD = Currency("IQD")
  val IRR = Currency("IRR")
  val ISJ = Currency("ISJ")
  val ISK = Currency("ISK")
  val ITL = Currency("ITL")
  val JMD = Currency("JMD")
  val JOD = Currency("JOD")
  val JPY = Currency("JPY")
  val KES = Currency("KES")
  val KGS = Currency("KGS")
  val KHR = Currency("KHR")
  val KMF = Currency("KMF")
  val KPW = Currency("KPW")
  val KRW = Currency("KRW")
  val KWD = Currency("KWD")
  val KYD = Currency("KYD")
  val KZT = Currency("KZT")
  val LAJ = Currency("LAJ")
  val LAK = Currency("LAK")
  val LBP = Currency("LBP")
  val LKR = Currency("LKR")
  val LRD = Currency("LRD")
  val LSL = Currency("LSL")
  val LSM = Currency("LSM")
  val LTL = Currency("LTL")
  val LTT = Currency("LTT")
  val LUC = Currency("LUC")
  val LUF = Currency("LUF")
  val LUL = Currency("LUL")
  val LVL = Currency("LVL")
  val LVR = Currency("LVR")
  val LYD = Currency("LYD")
  val MAD = Currency("MAD")
  val MDL = Currency("MDL")
  val MGA = Currency("MGA")
  val MGF = Currency("MGF")
  val MKD = Currency("MKD")
  val MLF = Currency("MLF")
  val MMK = Currency("MMK")
  val MNT = Currency("MNT")
  val MOP = Currency("MOP")
  val MRO = Currency("MRO")
  val MRU = Currency("MRU")
  val MTL = Currency("MTL")
  val MTP = Currency("MTP")
  val MUR = Currency("MUR")
  val MVQ = Currency("MVQ")
  val MVR = Currency("MVR")
  val MWK = Currency("MWK")
  val MXP = Currency("MXP")
  val MXV = Currency("MXV")
  val MYR = Currency("MYR")
  val MZE = Currency("MZE")
  val MZM = Currency("MZM")
  val MZN = Currency("MZN")
  val NAD = Currency("NAD")
  val NGN = Currency("NGN")
  val NIC = Currency("NIC")
  val NIO = Currency("NIO")
  val NLG = Currency("NLG")
  val NOK = Currency("NOK")
  val NPR = Currency("NPR")
  val NZD = Currency("NZD")
  val OMR = Currency("OMR")
  val PEH = Currency("PEH")
  val PEI = Currency("PEI")
  val PEN = Currency("PEN")
  val PES = Currency("PES")
  val PGK = Currency("PGK")
  val PKR = Currency("PKR")
  val PLN = Currency("PLN")
  val PLZ = Currency("PLZ")
  val PTE = Currency("PTE")
  val PYG = Currency("PYG")
  val QAR = Currency("QAR")
  val RHD = Currency("RHD")
  val ROK = Currency("ROK")
  val ROL = Currency("ROL")
  val RON = Currency("RON")
  val RSD = Currency("RSD")
  val RUB = Currency("RUB")
  val RUR = Currency("RUR")
  val RWF = Currency("RWF")
  val SAR = Currency("SAR")
  val SBD = Currency("SBD")
  val SCR = Currency("SCR")
  val SDD = Currency("SDD")
  val SDG = Currency("SDG")
  val SDP = Currency("SDP")
  val SEK = Currency("SEK")
  val SGD = Currency("SGD")
  val SHP = Currency("SHP")
  val SIT = Currency("SIT")
  val SKK = Currency("SKK")
  val SLL = Currency("SLL")
  val SOS = Currency("SOS")
  val SRD = Currency("SRD")
  val SRG = Currency("SRG")
  val SSP = Currency("SSP")
  val STD = Currency("STD")
  val STN = Currency("STN")
  val SUR = Currency("SUR")
  val SVC = Currency("SVC")
  val SYP = Currency("SYP")
  val SZL = Currency("SZL")
  val THB = Currency("THB")
  val TJR = Currency("TJR")
  val TJS = Currency("TJS")
  val TMM = Currency("TMM")
  val TMT = Currency("TMT")
  val TND = Currency("TND")
  val TOP = Currency("TOP")
  val TPE = Currency("TPE")
  val TRL = Currency("TRL")
  val TRY = Currency("TRY")
  val TTD = Currency("TTD")
  val TWD = Currency("TWD")
  val TZS = Currency("TZS")
  val UAH = Currency("UAH")
  val UAK = Currency("UAK")
  val UGS = Currency("UGS")
  val UGW = Currency("UGW")
  val UGX = Currency("UGX")
  val USN = Currency("USN")
  val USS = Currency("USS")
  val UYI = Currency("UYI")
  val UYN = Currency("UYN")
  val UYP = Currency("UYP")
  val UYU = Currency("UYU")
  val UYW = Currency("UYW")
  val UZS = Currency("UZS")
  val VEB = Currency("VEB")
  val VEF = Currency("VEF")
  val VES = Currency("VES")
  val VNC = Currency("VNC")
  val VND = Currency("VND")
  val VUV = Currency("VUV")
  val WST = Currency("WST")
  val XAF = Currency("XAF")
  val XAG = Currency("XAG")
  val XAU = Currency("XAU")
  val XBA = Currency("XBA")
  val XBB = Currency("XBB")
  val XBC = Currency("XBC")
  val XBD = Currency("XBD")
  val XCD = Currency("XCD")
  val XDR = Currency("XDR")
  val XEU = Currency("XEU")
  val XFO = Currency("XFO")
  val XFU = Currency("XFU")
  val XOF = Currency("XOF")
  val XPD = Currency("XPD")
  val XPF = Currency("XPF")
  val XPT = Currency("XPT")
  val XRE = Currency("XRE")
  val XSU = Currency("XSU")
  val XTS = Currency("XTS")
  val XUA = Currency("XUA")
  val XXX = Currency("XXX")
  val YDD = Currency("YDD")
  val YER = Currency("YER")
  val YUD = Currency("YUD")
  val YUM = Currency("YUM")
  val YUN = Currency("YUN")
  val ZAL = Currency("ZAL")
  val ZAR = Currency("ZAR")
  val ZMK = Currency("ZMK")
  val ZMW = Currency("ZMW")
  val ZRN = Currency("ZRN")
  val ZRZ = Currency("ZRZ")
  val ZWC = Currency("ZWC")
  val ZWD = Currency("ZWD")
  val ZWL = Currency("ZWL")
  val ZWN = Currency("ZWN")
  val ZWR = Currency("ZWR")

object ISO4217:
  final val codes = Set(
    "ADP",
    "AED",
    "AFA",
    "AFN",
    "ALK",
    "ALL",
    "AMD",
    "ANG",
    "AOA",
    "AOK",
    "AON",
    "AOR",
    "ARA",
    "ARP",
    "ARS",
    "ARY",
    "ATS",
    "AUD",
    "AWG",
    "AYM",
    "AZM",
    "AZN",
    "BAD",
    "BAM",
    "BBD",
    "BDT",
    "BEC",
    "BEF",
    "BEL",
    "BGJ",
    "BGK",
    "BGL",
    "BGN",
    "BHD",
    "BIF",
    "BMD",
    "BND",
    "BOB",
    "BOP",
    "BOV",
    "BRB",
    "BRC",
    "BRE",
    "BRL",
    "BRN",
    "BRR",
    "BSD",
    "BTN",
    "BUK",
    "BWP",
    "BYB",
    "BYN",
    "BYR",
    "BZD",
    "CAD",
    "CDF",
    "CHC",
    "CHE",
    "CHF",
    "CHW",
    "CLF",
    "CLP",
    "CNY",
    "COP",
    "COU",
    "CRC",
    "CSD",
    "CSJ",
    "CSK",
    "CUC",
    "CUP",
    "CVE",
    "CYP",
    "CZK",
    "DDM",
    "DEM",
    "DJF",
    "DKK",
    "DOP",
    "DZD",
    "ECS",
    "ECV",
    "EEK",
    "EGP",
    "ERN",
    "ESA",
    "ESB",
    "ESP",
    "ETB",
    "EUR",
    "FIM",
    "FJD",
    "FKP",
    "FRF",
    "GBP",
    "GEK",
    "GEL",
    "GHC",
    "GHP",
    "GHS",
    "GIP",
    "GMD",
    "GNE",
    "GNF",
    "GNS",
    "GQE",
    "GRD",
    "GTQ",
    "GWE",
    "GWP",
    "GYD",
    "HKD",
    "HNL",
    "HRD",
    "HRK",
    "HTG",
    "HUF",
    "IDR",
    "IEP",
    "ILP",
    "ILR",
    "ILS",
    "INR",
    "IQD",
    "IRR",
    "ISJ",
    "ISK",
    "ITL",
    "JMD",
    "JOD",
    "JPY",
    "KES",
    "KGS",
    "KHR",
    "KMF",
    "KPW",
    "KRW",
    "KWD",
    "KYD",
    "KZT",
    "LAJ",
    "LAK",
    "LBP",
    "LKR",
    "LRD",
    "LSL",
    "LSM",
    "LTL",
    "LTT",
    "LUC",
    "LUF",
    "LUL",
    "LVL",
    "LVR",
    "LYD",
    "MAD",
    "MDL",
    "MGA",
    "MGF",
    "MKD",
    "MLF",
    "MMK",
    "MNT",
    "MOP",
    "MRO",
    "MRU",
    "MTL",
    "MTP",
    "MUR",
    "MVQ",
    "MVR",
    "MWK",
    "MXN",
    "MXP",
    "MXV",
    "MYR",
    "MZE",
    "MZM",
    "MZN",
    "NAD",
    "NGN",
    "NIC",
    "NIO",
    "NLG",
    "NOK",
    "NPR",
    "NZD",
    "OMR",
    "PAB",
    "PEH",
    "PEI",
    "PEN",
    "PES",
    "PGK",
    "PHP",
    "PKR",
    "PLN",
    "PLZ",
    "PTE",
    "PYG",
    "QAR",
    "RHD",
    "ROK",
    "ROL",
    "RON",
    "RSD",
    "RUB",
    "RUR",
    "RWF",
    "SAR",
    "SBD",
    "SCR",
    "SDD",
    "SDG",
    "SDP",
    "SEK",
    "SGD",
    "SHP",
    "SIT",
    "SKK",
    "SLL",
    "SOS",
    "SRD",
    "SRG",
    "SSP",
    "STD",
    "STN",
    "SUR",
    "SVC",
    "SYP",
    "SZL",
    "THB",
    "TJR",
    "TJS",
    "TMM",
    "TMT",
    "TND",
    "TOP",
    "TPE",
    "TRL",
    "TRY",
    "TTD",
    "TWD",
    "TZS",
    "UAH",
    "UAK",
    "UGS",
    "UGW",
    "UGX",
    "USD",
    "USN",
    "USS",
    "UYI",
    "UYN",
    "UYP",
    "UYU",
    "UYW",
    "UZS",
    "VEB",
    "VEF",
    "VES",
    "VNC",
    "VND",
    "VUV",
    "WST",
    "XAF",
    "XAG",
    "XAU",
    "XBA",
    "XBB",
    "XBC",
    "XBD",
    "XCD",
    "XDR",
    "XEU",
    "XFO",
    "XFU",
    "XOF",
    "XPD",
    "XPF",
    "XPT",
    "XRE",
    "XSU",
    "XTS",
    "XUA",
    "XXX",
    "YDD",
    "YER",
    "YUD",
    "YUM",
    "YUN",
    "ZAL",
    "ZAR",
    "ZMK",
    "ZMW",
    "ZRN",
    "ZRZ",
    "ZWC",
    "ZWD",
    "ZWL",
    "ZWN",
    "ZWR"
  )
