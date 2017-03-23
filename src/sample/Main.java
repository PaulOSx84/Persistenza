package sample;


import java.io.IOException;
import java.util.ArrayList;

public class Main{


    public static void main(String[] args)
    {
        Persistenza persistenza = new Persistenza();
        ArrayList<Savable> persone = new ArrayList<>();
        ArrayList<Savable> automobili = new ArrayList<>();

        try
        {
            persone = persistenza.load("sample.Persona.txt");
            automobili = persistenza.load("sample.Automobile.txt");
        }
        catch (IOException e)
        {
            System.out.println("File di caricamento non trovato");
        }
        catch (LoadConfNotFoundException e)
        {
            System.out.println("Classe sconosciuta");
        }

    /*    Persona persona;
        for (Savable savable : persone)
        {
            persona = (Persona)savable;
            System.out.println(persona.getNome() + persona.getCognome());
        }*/

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
