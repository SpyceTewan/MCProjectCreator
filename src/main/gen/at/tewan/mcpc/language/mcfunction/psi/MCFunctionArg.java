// This is a generated file. Not intended for manual editing.
package at.tewan.mcpc.language.mcfunction.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MCFunctionArg extends PsiElement {

  @Nullable
  MCFunctionLiteralArg getLiteralArg();

  @Nullable
  MCFunctionNumberArg getNumberArg();

  @Nullable
  MCFunctionResource getResource();

  @Nullable
  MCFunctionSnbtCompound getSnbtCompound();

  @Nullable
  MCFunctionTarget getTarget();

}
