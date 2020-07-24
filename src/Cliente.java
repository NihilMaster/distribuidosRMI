
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GAMER
 */
public class Cliente {
    public static void MostrarMenu() {
        System.out.println("***************************");        
        System.out.println("**********MENU*************");        
        System.out.println("***************************");        
        System.out.println("1.  SUMAR");        
        System.out.println("2.  RESTAR");        
        System.out.println("3.  MULTIPLICAR");        
        System.out.println("4.  SALIR");        
        LeerSeleccion();
    }
    /*--------*/
    public static void LeerSeleccion() {
        try {
            int Seleccion;
            int[] polinomioA;
            int[] polinomioB;
            int[] resultado;
            
            InterfacCS i = (InterfacCS)Naming.lookup("rmi://localhost/Polinomio2");
            System.out.println("Digite su opcion: ");
            Scanner sc = new Scanner(new InputStreamReader(System.in));
            Seleccion = sc.nextInt();
            switch(Seleccion){
                case 1:
                    System.out.println("sumar: ");
                    polinomioA = LeerPolinomio("ingrese el primer polinomio");
                    polinomioB = LeerPolinomio("ingrese el segundo polinomio");
                    resultado = i.sumar(polinomioA, polinomioB);
                    System.out.println("El resultado de la suma es: ");
                    MostrarPolinomio(resultado);
                    MostrarMenu();
                    break;
                case 2:
                    System.out.println("Restar: ");
                    polinomioA = LeerPolinomio("ingrese el primer polinomio");
                    polinomioB = LeerPolinomio("ingrese el segundo polinomio");
                    resultado = i.restar(polinomioA, polinomioB);
                    System.out.println("El resultado de la resta es: ");
                    MostrarPolinomio(resultado);
                    MostrarMenu();
                    break;
                case 3:
                    System.out.println("sumar: ");
                    polinomioA = LeerPolinomio("ingrese el primer polinomio");
                    polinomioB = LeerPolinomio("ingrese el segundo polinomio");
                    resultado = i.multiplicar(polinomioA, polinomioB);
                    System.out.println("El resultado de la multiplicacion es: ");
                    MostrarPolinomio(resultado);
                    MostrarMenu();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.print("Opcion incorrecta");
                    MostrarMenu();
                    break;
            }

        } catch (Exception e) {
        }
        
    }
    
    public static int[]  LeerPolinomio(String pMensaje) {
        int[] Polinomio = new int[3];
        Scanner sc = new Scanner(System.in);
        System.out.println(pMensaje);
        for (int i = 0; i < 3; i++) {
            Polinomio[i]=sc.nextInt();
        }
        return Polinomio;
        
    }
    
    public static void MostrarPolinomio(int[] pPolinomio) {
        for (int i = 0; i < 3; i++) {
            System.out.println(" "+ pPolinomio[i]);
        }
        
    }
    /**********************/
    public static void main(String[] args) {
        try {
            MostrarMenu();
        } catch (Exception e) {
        }
    }
}
