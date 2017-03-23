package sample;


import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Persistenza
{

    public Savable generaOggetto(String file) throws LoadConfNotFoundException
    {
        if (file.equals("sample.Automobile.txt"))
            return new Automobile();
        else if(file.equals("sample.Persona.txt"))
            return new Persona();
        else
            throw new LoadConfNotFoundException();
    }




    // txt a programma
    public ArrayList<Savable> load(String file) throws IOException, LoadConfNotFoundException
    {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList<Savable> savables = new ArrayList<>();
        Savable savable = new Persona();

        while(bufferedReader.ready())
        {
            String loaded = bufferedReader.readLine();
            savable = generaOggetto(file);
            savable.load(loaded);
            savables.add(savable);
        }

        return savables;
    }
    // programma a txt
    public void save(ArrayList<Savable> savables) throws IOException {
        if (!savables.isEmpty())
        {
            FileWriter fileWriter = new FileWriter(savables.get(0).getClass().getName() + ".txt");
            for (Savable savable : savables) {
                String info = savable.save();
                fileWriter.append(info).append("\n");
            }

            fileWriter.flush();
            fileWriter.close();
        }
    }
}
