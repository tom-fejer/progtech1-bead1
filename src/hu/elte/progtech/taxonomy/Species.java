package hu.elte.progtech.taxonomy;

import java.util.ArrayList;
import java.util.List;

public class Species extends Genus {

	public static final String type = "S";
	private String hunName;
	private List<String> preys = new ArrayList<String>(); // full names of species
	private int initPopulation;
	private int growthRate;
	private int population;

	@Override
	String type() {
		return type;
	}

	public String getHunName() {
		return hunName;
	}

	public void setHunName(String hunName) {
		this.hunName = hunName;
	}

	public List<String> getPreys() {
		return preys;
	}

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
			this.population = initPopulation;
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

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

}
