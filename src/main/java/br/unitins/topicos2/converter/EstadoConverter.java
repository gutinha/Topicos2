package br.unitins.topicos2.converter;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.unitins.topicos2.model.Estado;

@FacesConverter(value = "estadoConverter", forClass=Estado.class)
public class EstadoConverter implements Converter<Object>{
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
			Estado p = (Estado) value;
			addAtributo(component, p);
			String chave = String.valueOf(p.getId());
			return chave;
		}
		return (String) value;
	}
	
	protected Map<String, Object> getMapaObjetos(UIComponent component){
		return component.getAttributes();
	}
	protected void addAtributo(UIComponent component, Estado estado) {
		String chave = String.valueOf(estado.getId());
		getMapaObjetos(component).put(chave, estado);
	}


}
