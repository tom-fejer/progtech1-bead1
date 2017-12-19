package hu.elte.progtech.taxonomy;

import java.util.ArrayList;
import java.util.List;

public class Species extends Genus {

	public static final String type = "S";
	private String hunName;
	private List<String> preys = new ArrayList<String>(); // full names of species
	private int initPopulation;
	private int growthRate;

	public String getHunName() {
		return hunName;
	}

	public void setHunName(String hunName) {
		this.hunName = hunName;
	}

	public List<String> getPreys() {
		return preys;
	}

	// simplify just to add by FullName -> "decode" in HierarchyTree
	public void addPreys(List<String> preys) {
		for (String prey : preys) {
			this.preys.add(prey);
		}
	}

	public int getInitPopulation() {
		return initPopulation;
	}

	public boolean setInitPopulation(int initPopulation) throws IllegalArgumentException {
		if (initPopulation > 0) {
			this.initPopulation = initPopulation;
			return true;
		} else
			throw new IllegalArgumentException();
	}

	public int getGrowthRate() {
		return growthRate;
	}

	public void setGrowthRate(int growthRate) {
		this.growthRate = growthRate;
	}

	public String getFullName() {
		StringBuffer sb = new StringBuffer();
		sb.append(getParent().getName());
		sb.append(" ");
		sb.append(getName().toLowerCase());
		return sb.toString();
	}

	@Override
	String type() {
		return type;
	}
}
