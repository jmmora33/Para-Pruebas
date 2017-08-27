package nombresRepetidos;
import java.util.*;
import java.io.*;


public class Archivo {

private Scanner sc;

public Scanner getSc() {
	return sc;
}

public void setSc(Scanner sc) {
	this.sc = sc;
}


void abrirArchivo(String path) throws FileNotFoundException
{
  this.setSc(new Scanner(new File(path)));
}

// LEE LA CANTIDAD DE NOMBRES QUE HAY
int leerCantidadNombres()
{
	return this.getSc().nextInt();
     
}
//LEE LA CANTIDAD DE REPETIDOS A MOSTRAR
int leerCantidadAMostrar()
{
	
	return this.getSc().nextInt();
}

//LEE EL SIGUIENTE NOMBRE
String leerSiguiente()
{ 
	
   if(this.getSc().hasNext())
       return this.getSc().next();
   else
   {  
	   this.getSc().close();
	   System.out.println("No Hay Mas Elementos.");
	   return "";
	   
   }
}

void escribirArchivo(String path, ArrayList<NombreRepetido> nomRep, int cantidad) throws IOException
{
	PrintWriter salida = new PrintWriter(new FileWriter(path));      
	for (int i=0;i<cantidad;i++) {
		salida.println(nomRep.get(i).toString());
	}
	salida.close();

}

}
