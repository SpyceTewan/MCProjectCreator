// This is a generated file. Not intended for manual editing.
package at.tewan.mcpc.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import at.tewan.mcpc.language.psi.impl.*;

public interface MCFunctionTypes {

  IElementType PROPERTY = new MCFunctionElementType("PROPERTY");

  IElementType COMMENT = new MCFunctionTokenType("COMMENT");
  IElementType CRLF = new MCFunctionTokenType("CRLF");
  IElementType KEY = new MCFunctionTokenType("KEY");
  IElementType SEPARATOR = new MCFunctionTokenType("SEPARATOR");
  IElementType VALUE = new MCFunctionTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == PROPERTY) {
        return new MCFunctionPropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
