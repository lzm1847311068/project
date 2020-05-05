package di;

import java.io.Serializable;

public class Saw implements Tools, Serializable {

    private String name = "锯";

    @Override
    public String toString() {
        return "Saw{" +
                "name='" + name + '\'' +
                '}';
    }
}
