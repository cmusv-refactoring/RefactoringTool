package cmu.detector.resources;

import cmu.detector.ast.visitors.MethodInvocationCollector;
import cmu.detector.graph.CallGraph;
import cmu.detector.resources.loader.SourceFile;
import org.eclipse.jdt.core.dom.*;

import java.util.ArrayList;
import java.util.List;

public class Method extends Resource {

    private transient List<String> parametersTypes;

    public IMethodBinding getBinding() {
        MethodDeclaration declaration = (MethodDeclaration)this.getNode();
        IMethodBinding binding = declaration.resolveBinding();
        return binding;
    }

    /**
     * Every time a new method is declared, it must be
     * registered in the call Graph
     */
    private void registerOnCallGraph(MethodDeclaration node) {
        CallGraph graph = CallGraph.getInstance();
        IMethodBinding thisBinding = this.getBinding();
        if (thisBinding == null) {
            //TODO LOG!
            return;
        }

        /*
         * Retrieves the list of method calls made by the new
         * declared method
         */
        MethodInvocationCollector invocationVisitor = new MethodInvocationCollector();
        node.accept(invocationVisitor);

        for (IMethodBinding methodBinding : invocationVisitor.getCalls()) {
            if (!(methodBinding.getDeclaringClass().getQualifiedName().startsWith("java"))){
                graph.addMethodCall(thisBinding, methodBinding);
            }
        }

    }

    public Method(SourceFile sourceFile, MethodDeclaration node) {
        super(sourceFile, node);
        this.registerOnCallGraph(node);

        this.parametersTypes = new ArrayList<>();
        for(Object obj : node.parameters()) {
            SingleVariableDeclaration declaration = (SingleVariableDeclaration)obj;
            declaration.getName();
            parametersTypes.add(declaration.getType().toString());
        }

        IBinding binding = node.resolveBinding();
        if (binding != null) {
            IMethodBinding methodBinding = (IMethodBinding)binding;
            String classFqn = methodBinding.getDeclaringClass().getQualifiedName();
            setFullyQualifiedName(classFqn + "." + node.getName());
        }
    }

    public List<String> getParametersTypes() {
        return parametersTypes;
    }

    @Override
    protected void identifyKind() {
        MethodDeclaration declaration = (MethodDeclaration)this.getNode();
        StringBuffer buffer = new StringBuffer();
        int modifiers = declaration.getModifiers();

        if (Modifier.isPublic(modifiers)) {
            buffer.append("public ");
        }

        if (Modifier.isPrivate(modifiers)) {
            buffer.append("private ");
        }

        if (Modifier.isProtected(modifiers)) {
            buffer.append("protected ");
        }

        if (buffer.isEmpty()) {
            buffer.append("package-private ");
        }

        if (Modifier.isStatic(modifiers)) {
            buffer.append("static ");
        }

        if (Modifier.isAbstract(modifiers)) {
            buffer.append("abstract ");
        }

        if (Modifier.isFinal(modifiers)) {
            buffer.append("final ");
        }

        buffer.append("method");
        this.setKind(buffer.toString());
    }

    @Override
    public String toString() {
        return "Method [fqn=" + getFullyQualifiedName() + "]";
    }

}
