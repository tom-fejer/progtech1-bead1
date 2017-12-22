package hu.elte.progtech.taxonomy;

import java.util.Scanner;

public class Launcher {

	public static void main(String[] args) {
		Simulation simulation = new Simulation(new FileParser("resources/testFile.txt"));
		simulation.run(getNumOfDays());
	}

	private static int getNumOfDays() {
		Scanner input = new Scanner(System.in);
		int numOfDays;
		do {
		    System.out.println("Add meg az eltelt napok sz�m�t!");
		    while (!input.hasNextInt()) {
		        System.out.println("Nem sz�mot adt�l meg! Pr�b�ld �jra!");
		        input.next();
		    }
		    numOfDays = input.nextInt();
		} while (numOfDays <= 0);
		input.close();
		return numOfDays;
	}

}
