/**
 * 
 */
package com.project.webapp.devtools.ipaddress;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.webapp.devtools.model.PortScanModel;

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
	
	@RequestMapping(value="connected/internet", method = RequestMethod.GET)
	public static Boolean netIsAvailable() {
	    try {
	        final URL url = new URL("http://www.google.com");
	        final URLConnection conn = url.openConnection();
	        conn.connect();
	        return true;
	    } catch (MalformedURLException e) {
	        throw new RuntimeException(e);
	    } catch (IOException e) {
	        return false;
	    }
	}
	
	@RequestMapping(value="host/{host}/port/{port}/listen", method=RequestMethod.GET)
	public static PortScanModel serverListening(@PathVariable("host") String host, @PathVariable("port") int port)
	{
		PortScanModel portScanModel = new PortScanModel();
		
	    Socket s = null;
	    try
	    {
	        s = new Socket(host, port);
	        portScanModel.setHost(host);
	        portScanModel.setMessage("Port in use");
	        portScanModel.setPort(port);
	        portScanModel.setIsOpen(true);
	        return portScanModel;
	    }
	    catch (Exception e)
	    {
	    	
	        portScanModel.setHost(host);
	        portScanModel.setMessage("Port not in use");
	        portScanModel.setPort(port);
	        portScanModel.setIsOpen(false);
	        return portScanModel;
	    }
	    finally
	    {
	        if(s != null)
	            try {s.close();}
	            catch(Exception e){}
	    }
	}
	
	
	@RequestMapping(value="host/{host}/port/{start}/range/{end}", method = RequestMethod.GET)
	public List<PortScanModel> getAvaiablePorts(@PathVariable("host") String host, @PathVariable("start") Integer start, @PathVariable("end") Integer end){
		
		List<PortScanModel> portScanModelList = new ArrayList<PortScanModel>();
		
		for(int i= start;i<end;i++){
			PortScanModel portScanModel = new PortScanModel();
			
		    Socket s = null;
		    try
		    {
		        s = new Socket(host, i);
		        portScanModel.setHost(host);
		        portScanModel.setMessage("Port in use");
		        portScanModel.setPort(i);
		        portScanModel.setIsOpen(true);
		        portScanModelList.add(portScanModel);
		    }
		    catch (Exception e)
		    {
		    	
		        portScanModel.setHost(host);
		        portScanModel.setMessage("Port not in use");
		        portScanModel.setPort(i);
		        portScanModel.setIsOpen(false);
		        portScanModelList.add(portScanModel);
		    }
		    finally
		    {
		        if(s != null)
		            try {s.close();}
		            catch(Exception e){}
		    }
		}
		
		return portScanModelList;
		
	}
	
	
}
