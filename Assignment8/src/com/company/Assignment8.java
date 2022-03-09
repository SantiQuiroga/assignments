package com.company;
import java.util.Arrays;
import java.util.Objects;

public class Assignment8 {
    StringBuilder mixed_text = new StringBuilder();
    StringBuilder final_text = new StringBuilder();
    String[] text_separated;
    String text;
    int numberWords;

    public Assignment8(String text) {
        this.text = text;
        this.text += ' ';
        this.numberWords = numberWords(this.text);
        this.text_separated = appendArray(this.numberWords, this.text);

        System.out.println(Arrays.toString(this.text_separated));

        for (String word : this.text_separated) {
            if (word.length() > 3) {
                String mixed_word;
                do {
                    mixed_word = mixText(word);
                }
                while (Objects.equals(mixed_word, word));
                this.final_text.append(mixed_word);
            }
            else {
                this.final_text.append(word);
            }
            this.final_text.append(' ');
        }
    }

    int numberWords(String text) {
        int numberWords = 0;

        for (int i = 0; i < text.length(); i++){
            char character = text.charAt(i);
            if (character == ' '){
                numberWords++;
            }
        }
        return numberWords;
    }

    String[] appendArray(int numberWords, String text) {
        StringBuilder create_word = new StringBuilder();
        String[] array = new String[numberWords];

        int pos_array = 0;

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if (character != ' ' ) {
                create_word.append(character);
            }
            else {
                array[pos_array] = String.valueOf(create_word);
                create_word = new StringBuilder();
                pos_array++;
            }
        }
        return array;
    }

    String mixText(String word) {
        int textLength = word.length() - 1;
        boolean condition = word.charAt(textLength) == ',' ||
                word.charAt(textLength) == '.' ||
                word.charAt(textLength) == '!';

        String clean_word = Refactor(word);

        int mixLength = clean_word.length() - 2;
        char[] charsToMix = new char[mixLength];
        int firstChar = 0;

        for (int i = 1; i < clean_word.length() - 1; i++){
            charsToMix[firstChar] = clean_word.charAt(i);
            firstChar++;
        }

        for (int i = 0; i < clean_word.length(); i++) {
            char character;
            int count = 0;
            if (i == 0 || i == clean_word.length() - 1) {
                character = clean_word.charAt(i);
            }
            else {
                int number = (int) (Math.random() * mixLength);
                character = charsToMix[number];
                mixLength -= 1;
                char[] aux = new char[mixLength];
                for (int j = 0; j < charsToMix.length; j++){
                    if (j != number) {
                        aux[count] = charsToMix[j];
                        count++;
                    }
                }
                charsToMix = new char[mixLength];
                System.arraycopy(aux, 0, charsToMix, 0, charsToMix.length);
            }
            this.mixed_text.append(character);
        }
        if (condition) {
            char character = word.charAt(textLength);
            this.mixed_text.append(character);
        }
        String text = String.valueOf(mixed_text);
        mixed_text = new StringBuilder();
        return text;
    }

    String Refactor(String word){
        word = word.replace(",", "");
        word = word.replace(".", "");
        word = word.replace("!", "");
        return word;
    }

    public String toString() {
        String result = String.valueOf(this.final_text);
        return result.trim();
    }
}
