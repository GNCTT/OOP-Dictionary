package Dictionary;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

import static Dictionary.Dictionary.dictionary_list;

public class DictionaryManagement  {
    String url = "E:\\tu_dien\\Dictionary-file-dev\\dictionary.txt";
    public void insertFromCommandline () {
        Scanner sc = new Scanner(System.in);
        String word_target = sc.nextLine();
        String word_explain = sc.nextLine();
        Word new_word = new Word(word_target, word_explain);
        addWord(new_word);
    }
    public void insertFromFile() throws FileNotFoundException{// đọc dữ liệu từ điển từ file
        File file = new File(url);
        Scanner scfile = new Scanner(file);
        while(scfile.hasNextLine()){
            String word_target = scfile.nextLine();
            String word_explain = scfile.nextLine();
            Word new_word = new Word(word_target, word_explain);
            addWord(new_word);
        }
    }
    public void sort_dictionary_list () {//sắp xếp từ điển
        Collections.sort(dictionary_list, new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                return o1.compareTo(o2);
            }
        });
    }

    public void Dictionary_Lookup(){//tìm kiếm từ ở từ điển
        String a;
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập từ tìm kiếm:");
        a = sc.nextLine();
        int n = dictionary_list.size();
        boolean check = false;
        for(int i = 0;i<n;i++) {
            if (a.equals(dictionary_list.get(i).getWord_target())) {
                System.out.println("từ bạn cần tìm là :" + dictionary_list.get(i).getWord_explain());
                check = true;
                break;
            }
        }
        if(check ==false) {
            System.out.println("không có từ bạn cần tìm");
        }
    }
    public void addWordInList() throws IOException{//thêm từ mới vào danh sách
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap tu muon them :");
        String word_target = sc.nextLine();
        System.out.println("nhap nghia :");
        String word_explain = sc.nextLine();
        Word newWord = new Word(word_target,word_explain);
        addWord(newWord);
        Deletefile();
        dictionaryExportToFile();
    }
    public void deleteWordInList() throws IOException,FileNotFoundException{ //xóa từ trong danh sách
            FileOutputStream fileout = new FileOutputStream(url);
            Scanner sc = new Scanner(System.in);
            System.out.println("nhap tu muon xoa :");
            String word_target = sc.nextLine();
            int n = dictionary_list.size();
            for(int i = 0; i<n;i++){
                if(dictionary_list.get(i).getWord_target().equals(word_target)){
                    dictionary_list.remove(i);
                    break;
                }
            }
            dictionaryExportToFile();
        }
    public void Deletefile() throws IOException{
        File file = new File(url);
        file.delete();
    }
    public void dictionaryExportToFile() throws IOException{
            try{
                FileOutputStream fileout = new FileOutputStream(url);
                String enter = "\r\n";
                byte e[] =enter.getBytes();
                for(int i = 0;i < dictionary_list.size() ; i++){
                    String a = dictionary_list.get(i).getWord_target();
                    byte word_tar[] = a.getBytes();
                    fileout.write(word_tar);
                    fileout.write(e);
                    String b = dictionary_list.get(i).getWord_explain();
                    byte word_exp[] = b.getBytes();
                    fileout.write(word_exp);
                    fileout.write(e);
                }
                fileout.close();
            }catch(Exception e){
                System.out.println(e);
            }
    }
    public void addWord (Word new_word) {
        dictionary_list.add(new_word);
        sort_dictionary_list();
    }

}
