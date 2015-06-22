package org;

import java.io.IOException;
import java.util.List;

import org.galaxy.InterGalacticTransaction;
import org.utils.FileUtil;

/**
 * This is the main class for our Intergalactic transaction.
 * This requires a input text file which has the notes
 * @author arvind
 */
public class Main {

	/**
	 * This is the main method from where the execution starts
	 * A sample txt file
	 * 	glob is I
		prok is V
		pish is X
		tegj is L
		glob glob Silver is 34 Credits
		glob prok Gold is 57800 Credits
		pish pish Iron is 3910 Credits
		how much is pish tegj glob glob ?
		how many Credits is glob prok Silver ?
		how many Credits is glob prok gold ?
		how many Credits is glob prok Iron ?
		how much wood could a woodchuck chuck if a woodchuck could chuck wood ?
		
	 * @param args should contain path to input file
	 */
	public static void main(String[] args) {
		if (args.length == 0 || args[0].isEmpty()) {
			System.out.println("Please specify input file name path");
		} else {
			List<String> listOfLines = null;
			try {
				listOfLines = FileUtil.parseFile(args[0]);
				InterGalacticTransaction galacticTrans = new InterGalacticTransaction(listOfLines);
				galacticTrans.parseNotes();
				galacticTrans.transactInGalaxy();
			} catch (IOException e) {
				System.out.println("Error while reading input file. Please make sure that the file is valid");
			}
		}
	}
}
