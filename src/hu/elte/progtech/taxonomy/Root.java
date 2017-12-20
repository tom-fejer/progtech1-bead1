package hu.elte.progtech.taxonomy;

public class Root extends Taxon {

	private final String type = "Root";
	private String name = "Root";

	public String getName() {
		return name;
	}

	@Override
	String type() {
		return this.type;
	}

}
