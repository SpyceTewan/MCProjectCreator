// This is a generated file. Not intended for manual editing.
package at.tewan.mcpc.language.mcfunction.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static at.tewan.mcpc.language.mcfunction.psi.MCFunctionTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import at.tewan.mcpc.language.mcfunction.psi.*;

public class MCFunctionArgImpl extends ASTWrapperPsiElement implements MCFunctionArg {

  public MCFunctionArgImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MCFunctionVisitor visitor) {
    visitor.visitArg(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MCFunctionVisitor) accept((MCFunctionVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public MCFunctionLiteralArg getLiteralArg() {
    return findChildByClass(MCFunctionLiteralArg.class);
  }

  @Override
  @Nullable
  public MCFunctionNumberArg getNumberArg() {
    return findChildByClass(MCFunctionNumberArg.class);
  }

  @Override
  @Nullable
  public MCFunctionResource getResource() {
    return findChildByClass(MCFunctionResource.class);
  }

  @Override
  @Nullable
  public MCFunctionSnbtCompound getSnbtCompound() {
    return findChildByClass(MCFunctionSnbtCompound.class);
  }

  @Override
  @Nullable
  public MCFunctionTarget getTarget() {
    return findChildByClass(MCFunctionTarget.class);
  }

}
