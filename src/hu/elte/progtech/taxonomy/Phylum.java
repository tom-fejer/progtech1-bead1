package hu.elte.progtech.taxonomy;

public class Phylum extends Taxon {
	
	public final String type = "P";

	@Override
	String type() {
		return type;
	}

}
