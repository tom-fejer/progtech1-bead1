package hu.elte.progtech.taxonomy;

import java.util.ArrayList;
import java.util.List;

public abstract class Taxon {

	private Taxon parent;
	private List<Taxon> children = new ArrayList<Taxon>();
	private String name;

	public Taxon getParent() {
		return parent;
	}

	public void setParent(Taxon parent) {
		this.parent = parent;
	}

	public List<Taxon> getChildren() {
		return children;
	}

	public void setChild(Taxon child) {
		this.children.add(child);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
