package calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrangeCalc {
    public static void main(String[] args) {
        String s = """
                1)расширить класс калькулятор на умножение
                2)расширить класс калькулятор на деление
                3)расширить класс калькулятор на бинарный перевод
                (  принимаемые значения как стринг, так и инт\s
                   - тут необходимо подумать как наилучшим образом реализовать,\s
                   что будет если будут приниматься округляемые Double/Float\s
                   (округляемые -> с нулем на конце прим. 3.0 , 4.0 и тд т)
                )
                ------------------------------------                   
                   """;
        System.out.println(s);
        StrangeCalc calc1 = new StrangeCalc();
        double sum, mul, div, sum2;
        sum = calc1.sum(new ArrayList<>(Arrays.asList(1,2,3)));
        System.out.println("sum="+sum);
        mul = calc1.mul(new ArrayList<>(Arrays.asList(1,2,3)));
        System.out.println("mul="+mul);
        div = calc1.div(new ArrayList<>(Arrays.asList(1,2,3)));
        System.out.println("div="+div);
        sum2 = calc1.sum2(new ArrayList<>(Arrays.asList(1,"2.0",3.1)));
        System.out.println("sum2="+sum2);
    }

    public Double sum(List<? extends Number> items) {
        double sum = 0;
        for(Number i: items)
            sum += i.doubleValue();
        return sum;
    }
    public Double mul(List<? extends Number> items) {
        double sum = 1;
        for(Number i: items)
            sum *= i.doubleValue();
        return sum;
    }
    public Double div(List<? extends Number> items) {
        double sum = 0;
        for(int i=0; i<items.size(); i++)
            if(i==0) sum = items.get(i).doubleValue();
            else sum /= items.get(i).doubleValue();
        return sum;
    }

    public Double sum2(List<? extends java.io.Serializable> items) { // хоть что-то :)
        double sum = 0;
        for(Object i: items) {
            double d = 0;
            if(i instanceof String) d = Double.valueOf((String) i);
            else d = ((Number)i).doubleValue();
            sum += d;
        }
        return sum;
    }

}