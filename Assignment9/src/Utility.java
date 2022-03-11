public class Utility {
    public static String[] Repeated(String word) {
        int number_repeated = 0;
        int max_repeated = 0;
        String max_letter = "";
        word = Utility.Order(word);
        int numberWords = Utility.numberWords(word);
        String[] words = Utility.appendArray(numberWords, word);
        String[] no_repeats = Utility.deleteRepeated(numberWords, word);
        String[] no_nulls = Utility.deleteNulls(numberWords, no_repeats);
        String[] result = new String[2];

        for (String pos_words : no_nulls) {
            for (String pos_repeated : words) {
                if (pos_words.equals(pos_repeated)) {
                    number_repeated++;
                }
            }
            if (number_repeated > max_repeated) {
                max_repeated = number_repeated;
                max_letter = pos_words;
            }
            number_repeated = 0;
        }

        result[0] = max_letter;
        result[1] = String.valueOf(max_repeated);
        return result;
    }

    public static String Order(String word){
        word = word.replace(",", "");
        word = word.replace("!", "");
        word = word + " ";
        word = word.toLowerCase();
        return word;
    }

    public static int numberWords(String word) {
        int word_number = 0;

        for (int i = 0; i < word.length(); i++){
            char character = word.charAt(i);
            if (character == ' '){
                word_number++;
            }
        }

        return word_number;
    }

    public static String[] appendArray(int numberWords, String word) {
        StringBuilder create_word = new StringBuilder();
        String[] array = new String[numberWords];
        int pos_array = 0;

        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
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

    public static String[] deleteRepeated(int numberWords, String word){
        StringBuilder create_word = new StringBuilder();
        String[] array = new String[numberWords];
        String created;
        boolean status = false;
        int pos_array = 0;

        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            if (character != ' ' ) {
                create_word.append(character);
            }
            else {
                for (String words_array : array) {
                    created = String.valueOf(create_word);
                    if (created.equals(words_array)) {
                        status = true;
                        break;
                    }
                }
                if (!status){
                    array[pos_array] = String.valueOf(create_word);
                    pos_array++;
                }
                create_word = new StringBuilder();
                status = false;
            }
        }

        return array;
    }

    public static String[] deleteNulls(int word_number, String[] first_array){
        int null_number = 0;
        int pos_array = 0;

        for (String position : first_array) {
            if (position == null) {
                null_number += 1;

            }
        }

        String[] result = new String[(word_number - null_number)];

        for (int i = 0; i < (word_number - null_number); i++){
            result[pos_array] = first_array[i];
            pos_array ++;
        }

        return result;
    }
}
