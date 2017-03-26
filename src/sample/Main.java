package sample;


import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

public class Main{


    public static void main(String[] args)
    {
        Persistenza persistenza = new Persistenza();
        ArrayList<Savable> persone = new ArrayList<>();
        ArrayList<Savable> automobili = new ArrayList<>();
        
      /*															//Test salva File
        Persona person1 = new Persona("Franco","Cataldo");
        Persona person2 = new Persona("Francesco","Rollo");
        Persona person3 = new Persona("Ludovica","Lezzi");
        Automobile auto1 = new Automobile("Ferrari","Enzo");
        Automobile auto2 = new Automobile("Maserati","Mirage");
        Automobile auto3 = new Automobile("Ford","Kuga");
        persone.add(person1);
        persone.add(person2);
        persone.add(person3);
        automobili.add(auto1);
        automobili.add(auto2);
        automobili.add(auto3);
     */   
   
       try															
        {
    	 
    	   persistenza.autoLoad();
        }
        catch (IOException e)
        {
            System.out.println("File di caricamento non trovato");
        }
        catch (Exception e)
        {
            System.out.println("Classe sconosciuta");
        }
 
      
        try
        {
            persistenza.save(persone);
            persistenza.save(automobili);
        }catch (IOException e)
        {
            System.out.println("File non accessibile");
        }




    }
}
