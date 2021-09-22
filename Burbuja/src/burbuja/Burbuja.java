
package burbuja;

import java.util.Scanner;


public class Burbuja {

    public static void main(String[] args) {
        Scanner cdcb= new Scanner(System.in);
        
        int limite, i,j,aux,menu;
        String res;
        
        System.out.print("cuantos numeros quieres ordenar? ");
        limite = cdcb.nextInt();
        int arreglo[]; 
             arreglo =  new int [limite];
        
        
        
        for (i=0; i < limite; i++){
            System.out.print("Ingrese el numero " + (i +1)+":");
            arreglo[i] = cdcb.nextInt();
        }
        do{
        System.out.println("como quieres ordenar?:");
        System.out.println("_1_De menor a MAYOR");
        System.out.println("_2_De MAYOR a menor");
        menu = cdcb.nextInt();
        
        
        if (menu == 1){
        
        for (i=0; i < limite; i++){
            for(j=i; j< limite;j++){
                
                if (arreglo[i] > arreglo[j]){
                    aux=arreglo[i];
                    arreglo[i]=arreglo[j];
                    arreglo[j]=aux;
                }
            }
        }
        System.out.print("ORDENADOS = {");
        for (i=0; i < limite; i++){
            System.out.print(arreglo[i]+",");
        }
        System.out.print("} ");
        }
        
        
    if (menu == 2){
        for (i=0; i < limite; i++){
            for(j=i; j< limite;j++){
                
                if (arreglo[i] < arreglo[j]){
                    aux=arreglo[i];
                    arreglo[i]=arreglo[j];
                    arreglo[j]=aux;
                }
            }
        }
        System.out.print("ORDENADOS = {");
        for (i=0; i < limite; i++){
            System.out.print(arreglo[i]+",");
        }
        System.out.println("} ");
    }
        
    System.out.println("\n_____________________________________________________________");
        }while (menu > 0);
    
    
    
    
    
    
    }

    
}
