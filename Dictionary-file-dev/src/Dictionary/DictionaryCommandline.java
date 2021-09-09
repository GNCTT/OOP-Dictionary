package Dictionary;

import static Dictionary.Dictionary.dictionary_list;
import java.io.FileNotFoundException;

public class DictionaryCommandline {

    public void showAllWords() {
        int size = dictionary_list.size();
        for (int i = 0; i < size; i++) {
            System.out.println(dictionary_list.get(i).getWord_target() + " : " + dictionary_list.get(i).getWord_explain());
        }
    }

    public void dictionaryBasic() {
        DictionaryManagement dcm = new DictionaryManagement();
        dcm.sort_dictionary_list();
        showAllWords();
    }
    public void DictionaryAdvance() throws FileNotFoundException{
        DictionaryManagement dcm = new DictionaryManagement();
//        dcm.addWordInList();
        dcm.insertFromFile("D:\\DEV\\OOP-Dictionary\\Dictionary-file-dev\\resource\\Dictionary\\dictionary.txt");
        dcm.Dictionary_Lookup();
        showAllWords();
    }

}
