package br.unitins.topicos2.converter;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.unitins.topicos2.model.Cidade;

@FacesConverter(value = "cidadeConverter", forClass=Cidade.class)
public class CidadeConverter implements Converter<Object>{
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null) {
			return getMapaObjetos(component).get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Cidade c = (Cidade) value;
			addAtributo(component, c);
			String chave = String.valueOf(c.getId());
			return chave;
		}
		return (String) value;
	}
	
	protected Map<String, Object> getMapaObjetos(UIComponent component){
		return component.getAttributes();
	}
	
	protected void addAtributo(UIComponent component, Cidade cidade) {
		String chave = String.valueOf(cidade.getId());
		getMapaObjetos(component).put(chave, cidade);
	}


}
