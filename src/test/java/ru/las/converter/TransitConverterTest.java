package ru.las.converter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TransitConverterTest {

    private final TranslitConverter translitConverter = new TranslitConverter();

    @Test
    public void cyrillicToLatin() {
        String message = "Устанавливай приложение!!! ш123 https://ssylka.dom";
        String translitMessage = "Ustanavlivay prilozheniye!!! sh123 https://ssylka.dom";

        assertEquals(translitMessage, translitConverter.cyrillicToLatin(message));
    }
}