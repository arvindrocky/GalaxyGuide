package org;

import java.util.List;

import org.utils.FileUtil;

public class Main {

	public static void main(String[] args) {
		if (args.length == 0 || args[0].isEmpty()) {
			System.out.println("Please specify input file name path");
		} else {
			List<String> listOfLines = FileUtil.parseFile(args[0]);
			for(String line : listOfLines) {
				System.out.println(line);
			}
		}
	}
}
