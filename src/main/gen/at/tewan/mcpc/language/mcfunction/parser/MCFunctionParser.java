// This is a generated file. Not intended for manual editing.
package at.tewan.mcpc.language.mcfunction.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static at.tewan.mcpc.language.mcfunction.psi.MCFunctionTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class MCFunctionParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return mcfunctionFile(b, l + 1);
  }

  /* ********************************************************** */
  // resource | number_arg | literal_arg | target | snbt_compound
  public static boolean arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARG, "<arg>");
    r = resource(b, l + 1);
    if (!r) r = number_arg(b, l + 1);
    if (!r) r = literal_arg(b, l + 1);
    if (!r) r = target(b, l + 1);
    if (!r) r = snbt_compound(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // COMMAND_NAME (SPACE arg)* COMMAND_END
  public static boolean command(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command")) return false;
    if (!nextTokenIs(b, COMMAND_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMAND_NAME);
    r = r && command_1(b, l + 1);
    r = r && consumeToken(b, COMMAND_END);
    exit_section_(b, m, COMMAND, r);
    return r;
  }

  // (SPACE arg)*
  private static boolean command_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!command_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "command_1", c)) break;
    }
    return true;
  }

  // SPACE arg
  private static boolean command_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SPACE);
    r = r && arg(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LITERAL
  public static boolean literal_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_arg")) return false;
    if (!nextTokenIs(b, LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LITERAL);
    exit_section_(b, m, LITERAL_ARG, r);
    return r;
  }

  /* ********************************************************** */
  // (command|COMMENT|WHITE_SPACE)*
  static boolean mcfunctionFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mcfunctionFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!mcfunctionFile_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "mcfunctionFile", c)) break;
    }
    return true;
  }

  // command|COMMENT|WHITE_SPACE
  private static boolean mcfunctionFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mcfunctionFile_0")) return false;
    boolean r;
    r = command(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, WHITE_SPACE);
    return r;
  }

  /* ********************************************************** */
  // NUMBER
  public static boolean number_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_arg")) return false;
    if (!nextTokenIs(b, NUMBER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NUMBER);
    exit_section_(b, m, NUMBER_ARG, r);
    return r;
  }

  /* ********************************************************** */
  // LITERAL RES_SEPARATOR RES_ID_NAME
  public static boolean resource(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resource")) return false;
    if (!nextTokenIs(b, LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LITERAL, RES_SEPARATOR, RES_ID_NAME);
    exit_section_(b, m, RESOURCE, r);
    return r;
  }

  /* ********************************************************** */
  // SNBT_ARR_START snbt_object* SNBT_ARR_END
  public static boolean snbt_array(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snbt_array")) return false;
    if (!nextTokenIs(b, SNBT_ARR_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SNBT_ARR_START);
    r = r && snbt_array_1(b, l + 1);
    r = r && consumeToken(b, SNBT_ARR_END);
    exit_section_(b, m, SNBT_ARRAY, r);
    return r;
  }

  // snbt_object*
  private static boolean snbt_array_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snbt_array_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!snbt_object(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "snbt_array_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // SNBT_COMP_START (snbt_compound_key SNBT_SEPARATOR snbt_object)* SNBT_COMP_END
  public static boolean snbt_compound(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snbt_compound")) return false;
    if (!nextTokenIs(b, SNBT_COMP_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SNBT_COMP_START);
    r = r && snbt_compound_1(b, l + 1);
    r = r && consumeToken(b, SNBT_COMP_END);
    exit_section_(b, m, SNBT_COMPOUND, r);
    return r;
  }

  // (snbt_compound_key SNBT_SEPARATOR snbt_object)*
  private static boolean snbt_compound_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snbt_compound_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!snbt_compound_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "snbt_compound_1", c)) break;
    }
    return true;
  }

  // snbt_compound_key SNBT_SEPARATOR snbt_object
  private static boolean snbt_compound_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snbt_compound_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = snbt_compound_key(b, l + 1);
    r = r && consumeToken(b, SNBT_SEPARATOR);
    r = r && snbt_object(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // STRING | SNBT_KEY
  public static boolean snbt_compound_key(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snbt_compound_key")) return false;
    if (!nextTokenIs(b, "<snbt compound key>", SNBT_KEY, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SNBT_COMPOUND_KEY, "<snbt compound key>");
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, SNBT_KEY);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (snbt_array | snbt_compound | snbt_value) SNBT_PARM_SEPARATOR?
  public static boolean snbt_object(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snbt_object")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SNBT_OBJECT, "<snbt object>");
    r = snbt_object_0(b, l + 1);
    r = r && snbt_object_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // snbt_array | snbt_compound | snbt_value
  private static boolean snbt_object_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snbt_object_0")) return false;
    boolean r;
    r = snbt_array(b, l + 1);
    if (!r) r = snbt_compound(b, l + 1);
    if (!r) r = snbt_value(b, l + 1);
    return r;
  }

  // SNBT_PARM_SEPARATOR?
  private static boolean snbt_object_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snbt_object_1")) return false;
    consumeToken(b, SNBT_PARM_SEPARATOR);
    return true;
  }

  /* ********************************************************** */
  // STRING | LITERAL | SNBT_VAL_BYTE | SNBT_VAL_SHORT | SNBT_VAL_INT | SNBT_VAL_LONG | SNBT_VAL_FLOAT | SNBT_VAL_DOUBLE
  public static boolean snbt_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snbt_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SNBT_VALUE, "<snbt value>");
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, LITERAL);
    if (!r) r = consumeToken(b, SNBT_VAL_BYTE);
    if (!r) r = consumeToken(b, SNBT_VAL_SHORT);
    if (!r) r = consumeToken(b, SNBT_VAL_INT);
    if (!r) r = consumeToken(b, SNBT_VAL_LONG);
    if (!r) r = consumeToken(b, SNBT_VAL_FLOAT);
    if (!r) r = consumeToken(b, SNBT_VAL_DOUBLE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // TARGET_SELECTOR(TARGET_BODY_START SPACE* TARGET_ATTR_KEY SPACE* TARGET_ATTR_EQU SPACE* TARGET_BODY_END)?
  public static boolean target(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "target")) return false;
    if (!nextTokenIs(b, TARGET_SELECTOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TARGET_SELECTOR);
    r = r && target_1(b, l + 1);
    exit_section_(b, m, TARGET, r);
    return r;
  }

  // (TARGET_BODY_START SPACE* TARGET_ATTR_KEY SPACE* TARGET_ATTR_EQU SPACE* TARGET_BODY_END)?
  private static boolean target_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "target_1")) return false;
    target_1_0(b, l + 1);
    return true;
  }

  // TARGET_BODY_START SPACE* TARGET_ATTR_KEY SPACE* TARGET_ATTR_EQU SPACE* TARGET_BODY_END
  private static boolean target_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "target_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TARGET_BODY_START);
    r = r && target_1_0_1(b, l + 1);
    r = r && consumeToken(b, TARGET_ATTR_KEY);
    r = r && target_1_0_3(b, l + 1);
    r = r && consumeToken(b, TARGET_ATTR_EQU);
    r = r && target_1_0_5(b, l + 1);
    r = r && consumeToken(b, TARGET_BODY_END);
    exit_section_(b, m, null, r);
    return r;
  }

  // SPACE*
  private static boolean target_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "target_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, SPACE)) break;
      if (!empty_element_parsed_guard_(b, "target_1_0_1", c)) break;
    }
    return true;
  }

  // SPACE*
  private static boolean target_1_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "target_1_0_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, SPACE)) break;
      if (!empty_element_parsed_guard_(b, "target_1_0_3", c)) break;
    }
    return true;
  }

  // SPACE*
  private static boolean target_1_0_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "target_1_0_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, SPACE)) break;
      if (!empty_element_parsed_guard_(b, "target_1_0_5", c)) break;
    }
    return true;
  }

}
