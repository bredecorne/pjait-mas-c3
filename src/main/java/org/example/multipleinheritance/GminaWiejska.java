package org.example.multipleinheritance;

import java.util.LinkedList;
import java.util.List;

public class GminaWiejska extends Gmina {
    private final List<String> sołectwa = new LinkedList<>();

    public GminaWiejska(String nazwa) {
        super(nazwa);
    }

    @Override
    public void wyświetlJednostkiPomocnicze() {
        System.out.println(
                "GminaWiejska{" +
                "sołectwa=" + sołectwa +
                '}'
        );
    }
    
    public void utwórzSołectwo(String nazwa) {
        sołectwa.add(nazwa);
    }

    public List<String> getSołectwa() {
        return sołectwa;
    }
}
