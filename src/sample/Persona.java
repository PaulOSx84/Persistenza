package sample;



public class Persona implements Savable {

    private String nome;
    private String cognome;

    public Persona()
    {

    }
    public Persona(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }


    @Override
    public String save(){

        return (new StringBuilder()).append(this.nome).append(this.cognome).getDaSalvare();
    }

    @Override
    public void load(String daCaricare) {
        StringBuilder sb = new StringBuilder(daCaricare);
        this.nome = sb.getNextString();
        this.cognome = sb.getNextString();
    }
}
