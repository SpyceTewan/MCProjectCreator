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

public class MCFunctionSnbtCompoundKeyImpl extends ASTWrapperPsiElement implements MCFunctionSnbtCompoundKey {

  public MCFunctionSnbtCompoundKeyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MCFunctionVisitor visitor) {
    visitor.visitSnbtCompoundKey(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MCFunctionVisitor) accept((MCFunctionVisitor)visitor);
    else super.accept(visitor);
  }

}
