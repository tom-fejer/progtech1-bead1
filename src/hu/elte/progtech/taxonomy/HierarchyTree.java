package hu.elte.progtech.taxonomy;

public class HierarchyTree {

	private Taxon root = new Root();

	public Taxon getRoot() {
		return root;
	}

	public Taxon addNode(Taxon parent, Taxon node) {
		return parent.setChild(node);
	}

	// TODO: modify: step through parents instead of children (call with lastAddedNode as starting point)
	public Taxon searchType(Taxon node, String typeToGet) {
		Taxon result = null;
		if (node.type().equals(typeToGet)) {
			return node;
		}
		if (node.getChildren().size() > 0) {
			for (Taxon child : node.getChildren()) {
				result = searchType(child, typeToGet);
				if (result != null) {
					return result;
				}
			}
		}
		return result;
	}

	// returns an array of full species names
	// call this from FileParser on its concrete tree
	// search species of that taxon with searchType()
	public String[] getSpeciesOf(String prey) {
		String[] parts = prey.split(" ");
		searchType(parts[0]);
		return null;
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
