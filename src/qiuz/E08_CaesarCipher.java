package qiuz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class E08_CaesarCipher {
	
	/*
	 * # 암호화
	 * - 평문을 알아볼 수 없는 형태(암호문)로 변환하는 것
	 * - 전달 과정에서 내용을 누가 훔쳐가더라도 알아볼 수 없게 하는 것이 목적이다
	 * 
	 * # 복호화
	 * - 암호화 된 암호문을 다시 평문으로 되돌리는 것
	 *
	 * # 키
	 * - 암호화 또는 복호화에 사용되는 값
	 * 
	 * # 시저 암호
	 * 
	 * 	"Hello, world!" --- key:5 ----> "Mjqqt, btwqi!"
	 * 
	 * 	ABCDEFGHIJKLMNOPQRSTUVWXYZ
	 * 
	 * 	암호화: key만큼 오른쪽으로 문자를 이동 시킴
	 *  복호화: key만큼 왼쪽으로 문자를 이동 시킴
	 * 
	 * # "frankenstein.txt"의 전체 내용을 1~25 사이의 랜덤 키로 암호화
	 * 	 "frankenstein.encrypted.txt"를 생성해보세요
	 * 	 (단, 알파벳만 암호화 할 것)
	 * 
	 * 
	 * */
	/*
	final static String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final static String LOWER = "abcdefghijklmnopqrstuvwxyz";

    public static char encrypt_upper(char ch, int key) {
        return UPPER.charAt((UPPER.indexOf(ch) + key) % UPPER.length());
    }
    
    public static char encrypt_lower(char ch, int key) {
        return LOWER.charAt((LOWER.indexOf(ch) + key) % LOWER.length());
    }
    
    public static void main(String[] args) {
        File frankenstein = new File("./data/text/frankenstein.txt");
        File frankenstein_encrypted = new File("./data/text/frakenstein.encrypted.txt");
        int key = new Random().nextInt(25) + 1;
        
        try (
              FileReader fin = new FileReader(frankenstein);
              BufferedReader bin = new BufferedReader(fin);
              FileWriter fout = new FileWriter(frankenstein_encrypted);
              BufferedWriter bout = new BufferedWriter(fout);
        ) {
            String line = null;                        
            while ((line = bin.readLine()) != null) {                                
                 for (int i = 0, len = line.length(); i < len; ++i) {
                            
                     char ch = line.charAt(i);

                     //System.out.printf("Is '%c' Alphabetic? %b\n", ch, Character.isAlphabetic(ch));
                            
                     switch (Character.getType(ch)) {  //ch값이 어떤 값인지 숫자로 반환(영어 소문자,대문자,한글
                     								//특수문자 등등)
                     case Character.UPPERCASE_LETTER:  //영어 대문자(1)필드 상수                                 
                          ch = encrypt_upper(ch, key);
                          break;
                     case Character.LOWERCASE_LETTER:  //영어 소문자(2)필드 상수  
                          ch = encrypt_lower(ch, key);
                          break;
                     }

                    fout.append(ch);                                        
                 }                
                fout.append('\n');  //라인으로 검사하기 때문에 라인 끝부분을 \n으로 구분해줘야한다.
            }                        
        } catch (FileNotFoundException e) {                        
           e.printStackTrace();
        } catch (IOException e) {
           e.printStackTrace();
        }  
        // 암호화된 파일을 해독하는 decryption(file, key) 메서드를 만들어보세요  
        
        //decryption(frankenstein_encrypted,key);
    }
    */
  
	final static String LARGELETTER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	final static String SMALLLETTER = "abcdefghijklmnopqrstuvwxyz";
	static StringBuilder sb  = new StringBuilder();

	public static void examineAlphabet(int indexSum, String alphabet) {
		int alphaLen = alphabet.length();
		
		if(indexSum < alphaLen) {
			sb.append(alphabet.charAt(indexSum));
		}else {
			int rest = indexSum % (alphaLen - 1);
			sb.append(alphabet.charAt(rest));
		}
	}
	
	public static void main(String[] args) {
		File file = new File("./data/text/frankenstein.txt");
		
		try (	FileInputStream fin = new FileInputStream(file);
				InputStreamReader inreader = new InputStreamReader(fin);
				FileWriter fileWr = new FileWriter("./data/text/frankenstein.encrypted.txt");
				){
			
			int intWord = -1;
			int ranKey = (int)(Math.random() * 25 + 1); 
			char chWord; 
			String strWord = null;
			
			while((intWord = inreader.read()) != -1) {
				int wordIndex;
				int indexSum;
				chWord = (char)intWord;  
				strWord = Character.toString(chWord);
				
				if (LARGELETTER.contains(strWord)) {
					wordIndex = LARGELETTER.indexOf(strWord);
					indexSum = wordIndex + ranKey - 1;
					
					examineAlphabet(indexSum, LARGELETTER);
				} else if (SMALLLETTER.contains(strWord)){
					wordIndex = SMALLLETTER.indexOf(strWord);
					indexSum = wordIndex + ranKey - 1;
					
					examineAlphabet(indexSum, SMALLLETTER);
				}else {
					sb.append(chWord);
				}
			}
			fileWr.append(sb.toString());
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
