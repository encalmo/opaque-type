package org.encalmo.models

opaque type PhoneNumberCountryPrefix = String

object PhoneNumberCountryPrefix extends SimpleOpaqueString[PhoneNumberCountryPrefix] {

  val phoneNumberPrefix2CountryCodeMap: Map[String, String] =
    Map(
      "1" -> "CAN",
      "1" -> "PRI",
      "1" -> "USA",
      "1242" -> "BHS",
      "1246" -> "BRB",
      "1264" -> "AIA",
      "1268" -> "ATG",
      "1284" -> "VGB",
      "1340" -> "VIR",
      "1345" -> "CYM",
      "1441" -> "BMU",
      "1473" -> "GRD",
      "1649" -> "TCA",
      "1664" -> "MSR",
      "1670" -> "MNP",
      "1671" -> "GUM",
      "1684" -> "ASM",
      "1721" -> "SXM",
      "1758" -> "LCA",
      "1767" -> "DMA",
      "1784" -> "VCT",
      "1809" -> "DOM",
      "1829" -> "DOM",
      "1849" -> "DOM",
      "1868" -> "TTO",
      "1869" -> "KNA",
      "1876" -> "JAM",
      "20" -> "EGY",
      "211" -> "SSD",
      "212" -> "ESH",
      "212" -> "ESH",
      "212" -> "MAR",
      "213" -> "DZA",
      "216" -> "TUN",
      "218" -> "LBY",
      "220" -> "GMB",
      "221" -> "SEN",
      "222" -> "MRT",
      "223" -> "MLI",
      "224" -> "GIN",
      "225" -> "CIV",
      "226" -> "BFA",
      "227" -> "NER",
      "228" -> "TGO",
      "229" -> "BEN",
      "230" -> "MUS",
      "231" -> "LBR",
      "232" -> "SLE",
      "233" -> "GHA",
      "234" -> "NGA",
      "235" -> "TCD",
      "236" -> "CAF",
      "237" -> "CMR",
      "238" -> "CPV",
      "239" -> "STP",
      "240" -> "GNQ",
      "241" -> "GAB",
      "242" -> "COG",
      "243" -> "COD",
      "244" -> "AGO",
      "245" -> "GNB",
      "246" -> "IOT",
      "248" -> "SYC",
      "248" -> "SYC",
      "249" -> "SDN",
      "250" -> "RWA",
      "251" -> "ETH",
      "252" -> "SOM",
      "253" -> "DJI",
      "254" -> "KEN",
      "255" -> "TZA",
      "256" -> "UGA",
      "257" -> "BDI",
      "258" -> "MOZ",
      "260" -> "ZMB",
      "261" -> "MDG",
      "262" -> "ATF",
      "262" -> "MYT",
      "262" -> "REU",
      "263" -> "ZWE",
      "264" -> "NAM",
      "265" -> "MWI",
      "266" -> "LSO",
      "267" -> "BWA",
      "268" -> "SWZ",
      "269" -> "COM",
      "27" -> "ZAF",
      "290" -> "SHN",
      "291" -> "ERI",
      "297" -> "ABW",
      "298" -> "FRO",
      "299" -> "GRL",
      "30" -> "GRC",
      "31" -> "NLD",
      "31" -> "NLD",
      "32" -> "BEL",
      "33" -> "FRA",
      "34" -> "ESP",
      "350" -> "GIB",
      "351" -> "PRT",
      "352" -> "LUX",
      "353" -> "IRL",
      "354" -> "ISL",
      "355" -> "ALB",
      "356" -> "MLT",
      "357" -> "CYP",
      "358" -> "ALA",
      "358" -> "FIN",
      "359" -> "BGR",
      "36" -> "HUN",
      "370" -> "LTU",
      "371" -> "LVA",
      "372" -> "EST",
      "373" -> "MDA",
      "374" -> "ARM",
      "375" -> "BLR",
      "376" -> "AND",
      "377" -> "MCO",
      "378" -> "SMR",
      "380" -> "UKR",
      "381" -> "SRB",
      "382" -> "MNE",
      "385" -> "HRV",
      "386" -> "SVN",
      "387" -> "BIH",
      "389" -> "MKD",
      "39" -> "ITA",
      "3906" -> "VAT",
      "40" -> "ROU",
      "41" -> "CHE",
      "420" -> "CZE",
      "421" -> "SVK",
      "423" -> "LIE",
      "43" -> "AUT",
      "44" -> "GBR",
      "44" -> "GGY",
      "44" -> "IMN",
      "44" -> "JEY",
      "45" -> "DNK",
      "45" -> "DNK",
      "46" -> "SWE",
      "47" -> "BVT",
      "47" -> "NOR",
      "47" -> "SJM",
      "48" -> "POL",
      "49" -> "DEU",
      "500" -> "FLK",
      "500" -> "SGS",
      "501" -> "BLZ",
      "502" -> "GTM",
      "503" -> "SLV",
      "504" -> "HND",
      "505" -> "NIC",
      "506" -> "CRI",
      "507" -> "PAN",
      "508" -> "SPM",
      "509" -> "HTI",
      "51" -> "PER",
      "52" -> "MEX",
      "53" -> "CUB",
      "54" -> "ARG",
      "55" -> "BRA",
      "56" -> "CHL",
      "57" -> "COL",
      "58" -> "VEN",
      "590" -> "BLM",
      "590" -> "GLP",
      "590" -> "MAF",
      "591" -> "BOL",
      "592" -> "GUY",
      "593" -> "ECU",
      "594" -> "GUF",
      "595" -> "PRY",
      "596" -> "MTQ",
      "597" -> "SUR",
      "598" -> "URY",
      "599" -> "BES",
      "599" -> "CUW",
      "60" -> "MYS",
      "61" -> "AUS",
      "61" -> "CCK",
      "61" -> "CXR",
      "62" -> "IDN",
      "63" -> "PHL",
      "64" -> "NZL",
      "65" -> "SGP",
      "66" -> "THA",
      "670" -> "TLS",
      "672" -> "ATA",
      "672" -> "HMD",
      "672" -> "NFK",
      "673" -> "BRN",
      "674" -> "NRU",
      "675" -> "PNG",
      "676" -> "TON",
      "677" -> "SLB",
      "678" -> "VUT",
      "679" -> "FJI",
      "680" -> "PLW",
      "681" -> "WLF",
      "682" -> "COK",
      "683" -> "NIU",
      "685" -> "WSM",
      "686" -> "KIR",
      "687" -> "NCL",
      "688" -> "TUV",
      "689" -> "PYF",
      "690" -> "TKL",
      "691" -> "FSM",
      "692" -> "MHL",
      "7" -> "KAZ",
      "7" -> "RUS",
      "81" -> "JPN",
      "82" -> "KOR",
      "84" -> "VNM",
      "850" -> "PRK",
      "852" -> "HKG",
      "853" -> "MAC",
      "855" -> "KHM",
      "856" -> "LAO",
      "86" -> "CHN",
      "870" -> "PCN",
      "880" -> "BGD",
      "886" -> "TWN",
      "90" -> "TUR",
      "91" -> "IND",
      "92" -> "PAK",
      "93" -> "AFG",
      "94" -> "LKA",
      "95" -> "MMR",
      "960" -> "MDV",
      "961" -> "LBN",
      "962" -> "JOR",
      "963" -> "SYR",
      "964" -> "IRQ",
      "965" -> "KWT",
      "966" -> "SAU",
      "967" -> "YEM",
      "968" -> "OMN",
      "970" -> "PSE",
      "971" -> "ARE",
      "972" -> "ISR",
      "973" -> "BHR",
      "974" -> "QAT",
      "975" -> "BTN",
      "976" -> "MNG",
      "977" -> "NPL",
      "98" -> "IRN",
      "992" -> "TJK",
      "993" -> "TKM",
      "994" -> "AZE",
      "995" -> "GEO",
      "996" -> "KGZ",
      "998" -> "UZB"
    )

  val phoneNumberPrefixesDescending: Seq[String] =
    phoneNumberPrefix2CountryCodeMap.keysIterator.toSeq.sortBy(k => -k.size)
}
