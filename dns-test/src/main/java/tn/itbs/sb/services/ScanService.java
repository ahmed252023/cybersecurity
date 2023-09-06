package tn.itbs.sb.services;

import java.io.BufferedReader;

import java.io.InputStreamReader;

import org.springframework.stereotype.Service;

@Service

public class ScanService {
	
	
	public String nmapscan (String ip)  {
    	try {
    		System.out.println(ip);
    		String[] command = {
                    "/bin/sh",
                    "-c",
                    "nmap  " + ip
                    
    		};
    		
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
            
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            
            
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
                
            }
            
            System.out.println("output:"+output);
         
            return output.toString();
            
        } catch (Exception e) {
            return "Error executing scan for domain: " + ip + "\n" + e.getMessage();
           
        }
    }

}
