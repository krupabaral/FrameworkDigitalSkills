package FrameworkPkg;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadData {
	public ArrayList<String> ReadInputFile(String InputFilePathName)
	{
	
		BufferedReader readReg;
		ArrayList<String> listofRegs;
		listofRegs = new ArrayList<>();
		String regPat = "[A-Z]{2}[0-9]{2} [A-Z]{3}|[A-Z]{2}[0-9]{2}[A-Z]{3}";
		Pattern regex = Pattern.compile(regPat);
			
		try {
			readReg = new BufferedReader(new FileReader(InputFilePathName));
			
			String eachLine = readReg.readLine();
			while (eachLine != null) {
				Matcher regMatch = regex.matcher(eachLine);
				
				while (regMatch.find()){
					listofRegs.add(regMatch.group().replaceAll("\\s+", ""));
				}
				eachLine = readReg.readLine();

			}
			readReg.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return listofRegs;	
	}

	public ArrayList<String> ReadOutputFile(String OutputFilePathName, String RegNum)
	{
	
		BufferedReader readReg;
		ArrayList<String> outputList;
		outputList = new ArrayList<>();
			
		try {
			
			readReg = new BufferedReader(new FileReader(OutputFilePathName));
			
			String eachLine = readReg.readLine();
			while (eachLine != null) {

					String [] strList = eachLine.split(",");
					if (strList.length > 0 && strList[0].contentEquals(RegNum)) {
						for (int i=0 ; i<strList.length ; i++) {
							outputList.add(strList[i]);
							//System.out.println(strList[i]);
						}
					}
				eachLine = readReg.readLine();

			}
			readReg.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return outputList;	
	}	
	
	
	
}
