package hu.elte.progtech.taxonomy;

public class Root extends Taxon {

	private final String type = "Root";

	@Override
	String type() {
		return this.type ;
	}

}
