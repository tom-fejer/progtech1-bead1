package hu.elte.progtech.taxonomy;

public final class TaxonType {
	
	public static final String[] values = {"P", "C", "O", "F", "G", "S"};
	
	public static boolean contains(String str) {
		boolean result = false; 
		for (String e : values) {
			if (e.equals(str)) {
				result = true;
			}
		}
		return result;
	}
}
