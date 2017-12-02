package hu.elte.progtech.taxonomy;

public class HierarchyTree {

	private Taxon root;

	public Taxon getRoot() {
		return root;
	}

	public void addNode(String taxonName, Taxon node) {
		if (getRoot() == null) {
			this.root = node;
			getRoot().setName(taxonName);
		} else
			addNode(getRoot(), taxonName, node);
	}

	public void addNode(Taxon parent, String parentName, Taxon node) throws IllegalArgumentException {
		Taxon parentNode = createTaxon(parentName);
		if (parentNode == null) {
			throw new IllegalArgumentException();
		} else
			parentNode.setChild(node);
	}

	private Taxon createTaxon(String parentName) {
		Taxon result = null;
		switch (parentName) {
		case "Phylum":
			result = new Phylum();
			break;
		case "Classis":
			result = new Classis();
			break;
		case "Ordo":
			result = new Ordo();
			break;
		case "Familia":
			result = new Familia();
			break;
		case "Genus":
			result = new Genus();
			break;
		case "Species":
			result = new Species();
			break;
		}
		result.setName(parentName);
		return result;
	}
}
