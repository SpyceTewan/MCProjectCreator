// This is a generated file. Not intended for manual editing.
package at.tewan.mcpc.language.mcfunction.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import at.tewan.mcpc.language.mcfunction.psi.impl.*;

public interface MCFunctionTypes {

  IElementType COMMAND = new MCFunctionElementType("COMMAND");

  IElementType COMMAND_ARGUMENT = new MCFunctionTokenType("COMMAND_ARGUMENT");
  IElementType COMMAND_NAME = new MCFunctionTokenType("COMMAND_NAME");
  IElementType COMMENT = new MCFunctionTokenType("COMMENT");
  IElementType CRLF = new MCFunctionTokenType("CRLF");
  IElementType TARGET_SELECTOR = new MCFunctionTokenType("TARGET_SELECTOR");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == COMMAND) {
        return new MCFunctionCommandImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
