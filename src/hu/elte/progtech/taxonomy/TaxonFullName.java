package hu.elte.progtech.taxonomy;

public enum TaxonFullName {
	P("Phylum"), 
	C("Classis"),
	O("Ordo"),
	F("Familia"), 
	G("Genus"), 
	S("Species");

	private String name;

	private TaxonFullName(String name) {
		this.name = name;
	}
}
