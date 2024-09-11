package cmu.detector.ast.visitors;

import cmu.detector.ast.CollectorVisitor;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.MethodInvocation;

import java.util.HashSet;
import java.util.Set;

/**
 * Assumes that the root node is a method declaration. This visitor
 * returns bindings for all distinct method calls performed inside the body of the
 * visited method excluding call to Java methods
 * 
 * @author Diego Cedrim
 */
public class MethodInvocationCollector extends CollectorVisitor<MethodInvocation> {
	
	private Set<IMethodBinding> calls;
	
	
	public MethodInvocationCollector() {
		this.calls = new HashSet<>();
	}
	
	@Override
	public boolean visit(MethodInvocation node) {
		IMethodBinding methodBinding = node.resolveMethodBinding();
		if (methodBinding == null) {
			return true;
		}

		ITypeBinding declaringClass = methodBinding.getDeclaringClass();
		if (declaringClass.getQualifiedName().startsWith("java")){
			return true;
		}
		
		this.calls.add(methodBinding);
		addCollectedNode(node);
		return true;
	}
	
	public Set<IMethodBinding> getCalls() {
		return calls;
	}
}

























