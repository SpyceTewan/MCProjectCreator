package at.tewan.mcpc.language.mcfunction.psi.impl;

import at.tewan.mcpc.language.mcfunction.psi.MCFunctionResource;
import at.tewan.mcpc.language.mcfunction.psi.MCFunctionTypes;
import at.tewan.mcpc.resource.Resource;
import com.intellij.lang.ASTNode;

public class MCFunctionPsiImplUtil {

	public static Resource getResource(MCFunctionResource element) {
		final ASTNode literalNode = element.getNode().findChildByType(MCFunctionTypes.LITERAL);
		final ASTNode idNode = element.getNode().findChildByType(MCFunctionTypes.RES_ID_NAME);

		if(literalNode == null || idNode == null) return null;
		return new Resource(literalNode.getText(), idNode.getText());
	}

}
