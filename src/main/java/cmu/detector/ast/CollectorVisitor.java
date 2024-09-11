package cmu.detector.ast;

import org.eclipse.jdt.core.dom.ASTVisitor;

import java.util.ArrayList;
import java.util.List;

public abstract class CollectorVisitor<T> extends ASTVisitor {
	
	private List<T> nodesCollected;
	
	public CollectorVisitor() {
		nodesCollected = new ArrayList<>();
	}
	
	protected void addCollectedNode(T node) {
		this.nodesCollected.add(node);
	}
	
	protected boolean wasAlreadyCollected(T node) {
		return this.nodesCollected.contains(node);
	}
	
	public List<T> getNodesCollected() {
		return nodesCollected;
	}
}
