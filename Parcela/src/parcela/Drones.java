package parcela;

import java.io.*;

public class Drones {
    private int id_dron;
    private String nombre;
    private String marca;
    private int id_usuario;
    
    private Drones inicial;
    private Drones fin;
    private Drones enlace;

    
    public Drones() {
        this.id_dron = 0;
        this.nombre = null;
        this.marca = null;
        this.id_usuario = 0;
    }
    
    public Drones(int id_dron, String nombre, String marca, int id_usuario) {
        this.id_dron = id_dron;
        this.nombre = nombre;
        this.marca = marca;
        this.id_usuario = id_usuario;
    }

	public int getId_dron() {
		return id_dron;
	}

	public void setId_dron(int id_dron) {
		this.id_dron = id_dron;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	public Drones getEnlace() {
		return enlace;
	}

	public void setEnlace(Drones enlace) {
		this.enlace = enlace;
	}
	
	
	// Control para drones
    
    public void add(int id_dron, String nombre, String marca, int id_usuario){
        Drones nuevo = new Drones(id_dron, nombre, marca, id_usuario);

        if (inicial == null){
            inicial = fin = nuevo;
        } else {
            nuevo.setEnlace(inicial);
            inicial = nuevo;
        }
    }
	
    public void addFin(int id_dron, String nombre, String marca, int id_usuario){
        Drones nuevo = new Drones(id_dron, nombre, marca, id_usuario);

        if(inicial == null){
            inicial = fin = nuevo;
        } else {
            fin.setEnlace(nuevo);
            fin = nuevo;
        }
    }
    
    public void leer() throws IOException {
        try {
            String linea;
            FileReader leer = new FileReader("drones.txt");           
            BufferedReader mibuffer = new BufferedReader(leer);
            
            while((linea = mibuffer.readLine()) != null) {
                if(linea!=null) {
                    String[] info = linea.split("-");
                    add(Integer.parseInt(info[0]),info[1],info[2],Integer.parseInt(info[3]));
                }
            }
            leer.close();
        } catch (FileNotFoundException e){
            System.err.println("No se ha encontrado datos guardados");
        }
    }
	
    public void guardar(int id_dron, String nombre, String marca, int id_usuario){
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            //Gurdar los datos
            String data = id_dron + "-" + nombre + "-" + marca + "-" + id_usuario + "\n";
            File file = new File("drones.txt");
            // Si el archivo no existe, se crea!
            if (!file.exists()) {
                file.createNewFile();
            }
            // flag true, indica adjuntar información al archivo.
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write(data);
    		System.out.println("Se ha creado correctamente!");
        } catch (IOException e) {
            System.out.println("No se ha gurdado correctamente!");
        } finally {
            try {
                //Cierra instancias de FileWriter y BufferedWriter
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                System.out.println("No se ha gurdado correctamente!");
            }
        }
    }
    
    public void borraDatos(){
        try {
            String dato = "";
            FileWriter guardar = new FileWriter("drones.txt");
    		// FileWriter guardar = new FileWriter("1.txt", true); agrega de mas, sin sobre escribir
            
            guardar.write(dato);
        	guardar.close();
        } catch (IOException e) {
            System.out.println("No se ha borrado correctamente!");
        }
    }

    public void reGuardar(){
        BufferedWriter bw = null;
        FileWriter fw = null;
        borraDatos();
        reverse();
        Drones aux = inicial;
        while(aux!=null){
	        try {
	            //Reguardar los datos
	            String data = aux.getId_dron() + "-" + aux.getNombre() + "-" + aux.getMarca() + "-" + aux.getId_usuario() + "\n";
	            File file = new File("drones.txt");
	            // Si el archivo no existe, se crea!
	            if (!file.exists()) {
	                file.createNewFile();
	            }
	            // flag true, indica adjuntar información al archivo.
	            fw = new FileWriter(file.getAbsoluteFile(), true);
	            bw = new BufferedWriter(fw);
	            bw.write(data);
	            aux = aux.getEnlace();
            	
	        } catch (IOException e) {
	            System.out.println("No se ha gurdado correctamente!");
	        } finally {
	            try {
	                //Cierra instancias de FileWriter y BufferedWriter
	                if (bw != null)
	                    bw.close();
	                if (fw != null)
	                    fw.close();
	            } catch (IOException ex) {
	                System.out.println("No se ha gurdado correctamente!");
	            }
	        }
        }
    }
    
    public void imprimir(int x){
        Drones aux = inicial;
        
        while(aux!=null)
        {
            if(x == aux.getId_usuario()) {
				System.out.println("---------Drones---------");
				System.out.println("     ID: " + aux.getId_dron());
				System.out.println("     Nombre: " + aux.getNombre());
				System.out.println("     Marca: " + aux.getMarca());
				System.out.println("------------------------");
	            System.out.println("");
            }
            aux = aux.getEnlace();
        }
    }
    
    public boolean esVacia()
    {
        if(inicial == null){
            return true;
        }
        return false;
    }
    
    public int valoInicial(){
        if(!esVacia()){
            return inicial.getId_dron();
        }
        return 0;
    }
    
    public boolean borra(int x, int y) {
        Drones ant = null;
        Drones aux = inicial;

        while(aux!=null) {
            if(x == aux.getId_dron() && y == aux.getId_usuario()) {
                if(this.fin == this.inicial) {
                    inicial = fin = null;
                } else {
                    if(aux == inicial) {
                        inicial = aux.getEnlace();
                        aux.setEnlace(null);
                        aux = inicial;
                    } else {
                        if(aux == fin) {
                            fin =ant;
                       } 
                        ant.setEnlace(aux.getEnlace());
                        aux.setEnlace(null);
                        aux = aux.getEnlace();
                    }
                }
                return true;
            } else {
                ant = aux;
                aux = aux.getEnlace();
            }
        }
        return false;
    }
    
    public boolean permiso(int x, int y) {
        Drones aux = inicial;

        while(aux!=null) {
            if(x == aux.getId_dron() && y == aux.getId_usuario()) {
                return true;
            }
            aux = aux.getEnlace();
        }
        return false;
    }
    
    public void reverse() {
        Drones aux = inicial;
        inicial = null;
        fin = null;
        
        while(aux!=null) {
            this.add(aux.getId_dron(), aux.getNombre(), aux.getMarca(), aux.getId_usuario());
            aux = aux.getEnlace();
        }
    }
    
    public Drones cargarDron(int x) {
        Drones aux = inicial;

        while(aux!=null) {
            if(aux.getId_dron() == x) {
                return aux;
            }
            aux = aux.getEnlace();
        }
        return null;
    }
}
