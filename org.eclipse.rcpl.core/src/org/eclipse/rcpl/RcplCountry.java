/*******************************************************************************
 * Copyright (c) 2003 - 2014 Ramin Assisi and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     Ramin Assisi - initial implementation
 *******************************************************************************/
package org.eclipse.rcpl;

import java.util.Locale;

import org.eclipse.rcpl.model.IImage;

/**
 * ISO 3166 Codes (Countries)
 * 
 * @author ramin
 * 
 */
@SuppressWarnings("nls")
public enum RcplCountry {

	AALAND_ISLANDS("AX", "ALA", 248),

	AFGHANISTAN("AF", "AFG", 4),

	ALBANIA("AL", "ALB", 8),

	ALGERIA("DZ", "DZA", 12), AMERICAN_SAMOA("AS", "ASM", 16),

	ANDORRA("AD", "AND", 20), ANGOLA("AO", "AGO", 24), ANGUILLA("AI", "AIA", 660),

	ANTARCTICA("AQ", "ATA", 10), ANTIGUA_AND_BARBUDA("AG", "ATG", 28),

	ARGENTINA("AR", "ARG", 32),

	ARMENIA("AM", "ARM", 51),

	ARUBA("AW", "ABW", 533),

	AUSTRALIA("AU", "AUS", 36),

	AUSTRIA("AT", "AUT", 40),

	AZERBAIJAN("AZ", "AZE", 31),

	BAHAMAS("BS", "BHS", 44), BAHRAIN("BH", "BHR", 48),

	BANGLADESH("BD", "BGD", 50), BARBADOS("BB", "BRB", 52),

	BELARUS("BY", "BLR", 112),

	BELGIUM("BE", "BEL", 56), BELIZE("BZ", "BLZ", 84),

	BENIN("BJ", "BEN", 204),

	BERMUDA("BM", "BMU", 60),

	BHUTAN("BT", "BTN", 64),

	BOLIVIA("BO", "BOL", 68),

	BOSNIA_AND_HERZEGOWINA("BA", "BIH", 70),

	BOTSWANA("BW", "BWA", 72),

	BOUVET_ISLAND("BV", "BVT", 74),

	BRAZIL("BR", "BRA", 76),

	BRITISH_INDIAN_OCEAN_TERRITORY("IO", "IOT", 86),

	BRUNEI_DARUSSALAM("BN", "BRN", 96),

	BULGARIA("BG", "BGR", 100), BURKINA_FASO("BF", "BFA", 854),

	BURUNDI("BI", "BDI", 108), CAMBODIA("KH", "KHM", 116),

	CAMEROON("CM", "CMR", 120),

	CANADA("CA", "CAN", 124), CAPE_VERDE("CV", "CPV", 132),

	CAYMAN_ISLANDS("KY", "CYM", 136),

	CENTRAL_AFRICAN_REPUBLIC("CF", "CAF", 140), CHAD("TD", "TCD", 148),

	CHILE("CL", "CHL", 152), CHINA("CN", "CHN", 156),

	CHRISTMAS_ISLAND("CX", "CXR", 162), COCOS_KEELING_ISLANDS("CC", "CCK", 166), COLOMBIA("CO", "COL", 170),
	COMOROS("KM", "COM", 174), CONGO_Democratic_Republic_of_was_Zaire("CD", "COD", 180),
	CONGO_Republic_of("CG", "COG", 178), COOK_ISLANDS("CK", "COK", 184), COSTA_RICA("CR", "CRI", 188),
	COTE_D_IVOIRE("CI", "CIV", 384), CROATIA_local_name_Hrvatska("HR", "HRV", 191), CUBA("CU", "CUB", 192),
	CYPRUS("CY", "CYP", 196), CZECH_REPUBLIC("CZ", "CZE", 203), DENMARK("DK", "DNK", 208),

	DJIBOUTI("DJ", "DJI", 262), DOMINICA("DM", "DMA", 212),

	DOMINICAN_REPUBLIC("DO", "DOM", 214), ECUADOR("EC", "ECU", 218), EGYPT("EG", "EGY", 818),

	EL_SALVADOR("SV", "SLV", 222), EQUATORIAL_GUINEA("GQ", "GNQ", 226), ERITREA("ER", "ERI", 232),
	ESTONIA("EE", "EST", 233), ETHIOPIA("ET", "ETH", 231), FALKLAND_ISLANDS_MALVINAS("FK", "FLK", 238),
	FAROE_ISLANDS("FO", "FRO", 234), FIJI("FJ", "FJI", 242),

	FINLAND("FI", "FIN", 246), FRANCE("FR", "FRA", 250), FRENCH_GUIANA("GF", "GUF", 254),

	RENCH_POLYNESIA("PF", "PYF", 258), FRENCH_SOUTHERN_TERRITORIES("TF", "ATF", 260), GABON("GA", "GAB", 266),
	GAMBIA("GM", "GMB", 270), GEORGIA("GE", "GEO", 268), GERMANY("DE", "DEU", 276), GHANA("GH", "GHA", 288),
	GIBRALTAR("GI", "GIB", 292),

	GREECE("GR", "GRC", 300), GREENLAND("GL", "GRL", 304),

	GRENADA("GD", "GRD", 308), GUADELOUPE("GP", "GLP", 312), GUAM("GU", "GUM", 316), GUATEMALA("GT", "GTM", 320),
	GUINEA("GN", "GIN", 324), GUINEA_BISSAU("GW", "GNB", 624), GUYANA("GY", "GUY", 328), HAITI("HT", "HTI", 332),
	HEARD_AND_MC_DONALD_ISLANDS("HM", "HMD", 334), HONDURAS("HN", "HND", 340), HONG_KONG("HK", "HKG", 344),

	HUNGARY("HU", "HUN", 348), ICELAND("IS", "ISL", 352), INDIA("IN", "IND", 356), INDONESIA("ID", "IDN", 360),
	IRAN_ISLAMIC_REPUBLIC_OF("IR", "IRN", 364), IRAQ("IQ", "IRQ", 368), IRELAND("IE", "IRL", 372),
	ISRAEL("IL", "ISR", 376), ITALY("IT", "ITA", 380), JAMAICA("JM", "JAM", 388), JAPAN("JP", "JPN", 392),
	JORDAN("JO", "JOR", 400), KAZAKHSTAN("KZ", "KAZ", 398), KENYA("KE", "KEN", 404), KIRIBATI("KI", "KIR", 296),
	KOREA_DEMOCRATIC_PEOPLES_REPUBLIC_OF("KP", "PRK", 408), KOREA_REPUBLIC_OF("KR", "KOR", 410),
	KUWAIT("KW", "KWT", 414), KYRGYZSTAN("KG", "KGZ", 417), LAO_PEOPLES_DEMOCRATIC_REPUBLIC("LA", "LAO", 418),
	LATVIA("LV", "LVA", 428), LEBANON("LB", "LBN", 422), LESOTHO("LS", "LSO", 426), LIBERIA("LR", "LBR", 430),
	LIBYAN_ARAB_JAMAHIRIYA("LY", "LBY", 434), LIECHTENSTEIN("LI", "LIE", 438), LITHUANIA("LT", "LTU", 440),
	LUXEMBOURG("LU", "LUX", 442),

	MACAU("MO", "MAC", 446), MACEDONIA_THE_FORMER_YUGOSLAV_REPUBLIC_OF("MK", "MKD", 807), MADAGASCAR("MG", "MDG", 450),
	MALAWI("MW", "MWI", 454), MALAYSIA("MY", "MYS", 458), MALDIVES("MV", "MDV", 462), MALI("ML", "MLI", 466),
	MALTA("MT", "MLT", 470), MARSHALL_ISLANDS("MH", "MHL", 584), MARTINIQUE("MQ", "MTQ", 474),
	MAURITANIA("MR", "MRT", 478), MAURITIUS("MU", "MUS", 480), MAYOTTE("YT", "MYT", 175), MEXICO("MX", "MEX", 484),
	MICRONESIA_FEDERATED_STATES_OF("FM", "FSM", 583), MOLDOVA_REPUBLIC_OF("MD", "MDA", 498), MONACO("MC", "MCO", 492),
	MONGOLIA("MN", "MNG", 496), MONTSERRAT("MS", "MSR", 500), MOROCCO("MA", "MAR", 504), MOZAMBIQUE("MZ", "MOZ", 508),
	MYANMAR("MM", "MMR", 104), NAMIBIA("NA", "NAM", 516), NAURU("NR", "NRU", 520), NEPAL("NP", "NPL", 524),
	NETHERLANDS("NL", "NLD", 528), NETHERLANDS_ANTILLES("AN", "ANT", 530), NEW_CALEDONIA("NC", "NCL", 540),
	NEW_ZEALAND("NZ", "NZL", 554), NICARAGUA("NI", "NIC", 558), NIGER("NE", "NER", 562), NIGERIA("NG", "NGA", 566),
	NIUE("NU", "NIU", 570), NORFOLK_ISLAND("NF", "NFK", 574), NORTHERN_MARIANA_ISLANDS("MP", "MNP", 580),
	NORWAY("NO", "NOR", 578), OMAN("OM", "OMN", 512), PAKISTAN("PK", "PAK", 586), PALAU("PW", "PLW", 585),
	PALESTINIAN_TERRITORY_Occupied("PS", "PSE", 275), PANAMA("PA", "PAN", 591), PAPUA_NEW_GUINEA("PG", "PNG", 598),
	PARAGUAY("PY", "PRY", 600), PERU("PE", "PER", 604), PHILIPPINES("PH", "PHL", 608), PITCAIRN("PN", "PCN", 612),
	POLAND("PL", "POL", 616), PORTUGAL("PT", "PRT", 620), PUERTO_RICO("PR", "PRI", 630), QATAR("QA", "QAT", 634),
	REUNION("RE", "REU", 638), ROMANIA("RO", "ROU", 642), RUSSIAN_FEDERATION("RU", "RUS", 643),
	RWANDA("RW", "RWA", 646), SAINT_HELENA("SH", "SHN", 654), SAINT_KITTS_AND_NEVIS("KN", "KNA", 659),
	SAINT_LUCIA("LC", "LCA", 662), SAINT_PIERRE_AND_MIQUELON("PM", "SPM", 666),
	SAINT_VINCENT_AND_THE_GRENADINES("VC", "VCT", 670), SAMOA("WS", "WSM", 882), SAN_MARINO("SM", "SMR", 674),
	SAO_TOME_AND_PRINCIPE("ST", "STP", 678), SAUDI_ARABIA("SA", "SAU", 682), SENEGAL("SN", "SEN", 686),
	SERBIA_AND_MONTENEGRO("CS", "SCG", 891), SEYCHELLES("SC", "SYC", 690), SIERRA_LEONE("SL", "SLE", 694),
	SINGAPORE("SG", "SGP", 702), SLOVAKIA("SK", "SVK", 703), SLOVENIA("SI", "SVN", 705),
	SOLOMON_ISLANDS("SB", "SLB", 90), SOMALIA("SO", "SOM", 706), SOUTH_AFRICA("ZA", "ZAF", 710),
	SOUTH_GEORGIA_AND_THE_SOUTH_SANDWICH_ISLANDS("GS", "SGS", 239), SPAIN("ES", "ESP", 724),
	SRI_LANKA("LK", "LKA", 144), SUDAN("SD", "SDN", 736), SURINAME("SR", "SUR", 740),
	SVALBARD_AND_JAN_MAYEN_ISLANDS("SJ", "SJM", 744), SWAZILAND("SZ", "SWZ", 748), SWEDEN("SE", "SWE", 752),
	SWITZERLAND("CH", "CHE", 756), SYRIAN_ARAB_REPUBLIC("SY", "SYR", 760), TAIWAN("TW", "TWN", 158),
	TAJIKISTAN("TJ", "TJK", 762), TANZANIA_UNITED_REPUBLIC_OF("TZ", "TZA", 834), THAILAND("TH", "THA", 764),
	TIMOR_LESTE("TL", "TLS", 626), TOGO("TG", "TGO", 768), TOKELAU("TK", "TKL", 772), TONGA("TO", "TON", 776),
	TRINIDAD_AND_TOBAGO("TT", "TTO", 780), TUNISIA("TN", "TUN", 788), TURKEY("TR", "TUR", 792),
	TURKMENISTAN("TM", "TKM", 795), TURKS_AND_CAICOS_ISLANDS("TC", "TCA", 796), TUVALU("TV", "TUV", 798),
	UGANDA("UG", "UGA", 800),

	UKRAINE("UA", "UKR", 804),

	UNITED_ARAB_EMIRATES("AE", "ARE", 784),

	UNITED_KINGDOM("GB", "GBR", 826),

	UNITED_STATES("US", "USA", 840),

	UNITED_STATES_MINOR_OUTLYING_ISLANDS("UM", "UMI", 581),

	URUGUAY("UY", "URY", 858),

	UZBEKISTAN("UZ", "UZB", 860),

	VANUATU("VU", "VUT", 548),

	VATICAN_CITY_STATE_HOLY_SEE("VA", "VAT", 336),

	VENEZUELA("VE", "VEN", 862), VIET_NAM("VN", "VNM", 704),

	VIRGIN_ISLANDS_BRITISH("VG", "VGB", 92), VIRGIN_ISLANDS_U_S("VI", "VIR", 850),
	WALLIS_AND_FUTUNA_ISLANDS("WF", "WLF", 876), WESTERN_SAHARA("EH", "ESH", 732), YEMEN("YE", "YEM", 887),
	ZAMBIA("ZM", "ZMB", 894), ZIMBABWE("ZW", "ZWE", 716),;

	private String a2;
	private String a3;
	private int code;

	/**
	 * @param a2
	 * @param a3
	 * @param code
	 */
	RcplCountry(String a2, String a3, int code) {
		this.a2 = a2;
		this.a3 = a3;
		this.code = code;
	}

	/**
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Enum[] getValues() {
		return values();
	}

	/**
	 * @return
	 */
	public String getA2() {
		return a2;
	}

	/**
	 * @return
	 */
	public String getA3() {
		return a3;
	}

	/**
	 * @return
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @return
	 */
	public String getDisplayName() {
		return toString();
	}

	/**
	 * @param locale
	 * @return
	 */
	public static RcplCountry getCountry(Locale locale) {
		String cc = locale.getCountry();
		for (RcplCountry c : values()) {
			if (c.getA2().equals(cc)) {
				return c;
			}
		}
		return null;
	}

	/**
	 * @return
	 */
	public IImage getImage() {
		return Rcpl.get().resources().getImage("domain_" + a2, 16, 16);
	}
}
