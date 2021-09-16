package Dictionary;

import com.sun.java.accessibility.util.Translator;
import com.sun.speech.freetts.VoiceManager;

import static Dictionary.Dictionary.dictionary_list;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.IOException;

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
    public void DictionaryAdvance() throws IOException {
        DictionaryManagement dcm = new DictionaryManagement();
        dcm.insertFromFile();
        dcm.Dictionary_Lookup();
        dcm.addWordInList();
        dcm.fixInList();
        dcm.deleteWordInList();
        showAllWords();
    }
    public void dictionarySearcher(String input){//hàm trả về các từ tìm kiếm nếu nhập dở
        int iS = input.length();// độ dài chuỗi input
        for(int i=0 ; i<dictionary_list.size();i++){
             if(dictionary_list.get(i).getWord_target().substring(0,iS).equals(input)){
                 System.out.println(dictionary_list.get(i).getWord_target()+"\t");
             }
        }
    }
    public void Speech(String text){
        VoiceManager voice = VoiceManager.getInstance();
        com.sun.speech.freetts.Voice syntheticVoice = voice.getVoice("kevin16");
        syntheticVoice.allocate();
        syntheticVoice.speak(text);
        syntheticVoice.deallocate();
    }
}
