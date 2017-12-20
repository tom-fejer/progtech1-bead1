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
			System.err.println("Error: non-existant parent node!");
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
		return searchName(this.root, parts[1]);
	}

	private List<String> searchName(Taxon node, String name) {
		List<String> result = new LinkedList<String>();
		if (!node.getName().equals(name)) {
			for (Taxon child : node.getChildren()) {
				searchName(child, name);
			}
		} else {
			result = walk(node);
		}
		return result;
	}

	private List<String> walk(Taxon node) {
		List<String> result = new LinkedList<String>();
		if (node.getChildren() != null) {
			for (Taxon child : node.getChildren()) {
				walk(child);
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

}
