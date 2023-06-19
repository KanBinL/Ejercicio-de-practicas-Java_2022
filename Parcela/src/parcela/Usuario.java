package parcela;
public class Usuario {
    private int id_usuario;
    private String dni;
    private String nombre;
    private String apellidos;
    private String correo;
    private String password;
    private Usuario enlace;

    
    public Usuario() {
        this.id_usuario = 0;
        this.dni = null;
        this.nombre = null;
        this.apellidos = null;
        this.correo = null;
        this.password = null; 
        this.enlace = null;
    }
    
    public Usuario(int id_usuario, String dni, String nombre, String apellidos, String correo, String password) {
        this.id_usuario = id_usuario;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.password = password;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
    }

    public Usuario getEnlace() {
        return enlace;
    }
    
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setEnlace(Usuario enlace) {
        this.enlace = enlace;
    }
}
