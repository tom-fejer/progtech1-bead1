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
//		this.children.get(this.children.size() - 1).setParent(this);
		child.setParent(this);
		return this.children.get(this.children.size() - 1);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((children == null) ? 0 : children.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Taxon other = (Taxon) obj;
		if (children == null) {
			if (other.children != null)
				return false;
		} else if (!children.equals(other.children))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		return true;
	}

}
