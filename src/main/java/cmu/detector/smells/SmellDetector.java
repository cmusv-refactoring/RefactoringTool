package cmu.detector.smells;

import cmu.detector.resources.Resource;

import java.util.List;

/**
 * Defines a generic interface for detecting smells
 */
public abstract class SmellDetector {

	/**
	 * Given a resource, return a list of existing smells 
	 * @param resource to be evaluated
	 * @return a list of existing smells
	 */
	public abstract List<Smell> detect(Resource resource);

	protected abstract SmellName getSmellName();
	
	protected Smell createSmell(Resource resource, String reason) {
		Smell smell = new Smell(getSmellName(), reason);

		smell.setStartingLine(resource.getStartLineNumber());
		smell.setEndingLine(resource.getEndLineNumber());

		return smell;
	}
	
	protected Smell createSmell(Resource resource) {
		Smell smell = new Smell(getSmellName());

		smell.setStartingLine(resource.getStartLineNumber());
		smell.setEndingLine(resource.getEndLineNumber());

		return smell;
	}
}
