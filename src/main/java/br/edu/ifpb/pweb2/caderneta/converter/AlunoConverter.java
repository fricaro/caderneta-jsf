package br.edu.ifpb.pweb2.caderneta.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.ifpb.pweb2.caderneta.model.Aluno;

@FacesConverter(forClass = Aluno.class)
public class AlunoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.isEmpty()) {
            return (Aluno) component.getAttributes().get(value);
        }
        return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Aluno) {
			Aluno entity= (Aluno) value;
            if (entity != null && entity instanceof Aluno && entity.getId() != null) {
            	component.getAttributes().put( entity.getId().toString(), entity);
                return entity.getId().toString();
            }
        }
        return "";
	}

}
