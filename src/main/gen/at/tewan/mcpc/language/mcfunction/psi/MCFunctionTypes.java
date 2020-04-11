// This is a generated file. Not intended for manual editing.
package at.tewan.mcpc.language.mcfunction.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import at.tewan.mcpc.language.mcfunction.psi.impl.*;

public interface MCFunctionTypes {

  IElementType ARG = new MCFunctionElementType("ARG");
  IElementType COMMAND = new MCFunctionElementType("COMMAND");
  IElementType TARGET = new MCFunctionElementType("TARGET");

  IElementType COMMAND_END = new MCFunctionTokenType("COMMAND_END");
  IElementType COMMAND_LITERAL = new MCFunctionTokenType("COMMAND_LITERAL");
  IElementType COMMAND_NAME = new MCFunctionTokenType("COMMAND_NAME");
  IElementType COMMENT = new MCFunctionTokenType("COMMENT");
  IElementType SPACE = new MCFunctionTokenType("SPACE");
  IElementType TARGET_ATTR_EQU = new MCFunctionTokenType("TARGET_ATTR_EQU");
  IElementType TARGET_ATTR_KEY = new MCFunctionTokenType("TARGET_ATTR_KEY");
  IElementType TARGET_BODY_END = new MCFunctionTokenType("TARGET_BODY_END");
  IElementType TARGET_BODY_START = new MCFunctionTokenType("TARGET_BODY_START");
  IElementType TARGET_SELECTOR = new MCFunctionTokenType("TARGET_SELECTOR");
  IElementType WHITE_SPACE = new MCFunctionTokenType("WHITE_SPACE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARG) {
        return new MCFunctionArgImpl(node);
      }
      else if (type == COMMAND) {
        return new MCFunctionCommandImpl(node);
      }
      else if (type == TARGET) {
        return new MCFunctionTargetImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
