package org.example.dynamic;

public class Musician {
    private MusicianType type;
    private String name;
    private String vocalRange;
    private String guitarType;
    private String repertoire;

    public Musician(MusicianType type, String name) {
        if (type == null) {
            throw new IllegalArgumentException("Type must not be null.");
        }
        
        this.type = type;
        this.name = name;
    }

    public MusicianType getType() {
        return type;
    }

    public void setType(MusicianType type) {
        if (type == null) {
            throw new IllegalArgumentException("Type must not be null.");
        }
        
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVocalRange() throws Exception {
        if (!type.equals(MusicianType.SINGER)) {
            throw new Exception();
        }
        return vocalRange;
    }

    public void setVocalRange(String vocalRange) throws Exception {
        if (!type.equals(MusicianType.SINGER)) {
            throw new Exception();
        }
        
        this.vocalRange = vocalRange;
    }

    public String getGuitarType() throws Exception {
        if (!type.equals(MusicianType.GUITARIST)) {
            throw new Exception();
        }
        
        return guitarType;
    }

    public void setGuitarType(String guitarType) throws Exception {
        if (!type.equals(MusicianType.GUITARIST)) {
            throw new Exception();
        }
        
        this.guitarType = guitarType;
    }

    public String getRepertoire() throws Exception {
        if (!type.equals(MusicianType.PIANIST)) {
            throw new Exception();
        }
        
        return repertoire;
    }

    public void setRepertoire(String repertoire) throws Exception {
        if (!type.equals(MusicianType.PIANIST)) {
            throw new Exception();
        }
        
        this.repertoire = repertoire;
    }
}
