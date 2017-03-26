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
    
    /**
     * Metodo che carica tutti i file caricabili nella cartella di lavoro
     * @author Paolo
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public void autoLoad() throws IOException,ClassNotFoundException,IllegalAccessException,InstantiationException{
    	
         ArrayList<Savable> persone = new ArrayList<>();
         ArrayList<Savable> automobili = new ArrayList<>();
    	File fil = new File("");
        File f; 
        File[]lf;
        ArrayList<File>filter = new ArrayList<File>();
        Long n ;
        int m;
        f = new File(fil.getCanonicalPath());
	   	System.out.println(f.getCanonicalPath());
		
		n = new Long(f.length()/1000);
		m = n.intValue();
		lf = new File[m];
		lf = f.listFiles();
		for(int i=0;i<lf.length;i++){
			if(lf[i].getName().contains(".txt"))
			System.out.println(lf[i].getName());
			filter.add(lf[i]);
		}
		for(int j=0;j<filter.size();j++){
			if(filter.get(j).getName().contains("Automobile"))
				automobili = this.load(filter.get(j).getName().replace(".txt",""));
			else if(filter.get(j).getName().contains("Persona"))
				persone = this.load(filter.get(j).getName().replace(".txt",""));
		}
		Persona persona;
		 for (Savable savable : persone)
	        {
	            persona = (Persona)savable;
	            System.out.println(persona.getNome() +" "+ persona.getCognome());
	        }
	        Automobile car;
	        for (Savable savable : automobili )
	        {
	            car = (Automobile)savable;
	            System.out.println(car.getMarca() +" "+ car.getModello());
	        }
    }
}
