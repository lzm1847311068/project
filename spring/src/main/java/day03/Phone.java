package day03;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Phone implements Serializable {
    private String name = "大哥大";

    @Override
    public String toString() {
        return name;
    }
}
