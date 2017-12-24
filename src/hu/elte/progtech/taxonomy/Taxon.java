package hu.elte.progtech.taxonomy;

import java.util.ArrayList;
import java.util.List;

public abstract class Taxon {

	private Taxon parent;
	private List<Taxon> children = new ArrayList<Taxon>();
	private String name;

	abstract String type();

	public Taxon getParent() {
		return parent;
	}

	public void setParent(Taxon parent) {
		this.parent = parent;
	}

	public List<Taxon> getChildren() {
		return children;
	}

	public Taxon setChild(Taxon child) {
		this.children.add(child);
		child.setParent(this);
		return this.children.get(this.children.size() - 1);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
