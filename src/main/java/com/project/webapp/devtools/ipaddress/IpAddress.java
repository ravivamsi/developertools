/**
 * 
 */
package com.project.webapp.devtools.ipaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.jni.Address;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.project.webapp.devtools.util.ConstantValues;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class IpAddress {

	@RequestMapping(value="ipaddress/{id}",method=RequestMethod.GET)
	public List<String> getIpAddressList(@PathVariable String id){
		List<String> inetAddressList = new ArrayList<String>();
		try {
			for(InetAddress addr : InetAddress.getAllByName(id)){
				inetAddressList.add(addr.getHostAddress());	
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return inetAddressList;
	}
	
	// Doesn't Work
	@RequestMapping(value="ip/address/{id}", method=RequestMethod.GET)
	public String getIpAddressDetails(@PathVariable String id){
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> variables = new HashMap<String, String>();
		String result = restTemplate.getForObject("https://freegeoip.net/json/"+id,  String.class, variables);
		return result;
	}
	
}
