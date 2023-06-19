package Nodo;

public class Contacto {
    private String nombre;
    private int edad;
    
    public Contacto() {
        this.nombre = null;
        this.edad = 0;
    }
    
    public Contacto(String p_nombre) {
    	this.nombre = p_nombre;
    	this.edad = 0;
    }
    
    public Contacto(String p_nombre, int p_edad) {
    	this.nombre = p_nombre;
    	this.edad = p_edad;
    }
     
     
    public String getNombre() {
    	return this.nombre;
    }
     
    public int getEdad() {
		return this.edad;
    }

     
    public void setEnlace(String p_nombre) {
    	this.nombre = p_nombre;
    }
    
    public void setDato(int p_edad) {
    	this.edad = p_edad;
    }
}
