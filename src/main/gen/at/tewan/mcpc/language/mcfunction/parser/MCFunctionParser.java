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
  // COMMAND_NAME ((COMMAND_ARGUMENT|TARGET_SELECTOR)?)+
  public static boolean command(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command")) return false;
    if (!nextTokenIs(b, COMMAND_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMAND_NAME);
    r = r && command_1(b, l + 1);
    exit_section_(b, m, COMMAND, r);
    return r;
  }

  // ((COMMAND_ARGUMENT|TARGET_SELECTOR)?)+
  private static boolean command_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = command_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!command_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "command_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMAND_ARGUMENT|TARGET_SELECTOR)?
  private static boolean command_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_1_0")) return false;
    command_1_0_0(b, l + 1);
    return true;
  }

  // COMMAND_ARGUMENT|TARGET_SELECTOR
  private static boolean command_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, COMMAND_ARGUMENT);
    if (!r) r = consumeToken(b, TARGET_SELECTOR);
    return r;
  }

  /* ********************************************************** */
  // command|COMMENT|CRLF
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    r = command(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, CRLF);
    return r;
  }

  /* ********************************************************** */
  // item_*
  static boolean mcfunctionFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mcfunctionFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "mcfunctionFile", c)) break;
    }
    return true;
  }

}
