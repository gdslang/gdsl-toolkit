package gdsl.plugin.ui.labeling

import com.google.inject.Inject
import gdsl.plugin.gDSL.ConDecl
import gdsl.plugin.gDSL.DeclExport
import gdsl.plugin.gDSL.Val
import gdsl.plugin.gDSL.Ty
import gdsl.plugin.gDSL.Type
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider
import org.eclipse.jdt.ui.ISharedImages
import org.eclipse.jdt.ui.JavaUI
import org.eclipse.jface.viewers.StyledString
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider
import static extension org.eclipse.xtext.EcoreUtil2.*

/**
 * Provides labels for a EObjects.
 * 
 * @author Daniel Endress
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#labelProvider
 */
class GDSLLabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	new(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}


	def text(DeclExport e){
		e.name.name
	}
	def image(DeclExport e){
		JavaUI.sharedImages.getImage(ISharedImages.IMG_OBJS_PRIVATE)
	}

	def text(Type t){
		var result = new StyledString()
		result.append(t.name)
		if(null != t.value){
			val style = StyledString.DECORATIONS_STYLER
			result.append(" = " + text(t.value), style)
		}
		return result
	}
	def String text(Ty t){
		var result = new StringBuilder()
		if(null != t.value){
			result.append(t.value)
		}
		if(null != t.typeRef){
			result.append(t.typeRef.name)
		}
		if(null != t.type){
			result.append(t.type)
		}
		if(null != t.elements && t.elements.length > 0){
			result.append('{')
			result.append(t.elements.get(0).name + ':' + text(t.elements.get(0).value))
			var i = 1
			while(i < t.elements.length){
				result.append(", " + t.elements.get(i).name + ':' + text(t.elements.get(i).value))
				i=i+1
			}
			result.append('}')
		}
		result.toString
	}
	def image(Type t){
		JavaUI.sharedImages.getImage(ISharedImages.IMG_OBJS_PROTECTED)
	}
	
	def text(ConDecl cd){
		val style = StyledString.COUNTER_STYLER
		var result = new StyledString()
		result.append(cd.name.conName)
		if(null != cd.ty){
			result.append(' (' + text(cd.ty) + ')', style)
		}
		result.append(' : ' + cd.getContainerOfType(typeof(Type)).name, style)
		return result
	}
	def image(ConDecl cd){
		JavaUI.sharedImages.getImage(ISharedImages.IMG_OBJS_IMPDECL)
	}
	
	def text(Val v){
		var result = new StyledString()
		result.append(v.name)
		val decPat = v.decPat
		if(null != decPat && decPat.length > 0){
			var bitPat = new StringBuilder()
			for(s : decPat){
				bitPat.append(" " + s)
			}
			result.append(" [" + bitPat.toString.trim + "]", StyledString.QUALIFIER_STYLER)
		}
		val attr = v.attr
		if(null != attr && attr.length > 0){
			val style = StyledString.COUNTER_STYLER
			result.append(" (", style)
			result.append(attr.get(0), style)
			var i = 1;
			while(i < attr.length){
				result.append(", " + attr.get(i), style)
				i=i+1
			}
			result.append(")", style)
		}
		return result
	}
	def image(Val v){
		JavaUI.sharedImages.getImage(ISharedImages.IMG_OBJS_PUBLIC)
	}
	
}
