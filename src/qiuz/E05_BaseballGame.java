package qiuz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class E05_BaseballGame {
	
	/*
	 * # 직렬화
	 * - 객체에 저장된 데이터를 스트림에 쓰기(write)위해 연속적인 데이터로 변환하는 것을 의미
	 * - 객체를 저장한다는 것은 객체의 모든 인스턴스 변수의 값을 저장한다는 것과 같다.(자바의 정석 p.662 참고)
	 * 
	 * (자바의 정석 p.663 참고)
	 * # ObjectInputStream
	 * - 역직렬화(스트림으로부터 객체를 입력)
	 * 
	 * # ObjectoutputStream
	 * - 직렬화(스트림에 객체를 출력)
	 * 
	 * 
	 * */

        public static void main(String[] args) {        
                
                LinkedList<UserRecord> ranking = new LinkedList<>();
                
                File save = new File("./data/base.game");
            
            if (save.exists()) {
                    try {
                            ObjectInputStream oin = new ObjectInputStream(new FileInputStream(save));
                            ranking = (LinkedList)oin.readObject(); //먼저 불러오기한다 그래서 아래에서 out.writeObject(ranking)를 해도 안날라간다     
                            oin.close();
                    } catch (FileNotFoundException e) {                                
                            e.printStackTrace();
                    } catch (IOException e) {                                
                            e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                    }                        
                    
                    System.out.println("######### 현재 랭킹 #########");
                    printRanking(ranking);
            }                
            
            int answer = 1234;
            
            InputStreamReader input = new InputStreamReader(System.in);
            // DataInputStream sc = new DataInputStream(System.in);
            Scanner sc = new Scanner(input);
            //InputStreamReader에 받은 것은 바이트! 그걸 스캐너로 감싸줘서
            //바이트를 문자화 시켜서 편하게 한다. 데이터인풋스트림과 비슷
    
            System.out.println("게임 시작! 빠르게 1234를 입력하는 게임!");
            
            long start = System.currentTimeMillis();
            
            System.out.print("입력해보세요 >> ");
            
            int record = -1;
            if (sc.nextInt() == 1234) {
                    System.out.println("성공!");
                    record = (int)(System.currentTimeMillis() - start);
                    
                    sc.nextLine();
                    System.out.print("당신의 이름을 입력하세요 > ");                        
                    ranking.add(new UserRecord(sc.next(), record));                        
                    Collections.sort(ranking);
                    
                    try {
                            ObjectOutputStream out = new ObjectOutputStream(
                                            new FileOutputStream(save));                                
                            out.writeObject(ranking);     //자바 인스턴스를 저장. 
                            out.close();
                    } catch (FileNotFoundException e) {                                
                            e.printStackTrace();
                    } catch (IOException e) {
                            e.printStackTrace();
                    }
            } else {
                    System.out.println("실패!");
            }                
            
            printRanking(ranking);
    }
    
    private static void printRanking(List<UserRecord> ranking) {
            int i = 1;
            for (UserRecord record : ranking) {
                    System.out.println(i++ + "위 - " + record);
                }
                
        }
        
}

/*
         # Serializable interface
         
          - 해당 클래스로 생성된 인스턴스를 직렬화 할 수 있다고 표시하는 인터페이스
          - serialVersionUID에 원하는 값을 넣으면 된다
          - ObjectOutputStream으로 자바 객체를 파일에 저장할 때 
                        해당 객체를 직렬화(코드화) 할 수 있어야 한다
*/
class UserRecord implements Comparable<UserRecord>, Serializable {
        
        private static final long serialVersionUID = 1L;
        
        String name;
        int user_try;
        int record;
        
        public UserRecord(String name, int record) {
                this.name = name;
                this.record = record;
                this.user_try = (int)(Math.random() * 8 + 1); 
        }
        
        @Override
        public String toString() {        
                return String.format("%s [try %d time(s) / %d millisec]", name, user_try, record);
        }

        @Override
        public int compareTo(UserRecord o) {                
                return this.user_try - o.user_try != 0 ? 
                       this.user_try - o.user_try : this.record - o.record;
        }
}











