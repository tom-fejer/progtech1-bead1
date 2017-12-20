package hu.elte.progtech.taxonomy;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Simulation {

	private int numOfDays = 0;
	HierarchyTree tree = null;

	public Simulation(FileParser fileParser) {
		Scanner input = new Scanner(System.in);
		System.out.println("Add meg a napok számát!");
		int days = input.nextInt();
		if (days > 0) {
			this.numOfDays = days;
			fileParser.parse();
			this.tree = fileParser.getTree();
		}
		input.close();
	}

	public void run() {
		List<Species> animals = this.tree.getLeaves(this.tree.getRoot());
		for (Species animal : animals) {
			animal.setPopulation(
					animal.getPopulation() + (animal.getPopulation() / 2) * (numOfDays / animal.getGrowthRate()));

			if (!animal.getPreys().isEmpty()) {
				List<Species> preys = new LinkedList<Species>();
				for (String preyName : animal.getPreys()) {
					preys.add(this.tree.searchByFullName(this.tree.getRoot(), preyName));

				}
				for (Species prey : preys) {
					prey.setPopulation(prey.getPopulation() - (animal.getPopulation() * numOfDays));
					if (prey.getPopulation() < 0) {
						animal.setPopulation(prey.getPopulation());
						prey.setPopulation(0);
					}
				}
			}
		}
		List<Species> result = this.tree.getLeaves(this.tree.getRoot());
		for (Species animal : result) {
			if (animal.getPopulation() > 0) {
				System.out.println(animal.getFullName() + " : " + animal.getPopulation());
			} else {
				System.out.println(animal.getFullName() + " : kihalt");
			}
		}
	}

}
