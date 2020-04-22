// This is a generated file. Not intended for manual editing.
package at.tewan.mcpc.language.mcfunction.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import at.tewan.mcpc.language.mcfunction.psi.impl.*;

public interface MCFunctionTypes {

  IElementType ARG = new MCFunctionElementType("ARG");
  IElementType COMMAND = new MCFunctionElementType("COMMAND");
  IElementType LITERAL_ARG = new MCFunctionElementType("LITERAL_ARG");
  IElementType NUMBER_ARG = new MCFunctionElementType("NUMBER_ARG");
  IElementType RESOURCE = new MCFunctionElementType("RESOURCE");
  IElementType SNBT_ARRAY = new MCFunctionElementType("SNBT_ARRAY");
  IElementType SNBT_COMPOUND = new MCFunctionElementType("SNBT_COMPOUND");
  IElementType SNBT_COMPOUND_KEY = new MCFunctionElementType("SNBT_COMPOUND_KEY");
  IElementType SNBT_OBJECT = new MCFunctionElementType("SNBT_OBJECT");
  IElementType SNBT_VALUE = new MCFunctionElementType("SNBT_VALUE");
  IElementType TARGET = new MCFunctionElementType("TARGET");

  IElementType COMMAND_END = new MCFunctionTokenType("COMMAND_END");
  IElementType COMMAND_NAME = new MCFunctionTokenType("COMMAND_NAME");
  IElementType COMMENT = new MCFunctionTokenType("COMMENT");
  IElementType LITERAL = new MCFunctionTokenType("LITERAL");
  IElementType NUMBER = new MCFunctionTokenType("NUMBER");
  IElementType RES_ID_NAME = new MCFunctionTokenType("RES_ID_NAME");
  IElementType RES_SEPARATOR = new MCFunctionTokenType("RES_SEPARATOR");
  IElementType SNBT_ARR_END = new MCFunctionTokenType("SNBT_ARR_END");
  IElementType SNBT_ARR_START = new MCFunctionTokenType("SNBT_ARR_START");
  IElementType SNBT_COMP_END = new MCFunctionTokenType("SNBT_COMP_END");
  IElementType SNBT_COMP_START = new MCFunctionTokenType("SNBT_COMP_START");
  IElementType SNBT_KEY = new MCFunctionTokenType("SNBT_KEY");
  IElementType SNBT_PARM_SEPARATOR = new MCFunctionTokenType("SNBT_PARM_SEPARATOR");
  IElementType SNBT_SEPARATOR = new MCFunctionTokenType("SNBT_SEPARATOR");
  IElementType SNBT_VAL_BYTE = new MCFunctionTokenType("SNBT_VAL_BYTE");
  IElementType SNBT_VAL_DOUBLE = new MCFunctionTokenType("SNBT_VAL_DOUBLE");
  IElementType SNBT_VAL_FLOAT = new MCFunctionTokenType("SNBT_VAL_FLOAT");
  IElementType SNBT_VAL_INT = new MCFunctionTokenType("SNBT_VAL_INT");
  IElementType SNBT_VAL_LONG = new MCFunctionTokenType("SNBT_VAL_LONG");
  IElementType SNBT_VAL_SHORT = new MCFunctionTokenType("SNBT_VAL_SHORT");
  IElementType SPACE = new MCFunctionTokenType("SPACE");
  IElementType STRING = new MCFunctionTokenType("STRING");
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
      else if (type == LITERAL_ARG) {
        return new MCFunctionLiteralArgImpl(node);
      }
      else if (type == NUMBER_ARG) {
        return new MCFunctionNumberArgImpl(node);
      }
      else if (type == RESOURCE) {
        return new MCFunctionResourceImpl(node);
      }
      else if (type == SNBT_ARRAY) {
        return new MCFunctionSnbtArrayImpl(node);
      }
      else if (type == SNBT_COMPOUND) {
        return new MCFunctionSnbtCompoundImpl(node);
      }
      else if (type == SNBT_COMPOUND_KEY) {
        return new MCFunctionSnbtCompoundKeyImpl(node);
      }
      else if (type == SNBT_OBJECT) {
        return new MCFunctionSnbtObjectImpl(node);
      }
      else if (type == SNBT_VALUE) {
        return new MCFunctionSnbtValueImpl(node);
      }
      else if (type == TARGET) {
        return new MCFunctionTargetImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
