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
  // COMMAND_ARGUMENT | target
  public static boolean arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg")) return false;
    if (!nextTokenIs(b, "<arg>", COMMAND_ARGUMENT, TARGET_SELECTOR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARG, "<arg>");
    r = consumeToken(b, COMMAND_ARGUMENT);
    if (!r) r = target(b, l + 1);
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
  // TARGET_SELECTOR(TARGET_BODY_START WHITE_SPACE? TARGET_ATTR_KEY WHITE_SPACE? TARGET_ATTR_EQU WHITE_SPACE? TARGET_BODY_END)?
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

  // (TARGET_BODY_START WHITE_SPACE? TARGET_ATTR_KEY WHITE_SPACE? TARGET_ATTR_EQU WHITE_SPACE? TARGET_BODY_END)?
  private static boolean target_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "target_1")) return false;
    target_1_0(b, l + 1);
    return true;
  }

  // TARGET_BODY_START WHITE_SPACE? TARGET_ATTR_KEY WHITE_SPACE? TARGET_ATTR_EQU WHITE_SPACE? TARGET_BODY_END
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

  // WHITE_SPACE?
  private static boolean target_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "target_1_0_1")) return false;
    consumeToken(b, WHITE_SPACE);
    return true;
  }

  // WHITE_SPACE?
  private static boolean target_1_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "target_1_0_3")) return false;
    consumeToken(b, WHITE_SPACE);
    return true;
  }

  // WHITE_SPACE?
  private static boolean target_1_0_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "target_1_0_5")) return false;
    consumeToken(b, WHITE_SPACE);
    return true;
  }

}
