package hu.elte.progtech.taxonomy;

import java.util.LinkedList;
import java.util.List;

public class Simulation {

	private int numOfDays = 0;
	HierarchyTree tree = null;
	List<Species> animals;

	public Simulation(FileParser fileParser) {
		fileParser.parse();
		this.tree = fileParser.getTree();
	}

	public void run(int numOfDays) {
		this.numOfDays = numOfDays;
		animals = this.tree.getLeaves(this.tree.getRoot());
		calculatePopulation(animals);
		animals = this.tree.getLeaves(this.tree.getRoot());
		printResults(animals);
	}

	private void calculatePopulation(List<Species> animals) {
		for (int i = 1; i <= numOfDays; i++) {
			for (Species animal : animals) {
				sex(i, animal);
				hunt(animal);
			}
		}
	}

	private void sex(int index, Species animal) {
		if (index % animal.getGrowthRate() == 0) {
			animal.setPopulation(
					animal.getPopulation() + (animal.getPopulation() / 2) * (index / animal.getGrowthRate()));
		}
	}

	private void hunt(Species animal) {
		if (!animal.getPreys().isEmpty()) {
			List<Species> preys = new LinkedList<Species>();
			for (String preyName : animal.getPreys()) {
				preys.add(this.tree.searchByFullName(this.tree.getRoot(), preyName));
			}
			int remainder = 0;
			for (int j = 0; j < preys.size(); j++) {
				if (preys.get(j).getPopulation() > 0) {
					if (remainder > 0) {
						preys.get(j).setPopulation(preys.get(j).getPopulation() - remainder);
						remainder = 0;
					} else {
						preys.get(j).setPopulation(preys.get(j).getPopulation() - animal.getPopulation());
					}
					if (preys.get(j).getPopulation() < 0) {
						remainder = preys.get(j).getPopulation() * (-1);
						preys.get(j).setPopulation(0);
					} else {
						break;
					}
				} else if (j == preys.size() - 1) {
					animal.setPopulation(0);
				}
			}
		}
	}

	private void printResults(List<Species> result) {
		for (Species animal : result) {
			if (animal.getPopulation() > 0) {
				System.out.println(animal.getFullName() + " : " + animal.getPopulation());
			} else {
				System.out.println(animal.getFullName() + " : kihalt");
			}
		}
	}

}
