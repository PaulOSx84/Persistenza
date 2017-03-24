package sample;


import java.io.*;
import java.util.ArrayList;

public class Persistenza
{

    public Savable generaOggetto(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException
    {
      return (Savable) Class.forName(className).newInstance();
    }

    // txt a programma
    public ArrayList<Savable> load(String classe) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        FileReader fileReader = new FileReader(classe+".txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList<Savable> savables = new ArrayList<>();
        Savable savable;

        while(bufferedReader.ready())
        {
            String loaded = bufferedReader.readLine();
            savable = generaOggetto(classe);
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
