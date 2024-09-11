package cmu.detector.smells.detectors;

import cmu.detector.smells.CompositeSmellDetector;
import cmu.detector.smells.SmellName;

public class ClassLevelSmellDetector extends CompositeSmellDetector {
	
	public ClassLevelSmellDetector() {

	}

	@Override
	protected SmellName getSmellName() {
		return null;
	}

}
