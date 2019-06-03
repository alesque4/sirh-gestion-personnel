package dev.sgp.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import dev.sgp.entite.VisiteWeb;

public class StatService {
	
	private List<VisiteWeb> listVisite;
	
	public Integer getMinVisiteTimeByPath(String path) {
		return getListVisite().stream()
				.filter(v -> v.getChemin().equals(path))
				.map(VisiteWeb::getTempsExecution)
				.min(Integer::compare)
				.orElse(Integer.MAX_VALUE);
	}
	
	public Integer getMaxVisiteTimeByPath(String path) {
		return getListVisite().stream()
				.filter(v -> v.getChemin().equals(path))
				.map(VisiteWeb::getTempsExecution)
				.max(Integer::compare)
				.orElse(Integer.MIN_VALUE);
	}
	
	public Long getNumberOfVisiteByPath(String path) {
		return getListVisite().stream()
				.filter(v -> v.getChemin().equals(path))
				.count();
	}
	
	public double getAverageVisiteTimeByPath(String path) {
		int somme = getListVisite().stream()
				.filter(v -> v.getChemin().equals(path))
				.collect(Collectors.summingInt(VisiteWeb::getTempsExecution));
		return somme/getNumberOfVisiteByPath(path);	
	}
	
	public List<String> getChemins(){
		return getListVisite().stream()
			.map(VisiteWeb::getChemin)
			.distinct()
			.collect(Collectors.toList());
	}
	
	
	public boolean addVisite(VisiteWeb visite) {
		return getListVisite().add(visite);
	}

	public List<VisiteWeb> getListVisite() {
		return listVisite;
	}
}
