package br.edu.ifpb.pweb2.caderneta.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.ifpb.pweb2.caderneta.model.Disciplina;

@FacesConverter(forClass = Disciplina.class)
public class DisciplinaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.isEmpty()) {
            return (Disciplina) component.getAttributes().get(value);
        }
        return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Disciplina) {
			Disciplina entity= (Disciplina) value;
            if (entity != null && entity instanceof Disciplina && entity.getId() != null) {
            	component.getAttributes().put( entity.getId().toString(), entity);
                return entity.getId().toString();
            }
        }
        return "";
	}

}
