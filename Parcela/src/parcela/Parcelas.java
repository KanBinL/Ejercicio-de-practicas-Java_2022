package parcela;

import java.io.*;

public class Parcelas {
    private int id_parcela;
    private String direccion;
    private String ruta;
    private int tamano;
    private int id_usuario;
    
    private Parcelas inicial;
    private Parcelas fin;
    private Parcelas enlace;

    
    public Parcelas() {
        this.id_parcela = 0;
        this.direccion = null;
        this.ruta = null;
        this.tamano = 0;
        this.id_usuario = 0;
    }
    
    public Parcelas(int id_parcela, String direccion, String ruta, int tamano, int id_usuario) {
        this.id_parcela = id_parcela;
        this.direccion = direccion;
        this.ruta = ruta;
        this.tamano = tamano;
        this.id_usuario = id_usuario;
    }

	public int getId_parcela() {
		return id_parcela;
	}

	public void setId_parcela(int id_parcela) {
		this.id_parcela = id_parcela;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public int getTamano() {
		return tamano;
	}

	public void setTamano(int tamano) {
		this.tamano = tamano;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

    public Parcelas getInicial() {
		return inicial;
	}

	public void setInicial(Parcelas inicial) {
		this.inicial = inicial;
	}

	public Parcelas getFin() {
		return fin;
	}

	public void setFin(Parcelas fin) {
		this.fin = fin;
	}

	public Parcelas getEnlace() {
		return enlace;
	}

	public void setEnlace(Parcelas enlace) {
		this.enlace = enlace;
	}
	
	
	// Control para parcelas
    
	public void add(int id_parcela, String direccion, String ruta, int tamano, int id_usuario){
        Parcelas nuevo = new Parcelas(id_parcela, direccion, ruta, tamano, id_usuario);

        if (inicial == null){
            inicial = fin = nuevo;
        } else {
            nuevo.setEnlace(inicial);
            inicial = nuevo;
        }
    }
	
    public void addFin(int id_parcela, String direccion, String ruta, int tamano, int id_usuario){
        Parcelas nuevo = new Parcelas(id_parcela, direccion, ruta, tamano, id_usuario);

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
            FileReader leer = new FileReader("parcelas.txt");           
            BufferedReader mibuffer = new BufferedReader(leer);
            
            while((linea = mibuffer.readLine()) != null) {
                if(linea!=null) {
                    String[] info = linea.split("-");
                    add(Integer.parseInt(info[0]),info[1],info[2],Integer.parseInt(info[3]),Integer.parseInt(info[4]));
                }
            }
            leer.close();
        } catch (FileNotFoundException e){
            System.err.println("No se ha encontrado datos guardados");
        }
    }
	
    public void guardar(int id_parcela, String direccion, String ruta, int tamano, int id_usuario){
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            //Gurdar los datos
            String data = id_parcela + "-" + direccion + "-" + ruta + "-" + tamano + "-" + id_usuario + "\n";
            File file = new File("parcelas.txt");
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
            FileWriter guardar = new FileWriter("parcelas.txt");
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
        Parcelas aux = inicial;
        while(aux!=null){
	        try {
	            //Reguardar los datos
	            String data = aux.getId_parcela() + "-" + aux.getDireccion() + "-" + aux.getRuta() + "-" + aux.getTamano() + "-" +aux.getId_usuario() + "\n";
	            File file = new File("parcelas.txt");
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
        Parcelas aux = inicial;
        
        while(aux!=null)
        {
            if(x == aux.getId_usuario()) {
				System.out.println("------------------Parcela------------------");
				System.out.println("       ID: " + aux.getId_parcela());
				System.out.println("       Direccion: " + aux.getDireccion());
				System.out.println("       Marca: " + aux.getTamano());
				System.out.println("       Rutas: " + "(" + aux.getRuta() + ")");
				System.out.println("--------------------------------------------");
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
            return inicial.getId_parcela();
        }
        return 0;
    }
    
    public boolean borra(int x, int y) {
        Parcelas ant = null;
        Parcelas aux = inicial;

        while(aux!=null) {
            if(x == aux.getId_parcela() && y == aux.getId_usuario()) {
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
    	Parcelas aux = inicial;

        while(aux!=null) {
            if(x == aux.getId_parcela() && y == aux.getId_usuario()) {
                return true;
            }
            aux = aux.getEnlace();
        }
        return false;
    }
    
    public void reverse() {
    	Parcelas aux = inicial;
        inicial = null;
        fin = null;
        
        while(aux!=null) {
            this.add(aux.getId_parcela(), aux.getDireccion(), aux.getRuta(), aux.getTamano(),aux.getId_usuario());
            aux = aux.getEnlace();
        }
    }
    
    public Parcelas cargarParcelas(int x) {
    	Parcelas aux = inicial;

        while(aux!=null) {
            if(aux.getId_parcela() == x) {
                return aux;
            }
            aux = aux.getEnlace();
        }
        return null;
    }
    
    
    
    
    
    
}
