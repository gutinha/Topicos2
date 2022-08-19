package br.unitins.topicos2.converter;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.unitins.topicos2.model.Pais;

@FacesConverter(value = "paisConverter", forClass=Pais.class)
public class PaisConverter implements Converter<Object>{
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
			Pais p = (Pais) value;
			addAtributo(component, p);
			return String.valueOf(p.getId());
		}
		return null;
	}
	
	protected Map<String, Object> getMapaObjetos(UIComponent component){
		return component.getAttributes();
	}
	protected void addAtributo(UIComponent component, Pais pais) {
		String chave = String.valueOf(pais.getId());
		getMapaObjetos(component).put(chave, pais);
	}


}
