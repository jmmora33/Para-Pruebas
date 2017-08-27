package nombresRepetidos;
import java.util.*;

public class NombreRepetido implements Comparable<NombreRepetido>{

private String nombre;
private int cantRepetido;

public NombreRepetido()
{
	
}

public NombreRepetido(String nom, int cant)
{
	this.setNombre(nom);
	this.setCantRepetido(cant);
}
public NombreRepetido(NombreRepetido nr)
{
  this.setCantRepetido(nr.getCantRepetido());
  this.setNombre(nr.getNombre());
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public int getCantRepetido() {
	return cantRepetido;
}
public void setCantRepetido(int cantRepetido) {
	this.cantRepetido = cantRepetido;
}

// ELIMINA LOS QUE ESTAN UNA SOLA VEZ. ESO SE CONSIDERA COMO NO REPETIDO
public static void  eliminarNoRepetidos(ArrayList<NombreRepetido> nomRep)
{
	Iterator<NombreRepetido> iterador = nomRep.iterator();
	
	while(iterador.hasNext())
	{
		NombreRepetido nr = iterador.next();
		if(nr.getCantRepetido() == 1)
			iterador.remove();
	}
}

// BUSCA EL NOMBRE EN LA LISTA. RETORNA -1 SI NO LA ENCUENTRA
public int buscarNombre(ArrayList<NombreRepetido> nombres)
{
	int i = 0;
	 for(NombreRepetido nr : nombres)
     {
    	 if(this.getNombre().equalsIgnoreCase(nr.getNombre()))
    		 return i;
    	 i++;
     }	

	 return -1;
}

// COMPARA POR CANTIDAD Y POR ORDEN ALFABETICO.
@Override
public int compareTo(NombreRepetido that) {
	
	if(this.getCantRepetido()> that.getCantRepetido())
		return -1;
	
	if(this.getCantRepetido() == that.getCantRepetido() && this.getNombre().compareTo(that.getNombre())==1)
		return 1;
	
	if(this.getCantRepetido() < that.getCantRepetido())
		return 1;
	
	if(this.getCantRepetido() == that.getCantRepetido() && this.getNombre().compareTo(that.getNombre())== -1)
		return -1;
	
	return 0;
}


@Override
public String toString()
{
	
return this.getNombre() + this.getCantRepetido();
}

}

