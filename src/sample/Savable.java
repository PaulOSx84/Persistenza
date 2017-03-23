package sample;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Mario on 23/03/2017.
 */
public interface Savable {

    public String save();
    public void load(String daCaricare);

}
