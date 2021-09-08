package Dictionary;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

import static Dictionary.Dictionary.dictionary_list;

public class DictionaryManagement {

    public void insertFromCommandline () {
        Scanner sc = new Scanner(System.in);
        String word_target = sc.nextLine();
        String word_explain = sc.nextLine();
        Word new_word = new Word(word_target, word_explain);
        addWord(new_word);
    }
    public void insertFromFile() throws FileNotFoundException{
        String url = "E:\\tu_dien\\Dictionary-file-dev\\dictionary.txt";
        File file = new File(url);
        Scanner scfile = new Scanner(file);
        while(scfile.hasNextLine()){
            String word_target = scfile.nextLine();
            String word_explain = scfile.nextLine();
            Word new_word = new Word(word_target, word_explain);
            addWord(new_word);
        }
    }
    public void sort_dictionary_list () {
        Collections.sort(dictionary_list, new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                return o1.compareTo(o2);
            }
        });
    }

    public void addWord (Word new_word) {
        dictionary_list.add(new_word);
        sort_dictionary_list();
    }

}
