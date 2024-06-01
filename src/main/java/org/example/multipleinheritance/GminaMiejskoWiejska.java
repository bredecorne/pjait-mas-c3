package org.example.multipleinheritance;

import java.util.LinkedList;
import java.util.List;

public class GminaMiejskoWiejska extends GminaWiejska implements IGminaMiejska {
    private final List<String> dzielnice = new LinkedList<>();
    private final List<String> osiedla = new LinkedList<>();

    public GminaMiejskoWiejska(String nazwa) {
        super(nazwa);
    }

    @Override
    public void wyświetlJednostkiPomocnicze() {
        System.out.println(
                "GminaMiejskoWiejska{" +
                "dzielnice=" + dzielnice +
                ", osiedla=" + osiedla +
                ", sołectwa=" + super.getSołectwa() +
                '}'
        );
    }
    
    @Override
    public void utwórzDzielnicę(String nazwa) {
        dzielnice.add(nazwa);
    }

    @Override
    public void utwórzOsiedle(String nazwa) {
        osiedla.add(nazwa);
    }

    @Override
    public void utwórzSołectwo(String nazwa) {
        super.utwórzSołectwo(nazwa);
    }
}

