package hu.elte.progtech.taxonomy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileParser {

	private Scanner scanner;

	public FileParser(String fileName) {
		try {
			scanner = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
		}
	}

	public HierarchyTree parse() {
		if (this.scanner.equals(null)) {
			return null;
		} else {
			return new HierarchyTree();
		}
	}

}
