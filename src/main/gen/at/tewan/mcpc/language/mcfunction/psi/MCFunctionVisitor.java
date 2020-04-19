// This is a generated file. Not intended for manual editing.
package at.tewan.mcpc.language.mcfunction.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class MCFunctionVisitor extends PsiElementVisitor {

  public void visitArg(@NotNull MCFunctionArg o) {
    visitPsiElement(o);
  }

  public void visitCommand(@NotNull MCFunctionCommand o) {
    visitPsiElement(o);
  }

  public void visitLiteralArg(@NotNull MCFunctionLiteralArg o) {
    visitPsiElement(o);
  }

  public void visitNumberArg(@NotNull MCFunctionNumberArg o) {
    visitPsiElement(o);
  }

  public void visitResource(@NotNull MCFunctionResource o) {
    visitPsiElement(o);
  }

  public void visitTarget(@NotNull MCFunctionTarget o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
