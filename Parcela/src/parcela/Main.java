package parcela;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	// Usuario y menu principal
        Control c = new Control();
        Scanner t = new Scanner(System.in);
        int id_usuario = 0;
        String dni = null;
        String nombre = null;
        String apellidos = null;
        String correo = null;
        String password = null;
        boolean salir = true;
        
        //Drones
        int id_dron = 0;
        String nombre_dron = null;
        String marca = null;
        Drones dron = new Drones();
        dron.leer();
        
        //Parceras
        int id_parcela = 0;
        String direccion = null;
        String ruta = "(0.0)";
        int tamano = 0;
        Parcelas par = new Parcelas();
        par.leer();
        
        //Trabajo
        int id_trabajo = 0;
        String tarea = null;
        String fecha = null;
        boolean estado = false;
        Trabajos tra = new Trabajos();
        tra.leer();
        
        c.leer();
        String menu = null;
        while(salir) {
	        System.out.println("----------Menu----------");
	        System.out.println("                        ");
	        System.out.println("       1.Iniciar        ");
	        System.out.println("       2.Registrar      ");
	        System.out.println("       3.salir          ");
	        System.out.println("                        ");
	        System.out.println("------------------------");
	        System.out.println("");
	        System.out.print("Introduce(1-3): ");
	        menu = t.next();
	        System.out.println("");
	        System.out.println("");
	        System.out.println("");
	        
	        if(menu.equals("1") || menu.equals("2") || menu.equals("3")){
	            if(menu.equals("1")){
	                /*Incialr*/
	                while(salir){
	                    System.out.println("----------Menu----------");
	                    System.out.println("                        ");
	                    System.out.println("     Iniciar sesion     ");
	                    System.out.println("                        ");
	                    System.out.println("------------------------");
	                    System.out.println("");
	                    System.out.print("Introduce su correo: ");
	                    correo = t.next();
	                    System.out.println("");
	                    System.out.println("");
	                    System.out.println("");
	
	                    System.out.print("Introduce su Contraseña: ");
	                    password = t.next();
	                    System.out.println("");
	                    System.out.println("");
	                    System.out.println("");
	                    
	                    if(c.repetirCorreo(correo) && c.repetirPassword(password)){
	                    	// Cargar datos del usuario
	                    	Usuario usuario = c.cargarUsuario(correo);
	                        // Entra al sistema
	                    	while(salir) {
		                        System.out.println("-------Menu de opciones------");
		                        System.out.println("   ¿Que quieres gestionar?   ");
		                        System.out.println("                             ");
		                        System.out.println("          1.Usuario          ");
		                        System.out.println("          2.Drones           ");
		                        System.out.println("          3.Parcelas         ");
		                        System.out.println("          4.Trabajos         ");
		                        System.out.println("          5.Salir            ");
		                        System.out.println("                             ");
		                        System.out.println("-----------------------------");
		                        System.out.println("");
		                        System.out.print("Introduce(1-5): ");
		                        menu = t.next();
		                        System.out.println("");
		                        System.out.println("");
		                        System.out.println("");
		                        
		                        if(menu.equals("1") || menu.equals("2") || menu.equals("3") || menu.equals("4") || menu.equals("5")){
		                        	//Moficar usuario
		                        	if(menu.equals("1")) {
	                                    System.out.println("--------Menu de usuario------");
	                                    System.out.println("   ¿Que quieres gestionar?   ");
	                                    System.out.println("                             ");
	                                    System.out.println("       1.Mostrar datos       ");
	                                    System.out.println("       2.Modificar datos     ");
	                                    System.out.println("       3.Salir               ");
	                                    System.out.println("                             ");
	                                    System.out.println("-----------------------------");
	                                    System.out.println("");
	                                    System.out.print("Introduce(1-3): ");
	                                    menu = t.next();
	                                    System.out.println("");
	                                    System.out.println("");
	                                    System.out.println("");
	                                    
	                                    if(menu.equals("1") || menu.equals("2") || menu.equals("3")){
	                                    	if(menu.equals("1")) {
	                                            System.out.println("--------Datos de usuario--------");
	                                            System.out.println("                                ");
	                                            System.out.println("      ID: " + usuario.getId_usuario());
	                                            System.out.println("      DNI: " + usuario.getDni());
	                                            System.out.println("      Nombre: " + usuario.getNombre());
	                                            System.out.println("      Apellidos: " + usuario.getApellidos());
	                                            System.out.println("      Correo: " + usuario.getCorreo());
	                                            System.out.println("                                ");
	                                            System.out.println("--------------------------------");
	                                            System.out.println("");
	                                            System.out.print("Pulsa cualquier boton para volver: ");
	                                            menu = t.next();
	                                            System.out.println("");
	                                            System.out.println("");
	                                            System.out.println("");
	                                            System.out.println("Has vuelto!");
	                                        // Modificar datos
	                                    	} else if (menu.equals("2")) {
	                                            System.out.println("--------Datos de usuario--------");
	                                            System.out.println("                                ");
	                                            System.out.println("     1.Nombre: " + usuario.getNombre());
	                                            System.out.println("     2.Apellidos: " + usuario.getApellidos());
	                                            System.out.println("     3.Correo: " + usuario.getCorreo());
	                                            System.out.println("     4.Contraseña: ********     ");
	                                            System.out.println("     5.Salir                    ");
	                                            System.out.println("                                ");
	                                            System.out.println("--------------------------------");
	                                            System.out.println("");
	                                            System.out.print("Que dato quieres modificar(1-5): ");
	                                            menu = t.next();
	                                            System.out.println("");
	                                            System.out.println("");
	                                            System.out.println("");
	                                            
	                                            if(menu.equals("1") || menu.equals("2") || menu.equals("3") || menu.equals("4") || menu.equals("5")){
	                                            	if(menu.equals("1")) {
		                                                System.out.print("Introduce su Nombre: ");
		                                                nombre = t.next();
		                                                usuario.setNombre(nombre);
		                                                System.out.println("");
		                                                System.out.println("");
		                                                System.out.println("");
		                                                System.out.println("Se ha modificado correctamente a (Vulve a iniciar): " + usuario.getNombre());
		                                                c.reGuardar();
		                                                salir = false;
	                                            	} else if (menu.equals("2")) {
		                                                System.out.print("Introduce sus Apellidos: ");
		                                                apellidos = t.next();
		                                                usuario.setApellidos(apellidos);
		                                                System.out.println("");
		                                                System.out.println("");
		                                                System.out.println("");
		                                                System.out.println("Se ha modificado correctamente a (Vulve a iniciar): " + usuario.getApellidos());
		                                                c.reGuardar();
		                                                salir = false;
	                                            	} else if (menu.equals("3")) {
	                                            		
	                                	                do {
	                                	                    System.out.println("!Si tu correo se repite, te pedira introducir otra vez¡");
	                                	                    System.out.print("Introduce su correo: ");
	                                	                    correo = t.next();
	                                	                    System.out.println("");
	                                	                    System.out.println("");
	                                	                    System.out.println("");
	                                	                } while (c.repetirCorreo(correo));
	                                	                usuario.setCorreo(correo);
	                                	                System.out.println("Se ha modificado correctamente a (Vulve a iniciar): " + usuario.getCorreo());
		                                                c.reGuardar();
		                                                salir = false;
	                                            	} else if (menu.equals("4")) {
		                                                System.out.print("Introduce su Contraseña: ");
		                                                password = t.next();
		                                                usuario.setPassword(password);
		                                                System.out.println("");
		                                                System.out.println("");
		                                                System.out.println("");
		                                                System.out.println("Se ha modificado correctamente a (Vulve a iniciar): " + usuario.getPassword());
		                                                c.reGuardar();
		                                                salir = false;
	                                            	} else {
	                                                    System.out.println("Has salido!");
	                                            		salir = false;
	                                            	}
	
	                                            } else {
	                                                System.err.println("Introduce la opcion correcta!");
	                                            }
	        	                        	} else {
	        	                        		System.out.println("Has salido!");
	                                    		salir = false;
											}
	                                    } else {
	                                        System.out.println("Introduce la opcion correcta!");
	                                    }
	                                //Gestion drones
		                        	} else if (menu.equals("2")) {

	                                    System.out.println("--------Menu de Drones-------");
	                                    System.out.println("   ¿Que quieres gestionar?   ");
	                                    System.out.println("                             ");
	                                    System.out.println("       1.Añadir drones       ");
	                                    System.out.println("       2.Eliminar drones     ");
	                                    System.out.println("       3.Listar drones       ");
	                                    System.out.println("       4.Modificar drone     ");
	                                    System.out.println("       5.Salir               ");
	                                    System.out.println("                             ");
	                                    System.out.println("-----------------------------");
	                                    System.out.println("");
	                                    System.out.print("Introduce(1-5): ");
	                                    menu = t.next();
	                                    System.out.println("");
	                                    System.out.println("");
	                                    System.out.println("");
	                                    
	                                    if(menu.equals("1") || menu.equals("2") || menu.equals("3") || menu.equals("4") || menu.equals("5")){
	                                    	// Añadir drones
	                                    	if (menu.equals("1")) {
	                                    		id_dron = dron.valoInicial() + 1;
	                        	                System.out.println("---------Drones---------");
	                        	                System.out.println("                        ");
	                        	                System.out.println("     Estas añadiendo    ");
	                        	                System.out.println("                        ");
	                        	                System.out.println("------------------------");
	                        	                System.out.println("");
	                        	                System.out.print("Introduce su Nombre: ");
	                        	                nombre_dron = t.next();
	                        	                System.out.println("");
	                        	                System.out.println("");
	                        	                System.out.println("");
	                        	                
	                        	                System.out.print("Introduce la marca: ");
	                        	                marca = t.next();
	                        	                System.out.println("");
	                        	                System.out.println("");
	                        	                System.out.println("");
	                                    		
	                                    		dron.guardar(id_dron, nombre_dron, marca, usuario.getId_usuario());
	                        	                System.out.println("Se ha creado correctamente tienes que volver a iniciar");
	                        	                salir = false;
											// Eliminar drones
	                                    	} else if (menu.equals("2")) {
												dron.imprimir(usuario.getId_usuario());
	                        	                System.out.println("Estos son los drones que tienes " + usuario.getNombre() + " " + usuario.getApellidos());
	                        	                System.out.println("---------Drones---------");
	                        	                System.out.println("                        ");
	                        	                System.out.println("     Estas Eliminando   ");
	                        	                System.out.println("                        ");
	                        	                System.out.println("------------------------");
	                	                        System.out.println("");
	                	                        System.out.println("");
	                        	                System.out.println("Introduce que dron quieres borrar (Introduce su ID): ");
	                        	                int borrar_dron = t.nextInt();
	                        	                
	                        	                if (dron.borra(borrar_dron, usuario.getId_usuario())) {
	                        	                	dron.reGuardar();
												} else {
													System.out.println("No ha hecho nada, porque has introducido mal o ID equivodado.");
												}
											// Listar drones
											} else if (menu.equals("3")) {
												dron.imprimir(usuario.getId_usuario());
	                        	                System.out.println("Estos son los drones que tienes " + usuario.getNombre() + " " + usuario.getApellidos());
	    	                                    System.out.print("Introduce algo para continuar: ");
	    	                                    menu = t.next();
    	                                    // Modificar
											} else if (menu.equals("4")) {
												dron.imprimir(usuario.getId_usuario());
	                        	                System.out.println("Estos son los drones que tienes " + usuario.getNombre() + " " + usuario.getApellidos());
	                        	                System.out.println("---------Drones---------");
	                        	                System.out.println("                        ");
	                        	                System.out.println("     Estas Modificando  ");
	                        	                System.out.println("                        ");
	                        	                System.out.println("------------------------");
	                	                        System.out.println("");
	                	                        System.out.println("");
	                        	                System.out.println("Introduce que dron quieres modificar (Introduce su ID): ");
	                        	                int midificando_dron = t.nextInt();
	                        	                
	                        	                if(dron.permiso(midificando_dron, usuario.getId_usuario())) {
	                        	                	Drones dron1 = dron.cargarDron(midificando_dron);
	                        	                	System.out.println("");
		                        	                System.out.print("Introduce su Nombre: ");
		                        	                nombre_dron = t.next();
		                        	                dron1.setNombre(nombre_dron);
		                        	                System.out.println("");
		                        	                System.out.println("");
		                        	                System.out.println("");
		                        	                
		                        	                System.out.print("Introduce la marca: ");
		                        	                marca = t.next();
		                        	                dron1.setMarca(marca);
		                        	                System.out.println("");
		                        	                System.out.println("");
		                        	                System.out.println("");
		                        	                dron.reGuardar();
		                        	                System.out.println("Se ha modificado tienes que volver a iniciar");
		                        	                salir = false;
	                        	                } else {
													System.out.println("No ha hecho nada, porque has introducido mal o ID equivodado.");
												}
	                        	                
											} else {
                                                System.out.println("Has salido!");
                                        		salir = false;
											}
	                                    	
                                    	} else {
	                                        System.out.println("Introduce la opcion correcta!");
	                                    }
	                        		//Gestion parcelas
		                        	} else if (menu.equals("3")) {

	                                    System.out.println("-------Menu de Parcelas------");
	                                    System.out.println("   ¿Que quieres gestionar?   ");
	                                    System.out.println("                             ");
	                                    System.out.println("     1.Añadir parcelas       ");
	                                    System.out.println("     2.Eliminar parcelas     ");
	                                    System.out.println("     3.Listar parcelas       ");
	                                    System.out.println("     4.Modificar ruta        ");
	                                    System.out.println("     5.Salir                 ");
	                                    System.out.println("                             ");
	                                    System.out.println("-----------------------------");
	                                    System.out.println("");
	                                    System.out.print("Introduce(1-5): ");
	                                    menu = t.next();
	                                    System.out.println("");
	                                    System.out.println("");
	                                    System.out.println("");
	                                    
	                                    if(menu.equals("1") || menu.equals("2") || menu.equals("3") || menu.equals("4") || menu.equals("5")){
	                                    	// Añadir parcelas
	                                    	if (menu.equals("1")) {
	                                    		id_parcela = par.valoInicial() + 1;
	                        	                System.out.println("--------Parcela---------");
	                        	                System.out.println("                        ");
	                        	                System.out.println("     Estas añadiendo    ");
	                        	                System.out.println("                        ");
	                        	                System.out.println("------------------------");
	                        	                System.out.println("");
	                        	                System.out.print("Introduce una direccion para tu parcela: ");
	                        	                direccion = t.next();
	                        	                System.out.println("");
	                        	                System.out.println("");
	                        	                System.out.println("");
	                        	                boolean menu_par = true;
	                        	                
	                        	                do {
	                        	                	System.out.print("Introduce  una tamaño m2 para tu parcela (Solo numero): ");
		                        	                tamano = t.nextInt();
		                        	                System.out.println("");
		                        	                System.out.println("");
		                        	                System.out.println("");
		                        	                if (tamano > 0) {
		                        	                	menu_par = false;
													}else {
														System.out.println("El tamaño tiene que mayor de 0");
													}
	                        	                }while(menu_par);
	                        	                
	                        	                
	                        	                System.out.println("Para configurar la ruta");
	                        	                System.out.print("primero tines que poner cuantas paradas hay (Solo numero): ");
	                        	                int ruta_par = t.nextInt();
	                        	                System.out.println("");
	                        	                System.out.println("");
	                        	                System.out.println("");
	                                    		for(int i=0; i<ruta_par ; i++) {
		                        	                System.out.print("Introduce la cordinada x: ");
		                        	                int x = t.nextInt();
		                        	                System.out.println("");
		                        	                System.out.println("");
		                        	                System.out.println("");
		                        	                ruta = ruta + "+(" + x + ",";
		                        	                
		                        	                System.out.print("Introduce la cordinada y: ");
		                        	                int y = t.nextInt();
		                        	                System.out.println("");
		                        	                System.out.println("");
		                        	                System.out.println("");
		                        	                ruta = ruta + y + ")";
	                                    		}
	                                    		
	                        	                par.guardar(id_parcela, direccion, ruta, tamano, usuario.getId_usuario());
	                        	                System.out.println("Se ha creado correctamente tienes que volver a iniciar");
	                        	                salir = false;
	                        	               // Eliminar parcelas
											} else if (menu.equals("2")) {
												par.imprimir(usuario.getId_usuario());
	                        	                System.out.println("Estos son los parcelas que tienes " + usuario.getNombre() + " " + usuario.getApellidos());
	                        	                System.out.println("---------Parcelas---------");
	                        	                System.out.println("                          ");
	                        	                System.out.println("      Estas Eliminando    ");
	                        	                System.out.println("                          ");
	                        	                System.out.println("--------------------------");
	                	                        System.out.println("");
	                	                        System.out.println("");
	                        	                System.out.println("Introduce que parcela quieres borrar (Introduce su ID): ");
	                        	                int borrar_parcela = t.nextInt();
	                        	                
	                        	                if (par.borra(borrar_parcela, usuario.getId_usuario())) {
	                        	                	par.reGuardar();
												} else {
													System.out.println("No ha hecho nada, porque has introducido mal o ID equivodado.");
												}
                        	                // Listar parcelas
											} else if (menu.equals("3")) {
												par.imprimir(usuario.getId_usuario());
	                        	                System.out.println("Estos son los drones que tienes " + usuario.getNombre() + " " + usuario.getApellidos());
	    	                                    System.out.print("Introduce algo para continuar: ");
	    	                                    menu = t.next();
    	                                    // Modificar parcelas
											} else if (menu.equals("4")) {
												par.imprimir(usuario.getId_usuario());
	                        	                System.out.println("Estos son los drones que tienes " + usuario.getNombre() + " " + usuario.getApellidos());
	                        	                System.out.println("---------Parcelas---------");
	                        	                System.out.println("                          ");
	                        	                System.out.println("      Estas Modificando   ");
	                        	                System.out.println("                          ");
	                        	                System.out.println("--------------------------");
	                	                        System.out.println("");
	                	                        System.out.println("");
	                        	                System.out.println("Introduce la parcela que quieres modificar (Introduce su ID): ");
	                        	                int midificando_dron = t.nextInt();
	                        	                
	                        	                if(par.permiso(midificando_dron, usuario.getId_usuario())) {
	                        	                	Parcelas par1 = par.cargarParcelas(midificando_dron);
		                        	                System.out.println("Para configurar la ruta");
		                        	                System.out.print("Primero tines que poner cuantas paradas hay (Solo numero): ");
		                        	                int ruta_par = t.nextInt();
		                        	                System.out.println("");
		                        	                System.out.println("");
		                        	                System.out.println("");
		                        	                ruta = "(0.0)";
		                                    		for(int i=0; i<ruta_par ; i++) {
			                        	                System.out.print("Introduce la cordinada x: ");
			                        	                int x = t.nextInt();
			                        	                System.out.println("");
			                        	                System.out.println("");
			                        	                System.out.println("");
			                        	                ruta = ruta + "+(" + x + ",";
			                        	                
			                        	                System.out.print("Introduce la cordinada y: ");
			                        	                int y = t.nextInt();
			                        	                System.out.println("");
			                        	                System.out.println("");
			                        	                System.out.println("");
			                        	                ruta = ruta + y + ")";
		                                    		}
		                                    		par1.setRuta(ruta);
		                        	                par.reGuardar();
		                        	                System.out.println("Se ha modificado tienes que volver a iniciar");
		                        	                salir = false;
	                        	                } else {
													System.out.println("No ha hecho nada, porque has introducido mal o ID equivodado.");
												}
											} else {
                                                System.out.println("Has salido!");
                                        		salir = false;
											}
	                                    	
	                                    } else {
	                                        System.out.println("Introduce la opcion correcta!");
	                                    }
	                        		//Gestion trabajos
		                        	} else if (menu.equals("4")) {
	                                    if(menu.equals("1") || menu.equals("2") || menu.equals("3") || menu.equals("4") || menu.equals("5")){
	                                    	System.out.println("-------Menu de Parcelas------");
		                                    System.out.println("   ¿Que quieres gestionar?   ");
		                                    System.out.println("                             ");
		                                    System.out.println("     1.Añadir trabajo        ");
		                                    System.out.println("     2.Ejecutar trabajo      ");
		                                    System.out.println("     3.Listar trabajo        ");
		                                    System.out.println("     4.Modificar tarabajo    ");
		                                    System.out.println("     5.Salir                 ");
		                                    System.out.println("                             ");
		                                    System.out.println("-----------------------------");
		                                    System.out.println("");
		                                    System.out.print("Introduce(1-5): ");
		                                    menu = t.next();
		                                    System.out.println("");
		                                    System.out.println("");
		                                    System.out.println("");
	                                    	// Añador trabajo
	                                    	if (menu.equals("1")) {
	                                    		id_trabajo = tra.valoInicial() + 1;
	                        	                System.out.println("---------Trabajo---------");
	                        	                System.out.println("                         ");
	                        	                System.out.println("     Estas añadiendo     ");
	                        	                System.out.println("                         ");
	                        	                System.out.println("-------------------------");
	                        	                System.out.println("");
	                        	                dron.imprimir(usuario.getId_usuario());
	                        	                System.out.println("Estos son los drones que tienes " + usuario.getNombre() + " " + usuario.getApellidos());
	    	                                    System.out.print("Introduce el dron que quieres añadir (Id del dron): ");
	                        	                int par_dron = t.nextInt();
	                        	                System.out.println("");
	                        	                System.out.println("");
	                        	                System.out.println("");
	                        	                if(dron.permiso(par_dron, usuario.getId_usuario())) {
	                        	                	par.imprimir(usuario.getId_usuario());
		                        	                System.out.println("Estos son las parcelas que tienes " + usuario.getNombre() + " " + usuario.getApellidos());
		    	                                    System.out.print("Introduce el dron que quieres añadir (Id de la parcelas): ");
		    	                                    int par_parcela = t.nextInt();
		                        	                System.out.println("");
		                        	                System.out.println("");
		                        	                System.out.println("");
		                        	                
		                        	                if(par.permiso(par_parcela, usuario.getId_usuario())) {
		                        	                	System.out.println("---------Tarea---------");
			                        	                System.out.println("                       ");
			                        	                System.out.println("     1. Sembrar        ");
			                        	                System.out.println("     2. Abonar         ");
			                        	                System.out.println("     3. Fumigar        ");
			                        	                System.out.println("                       ");
			                        	                System.out.println("-------------------------");
			                        	                System.out.println("");
			    	                                    System.out.print("Introduce que tarea quieres asignarle: ");
			    	                                    menu = t.next();
			                        	                System.out.println("");
			                        	                System.out.println("");
			                        	                System.out.println("");
			                                    		if (menu.equals("1") || menu.equals("2") || menu.equals("3")) {
			                                    			if (menu.equals("1")) {
			                                    				tarea = "Sembrar";
			                                    			} else if (menu.equals("2")) {
			                                    				tarea = "Abonar";
			    											} else {
			                                    				tarea = "Fumigar";
			    											}
			                                    			
			                                    			SimpleDateFormat fec = new SimpleDateFormat("yyyy/MM/dd");
			                                    			fecha =  fec.format(new Date());
			                                    			
			                                    			tra.guardar(id_trabajo, par_dron, par_parcela, tarea, fecha, estado, usuario.getId_usuario());
				                        	                System.out.println("Se ha creado correctamente tienes que volver a iniciar");
				                        	                salir = false;
			                                    		} else {
			    	                                        System.out.println("Introduce la opcion correcta!");
														}
		                        	                } else {
														System.out.println("No ha hecho nada, porque has introducido mal o ID equivodado.");

													}
	                        	                } else {
													System.out.println("No ha hecho nada, porque has introducido mal o ID equivodado.");

												}

                                    		//Ejecutar trabajo
											} else if (menu.equals("2")) {
												tra.imprimir(usuario.getId_usuario());
	                        	                System.out.println("Estos son los trajos que tienes " + usuario.getNombre() + " " + usuario.getApellidos());
	                        	                System.out.println("---------Trabajo----------");
	                        	                System.out.println("                          ");
	                        	                System.out.println("      Estas Ejecutando    ");
	                        	                System.out.println("                          ");
	                        	                System.out.println("--------------------------");
	                	                        System.out.println("");
	                	                        System.out.println("");
	                        	                System.out.println("Introduce el trabajo que quieres ejecutar (Introduce su ID): ");
	                        	                int ejecuta_par = t.nextInt();
	                	                        System.out.println("");

	                        	                if (tra.permiso(ejecuta_par, usuario.getId_usuario())) {
	                        	                	Trabajos tra1 = tra.cargarTran(ejecuta_par);
	                        	                	tra1.setEstado(true);
	                        	                	tra.reGuardar();
		                        	                System.out.println("Se ha ejecutado correctamente tienes que volver a iniciar");
		                        	                salir = false;
												} else {
													System.out.println("No ha hecho nada, porque has introducido mal o ID equivodado.");
												}
	                        	                
                        	                // Listar trabajo
											} else if (menu.equals("3")) {
												tra.imprimir(usuario.getId_usuario());
	                        	                System.out.println("Estos son los trajos que tienes " + usuario.getNombre() + " " + usuario.getApellidos());
	    	                                    System.out.print("Introduce algo para continuar: ");
	    	                                    menu = t.next();
    	                                    // modificar
											} else if (menu.equals("4")) {
												tra.imprimir(usuario.getId_usuario());
	                        	                System.out.println("Estos son los trajos que tienes " + usuario.getNombre() + " " + usuario.getApellidos());
	                        	                System.out.println("---------Parcelas---------");
	                        	                System.out.println("                          ");
	                        	                System.out.println("      Estas Modificando   ");
	                        	                System.out.println("                          ");
	                        	                System.out.println("--------------------------");
	                	                        System.out.println("");
	                	                        System.out.println("");
	                        	                System.out.println("Introduce el trabajo que quieres ejecutar (Introduce su ID): ");
	                        	                int ejecuta_par = t.nextInt();
	                        	                
	                        	                if (tra.permiso(ejecuta_par, usuario.getId_usuario())) {
	                        	                	Trabajos tra1 = tra.cargarTran(ejecuta_par);
		                        	                dron.imprimir(usuario.getId_usuario());
		                        	                System.out.println("Estos son los drones que tienes " + usuario.getNombre() + " " + usuario.getApellidos());
		                        	                System.out.print("Introduce el dron que quieres añadir (Id del dron): ");
		                        	                int par_dron = t.nextInt();
		                        	                System.out.println("");
		                        	                System.out.println("");
		                        	                System.out.println("");
		                        	                if(dron.permiso(par_dron, usuario.getId_usuario())) {
		                        	                	tra1.setId_dron(par_dron);
		                        	                	par.imprimir(usuario.getId_usuario());
			                        	                System.out.println("Estos son las parcelas que tienes " + usuario.getNombre() + " " + usuario.getApellidos());
			    	                                    System.out.print("Introduce el dron que quieres añadir (Id de la parcelas): ");
			    	                                    int par_parcela = t.nextInt();
			                        	                System.out.println("");
			                        	                System.out.println("");
			                        	                System.out.println("");
			                        	                
			                        	                if(par.permiso(par_parcela, usuario.getId_usuario())) {
			                        	                	tra1.setId_parcela(par_parcela);
			                        	                	System.out.println("---------Tarea---------");
				                        	                System.out.println("                       ");
				                        	                System.out.println("     1. Sembrar        ");
				                        	                System.out.println("     2. Abonar         ");
				                        	                System.out.println("     3. Fumigar        ");
				                        	                System.out.println("                       ");
				                        	                System.out.println("-------------------------");
				                        	                System.out.println("");
				    	                                    System.out.print("Introduce que tarea quieres asignarle: ");
				    	                                    menu = t.next();
				                        	                System.out.println("");
				                        	                System.out.println("");
				                        	                System.out.println("");
				                                    		if (menu.equals("1") || menu.equals("2") || menu.equals("3")) {
				                                    			if (menu.equals("1")) {
				                                    				tra1.setTarea("Sembrar");
				                                    			} else if (menu.equals("2")) {
				                                    				tra1.setTarea("Abonar");
				    											} else {
				                                    				tra1.setTarea("Fumigar");
				    											}
				                                    			tra.reGuardar();
					                        	                System.out.println("Se ha modificado correctamente tienes que volver a iniciar");
					                        	                salir = false;
				                                    		} else {
				    	                                        System.out.println("Introduce la opcion correcta!");
															}
			                        	                } else {
															System.out.println("No ha hecho nada, porque has introducido mal o ID equivodado.");

														}
		                        	                } else {
														System.out.println("No ha hecho nada, porque has introducido mal o ID equivodado.");

													}  
	                        	                } else {
													System.out.println("No ha hecho nada, porque has introducido mal o ID equivodado.");
												}
											} else {
                                                System.out.println("Has salido!");
                                        		salir = false;
											}
	                                    	
	                                    } else {
	                                        System.out.println("Introduce la opcion correcta!");
	                                    }
	                        		//Salir
		                        	} else {
		                        		System.out.println("Has salido!");
		                        		salir = false;
		                        	}
		                        } else {
		                            System.out.println("Introduce la opcion correcta!");
		                        }
	                    	}
	                    } else {
	                        // Cuando no son correctas la cotraseña o correo
	                        System.out.println("-------------Menu------------");
	                        System.out.println("   !No coincide los datos¡   ");
	                        System.out.println("                             ");
	                        System.out.println("          1.continuar        ");
	                        System.out.println("           2.salir           ");
	                        System.out.println("                             ");
	                        System.out.println("-----------------------------");
	                        System.out.println("");
	                        System.out.print("Introduce(1-2): ");
	                        menu = t.next();
	                        System.out.println("");
	                        System.out.println("");
	                        System.out.println("");
	                        if(menu.equals("1")){
	                            System.out.println("Continua");
	                        } else if (menu.equals("2")){
	                            System.out.println("Has salido!");
	                            salir = false;
	                        } else {
	                            System.out.println("Introduce la opcion correcta!");
	                        }
	                    }
	                }
	             // Registrar
	            } else if (menu.equals("2")) {
	                id_usuario = c.valoInicial() + 1;
	                
	                System.out.println("----------Menu----------");
	                System.out.println("                        ");
	                System.out.println("   Estas registrando    ");
	                System.out.println("                        ");
	                System.out.println("------------------------");
	                System.out.println("");
	                System.out.print("Introduce su DNI: ");
	                dni = t.next();
	                System.out.println("");
	                System.out.println("");
	                System.out.println("");
	                
	                System.out.print("Introduce su Nombre: ");
	                nombre = t.next();
	                System.out.println("");
	                System.out.println("");
	                System.out.println("");
	                
	                System.out.print("Introduce sus Apellidos: ");
	                apellidos = t.next();
	                System.out.println("");
	                System.out.println("");
	                System.out.println("");
	                
	                do {
	                    System.out.println("!Si tu correo se repite, te pedira introducir otra vez¡");
	                    System.out.print("Introduce su correo: ");
	                    correo = t.next();
	                    System.out.println("");
	                    System.out.println("");
	                    System.out.println("");
	                } while (c.repetirCorreo(correo));
	                
	                System.out.print("Introduce su Contraseña: ");
	                password = t.next();
	                System.out.println("");
	                System.out.println("");
	                System.out.println("");
	                
	                while(salir){
	                    System.out.print("Repite su Contraseña para confirmar: ");
	                    String password2 = t.next();
	                    System.out.println("");
	                    System.out.println("");
	                    System.out.println("");
	
	                    if(password.equals(password2)){
	                        c.guardar(id_usuario, dni, nombre, apellidos, correo, password);
	                        salir = false;
	                    } else {
	                        System.out.println("-------------Menu------------");
	                        System.out.println("!No coincide las contraseñas¡");
	                        System.out.println("                             ");
	                        System.out.println("          1.continuar        ");
	                        System.out.println("           2.salir           ");
	                        System.out.println("                             ");
	                        System.out.println("-----------------------------");
	                        System.out.println("");
	                        System.out.print("Introduce(1-2): ");
	                        menu = t.next();
	                        System.out.println("");
	                        System.out.println("");
	                        System.out.println("");
	                        if(menu.equals("1")){
	                            System.out.println("Continua");
	                        } else if (menu.equals("2")){
	                            System.out.println("Has salido!");
	                            salir = false;
	                        } else {
	                            System.out.println("Introduce la opcion correcta!");
	                        }
	                    }
	                }
	            } else {
	                //Salir desde menu1
	                System.out.println("Has salido!");
	                salir = false;
	            }
	        }else{
	            System.out.println("Introduce la opcion correcta!");
	        }
        }
        t.close();
    }
}
