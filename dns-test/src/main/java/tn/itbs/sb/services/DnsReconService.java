package tn.itbs.sb.services;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import jakarta.annotation.PreDestroy;
import lombok.ToString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;









@Service
public class DnsReconService {
	
 

 
    
  public String testdns(String domain) {
    	
//    	public static List<String> testdns(String domain) {
//            List<String> testdns = new ArrayList<String>();
//            String[] command= {
//                  "/bin/sh",
//                  "-c",
//                  
//                  "echo " + "'Test Zone Transfer'"+";"+
//                  "dnsrecon -d "+ domain +" -t axfr | grep -E 'Zone Transfer'" +" ; "+
//                  "echo " + "'Test Records'"+";"+
//                  "dnsrecon -d " + domain + " -t " + "std" + " | grep -E 'DNSSEC| NS| MX | TXT | SOA | A | AAAA'" +" ; "+
//                  "echo " + "'Test DMARC'"+";"+
//                   
//                  "nslookup " + " -type=txt " + "_dmarc. " + domain +" ; "+
//                  
//					"echo " + "'Test SPF'"+";"+
//                  "nslookup " + "-type=txt " + domain +"| grep -E 'Server:|Address:|v='"
//              };
//            try {
//                HttpClient client = HttpClient.newHttpClient();
//                HttpRequest request = HttpRequest.newBuilder()
//                		
//                       //.uri(URI.create((command)))
//                       .build();
//                
//                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//                JSONObject data = new JSONObject(response.body());
//                // Vérifiez si la requête a réussi
//                if (response.statusCode() == 200) {
//                    JSONArray test = data.getJSONObject("data").getJSONArray("test");
//                    for (int i = 0; i < test.length(); i++) {
//                    	testdns.add(test.getJSONObject(i).getString("value"));
//                    }
//                }
//            } catch (IOException | InterruptedException | JSONException e) {
//                System.err.println("Une erreur s'est produite lors de la requête : " + e.getMessage());
//            }
//
//            return testdns;
//        } 
        try {
        	
        	 //String command = "dnsrecon -d " + domain + " -t " + "std" + "| grep -E 'DNSSEC| NS| MX | TXT | SOA | A | AAAA'" ;
        	String[] command = {
                    "/bin/sh",
                    "-c",
                    
                    "echo " + "'Test Zone Transfer'"+";"+
                    "dnsrecon -d "+ domain +" -t axfr | grep -E 'Zone Transfer'" +" ; "+
                    "echo " + "'Test Records'"+";"+
                    "dnsrecon -d " + domain + " -t " + "std" + " | grep -E 'DNSSEC| NS| MX | TXT | SOA | A | AAAA'" +" ; "+
                    "echo " + "'Test DMARC'"+";"+
                     
                    "nslookup " + " -type=txt " + "_dmarc. " + domain +" ; "+
                    
					"echo " + "'Test SPF'"+";"+
                    "nslookup " + "-type=txt " + domain +"| grep -E 'Server:|Address:|v='"
                };
        	
        	
            
        	Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
           
            StringBuilder output = new StringBuilder();
            String line;
                       
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
               
                 
            }
            
            return output.toString();
        
            
        } catch (Exception e) {
            return "Error executing DNS Zone transfer for domain: " + domain + "\n" + e.getMessage();
        }
    }
    
    
  
    public String bruteforce (String domain ,String path )  {
    	
    	
    	
    	try {
    		
    		String[] command = {
                    "/bin/sh",
                    "-c",
                    "dnsrecon -t brt -d " + domain + " -D /usr/share/dnsrecon/"+ path 
    		};
    		
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
           
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            
            return output.toString();
        } catch (Exception e) {
            return "Error executing DNS spf for domain: " + domain + "\n" + e.getMessage();
        }
    }

}










