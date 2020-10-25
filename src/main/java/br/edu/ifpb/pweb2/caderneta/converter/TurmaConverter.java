package br.edu.ifpb.pweb2.caderneta.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.ifpb.pweb2.caderneta.model.Turma;

@FacesConverter(forClass = Turma.class)
public class TurmaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.isEmpty()) {
            return (Turma) component.getAttributes().get(value);
        }
        return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Turma) {
			Turma entity= (Turma) value;
            if (entity != null && entity instanceof Turma && entity.getId() != null) {
            	component.getAttributes().put( entity.getId().toString(), entity);
                return entity.getId().toString();
            }
        }
        return "";
	}

}
