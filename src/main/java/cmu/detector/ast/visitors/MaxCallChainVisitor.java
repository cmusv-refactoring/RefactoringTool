package cmu.detector.ast.visitors;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MethodInvocation;

/**
 * The visitor will visit a method and find the maximum length of a method call chain
 */
public class MaxCallChainVisitor extends ASTVisitor {
    private Integer maxCallChain;

    public MaxCallChainVisitor() {
        maxCallChain = 0;
    }

    @Override
    public boolean visit(MethodInvocation node) {

        Integer chainSize = 1;

        ASTNode parent = node.getParent();

        while (parent != null && (parent instanceof MethodInvocation)) {
            chainSize++;
            parent = parent.getParent();
        }
        maxCallChain = Math.max(maxCallChain, chainSize);

        return true;
    }

    public Integer getMaxCallChain() {
        return maxCallChain;
    }
}
