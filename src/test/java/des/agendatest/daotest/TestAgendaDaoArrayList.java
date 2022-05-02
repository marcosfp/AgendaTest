/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package des.agendatest.daotest;

import ed.agenda.dao.AgendaDaoArrayList;
import ed.agenda.entidades.Contacto;
import ed.agenda.entidades.ContactoPersona;
import java.util.ArrayList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author marco
 */
public class TestAgendaDaoArrayList {
    
//    @Before
//    public void vaciarArray(){
//                dao.setContactos(new ArrayList<Contacto>());
//
//    }
    
    @Test
    public void TestCrearContactoPersona (){
    
    ContactoPersona CP1 = new ContactoPersona("11221999", "Bill Gates", "+34 981 666666");
        AgendaDaoArrayList dao = new AgendaDaoArrayList();

        //Verifico que la agenda esta vacia
        assertTrue(dao.getContactos().isEmpty());
        //Añado el cotnacto persona
        dao.crearContactoPersona(CP1);

        //Verifico que la agenda contiene el contacto que yo he añadido
        assertTrue(dao.getContactos().contains(CP1));
        //Verificao que la agenda a aumentado su catidad de cotnactos en 1
        assertTrue(dao.getContactos().size()==1);
        
        
        
    
    }
    
    
        @Test
    public void TestCrearContactoPersonaConNombreInvalido (){
    
    ContactoPersona CP1 = new ContactoPersona("11221999", "Bi", "+34 981 666666");
        AgendaDaoArrayList dao2 = new AgendaDaoArrayList();

        //Verifico que la agenda esta vacia
        assertTrue(dao2.getContactos().isEmpty());
        //Añado el cotnacto persona
        dao2.crearContactoPersona(CP1);

        //Verificamos que no se ha añadido ya que el nombre solo tiene 3 carcteres
        assertTrue(dao2.getContactos().isEmpty());
        
        CP1.setNombre("asfdjaonvsoasnfbjinafpubnapjifnbihpabinadipvasodpvnpasidvipasndpivnasdnviSDVni");
        assertFalse(dao2.crearContactoPersona(CP1));//Añado el cotnacto persona y devuelve false
        //Verificamos que no se ha añadido ya que el nombre solo tiene 3 carcteres
        assertTrue(dao2.getContactos().isEmpty());
    }
    
}
