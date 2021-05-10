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
public class Agenda {
    private ArrayList<Contacto> contactos = new ArrayList();

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }
    
    

    public boolean insertarContacto(Contacto contacto){
        if (contacto!=null && 
                this.buscarTelefono(contacto.getTelefono())==null){
           
                this.contactos.add(contacto);
                return true;
           
        }
        return false;
    }
    
    public Contacto buscarTelefono(String telefono){
        /*
        for (int i = 0; i < contactos.size(); i++) {
            Contacto contacto = contactos.get(i);
        } */
        for (Contacto contacto : contactos) {
            if(contacto.getTelefono().equals(telefono)){
                return contacto;
            }
        }
        return null;
    }
    
    public boolean modificarContacto(Contacto contacto, 
            String telefono){
        if(contacto!=null && telefono!=null){
            Contacto aux = this.buscarTelefono(telefono);
            if(aux!=null){
                aux.setEmail(contacto.getEmail());
                aux.setNombre(contacto.getNombre());
                if(!telefono.equals(contacto.getTelefono()) 
                        && buscarTelefono(contacto.getTelefono())==null){
                    aux.setTelefono(contacto.getTelefono());
                }
                return true;
            }
        }
        return false;
    }
    
    public Contacto borrarContacto(String telefono){
        if(telefono != null){
            Contacto aux = this.buscarTelefono(telefono);
            if(aux!=null){
                this.contactos.remove(aux);
                return aux;
            }
        }
        return null;
    }
}
