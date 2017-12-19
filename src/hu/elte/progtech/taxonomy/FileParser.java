package hu.elte.progtech.taxonomy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileParser {

	private Scanner scanner;
	private HierarchyTree tree;

	public FileParser(String fileName) {
		try {
			scanner = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			System.err.println("File not found!");
		}
	}

	public void parse() {
		this.tree = new HierarchyTree();
		Taxon lastAddedNode = null;
		while (scanner.hasNextLine()) {
			Taxon taxonToAdd = parseLine(scanner.nextLine());
			if (lastAddedNode == null) {
				this.tree.getRoot().setChild(taxonToAdd);
				int lastNodeIndex = this.tree.getRoot().getChildren().size() - 1;
				lastAddedNode = this.tree.getRoot().getChildren().get(lastNodeIndex);
			} else if (lastAddedNode.getParent().equals(this.tree.getRoot())) {
				lastAddedNode = this.tree.addNode(this.tree.getRoot(), taxonToAdd);
			} else {
				Taxon parentNode = searchParentNode(taxonToAdd, lastAddedNode);
				lastAddedNode = this.tree.addNode(parentNode, taxonToAdd);
			}
		}
		scanner.close();
	}

	private Taxon parseLine(String nextLine) {
		Scanner lineScanner = new Scanner(nextLine);
		String taxonType = lineScanner.next();
		String taxonLatinName = lineScanner.next();
		Taxon taxon = null;
		if (taxonType.equals("S")) {
			String hunName = parseHunName(lineScanner);
			String[] preys = null;
			if (!lineScanner.hasNextInt()) {
				preys = parsePreys(lineScanner);
			}
			int initPopulation = lineScanner.nextInt();
			int growthRate = lineScanner.nextInt();
			taxon = createTaxon(taxonType, taxonLatinName, hunName, preys, initPopulation, growthRate);
		} else {
			taxon = createTaxon(taxonType, taxonLatinName, null, null, 0, 0);
		}
		lineScanner.close();
		return taxon;
	}

	private String parseHunName(Scanner lineScanner) {
		lineScanner.useDelimiter("\\s*[|]|\\d");
		String result = lineScanner.next();
		lineScanner.reset();
		return result.trim();
	}

	private String[] parsePreys(Scanner lineScanner) {
		lineScanner.useDelimiter("\\d");
		String[] preys = lineScanner.next().split(",");
		String[] result = new String[preys.length];
		for (int i = 0; i < preys.length; i++) {
			result[i] = preys[i].trim();
		}
		lineScanner.reset();
		return result;
	}

	public Taxon createTaxon(String taxonType, String taxonName, String hunName, String[] preys, int initPopulation,
			int growthRate) {
		Taxon taxon = null;
		switch (taxonType) {
		case "P":
			taxon = new Phylum();
			break;
		case "C":
			taxon = new Classis();
			break;
		case "O":
			taxon = new Ordo();
			break;
		case "F":
			taxon = new Familia();
			break;
		case "G":
			taxon = new Genus();
			break;
		case "S":
			Species node = new Species();
			node.setHunName(hunName);
			List<String> preysNames = genPreysNames(preys);
			node.addPreys(preysNames);
			node.setInitPopulation(initPopulation);
			node.setGrowthRate(growthRate);
			taxon = node;
			break;
		}
		if (taxon != null) {
			taxon.setName(taxonName);
		}
		return taxon;
	}

	private List<String> genPreysNames(String[] preys) {
		List<String> result = new ArrayList<String>();
		if (!preys.equals(null)) {
			for (String prey : preys) {
				if (this.tree.preyType(prey).equals("fullName")) {
					result.add(prey);
				} else if (this.tree.preyType(prey).equals("taxon")) {
					String[] animals = this.tree.getSpeciesOf(prey);
					for (String species : animals) {
						result.add(species);
					}
				}
			}
		}
		return result;
	}

	private Taxon searchParentNode(Taxon newNode, Taxon lastAddedNode) {
		if (lastAddedNode.type().equals(newNode.type())) {
			return lastAddedNode.getParent();
		}
		for (int i = 0; i < TaxonType.values.length - 2; i++) {
			if (lastAddedNode.type().equals(TaxonType.values[i]) && newNode.type().equals(TaxonType.values[i + 1])) {
				return lastAddedNode;
			} else if (newNode.type().equals(TaxonType.values[i + 1])) {
				String typeToGet = TaxonType.values[i];
				return this.tree.searchType(this.tree.getRoot(), typeToGet);
			}
		}
		return null;
	}
}
