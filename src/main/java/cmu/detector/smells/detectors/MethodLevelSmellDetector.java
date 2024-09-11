package cmu.detector.smells.detectors;

import cmu.detector.smells.CompositeSmellDetector;
import cmu.detector.smells.SmellName;

public class MethodLevelSmellDetector extends CompositeSmellDetector {
	
	public MethodLevelSmellDetector() {

	}

	@Override
	protected SmellName getSmellName() {
		return null;
	}

}
