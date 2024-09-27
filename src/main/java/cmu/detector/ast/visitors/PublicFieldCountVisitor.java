package cmu.detector.ast.visitors;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.Modifier;

/**
 * Count all the public fields, exclude static, private and protected fields
 */
public class PublicFieldCountVisitor extends ASTVisitor {
    private int publicFieldCount = 0;

    @Override
    public boolean visit(FieldDeclaration node) {
        int modifiers = node.getModifiers();

        if (Modifier.isPublic(modifiers) && !Modifier.isStatic(modifiers)) {
            publicFieldCount++;
        }

        return false;
    }

    public int getPublicFieldCount() {
        return publicFieldCount;
    }
}
