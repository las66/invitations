package ru.las.converter;

import com.ibm.icu.text.Transliterator;
import org.springframework.stereotype.Component;

@Component
public class TranslitConverter {

    private static final String CYRILLIC_TO_LATIN = "Russian-Latin/BGN";

    public String cyrillicToLatin(String message) {
        Transliterator toLatinTrans = Transliterator.getInstance(CYRILLIC_TO_LATIN);
        return toLatinTrans.transliterate(message);
    }
}
