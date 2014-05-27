package gdsl.plugin.generator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RunCompiler {

	private static final String COMMAND = "ping -c 3 8.8.8.8";
	
	public static String compile(){
		return RunCompiler.compile(COMMAND);
	}
	
	public static String compile(String command){
		StringBuffer output = new StringBuffer();
		Process p;
		try{
			p = Runtime.getRuntime().exec(COMMAND);
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
