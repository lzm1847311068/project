package di;

import java.io.Serializable;

public class Axe implements Tools, Serializable {

    private String name = "斧子";

    @Override
    public String toString() {
        return "Axe{" +
                "name='" + name + '\'' +
                '}';
    }
}
