package sample;


public class Automobile implements Savable{

    private String marca;
    private String modello;

    public Automobile()
    {

    }
    public Automobile(String marca, String modello) {
        this.marca = marca;
        this.modello = modello;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }


    @Override
    public String save(){

        return (new StringBuilder()).append(this.marca).append(this.modello).getDaSalvare();
    }


    public void load(String daCaricare) {
        StringBuilder sb = new StringBuilder(daCaricare);
        this.marca = sb.getNextString();
        this.modello = sb.getNextString();
    }
}
