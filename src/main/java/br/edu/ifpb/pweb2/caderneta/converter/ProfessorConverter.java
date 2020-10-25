package br.edu.ifpb.pweb2.caderneta.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.ifpb.pweb2.caderneta.model.Professor;

@FacesConverter(forClass = Professor.class)
public class ProfessorConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.isEmpty()) {
            return (Professor) component.getAttributes().get(value);
        }
        return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Professor) {
			Professor entity= (Professor) value;
            if (entity != null && entity instanceof Professor && entity.getId() != null) {
            	component.getAttributes().put( entity.getId().toString(), entity);
                return entity.getId().toString();
            }
        }
        return "";
	}

}
