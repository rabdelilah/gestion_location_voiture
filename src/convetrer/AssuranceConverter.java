package convetrer;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import sessionBeans.AssuranceFacade;
import backingBeans.util.JsfUtil;
import entity.Assurance;

@ManagedBean
public class AssuranceConverter implements Converter {
	
	@EJB
    private AssuranceFacade ejbFacade;
	
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component,
			String value) {
		if (value == null || value.length() == 0
				|| JsfUtil.isDummySelectItem(component, value)) {
			return null;
		}
		return this.ejbFacade.find(getKey(value));
	}

	java.lang.Integer getKey(String value) {
		java.lang.Integer key;
		key = Integer.valueOf(value);
		return key;
	}

	String getStringKey(java.lang.Integer value) {
		StringBuilder sb = new StringBuilder();
		sb.append(value);
		return sb.toString();
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component,
			Object object) {
		if (object == null) {
			return null;
		}
		if (object instanceof Assurance) {
			Assurance o = (Assurance) object;
			return getStringKey(o.getId());
		} else {
			throw new IllegalArgumentException("object " + object
					+ " is of type " + object.getClass().getName()
					+ "; expected type: " + Assurance.class.getName());
		}
	}

}
