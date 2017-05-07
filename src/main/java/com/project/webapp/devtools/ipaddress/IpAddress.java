/**
 * 
 */
package com.project.webapp.devtools.ipaddress;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	

	@RequestMapping(value="ipaddress/{id}/resolve", method=RequestMethod.GET)
	public String getIpAddressByHostName(@PathVariable("id") String id) throws UnknownHostException{
		
		InetAddress inetAddress = InetAddress.getByName(id);
		
		return inetAddress.getHostAddress();
	}
	
	@RequestMapping(value="hostname/{id}/resolve", method=RequestMethod.GET)
	public String getHostNameByIpAddress(@PathVariable("id") String id) throws UnknownHostException{
		
		InetAddress inetAddress = InetAddress.getByName(id);
		
		return inetAddress.getHostName();
	}
	
	@RequestMapping(value="ping/{id}/resolve", method=RequestMethod.GET)
	public String pingIpAddressOrHost(@PathVariable("id") String id) throws IOException{
		
		InetAddress inetAddress = InetAddress.getByName(id);
		if(inetAddress.isReachable(5000)){
			return "Host is Reachable";
		}else{
			return "Host is not Reachable";
		}
	}
	
	
	
}
