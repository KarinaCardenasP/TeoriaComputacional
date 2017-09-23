
package automataafd;

import java.util.Scanner;

public class AutomataAFD {

    int cont;//variable que sirve como puntero del arreglo de caracteres de la cadena
    char [] cadenaIngresada; //Arreglo donde se guarda los caracteres por separado
    boolean aceptado; //Variable de aceptacion
    public static void main(String[] args) {
        
        String cadena;
        System.out.println("Ingresa Cadena");
        Scanner teclado=new Scanner(System.in);
        AutomataAFD automata = new AutomataAFD();
        cadena=teclado.next();
        
        automata.cadenaIngresada = cadena.toCharArray();
        automata.inicio();
        if(automata.aceptado)
             System.out.println("Cadena Aceptada");
        else System.out.println("Cadena No Aceptada");
    }
    
    public void inicio(){
           cont =0;
           q0(); //El automata de va al estado inicia q0
   }
      
    public void q0(){
       System.out.println("En q0");
       aceptado=false; //Se inicializa la variable de aceptacion en false porque q0 no es estado valido
    if(cont<cadenaIngresada.length){ //Se evalua que el contador este antes del final de la cadena
       if(cadenaIngresada[cont]=='1'){ //Si la posicion de la cadena en la que se encuentra es igual a 1
            cont++; //Se aumenta el contador para evaluar el siquiente caracter
            q1(); //El automata se dirige al estado q1
       }else if(cadenaIngresada[cont]=='0'){ //Si la cadena inicia con un 0, marcará un error
            qerror();
       }
    }
   
   }
    
    public void q1(){
     System.out.println("En q1");
      aceptado=true;//Dentro del estado q1, se inicializa la variable de aceptacion en true porque ya es un estado válido
      if(cont<cadenaIngresada.length){
       if(cadenaIngresada[cont]=='0'){ //Si el caracter que sigue es igual a 0, se aumenta el contador
            cont++;
            q2();//Y se dirige al estado q2
        }else if(cadenaIngresada[cont]=='1'){ //En caso de que el caracter que se encuentre en la posicion sea un 1
            qerror(); //Marca un error porque no es una cadena valida
       
      }
      }
    }
    
    
    public void q2(){
     System.out.println("En q2");
      aceptado=true;//El estado q2 es un estado válido de igual forma
      if(cont<cadenaIngresada.length){
       if(cadenaIngresada[cont]=='0'){//En caso de que el caracter sea un 0 se aumenta el contador 
            cont++;
            q1();//Y se regresa al estado q1, cumpliendo con 0*, pues se generaran muchos 0
        }else if(cadenaIngresada[cont]=='1'){ //Si el siguiente caracter es un 1, se marca un error y no es aceptada la cadena
            qerror();
       
      }
      }
    }

   public void qerror(){
   System.out.println("Error");
   aceptado = false; //Se cambia el valor de la variable de aceptacion a 0
   }
        
    }
    

