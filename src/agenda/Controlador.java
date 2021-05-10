/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.util.ArrayList;

/**
 *
 * @author CES
 */
public class Controlador {

    public void run() {
        Agenda agenda = new Agenda();
        Contacto contacto = new Contacto();
        int opc = 0;
        do {
            Vista.mostrarMenu();
            opc = Vista.leerOpcion();
            switch (opc) {
                case 1:
                    contacto = Vista.leerContacto();
                    boolean result = agenda.insertarContacto(contacto);
                    Vista.showResult(result);
                    break;
                case 2:
                    contacto = agenda.borrarContacto(Vista.leerTelefono());
                    Vista.mostrarContacto(contacto);  
                    break;
                case 3:
                    String telefono = Vista.leerTelefono();
                    contacto = Vista.leerContacto();
                    Vista.showResult(agenda.modificarContacto(contacto, telefono));
                    break;
                case 4:
                    Vista.mostrarContacto(agenda.buscarTelefono(Vista.leerTelefono()));
                    break;
                case 5:
                    ArrayList<Contacto> contactos = agenda.getContactos();
                    Vista.mostrarListado(contactos);
                    break;
                default:
                    break;
            }
        } while (opc != 0);
    }

}
