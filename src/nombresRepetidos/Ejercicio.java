package nombresRepetidos;

import java.io.*;
import java.util.*;

public class Ejercicio {

	public static void main(String[] args) throws IOException {
    Archivo archivo = new Archivo();
    int cantAMostrar;
    int cantNom;
    int indice;
   String pathEnt = ".\\LoteDePrueba\\nombres1.in";
   String pathSal = ".\\LoteDePrueba\\salida1.in";
    NombreRepetido nombre = new NombreRepetido();
    ArrayList<NombreRepetido> nombres = new ArrayList<>();
    
    
    archivo.abrirArchivo(pathEnt);
    
    cantNom = archivo.leerCantidadNombres();// POR SI SE DESEA UTILIZAR PARA LIMITAR LA LECTURA
    cantAMostrar = archivo.leerCantidadAMostrar();
    // VALIDA SI HAY MAS PARA MOSTRAR QUE NOMBRES
    if(cantAMostrar > cantNom)
    {
    	System.err.println("Error en el archivo"+pathEnt+":"+"No hay suficientes nombres para mostrar");
    	nombres.add(new NombreRepetido("",0));
    	archivo.escribirArchivo(pathSal, nombres,1);
    	System.exit(0);
    }
    nombre.setNombre(archivo.leerSiguiente());
    while( nombre.getNombre()!= null && nombre.getNombre() != "")
    {  
    	indice = nombre.buscarNombre(nombres);
    	if(indice == -1)
    	{  
    		nombre.setCantRepetido(1);
    		nombres.add(new NombreRepetido(nombre));
    		
    	}else
    	{
    		nombres.get(indice).setCantRepetido(nombres.get(indice).getCantRepetido() +1);
    	}
    		
    	nombre.setNombre(archivo.leerSiguiente());
	}
 // ELIMINA LOS NOMBRES QUE ESTAN UNA VEZ. ES DECIR, NO ESTAN REPETIDOS
    NombreRepetido.eliminarNoRepetidos(nombres);
    
    if(cantAMostrar > nombres.size() || nombres.isEmpty())  
    {
    	nombres.clear();
    	nombres.add(0,new NombreRepetido("",0));
    	System.err.println("Error en el archivo");
    	 archivo.escribirArchivo(pathSal, nombres,1);
    	    
    }else {
    	Collections.sort(nombres);
        System.out.println(nombres);
        archivo.escribirArchivo(pathSal, nombres,cantAMostrar);
         		
        
    }
   
	}
	

}
