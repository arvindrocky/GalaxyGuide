package org;

import java.util.List;

import org.galaxy.InterGalacticTransaction;
import org.utils.FileUtil;
import org.utils.TextUtil;


public class Main {

	public static void main(String[] args) {
		if (args.length == 0 || args[0].isEmpty()) {
			System.out.println("Please specify input file name path");
		} else {
			List<String> listOfLines = FileUtil.parseFile(args[0]);
			
			InterGalacticTransaction galacticTrans = new InterGalacticTransaction(listOfLines);
			galacticTrans.parseNotes();
			galacticTrans.transactInGalaxy();
			
			/*GalaxyNotes notes = new GalaxyNotes(listOfLines);
			notes.parseNotes();
			Map<String, String> listOfAnswers = notes.getListOfAnswers();
			
			for (Map.Entry<String, String> entry : listOfAnswers.entrySet()) {
				String result = entry.getValue().isEmpty() ? entry.getKey() : entry.getKey() + " is " + entry.getValue();
				System.out.println(result);
			}*/
		}
		
		/*String line = "how much Is pish tegj glob glob ?";
		String[] creditMapping = TextUtil.stripQuestionMark(line).split(" (?i)is ");
		
		for (String a : creditMapping) {
			System.out.println(a);
		}
		
		System.out.println("============");*/
		
		/*String line = "glob glob Silver is 34 Credits";
		String[] creditMapping = line.split(" is ");
		
		for (String a : creditMapping) {
			System.out.println(a.trim());
		}
		
		System.out.println("============");*/
		
		/*String mappingLine = "glob is I";
		String[] mappingWords = mappingLine.split("is");
		
		for (String b : mappingWords) {
			System.out.println(b.trim());
		}
		
		System.out.println("============");*/
		
		/*if (line.toLowerCase().contains("credits")) {
			System.out.println("TRUE");
		} else {
			System.out.println("FALSE");
		}*/

		/*for (RomanNumbers a : RomanNumbers.values()) {
			System.out.println(a.toString());
		}*/
		
		/*System.out.println("============");
		
		String credit = "34 Credits ? ";
		String stringToBeReplaced = "\\?";
		System.out.println(credit.toLowerCase().replaceAll(stringToBeReplaced, "").trim());*/
		
		/*System.out.println("============");
		System.out.println(RomanNumberToEnglishNumberConvertor.convertRomanNumber("MCMIII").intValue());*/
		
		/*System.out.println("============");
		List<String> listOfQuestions = new ArrayList<String>();
		listOfQuestions.add("how much is pish tegj glob glob ?");
		listOfQuestions.add("how many Credits is glob prok Silver ?");
		listOfQuestions.add("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?");
		listOfQuestions.add("how many Credits is glob prok Iron ?");
		
		System.out.println(listOfQuestions.contains("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"));*/
	}
}
