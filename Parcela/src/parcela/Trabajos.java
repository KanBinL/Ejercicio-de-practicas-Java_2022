package parcela;

import java.io.*;

public class Trabajos {
    private int id_trabajo;
    private int id_dron;
    private int id_parcela;
    private String tarea;
    private String fecha;
    private boolean estado;
    private int id_usuario;

		
    
    private Trabajos inicial;
    private Trabajos fin;
    private Trabajos enlace;
    
    public Trabajos() {
        this.id_trabajo = 0;
        this.id_dron = 0;
        this.id_parcela = 0;
        this.tarea = null;
        this.fecha = null;
        this.estado = false;
        this.id_usuario = 0;
    }
    
    public Trabajos(int id_trabajo, int id_dron, int id_parcela, String tarea, String fecha, boolean estado, int id_usuario) {
        this.id_trabajo = id_trabajo;
        this.id_dron = id_dron;
        this.id_parcela = id_parcela;
        this.tarea = tarea;
        this.fecha = fecha;
        this.estado = estado;
        this.id_usuario = id_usuario;
    }

	public int getId_trabajo() {
		return id_trabajo;
	}

	public void setId_trabajo(int id_trabajo) {
		this.id_trabajo = id_trabajo;
	}

	public int getId_dron() {
		return id_dron;
	}

	public void setId_dron(int id_dron) {
		this.id_dron = id_dron;
	}

	public int getId_parcela() {
		return id_parcela;
	}

	public void setId_parcela(int id_parcela) {
		this.id_parcela = id_parcela;
	}

	public String getTarea() {
		return tarea;
	}

	public void setTarea(String tarea) {
		this.tarea = tarea;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Trabajos getInicial() {
		return inicial;
	}

	public void setInicial(Trabajos inicial) {
		this.inicial = inicial;
	}

	public Trabajos getFin() {
		return fin;
	}

	public void setFin(Trabajos fin) {
		this.fin = fin;
	}

	public Trabajos getEnlace() {
		return enlace;
	}

	public void setEnlace(Trabajos enlace) {
		this.enlace = enlace;
	}
    
    public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
    
	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	
	// Control para trabajo
    
	public void add(int id_trabajo, int id_dron, int id_parcela, String tarea, String fecha, boolean estado, int id_usuario){
        Trabajos nuevo = new Trabajos(id_trabajo, id_dron, id_parcela, tarea, fecha, estado, id_usuario);

        if (inicial == null){
            inicial = fin = nuevo;
        } else {
            nuevo.setEnlace(inicial);
            inicial = nuevo;
        }
    }
	
    public void addFin(int id_trabajo, int id_dron, int id_parcela, String tarea, String fecha, boolean estado, int id_usuario){
        Trabajos nuevo = new Trabajos(id_trabajo, id_dron, id_parcela, tarea, fecha, estado, id_usuario);

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
            FileReader leer = new FileReader("trabajo.txt");           
            BufferedReader mibuffer = new BufferedReader(leer);
            
            while((linea = mibuffer.readLine()) != null) {
                if(linea!=null) {
                    String[] info = linea.split("-");
                    add(Integer.parseInt(info[0]),Integer.parseInt(info[1]),Integer.parseInt(info[2]),info[3],info[4],Boolean.parseBoolean(info[5]),Integer.parseInt(info[6]));
                }
            }
            leer.close();
        } catch (FileNotFoundException e){
            System.err.println("No se ha encontrado datos guardados");
        }
    }
	
    public void guardar(int id_trabajo, int id_dron, int id_parcela, String tarea, String fecha, boolean estado, int id_usuario){
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            //Gurdar los datos
            String data = id_trabajo + "-" + id_dron + "-" + id_parcela + "-" + tarea + "-" + fecha + "-" + estado + "-" + id_usuario + "\n";
            File file = new File("trabajo.txt");
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
            FileWriter guardar = new FileWriter("trabajo.txt");
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
        Trabajos aux = inicial;
        while(aux!=null){
	        try {
	            //Reguardar los datos
	            String data = aux.getId_trabajo() + "-" + aux.getId_dron() + "-" + aux.getId_parcela() + "-" + aux.getTarea() + "-" + aux.getFecha() + "-" + aux.getEstado() + "-" + aux.getId_usuario() + "\n";
	            File file = new File("trabajo.txt");
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
        Trabajos aux = inicial;
        
        while(aux!=null)
        {
            if(x == aux.getId_usuario() && false == aux.getEstado()) {
				System.out.println("---------Trabajo---------");
				System.out.println("     ID: " + aux.getId_trabajo());
				System.out.println("     Dron: " + aux.getId_dron());
				System.out.println("     Parcela: " + aux.getId_parcela());
				System.out.println("     Tarea: " + aux.getTarea());
				System.out.println("     Estado: " + aux.getEstado());
				System.out.println("     Fecha: " + aux.getFecha());
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
            return inicial.getId_trabajo();
        }
        return 0;
    }
    
    public boolean permiso(int x, int y) {
        Trabajos aux = inicial;

        while(aux!=null) {
            if(x == aux.getId_trabajo() && y == aux.getId_usuario()) {
                return true;
            }
            aux = aux.getEnlace();
        }
        return false;
    }
    
    public void reverse() {
    	Trabajos aux = inicial;
        inicial = null;
        fin = null;
        
        while(aux!=null) {
            this.add(aux.getId_trabajo(), aux.getId_dron(), aux.getId_parcela(), aux.getTarea(), aux.getFecha(), aux.getEstado(), aux.getId_usuario());
            aux = aux.getEnlace();
        }
    }
    
    public Trabajos cargarTran(int x) {
    	Trabajos aux = inicial;

        while(aux!=null) {
            if(aux.getId_trabajo() == x) {
                return aux;
            }
            aux = aux.getEnlace();
        }
        return null;
    }
    
    
    
    
    
    
    
    
    
    
    
}
