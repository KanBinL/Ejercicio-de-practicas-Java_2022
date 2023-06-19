package parcela;
import java.io.*;

public class Control {
    private Usuario inicial;
    private Usuario fin;

    public Control() {
        this.inicial= this.fin = null;
    }

    public void add(int id_usuario, String dni, String nombre, String apellidos, String correo, String password){
        Usuario nuevo = new Usuario(id_usuario, dni, nombre, apellidos, correo, password);

        if (inicial == null){
            inicial = fin = nuevo;
        } else {
            nuevo.setEnlace(inicial);
            inicial = nuevo;
        }
    }

    public void addFin(int id_usuario, String dni, String nombre, String apellidos, String correo, String password){
        Usuario nuevo = new Usuario(id_usuario, dni, nombre, apellidos, correo, password);

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
            FileReader leer = new FileReader("usuario.txt");           
            BufferedReader mibuffer = new BufferedReader(leer);
            
            while((linea = mibuffer.readLine()) != null) {
                if(linea!=null) {
                    String[] info = linea.split("-");
                    add(Integer.parseInt(info[0]),info[1],info[2],info[3],info[4],info[5]);
                }
            }
            leer.close();
        } catch (FileNotFoundException e){
            System.err.println("No se ha encontrado datos guardados");
        }
    }

    public void guardar(int id_usuario, String dni, String nombre, String apellidos, String correo, String password){
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            //Gurdar los datos
            String data = id_usuario + "-" + dni + "-" + nombre + "-" + apellidos + "-" + correo + "-" + password + "\n";
            File file = new File("usuario.txt");
            // Si el archivo no existe, se crea!
            if (!file.exists()) {
                file.createNewFile();
            }
            // flag true, indica adjuntar información al archivo.
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write(data);
            System.out.println("Se ha guardado correctamente los datos!");
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
            FileWriter guardar = new FileWriter("usuario.txt");
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
        Usuario aux = inicial;
        while(aux!=null){
	        try {
	            //Reguardar los datos
	            String data = aux.getId_usuario() + "-" + aux.getDni() + "-" + aux.getNombre() + "-" + aux.getApellidos() + "-" + aux.getCorreo() + "-" + aux.getPassword() + "\n";
	            File file = new File("usuario.txt");
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

    public void imprimir(){
        Usuario aux = inicial;
        
        while(aux!=null)
        {
          System.out.println(aux.getId_usuario());
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
            return inicial.getId_usuario();
        }
        return 0;
    }

    public void reverse() {
        Usuario aux = inicial;
        inicial = null;
        fin = null;
        
        while(aux!=null) {
            this.add(aux.getId_usuario(), aux.getDni(), aux.getNombre(), aux.getApellidos(), aux.getCorreo(), aux.getPassword());
            aux = aux.getEnlace();
        }
    }
    
    // Buscar repetidos
    public boolean repetirCorreo(String correo){
        Usuario aux = inicial;
        
        while(aux!=null){
            if(aux.getCorreo().equals(correo)){
                return true;
            }
            aux = aux.getEnlace();
        }
        return false;
    }

    public boolean repetirPassword(String password){
        Usuario aux = inicial;
        
        while(aux!=null){
            if(aux.getPassword().equals(password)){
                return true;
            }
            aux = aux.getEnlace();
        }
        return false;
    }

    // Buscar usuario
    public Usuario cargarUsuario(String x) {
        Usuario aux = inicial;

        while(aux!=null) {
            if(aux.getCorreo().equals(x)) {
                return aux;
            }
            aux = aux.getEnlace();
        }
        return null;
    }
    
}

