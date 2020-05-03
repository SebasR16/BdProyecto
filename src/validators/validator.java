
package validators;

import java.util.ArrayList;
import java.util.List;


public class validator {
      public List<String> CheckEmp(String nombre, String Apellido){
    List <String> errores=new ArrayList();
        if (nombre.isEmpty()) {
       errores.add("El campo nombre no puede estar vacio");
        
        }
        if (Apellido.isEmpty()) {
           errores.add("El campo apellido no puede estar vacio");
        }
        if (!isLetter(nombre)) {
            errores.add("El campo nombre debe ser solo letras");
        }
        if (!isLetter(Apellido)) {
            errores.add("El campo apellido debe ser solo letras");
        }
      
        return errores;
    }
      public List<String> CheckDept(String nombre, String numero){
    List <String> errores=new ArrayList();
        if (nombre.isEmpty()) {
       errores.add("El campo nombre no puede estar vacio");
        
        }
        if (numero.isEmpty()) {
           errores.add("El campo numero no puede estar vacio");
        }
        if (!isLetter(nombre)) {
            errores.add("El campo nombre debe ser solo letras");
        }
          if (!isNumeric(numero)) {
              errores.add("El campo de numero debe ser solo numeros");
          }
        
      
        return errores;
    }
         public List<String> CheckTitle(String nombre, String numero){
    List <String> errores=new ArrayList();
        if (nombre.isEmpty()) {
       errores.add("El campo titulo no puede estar vacio");
        
        }
        if (numero.isEmpty()) {
           errores.add("El campo numero no puede estar vacio");
        }
        if (!isLetter(nombre)) {
            errores.add("El campo titulo debe ser solo letras");
        }
          if (!isNumeric(numero)) {
              errores.add("El campo de numero debe ser solo numeros");
          }
        
      
        return errores;
    }
         public List<String> CheckDeptEmp(String numero){
    List <String> errores=new ArrayList();
      
        if (numero.isEmpty()) {
           errores.add("El campo numero no puede estar vacio");
        }
        
          if (!isNumeric(numero)) {
              errores.add("El campo de numero debe ser solo numeros");
          }
        
      
        return errores;
    }
          public List<String> CheckSalaries(String numero, String Salary){
    List <String> errores=new ArrayList();
      
        if (numero.isEmpty()) {
           errores.add("El campo numero no puede estar vacio");
        }
        
          if (!isNumeric(numero)) {
              errores.add("El campo de numero debe ser solo numeros");
          }
        if (Salary.isEmpty()) {
           errores.add("El campo salario no puede estar vacio");
        }
        
          if (!isNumeric(Salary)){
              errores.add("El campo de salario debe ser solo numeros");
          } 
      
        return errores;
    }
      public Boolean isLetter(String txt){
    	for (int i = 0; i < txt.length(); i++)
		{
			char caracter = txt.toUpperCase().charAt(i);
			int valorASCII = (int)caracter;
			if (valorASCII != 165 && (valorASCII < 65 || valorASCII > 90))
				return false; //Se ha encontrado un caracter que no es letra
		}
 
		//Terminado el bucle sin que se haya retornado false, es que todos los caracteres son letras
		return true;
    }
      private static boolean isNumeric(String txt){
	try {
		Integer.parseInt(txt);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
}
}