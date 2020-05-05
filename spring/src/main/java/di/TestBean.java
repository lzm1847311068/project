package di;

import di.Tools;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TestBean implements Serializable {

    //基本值集合
    private List<String> names;
    //对象集合
    private List<Tools> tools;
    //map集合
    private Map<String,String> map;

    //基本值数组
    private double[] values;
    //对象数组
    private Tools[] arr;



    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public List<Tools> getTools() {
        return tools;
    }

    public void setTools(List<Tools> tools) {
        this.tools = tools;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public double[] getValues() {
        return values;
    }

    public void setValues(double[] values) {
        this.values = values;
    }

    public Tools[] getArr() {
        return arr;
    }

    public void setArr(Tools[] arr) {
        this.arr = arr;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "names=" + names +
                ", tools=" + tools +
                ", map=" + map +
                ", values=" + Arrays.toString(values) +
                ", arr=" + Arrays.toString(arr) +
                '}';
    }
}
