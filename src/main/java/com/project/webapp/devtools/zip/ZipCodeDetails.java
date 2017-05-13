/**
 * 
 */
package com.project.webapp.devtools.zip;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class ZipCodeDetails {

	@RequestMapping(value="zip/{country}/{zip}", method=RequestMethod.GET)
	public JSONObject getZipDetails(@PathVariable("country") String country, @PathVariable("zip") String zip) throws UnirestException, ParseException{
		HttpResponse<String> response = Unirest.get("https://api.zippopotam.us/"+country+"/"+zip)
				.asString();
		
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(response.getBody());
		return json;
	}
	
	@RequestMapping(value="zip/countries", method=RequestMethod.GET)
	public List<String> getZipCountries(){
		List<String> countriesList = new ArrayList<String>();
		
		countriesList.add("Andorra						AD		AD100 : AD700");
		countriesList.add("Argentina					AR		1601 : 9431");
		countriesList.add("American Samoa				AS		96799 : 96799");
		countriesList.add("Austria						AT		1010 : 9992");
		countriesList.add("Australia					AU		0200 : 9726");
		countriesList.add("Bangladesh					BD		1000 : 9461");
		countriesList.add("Belgium						BE		1000 : 9992");
		countriesList.add("Bulgaria						BG		1000 : 9974");
		countriesList.add("Brazil						BR		01000-000 : 99990-000");
		countriesList.add("Canada						CA		A0A : Y1A");
		countriesList.add("Switzerland					CH		1000 : 9658");
		countriesList.add("Czech Republic				CZ		100 00 : 798 62");
		countriesList.add("Germany						DE		01067 : 99998");
		countriesList.add("Denmark						DK		0800 : 9990	");
		countriesList.add("Dominican Republic			DO		10101 : 11906");
		countriesList.add("Spain						ES		01001 : 52080");
		countriesList.add("Finland						FI		00002 : 99999");
		countriesList.add("Faroe Islands				FO		100 : 970");
		countriesList.add("France						FR	 	01000 : 98799");
		countriesList.add("Great Britain				GB	 	AB1 : ZE3");
		countriesList.add("French Guyana				GF	 	97300 : 97390");
		countriesList.add("Guernsey						GG	 	GY1 : GY9");
		countriesList.add("Greenland					GL	 	2412 : 3992");
		countriesList.add("Guadeloupe					GP	 	97100 : 97190");
		countriesList.add("Guatemala					GT	 	01001 : 22027");
		countriesList.add("Guam							GU	 	96910 : 96932");
		countriesList.add("Guyana						GY	 	97312 : 97360");
		countriesList.add("Croatia						HR	 	10000 : 53296");
		countriesList.add("Hungary						HU	 	1011 : 9985");
		countriesList.add("Isle of Man					IM	 	IM1 : IM9");
		countriesList.add("India						IN	 	110001 : 855126");
		countriesList.add("Iceland						IS	 	101 : 902");
		countriesList.add("Italy						IT	 	00010 : 98168");
		countriesList.add("Jersey						JE	 	JE1 : JE3");
		countriesList.add("Japan						JP	 	100-0001 : 999-8531");
		countriesList.add("Liechtenstein				LI	 	9485 : 9498");
		countriesList.add("Sri Lanka					LK	  	* : 96167");
		countriesList.add("Lithuania					LT	 	00001 : 99069");
		countriesList.add("Luxembourg					LU	 	L-1009 : L-9999");
		countriesList.add("Monaco						MC	 	98000 : 98000");
		countriesList.add("Moldavia						MD	 	MD-2000 : MD-7731");
		countriesList.add("Marshall Islands				MH	 	96960 : 96970");
		countriesList.add("Macedonia					MK	 	1000 : 7550");
		countriesList.add("Northern Mariana Islands		MP	 	96950 : 96952");
		countriesList.add("Martinique					MQ	 	97200 : 97290");
		countriesList.add("Mexico						MX	 	01000 : 99998");
		countriesList.add("Malaysia						MY	 	01000 : 98859");
		countriesList.add("Holland						NL	 	1000 : 9999");
		countriesList.add("Norway						NO	 	0001 : 9991");
		countriesList.add("New Zealand					NZ	 	0110 : 9893");
		countriesList.add("Phillippines					PH	 	0400 : 9811");
		countriesList.add("Pakistan						PK	 	10010 : 97320");
		countriesList.add("Poland						PL	 	00-001 : 99-440");
		countriesList.add("Saint Pierre and Miquelon	PM	 	97500 : 97500");
		countriesList.add("Puerto Rico					PR	 	00601 : 00988");
		countriesList.add("Portugal						PT	 	1000-001 : 9980-999");
		countriesList.add("French Reunion				RE	 	97400 : 97490");
		countriesList.add("Russia						RU	 	101000 : 901993");
		countriesList.add("Sweden						SE	 	10005 : 98499");
		countriesList.add("Slovenia						SI	 	1000 : 9600");
		countriesList.add("Svalbard & Jan Mayen Islands	SJ	 	8099 : 9178");
		countriesList.add("Slovak Republic				SK	 	010 01 : 992 01");
		countriesList.add("San Marino					SM	 	47890 : 47899");
		countriesList.add("Thailand						TH	 	10100 : 96220");
		countriesList.add("Turkey						TR	 	01000 : 81950");
		countriesList.add("United States				US	 	00210 : 99950");
		countriesList.add("Vatican						VA	 	00120 : 00120");
		countriesList.add("Virgin Islands				VI	 	00801 : 00851");
		countriesList.add("Mayotte						YT	 	97600 : 97680");
		countriesList.add("South Africa					ZA	 	0002 : 9992");
		
		return countriesList;
		
	}
	
	@RequestMapping(value="zip/countries/list", method=RequestMethod.GET)
	public Map<String, String> getZipCountriesList(){
		Map<String, String> countriesMap = new HashMap<String, String>();
		
		countriesMap.put("AD","Andorra								AD100 : AD700");
		countriesMap.put("AR","Argentina							1601 : 9431");
		countriesMap.put("AS","American Samoa						96799 : 96799");
		countriesMap.put("AU","Austria								1010 : 9992");
		countriesMap.put("AT","Australia							0200 : 9726");
		countriesMap.put("BD","Bangladesh							1000 : 9461");
		countriesMap.put("BE","Belgium								1000 : 9992");
		countriesMap.put("BG","Bulgaria								1000 : 9974");
		countriesMap.put("BR","Brazil								01000-000 : 99990-000");
		countriesMap.put("CA","Canada								A0A : Y1A");
		countriesMap.put("CH","Switzerland							1000 : 9658");
		countriesMap.put("CZ","Czech Republic						100 00 : 798 62");
		countriesMap.put("DE","Germany								01067 : 99998");
		countriesMap.put("DK","Denmark								0800 : 9990	");
		countriesMap.put("DO","Dominican Republic					10101 : 11906");
		countriesMap.put("ES","Spain								01001 : 52080");
		countriesMap.put("FI","Finland								00002 : 99999");
		countriesMap.put("FO","Faroe Islands						100 : 970");
		countriesMap.put("FR","France							 	01000 : 98799");
		countriesMap.put("GB","Great Britain					 	AB1 : ZE3");
		countriesMap.put("GF","French Guyana					 	97300 : 97390");
		countriesMap.put("GG","Guernsey							 	GY1 : GY9");
		countriesMap.put("GL","Greenland						 	2412 : 3992");
		countriesMap.put("GP","Guadeloupe						 	97100 : 97190");
		countriesMap.put("GT","Guatemala						 	01001 : 22027");
		countriesMap.put("GU","Guam								 	96910 : 96932");
		countriesMap.put("GY","Guyana							 	97312 : 97360");
		countriesMap.put("HR","Croatia							 	10000 : 53296");
		countriesMap.put("HU","Hungary							 	1011 : 9985");
		countriesMap.put("IM","Isle of Man						 	IM1 : IM9");
		countriesMap.put("IN","India							 	110001 : 855126");
		countriesMap.put("IS","Iceland							 	101 : 902");
		countriesMap.put("IT","Italy							 	00010 : 98168");
		countriesMap.put("JE","Jersey							 	JE1 : JE3");
		countriesMap.put("JP","Japan							 	100-0001 : 999-8531");
		countriesMap.put("LI","Liechtenstein					 	9485 : 9498");
		countriesMap.put("LK","Sri Lanka						  	* : 96167");
		countriesMap.put("LT","Lithuania						 	00001 : 99069");
		countriesMap.put("LU","Luxembourg						 	L-1009 : L-9999");
		countriesMap.put("MC","Monaco							 	98000 : 98000");
		countriesMap.put("MD","Moldavia							 	MD-2000 : MD-7731");
		countriesMap.put("MH","Marshall Islands					 	96960 : 96970");
		countriesMap.put("MK","Macedonia						 	1000 : 7550");
		countriesMap.put("MP","Northern Mariana Islands			 	96950 : 96952");
		countriesMap.put("MQ","Martinique						 	97200 : 97290");
		countriesMap.put("MX","Mexico							 	01000 : 99998");
		countriesMap.put("MY","Malaysia							 	01000 : 98859");
		countriesMap.put("NL","Holland							 	1000 : 9999");
		countriesMap.put("NO","Norway							 	0001 : 9991");
		countriesMap.put("NZ","New Zealand						 	0110 : 9893");
		countriesMap.put("PH","Phillippines						 	0400 : 9811");
		countriesMap.put("PK","Pakistan							 	10010 : 97320");
		countriesMap.put("PL","Poland							 	00-001 : 99-440");
		countriesMap.put("PM","Saint Pierre and Miquelon		 	97500 : 97500");
		countriesMap.put("PR","Puerto Rico						 	00601 : 00988");
		countriesMap.put("PT","Portugal							 	1000-001 : 9980-999");
		countriesMap.put("RE","French Reunion					 	97400 : 97490");
		countriesMap.put("RU","Russia							 	101000 : 901993");
		countriesMap.put("SE","Sweden							 	10005 : 98499");
		countriesMap.put("SI","Slovenia							 	1000 : 9600");
		countriesMap.put("SJ","Svalbard & Jan Mayen Islands		 	8099 : 9178");
		countriesMap.put("SK","Slovak Republic					 	010 01 : 992 01");
		countriesMap.put("SM","San Marino						 	47890 : 47899");
		countriesMap.put("TH","Thailand							 	10100 : 96220");
		countriesMap.put("TR","Turkey							 	01000 : 81950");
		countriesMap.put("US","United States					 	00210 : 99950");
		countriesMap.put("VA","Vatican							 	00120 : 00120");
		countriesMap.put("VI","Virgin Islands					 	00801 : 00851");
		countriesMap.put("YT","Mayotte							 	97600 : 97680");
		countriesMap.put("ZA","South Africa						 	0002 : 9992");
		
		return countriesMap;
		
	}
	
	/*
Country	Code	Example URL	Range	Count
Andorra	AD	api.zippopotam.us/AD/AD100	AD100 : AD700	7
Argentina	AR	api.zippopotam.us/AR/1601	1601 : 9431	20260
American Samoa	AS	api.zippopotam.us/AS/96799	96799 : 96799	1
Austria	AT	api.zippopotam.us/AT/1010	1010 : 9992	4877
Australia	AU	api.zippopotam.us/AU/0200	0200 : 9726	10161
Bangladesh	BD	api.zippopotam.us/BD/1000	1000 : 9461	1323
Belgium	BE	api.zippopotam.us/BE/1000	1000 : 9992	3386
Bulgaria	BG	api.zippopotam.us/BG/1000	1000 : 9974	5304
Brazil	BR	api.zippopotam.us/BR/01000-000	01000-000 : 99990-000	5526
Canada	CA	api.zippopotam.us/CA/A0A	A0A : Y1A	1621
Switzerland	CH	api.zippopotam.us/CH/1000	1000 : 9658	4614
Czech Republic	CZ	api.zippopotam.us/CZ/100 00	100 00 : 798 62	15507
Germany	DE	api.zippopotam.us/DE/01067	01067 : 99998	16482
Denmark	DK	api.zippopotam.us/DK/0800	0800 : 9990	1182
Dominican Republic	DO	api.zippopotam.us/DO/10101	10101 : 11906	546
Spain	ES	api.zippopotam.us/ES/01001	01001 : 52080	56542
Finland	FI	api.zippopotam.us/FI/00002	00002 : 99999	4637
Faroe Islands	FO	api.zippopotam.us/FO/100	100 : 970	130
France	FR	api.zippopotam.us/FR/01000	01000 : 98799	51129
Great Britain	GB	api.zippopotam.us/GB/AB1	AB1 : ZE3	27769
French Guyana	GF	api.zippopotam.us/GF/97300	97300 : 97390	25
Guernsey	GG	api.zippopotam.us/GG/GY1	GY1 : GY9	8
Greenland	GL	api.zippopotam.us/GL/2412	2412 : 3992	33
Guadeloupe	GP	api.zippopotam.us/GP/97100	97100 : 97190	33
Guatemala	GT	api.zippopotam.us/GT/01001	01001 : 22027	548
Guam	GU	api.zippopotam.us/GU/96910	96910 : 96932	23
Guyana	GY	api.zippopotam.us/GY/97312	97312 : 97360	9
Croatia	HR	api.zippopotam.us/HR/10000	10000 : 53296	6943
Hungary	HU	api.zippopotam.us/HU/1011	1011 : 9985	4041
Isle of Man	IM	api.zippopotam.us/IM/IM1	IM1 : IM9	86
India	IN	api.zippopotam.us/IN/110001	110001 : 855126	15226
Iceland	IS	api.zippopotam.us/IS/101	101 : 902	148
Italy	IT	api.zippopotam.us/IT/00010	00010 : 98168	19940
Jersey	JE	api.zippopotam.us/JE/JE1	JE1 : JE3	4
Japan	JP	api.zippopotam.us/JP/100-0001	100-0001 : 999-8531	94388
Liechtenstein	LI	api.zippopotam.us/LI/9485	9485 : 9498	13
Sri Lanka	LK	api.zippopotam.us/LK/ *	* : 96167	1832
Lithuania	LT	api.zippopotam.us/LT/00001	00001 : 99069	20558
Luxembourg	LU	api.zippopotam.us/LU/L-1009	L-1009 : L-9999	4334
Monaco	MC	api.zippopotam.us/MC/98000	98000 : 98000	29
Moldavia	MD	api.zippopotam.us/MD/MD-2000	MD-2000 : MD-7731	1753
Marshall Islands	MH	api.zippopotam.us/MH/96960	96960 : 96970	2
Macedonia	MK	api.zippopotam.us/MK/1000	1000 : 7550	220
Northern Mariana Islands	MP	api.zippopotam.us/MP/96950	96950 : 96952	4
Martinique	MQ	api.zippopotam.us/MQ/97200	97200 : 97290	34
Mexico	MX	api.zippopotam.us/MX/01000	01000 : 99998	75203
Malaysia	MY	api.zippopotam.us/MY/01000	01000 : 98859	2818
Holland	NL	api.zippopotam.us/NL/1000	1000 : 9999	5314
Norway	NO	api.zippopotam.us/NO/0001	0001 : 9991	4574
New Zealand	NZ	api.zippopotam.us/NZ/0110	0110 : 9893	1737
Phillippines	PH	api.zippopotam.us/PH/0400	0400 : 9811	2232
Pakistan	PK	api.zippopotam.us/PK/10010	10010 : 97320	11847
Poland	PL	api.zippopotam.us/PL/00-001	00-001 : 99-440	21980
Saint Pierre and Miquelon	PM	api.zippopotam.us/PM/97500	97500 : 97500	2
Puerto Rico	PR	api.zippopotam.us/PR/00601	00601 : 00988	187
Portugal	PT	api.zippopotam.us/PT/1000-001	1000-001 : 9980-999	204006
French Reunion	RE	api.zippopotam.us/RE/97400	97400 : 97490	37
Russia	RU	api.zippopotam.us/RU/101000	101000 : 901993	43538
Sweden	SE	api.zippopotam.us/SE/10005	10005 : 98499	16079
Slovenia	SI	api.zippopotam.us/SI/1000	1000 : 9600	557
Svalbard & Jan Mayen Islands	SJ	api.zippopotam.us/SJ/8099	8099 : 9178	8
Slovak Republic	SK	api.zippopotam.us/SK/010 01	010 01 : 992 01	4152
San Marino	SM	api.zippopotam.us/SM/47890	47890 : 47899	26
Thailand	TH	api.zippopotam.us/TH/10100	10100 : 96220	902
Turkey	TR	api.zippopotam.us/TR/01000	01000 : 81950	51379
United States	US	api.zippopotam.us/US/00210	00210 : 99950	43624
Vatican	VA	api.zippopotam.us/VA/00120	00120 : 00120	2
Virgin Islands	VI	api.zippopotam.us/VI/00801	00801 : 00851	16
Mayotte	YT	api.zippopotam.us/YT/97600	97600 : 97680	17
South Africa	ZA	api.zippopotam.us/ZA/0002	0002 : 9992	3920*/
}
