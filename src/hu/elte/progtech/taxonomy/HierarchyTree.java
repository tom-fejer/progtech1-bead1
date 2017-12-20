package hu.elte.progtech.taxonomy;

import java.util.LinkedList;
import java.util.List;

public class HierarchyTree {

	private Taxon root = new Root();

	public Taxon getRoot() {
		return root;
	}

	public Taxon addNode(Taxon parent, Taxon node) {
		if (parent == null) {
			System.err.println("Error: non-existent parent node!");
			return null;
		} else {
			return parent.setChild(node);
		}
	}

	public Taxon searchType(Taxon node, String typeToGet) {
		Taxon result = null;
		if (node.type().equals(typeToGet)) {
			return node;
		} else {
			result = searchType(node.getParent(), typeToGet);
		}
		return result;
	}

	public List<String> getSpeciesOf(String prey) {
		String[] parts = prey.split(" ");
		Taxon nodeToWalk = searchByName(this.getRoot(), parts[1]);
		return walk(nodeToWalk);
	}

	public Taxon searchByName(Taxon node, String name) {
		Taxon result = null;
		if (node.getName().equals(name)) {
			return node;
		} else {
			for (Taxon child : node.getChildren()) {
				result = searchByName(child, name);
				if (result != null) {
					break;
				}
			}
		}
		return result;
	}

	public List<String> walk(Taxon node) {
		List<String> result = new LinkedList<String>();
		if (node.getChildren().size() > 0) {
			for (Taxon child : node.getChildren()) {
				result.addAll(walk(child));
			}
		}
		if (node.type().equals("S")) {
			Species species = (Species) node;
			result.add(species.getFullName());
		}
		return result;
	}

	public String preyType(String prey) {
		String[] parts = prey.split(" ");
		if (TaxonType.contains(parts[0])) {
			return "taxon";
		} else {
			return "fullName";
		}
	}

	public List<Species> getLeaves(Taxon node) {
		List<Species> result = new LinkedList<Species>();
		if (node.getChildren().size() > 0) {
			for (Taxon child : node.getChildren()) {
				result.addAll(getLeaves(child));
			}
		}
		if (node.type().equals("S")) {
			Species species = (Species) node;
			result.add(species);
		}
		return result;
	}

	public Species searchByFullName(Taxon node, String fullName) {
		Species result = new Species();
		if (node instanceof Species) {
			Species species = (Species) node;
			if (species.getFullName().equals(fullName)) {
				result = species;
			}
		} else if (node.getChildren().size() > 0) {
			for (Taxon child : node.getChildren()) {
				result = searchByFullName(child, fullName);
				if (result.getHunName() != null) {
					break;
				}
			}
		}
		return result;
	}

}
