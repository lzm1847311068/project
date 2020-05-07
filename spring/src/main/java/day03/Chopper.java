package day03;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Chopper implements Serializable {
    private String name = "屠龙刀";

    @Override
    public String toString() {
        return name;
    }
}
