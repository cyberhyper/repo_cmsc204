package assignment5;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class MorseCodeConverter {

  private static MorseCodeTree morse = new MorseCodeTree();

  public static String convertToEnglish(String code) {
	  
    String[] letter;
    String[] word = code.split(" / ");
    StringBuilder english = new StringBuilder();

    for (String ch : word) 
    {
      letter = ch.split(" ");
      
      for (String tmp : letter) 
      {
        english.append(morse.fetch(tmp));
      }
      english.append(" ");
    }
    return english.toString().trim();
  }

  public static String convertToEnglish(File codeFile) throws FileNotFoundException {
	  
    StringBuilder sb = new StringBuilder();
    InputStream in = new FileInputStream(codeFile);
    BufferedReader br = new BufferedReader(new InputStreamReader(in));

    br.lines().forEach(s -> sb.append(convertToEnglish(s)).append("\n"));
    try 
    {
      br.close();
    } 
    catch (IOException e) 
    {
      e.printStackTrace();
    }
    return sb.toString().trim();
  }

  public static String printTree() {
    ArrayList<String> morseTree = morse.toArrayList();
    StringBuilder sb = new StringBuilder();

    for (String letters : morseTree) 
    {
      sb.append(letters).append(" ");
    }
    
    return sb.toString().trim();
  }

}