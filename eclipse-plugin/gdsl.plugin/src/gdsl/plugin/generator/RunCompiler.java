package gdsl.plugin.generator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RunCompiler {

	public static String compile(String command){
		System.out.println(command);
		StringBuffer output = new StringBuffer();
		Process p;
		try{
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = "";
			while((line = reader.readLine())!= null){
				output.append(line + "\n");
			}
		}catch(Exception e){}
		System.out.print(output);
		return output.toString();
	}
	
}
