/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.malbino.orion.converters;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.malbino.orion.entities.Carrera;
import org.malbino.orion.entities.CarreraEstudiante;
import org.malbino.orion.enums.Nivel;
import org.malbino.orion.facades.CarreraFacade;

/**
 *
 * @author malbino
 */
@Named(value = "CarreraEstudianteConverter")
@RequestScoped
public class CarreraEstudianteConverter implements Converter {

    @EJB
    CarreraFacade carreraFacade;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
        Object o = null;

        if (submittedValue == null || submittedValue.isEmpty()) {
            o = null;
        } else {
            String[] split = submittedValue.split(",");

            Integer id_carrera = Integer.valueOf(split[0]);
            Integer id_persona = Integer.valueOf(split[1]);
            Nivel nivel = Nivel.getById(Integer.valueOf(split[2]));

            CarreraEstudiante.CarreraEstudianteId carreraEstudianteId = new CarreraEstudiante.CarreraEstudianteId();
            carreraEstudianteId.setId_carrera(id_carrera);
            carreraEstudianteId.setId_persona(id_persona);

            CarreraEstudiante carreraEstudiante = new CarreraEstudiante();
            carreraEstudiante.setCarreraEstudianteId(carreraEstudianteId);
            carreraEstudiante.setNivelInicio(nivel);

            Carrera carrera = carreraFacade.find(id_carrera);
            carreraEstudiante.setCarrera(carrera);

            o = carreraEstudiante;
        }

        return o;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
        String s;

        if (value == null || value.equals("")) {
            s = "";
        } else {
            CarreraEstudiante ce = (CarreraEstudiante) value;
            s = String.valueOf(
                    ce.getCarreraEstudianteId().getId_carrera()
                    + "," + ce.getCarreraEstudianteId().getId_persona()
            );

            if (ce.getNivelInicio() != null) {
                s += "," + ce.getNivelInicio().getId();
            } else {
                s += ",-1";
            }
        }

        return s;
    }

}
