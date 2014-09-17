package gdsl.plugin.ui.outline

import gdsl.plugin.gDSL.ConDecl
import gdsl.plugin.gDSL.DeclExport
import gdsl.plugin.gDSL.Val
import gdsl.plugin.gDSL.Model
import gdsl.plugin.gDSL.Type
import org.eclipse.xtext.ui.editor.outline.IOutlineNode
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode

/**
 * Customization of the default outline structure.
 * 
 * @author Daniel Endress
 *
 * see http://www.eclipse.org/Xtext/documentation.html#outline
 */
class GDSLOutlineTreeProvider extends DefaultOutlineTreeProvider {
	
	def _isLeaf(DeclExport e){ true }
	def _isLeaf(Val v){ true }
	def _isLeaf(ConDecl cd){ true }
	def _isLeaf(Type t){
		t.value != null
	}
	
	/**
	 * Skip the top level node
	 */
	def void _createChildren(DocumentRootNode outlineNode, Model model){
		model.decl.forEach[decl | createNode(outlineNode, decl)]
	}
	
	/**
	 * Create constructors as the children nodes of type elements
	 */
	def void _createChildren(IOutlineNode parent, Type type){
		type.conDecl.forEach[con | createNode(parent, con)]
	}
}
