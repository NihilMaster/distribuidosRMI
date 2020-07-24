
import java.rmi.Naming;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates/Polinomio2//src/
 * and open the template in the editor.
 */

/**
 *
 * @author GAMER
 */
public class Servidor {

    public Servidor() {
        try {
            System.setProperty("java.rmi.server.codebase", "file:C:/RMI/src/Polinomio2/src/");
            InterfacCS i = new Implementacion();
            Naming.rebind("rmi://localhost/Polinomio2", i);
            
            System.out.println("Entre");
        } catch (Exception e) {
            System.out.println("error.servidor.java");
        }
    }
    public static void main(String[] args){
        new Servidor();
        System.out.println("Servidor  en espera");
    }           
    
}
