package org.example.multipleinheritance;

public abstract class Gmina {
    private String nazwa;

    public Gmina(String nazwa) {
        this.nazwa = nazwa;
    }

    abstract void wyświetlJednostkiPomocnicze();

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}
