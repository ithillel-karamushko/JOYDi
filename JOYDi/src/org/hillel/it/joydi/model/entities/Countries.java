package org.hillel.it.joydi.model.entities;

public enum Countries {
	Afghanistan("Afghanistan"), Albania("Albania"), Algeria("Algeria"), Andorra(
			"Andorra"), Angola("Angola"), Antigua_and_Barbuda(
			"Antigua and Barbuda"), Argentina("Argentina"), Armenia("Armenia"), Australia(
			"Australia"), Austria("Austria"), Azerbaijan("Azerbaijan"), Bahamas(
			"Bahamas"), Bahrain("Bahrain"), Bangladesh("Bangladesh"), Barbados(
			"Barbados"), Belarus("Belarus"), Belgium("Belgium"), Belize(
			"Belize"), Benin("Benin"), Bhutan("Bhutan"), Bolivia("Bolivia"), Bosnia_and_Herzegovina(
			"Bosnia and Herzegovina"), Botswana("Botswana"), Brazil("Brazil"), Brunei(
			"Brunei"), Bulgaria("Bulgaria"), Burkina_Faso("Burkina Faso"), Burma(
			"Burma"), Burundi("Burundi"), Cambodia("Cambodia"), Cameroon(
			"Cameroon"), Canada("Canada"), Cape_Verde("Cape Verde"), Central_African_Republic(
			"Central African Republic"), Chad("Chad"), Chile("Chile"), China(
			"China"), Colombia("Colombia"), Comoros("Comoros"), Congo("Congo"), Costa_Rica(
			"Costa Rica"), Cote_dIvoire("Cote dIvoire"), Croatia("Croatia"), Cuba(
			"Cuba"), Cyprus("Cyprus"), Czech_Republic("Czech Republic"), Denmark(
			"Denmark"), Djibouti("Djibouti"), Dominica("Dominica"), Dominican_Republic(
			"Dominican Republic"), East_Timor("East Timor"), Ecuador("Ecuador"), Egypt(
			"Egypt"), El_Salvador("El Salvador"), England("England"), Equatorial_Guinea(
			"Equatorial Guinea"), Eritrea("Eritrea"), Estonia("Estonia"), Ethiopia(
			"Ethiopia"), Faroese("Faroese"), Fiji("Fiji"), Finland("Finland"), France(
			"France"), Gabon("Gabon"), Gambia("Gambia"), Georgia("Georgia"), Germany(
			"Germany"), Ghana("Ghana"), Greece("Greece"), Grenada("Grenada"), Guatemala(
			"Guatemala"), Guinea("Guinea"), Guinea_Bissau("Guinea-Bissau"), Guyana(
			"Guyana"), Haiti("Haiti"), Honduras("Honduras"), Hong_Kong(
			"Hong Kong"), Hungary("Hungary"), Iceland("Iceland"), India("India"), Indonesia(
			"Indonesia"), Iran("Iran"), Iraq("Iraq"), Ireland("Ireland"), Isle_of_Man(
			"Isle of Man"), Israel("Israel"), Italy("Italy"), Jamaica("Jamaica"), Japan(
			"Japan"), Jordan("Jordan"), Kazakhstan("Kazakhstan"), Kenya("Kenya"), Kiribati(
			"Kiribati"), Korea("Korea"), Korea_North("Korea, North"), Kosovo(
			"Kosovo"), Kuwait("Kuwait"), Kyrgyzstan("Kyrgyzstan"), Laos("Laos"), Latvia(
			"Latvia"), Lebanon("Lebanon"), Lesotho("Lesotho"), Liberia(
			"Liberia"), Libya("Libya"), Liechtenstein("Liechtenstein"), Lithuania(
			"Lithuania"), Luxembourg("Luxembourg"), Macau("Macau"), Macedonia(
			"Macedonia"), Madagascar("Madagascar"), Malawi("Malawi"), Malaysia(
			"Malaysia"), Maldives("Maldives"), Mali("Mali"), Malta("Malta"), Marshall_Islands(
			"Marshall Islands"), Mauritania("Mauritania"), Mauritius(
			"Mauritius"), Mexico("Mexico"), Micronesia("Micronesia"), Moldova(
			"Moldova"), Monaco("Monaco"), Mongolia("Mongolia"), Montenegro(
			"Montenegro"), Morocco("Morocco"), Mozambique("Mozambique"), Namibia(
			"Namibia"), Nauru("Nauru"), Nepal("Nepal"), Netherlands(
			"Netherlands"), New_Zealand("New Zealand"), Nicaragua("Nicaragua"), Niger(
			"Niger"), Nigeria("Nigeria"), Norway("Norway"), Oman("Oman"), Pakistan(
			"Pakistan"), Palau("Palau"), Panama("Panama"), Papua_New_Guinea(
			"Papua New Guinea"), Paraguay("Paraguay"), Peru("Peru"), Philippines(
			"Philippines"), Poland("Poland"), Portugal("Portugal"), Puerto_Rico(
			"Puerto Rico"), Qatar("Qatar"), Romania("Romania"), Russia("Russia"), Rwanda(
			"Rwanda"), Saint_Kitts_and_Nevis("Saint Kitts and Nevis"), Saint_Lucia(
			"Saint Lucia"), Saint_Vincent_and_the_Grenadines(
			"Saint Vincent and the Grenadines"), Samoa("Samoa"), San_Marino(
			"San Marino"), Sao_Tome_and_Principe("Sao Tome and Principe"), Saudi_Arabia(
			"Saudi Arabia"), Scotland("Scotland"), Senegal("Senegal"), Serbia(
			"Serbia"), Seychelles("Seychelles"), Sierra_Leone("Sierra Leone"), Singapore(
			"Singapore"), Slovakia("Slovakia"), Slovenia("Slovenia"), Solomon_Islands(
			"Solomon Islands"), Somalia("Somalia"), South_Africa("South Africa"), South_Korea(
			"South Korea"), Spain("Spain"), Sri_Lanka("Sri Lanka"), Sudan(
			"Sudan"), Suriname("Suriname"), Swaziland("Swaziland"), Sweden(
			"Sweden"), Switzerland("Switzerland"), Syria("Syria"), Taiwan(
			"Taiwan"), Tajikistan("Tajikistan"), Tanzania("Tanzania"), Thailand(
			"Thailand"), Togo("Togo"), Tonga("Tonga"), Trinidad_and_Tobago(
			"Trinidad and Tobago"), Tunisia("Tunisia"), Turkey("Turkey"), Turkmenistan(
			"Turkmenistan"), Tuvalu("Tuvalu"), Uganda("Uganda"), Ukraine(
			"Ukraine"), United_Arab_Emirates("United Arab Emirates"), United_Kingdom(
			"United Kingdom"), United_States_of_America(
			"United States of America"), Uruguay("Uruguay"), Uzbekistan(
			"Uzbekistan"), Vanuatu("Vanuatu"), Vatican_City("Vatican City"), Venezuela(
			"Venezuela"), Vietnam("Vietnam"), Wales("Wales"), Yemen("Yemen"), Zambia(
			"Zambia"), Zimbabwe("Zimbabwe");

	private String text;

	private Countries(String text) {
		this.text = text;

	}

	public String getText() {
		return text;

	}
}
