package sample;



public class StringBuilder {

    private String daSalvare;

    public StringBuilder()
    {
        daSalvare = "";
    }

    public StringBuilder(String s)
    {
        this.daSalvare = s;
    }

    public StringBuilder append(String daAggiungere)
    {
        this.daSalvare = this.daSalvare + "---" + daAggiungere;
        return this;
    }

    public StringBuilder append(int daAggiungere)
    {
        this.daSalvare = this.daSalvare + "---" + daAggiungere;
        return this;
    }

    public String getDaSalvare()
    {
        this.daSalvare += "---";
        return this.daSalvare;
    }

    public String getNextString()
    {
        this.daSalvare = this.daSalvare.substring(3); //Eliminiamo 3 trattini
        String daRestituire = this.daSalvare.substring(0, this.daSalvare.indexOf("---")); // salvare parola da restituire
        this.daSalvare = this.daSalvare.substring(this.daSalvare.indexOf("---")); // da salvare aggiornta
        return daRestituire;
    }

    public int getNextInt()
    {
        this.daSalvare = this.daSalvare.substring(3); //Eliminiamo 3 trattini
        String daRestituire = this.daSalvare.substring(0, this.daSalvare.indexOf("---")); // salvare parola da restituire
        this.daSalvare = this.daSalvare.substring(this.daSalvare.indexOf("---")); // da salvare aggiornta

        return Integer.parseInt(daRestituire);
    }
}
