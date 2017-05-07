/**
 * 
 */
package com.project.webapp.devtools.zip;

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
