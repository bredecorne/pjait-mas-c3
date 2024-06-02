package org.example.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MusicianTest {
    
    private Musician musician;

    @Test
    void setsAndRetrievesAttributesCorrectlyForSinger() {
        musician = new Musician(MusicianType.SINGER, "Adam Gessler");
        try {
            musician.setVocalRange("Mezzo-Soprano");
        } catch (Exception e) {
            fail("Exception should not be thrown for a singer setting vocal range.");
        }

        assertAll(
                () -> assertEquals("Adam Gessler", musician.getName()),
                () -> assertEquals(MusicianType.SINGER, musician.getType()),
                () -> assertEquals("Mezzo-Soprano", musician.getVocalRange())
        );
    }

    @Test
    void setsAndRetrievesAttributesCorrectlyForGuitarist() {
        musician = new Musician(MusicianType.GUITARIST, "Jonatan Gitarzysta");
        try {
            musician.setGuitarType("Stratocaster");
        } catch (Exception e) {
            fail("Exception should not be thrown for a guitarist setting guitar type.");
        }

        assertAll(
                () -> assertEquals("Jonatan Gitarzysta", musician.getName()),
                () -> assertEquals(MusicianType.GUITARIST, musician.getType()),
                () -> assertEquals("Stratocaster", musician.getGuitarType())
        );
    }

    @Test
    void setsAndRetrievesAttributesCorrectlyForPianist() {
        musician = new Musician(MusicianType.PIANIST, "Yang Mang Jr");
        try {
            musician.setRepertoire("Chopin, Bach");
        } catch (Exception e) {
            fail("Exception should not be thrown for a pianist setting repertoire.");
        }

        assertAll(
                () -> assertEquals("Yang Mang Jr", musician.getName()),
                () -> assertEquals(MusicianType.PIANIST, musician.getType()),
                () -> assertEquals("Chopin, Bach", musician.getRepertoire())
        );
    }

    @Test
    void changingTypeAllowsOtherMethodsToBeUsed() {
        musician = new Musician(MusicianType.PIANIST, "Yang Mang Jr");
        try {
            musician.setRepertoire("Chopin, Bach");
        } catch (Exception e) {
            fail("Exception should not be thrown for a pianist setting repertoire.");
        }
        
        musician.setType(MusicianType.SINGER);
        try {
            musician.setVocalRange("Mezzo-Soprano");
        } catch (Exception e) {
            fail("Exception should not be thrown for a singer setting vocal range.");
        }

        assertAll(
                () -> assertEquals("Yang Mang Jr", musician.getName()),
                () -> assertEquals(MusicianType.SINGER, musician.getType()),
                () -> assertEquals("Mezzo-Soprano", musician.getVocalRange()),
                () -> assertThrows(
                        Exception.class,
                        () -> musician.getRepertoire())
        );
    }

    @Test
    void throwsExceptionForInvalidAttributeAccess() {
        musician = new Musician(MusicianType.SINGER, "Bajon");
        assertThrows(Exception.class, () -> musician.setGuitarType("Acoustic"));
    }
}