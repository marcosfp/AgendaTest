/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ed.agenda.dao;

import ed.agenda.entidades.Contacto;
import ed.agenda.entidades.ContactoEmpresa;
import ed.agenda.entidades.ContactoPersona;
import ed.agenda.excepciones.ContactoNoEncontradoException;
import ed.agenda.excepciones.PosicionNoEncontradaException;
import java.util.ArrayList;

/**
 *
 * @author marco
 */
public class AgendaDaoArrayList implements AgendaDao {

    String nomre;
    static ArrayList<Contacto> contactos = new ArrayList<Contacto>();

    public static ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public static void setContactos(ArrayList<Contacto> contactos) {
        AgendaDaoArrayList.contactos = contactos;
    }

    @Override
    public boolean crearContactoPersona(ContactoPersona c) {
        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).getNombre().equalsIgnoreCase(c.getNombre())) {
                return false;
            }
        }
        contactos.add(c);
        return true;
    }

    @Override
    public boolean crearContactoEmpresa(ContactoEmpresa c) {
        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).getNombre().equalsIgnoreCase(c.getNombre())) {
                return false;
            }
        }
        contactos.add(c);
        return true;
    }

    @Override
    public boolean borrarContactoPorPosicion(int index) throws PosicionNoEncontradaException {
        if (index > contactos.size()) throw new PosicionNoEncontradaException();
        
        System.out.println("Borrado "+ contactos.get(index).toString());
        contactos.remove(index);
        return false;
 }

    @Override
    public Contacto obtenerContactoPorPosicion(int index) {
        return contactos.get(index);
    }

    @Override
    public Contacto obtenerContactoPorNombre(String nombre) {
        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).getNombre().equals(nombre)) {
                System.out.println("Se encuentra en la posición " + i);
                return contactos.get(i);
            }
        }
        return null;
    }

    @Override
    public void listarContactos() {
        for (int i = 0; i < contactos.size(); i++) {
            System.out.println(contactos.get(i).toString());
        }
    }

    @Override
    public boolean eliminarContactoPorNombre(String nombre) throws ContactoNoEncontradoException {
        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).getNombre().equalsIgnoreCase(nomre)) {
                contactos.remove(contactos.get(i));
                return true;
            }
        }
        return false;
    }

    @Override
    public void mostrarTrabajadoresEmpresa(String nombre) throws ContactoNoEncontradoException {
        Contacto empresa = obtenerContactoPorNombre(nombre);

//        if (empresa instanceof ContactoEmpresa){
        for (ContactoPersona trabajador : ((ContactoEmpresa) empresa).getTrabajadores()) {
            System.out.println(trabajador.toString());
        }
    }
    //        }

}
