/**
 * 
 */
package com.project.webapp.devtools.holidays;

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
import com.project.webapp.devtools.util.ConstantValues;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class Holidays {
	
	// unable to find valid certification path to requested target

	/*sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target
	at sun.security.provider.certpath.SunCertPathBuilder.build(Unknown Source) ~[na:1.8.0_91]
	at sun.security.provider.certpath.SunCertPathBuilder.engineBuild(Unknown Source) ~[na:1.8.0_91]
	at java.security.cert.CertPathBuilder.build(Unknown Source) ~[na:1.8.0_91]
	at sun.security.validator.PKIXValidator.doBuild(Unknown Source) ~[na:1.8.0_91]
	at sun.security.validator.PKIXValidator.engineValidate(Unknown Source) ~[na:1.8.0_91]
	at sun.security.validator.Validator.validate(Unknown Source) ~[na:1.8.0_91]
	at sun.security.ssl.X509TrustManagerImpl.validate(Unknown Source) ~[na:1.8.0_91]
	at sun.security.ssl.X509TrustManagerImpl.checkTrusted(Unknown Source) ~[na:1.8.0_91]
	at sun.security.ssl.X509TrustManagerImpl.checkServerTrusted(Unknown Source) ~[na:1.8.0_91]
	at sun.security.ssl.ClientHandshaker.serverCertificate(Unknown Source) ~[na:1.8.0_91]
	at sun.security.ssl.ClientHandshaker.processMessage(Unknown Source) ~[na:1.8.0_91]
	at sun.security.ssl.Handshaker.processLoop(Unknown Source) ~[na:1.8.0_91]
	at sun.security.ssl.Handshaker.process_record(Unknown Source) ~[na:1.8.0_91]
	at sun.security.ssl.SSLSocketImpl.readRecord(Unknown Source) ~[na:1.8.0_91]
	at sun.security.ssl.SSLSocketImpl.performInitialHandshake(Unknown Source) ~[na:1.8.0_91]
	at sun.security.ssl.SSLSocketImpl.startHandshake(Unknown Source) ~[na:1.8.0_91]
	at sun.security.ssl.SSLSocketImpl.startHandshake(Unknown Source) ~[na:1.8.0_91]
	at org.apache.http.conn.ssl.SSLConnectionSocketFactory.createLayeredSocket(SSLConnectionSocketFactory.java:396) ~[httpclient-4.5.3.jar:4.5.3]
	at org.apache.http.conn.ssl.SSLConnectionSocketFactory.connectSocket(SSLConnectionSocketFactory.java:355) ~[httpclient-4.5.3.jar:4.5.3]
	at org.apache.http.impl.conn.DefaultHttpClientConnectionOperator.connect(DefaultHttpClientConnectionOperator.java:142) ~[httpclient-4.5.3.jar:4.5.3]
	at org.apache.http.impl.conn.PoolingHttpClientConnectionManager.connect(PoolingHttpClientConnectionManager.java:359) ~[httpclient-4.5.3.jar:4.5.3]
	at org.apache.http.impl.execchain.MainClientExec.establishRoute(MainClientExec.java:381) ~[httpclient-4.5.3.jar:4.5.3]
	at org.apache.http.impl.execchain.MainClientExec.execute(MainClientExec.java:237) ~[httpclient-4.5.3.jar:4.5.3]
	at org.apache.http.impl.execchain.ProtocolExec.execute(ProtocolExec.java:185) ~[httpclient-4.5.3.jar:4.5.3]
	at org.apache.http.impl.execchain.RetryExec.execute(RetryExec.java:89) ~[httpclient-4.5.3.jar:4.5.3]
	at org.apache.http.impl.execchain.RedirectExec.execute(RedirectExec.java:111) ~[httpclient-4.5.3.jar:4.5.3]
	at org.apache.http.impl.client.InternalHttpClient.doExecute(InternalHttpClient.java:185) ~[httpclient-4.5.3.jar:4.5.3]
	at org.apache.http.impl.client.CloseableHttpClient.execute(CloseableHttpClient.java:83) ~[httpclient-4.5.3.jar:4.5.3]
	at org.apache.http.impl.client.CloseableHttpClient.execute(CloseableHttpClient.java:108) ~[httpclient-4.5.3.jar:4.5.3]
	at org.apache.http.impl.client.CloseableHttpClient.execute(CloseableHttpClient.java:56) ~[httpclient-4.5.3.jar:4.5.3]
	at com.mashape.unirest.http.HttpClientHelper.request(HttpClientHelper.java:138) ~[unirest-java-1.4.9.jar:na]
	at com.mashape.unirest.request.BaseRequest.asString(BaseRequest.java:56) ~[unirest-java-1.4.9.jar:na]
	at com.project.webapp.devtools.holidays.Holidays.getHolidayInformationByCountryYearMonth(Holidays.java:30) ~[classes/:na]
*/
	@RequestMapping(value="holiday/country/{country}/year/{year}/month/{month}",method=RequestMethod.GET)
	public JSONObject getHolidayInformationByCountryYearMonth(@PathVariable("country") String country, @PathVariable("year") String year, @PathVariable("month") String month) throws UnirestException, ParseException{
		
		HttpResponse<String> response = Unirest.get("https://holidayapi.com/v1/holidays?key="+ConstantValues.API_KEY_HOLIDAYS+"&country="+country+"&year="+year+"&month="+month)
				.asString();
		
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(response.getBody());
		
		return json;
	}

}
