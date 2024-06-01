package org.example.multipleinheritance;

import java.util.LinkedList;
import java.util.List;

public class GminaMiejska extends Gmina implements IGminaMiejska{
    private final List<String> dzielnice = new LinkedList<>();
    private final List<String> osiedla = new LinkedList<>();

    public GminaMiejska(String nazwa) {
        super(nazwa);
    }

    @Override
    public void wyświetlJednostkiPomocnicze() {
        System.out.println(
                "GminaMiejska{" +
                "dzielnice=" + dzielnice +
                ", osiedla=" + osiedla +
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
}
