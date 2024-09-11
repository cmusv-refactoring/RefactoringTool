package cmu.detector.smells;

import cmu.detector.resources.Resource;

import java.util.ArrayList;
import java.util.List;

public abstract class CompositeSmellDetector extends SmellDetector {

	private List<SmellDetector> detectors;
	
	public CompositeSmellDetector() {
		this.detectors = new ArrayList<>();
	}
	
	public void addDetector(SmellDetector detector) {
		this.detectors.add(detector);
	}
	
	@Override
	public List<Smell> detect(Resource resource) {
		List<Smell> smells = new ArrayList<>();

		for (SmellDetector detector : this.detectors) {
			smells.addAll(detector.detect(resource));
		}
		return smells;
	}
}
