/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.malbino.orion.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.malbino.orion.entities.Carrera;
import org.malbino.orion.entities.Log;
import org.malbino.orion.entities.Modulo;
import org.malbino.orion.enums.EntidadLog;
import org.malbino.orion.enums.EventoLog;
import org.malbino.orion.facades.MateriaFacade;
import org.malbino.orion.facades.negocio.PlanEstudioFacade;
import org.malbino.orion.util.Fecha;

/**
 *
 * @author Tincho
 */
@Named("MateriaController")
@SessionScoped
public class MateriaController extends AbstractController implements Serializable {

    @EJB
    MateriaFacade materiaFacade;
    @EJB
    PlanEstudioFacade planEstudioFacade;
    @Inject
    LoginController loginController;

    private List<Modulo> materias;
    private Modulo nuevaMateria;
    private Modulo seleccionMateria;
    private Carrera seleccionCarrera;

    private String keyword;

    @PostConstruct
    public void init() {
        materias = new ArrayList();
        nuevaMateria = new Modulo();
        seleccionMateria = null;

        keyword = null;
    }

    public void reinit() {
        if (seleccionCarrera != null) {
            materias = materiaFacade.listaMaterias(seleccionCarrera);
        }
        nuevaMateria = new Modulo();
        seleccionMateria = null;

        keyword = null;
    }

    public void buscar() {
        if (seleccionCarrera != null) {
            materias = materiaFacade.buscar(keyword, seleccionCarrera.getId_carrera());
        }
    }

    public List<Modulo> listaMateriasCrear() {
        return materiaFacade.listaMaterias(seleccionCarrera);
    }

    public List<Modulo> listaMateriasEditar() {
        return materiaFacade.listaMaterias(seleccionMateria.getCarrera(), seleccionMateria.getId_modulo());
    }

    public void crearMateria() throws IOException {
        nuevaMateria.setCarrera(seleccionCarrera);
        if (materiaFacade.buscarPorCodigo(nuevaMateria.getCodigo(), nuevaMateria.getCarrera()).isEmpty()) {
            if (materiaFacade.create(nuevaMateria)) {
                //log
                logFacade.create(new Log(Fecha.getDate(), EventoLog.CREATE, EntidadLog.MATERIA, nuevaMateria.getId_modulo(), "Creación materia", loginController.getUsr().toString()));

                this.toMaterias();
            }
        } else {
            this.mensajeDeError("Materia repetida.");
        }
    }

    public void editarMateria() throws IOException {
        if (materiaFacade.buscarPorCodigo(seleccionMateria.getCodigo(), seleccionMateria.getId_modulo(), seleccionMateria.getCarrera()).isEmpty()) {
            if (materiaFacade.edit(seleccionMateria)) {
                //log
                logFacade.create(new Log(Fecha.getDate(), EventoLog.UPDATE, EntidadLog.MATERIA, seleccionMateria.getId_modulo(), "Actualización materia", loginController.getUsr().toString()));

                this.toMaterias();
            }
        } else {
            this.mensajeDeError("Materia repetida.");
        }
    }

    public void eliminarMateria() throws IOException {
        if (planEstudioFacade.eliminarMateria(seleccionMateria)) {
            //log
            logFacade.create(new Log(Fecha.getDate(), EventoLog.DELETE, EntidadLog.MATERIA, seleccionMateria.getId_modulo(), "Borrado materia", loginController.getUsr().toString()));

            this.toMaterias();
        }
    }

    public void toNuevaMateria() throws IOException {
        this.redireccionarViewId("/planesEstudio/materia/nuevaMateria");
    }

    public void toEditarMateria() throws IOException {
        this.redireccionarViewId("/planesEstudio/materia/editarMateria");
    }

    public void toMaterias() throws IOException {
        reinit();

        this.redireccionarViewId("/planesEstudio/materia/materias");
    }

    /**
     * @return the materias
     */
    public List<Modulo> getMaterias() {
        return materias;
    }

    /**
     * @param materias the materias to set
     */
    public void setMaterias(List<Modulo> materias) {
        this.materias = materias;
    }

    /**
     * @return the nuevaMateria
     */
    public Modulo getNuevaMateria() {
        return nuevaMateria;
    }

    /**
     * @param nuevaMateria the nuevaMateria to set
     */
    public void setNuevaMateria(Modulo nuevaMateria) {
        this.nuevaMateria = nuevaMateria;
    }

    /**
     * @return the seleccionMateria
     */
    public Modulo getSeleccionMateria() {
        return seleccionMateria;
    }

    /**
     * @param seleccionMateria the seleccionMateria to set
     */
    public void setSeleccionMateria(Modulo seleccionMateria) {
        this.seleccionMateria = seleccionMateria;
    }

    /**
     * @return the seleccionCarrera
     */
    public Carrera getSeleccionCarrera() {
        return seleccionCarrera;
    }

    /**
     * @param seleccionCarrera the seleccionCarrera to set
     */
    public void setSeleccionCarrera(Carrera seleccionCarrera) {
        this.seleccionCarrera = seleccionCarrera;
    }

    /**
     * @return the keyword
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * @param keyword the keyword to set
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
