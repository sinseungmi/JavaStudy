package ssm_study;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public class Json {
	
	static HashMap<String, Object> myMap = new HashMap<>();
	ObjectInputStream obIn;
	static ObjectOutputStream obOPS;
	
	public static void main(String[] args) {
		
		//myMap에 저장된 데이터들을 JSON형태의 문자열로 만들어 파일에 출력하는 메서드를 만들어보세요
		// (확장자는 .json)
		
		myMap.put("name", "홍길동");
		myMap.put("age", 123);
		myMap.put("tel", "010-1234-1234");
		myMap.put("tel2", null);
		myMap.put("language", new String[] {"C","JAVA","Javascript", "React"});
		myMap.put("lotto", new Integer[] {1, 2, 3, 4, 5, 6, 7});
		StringBuilder str = mapToJsonStr(myMap);
		Json json = new Json();
		json.mapToJsonFile(str);
		json.entryMap(json.maping());
		
		File f = new File("./test/jsontest.json");
		try {
			obOPS = new ObjectOutputStream(new FileOutputStream(f));
			obOPS.writeObject(myMap);
			
			obOPS.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//작성된 파일의 내용을 다시 JAVA맵으로 로드하는 메서드를 만들어라
	}
	
	public void entryMap(HashMap<String, Object> againMap) {
		
		for(Entry<String, Object> entry : againMap.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			if(value instanceof String[]) {
				int i = 0;
				System.out.print(key + "=[");
				while(i < ((String[]) value).length) {
					System.out.print((((String[])value)[i]) + ", ");						
					i++;
				}
				System.out.print("]\n");
			}else if(value instanceof Integer[]) {
				int i = 0;
				System.out.print(key + "=[");
				while(i < ((Integer[]) value).length) {
					System.out.print(((Integer[])value)[i] + " ,");
					i++;
				}
				System.out.println("]");
			}else {
				System.out.println(key + "=" + value);
			}
		}	
	}

	public HashMap<String, Object> maping() {
		HashMap<String, Object> againMap = null;
		try {
			obIn = new ObjectInputStream(new FileInputStream("./test/jsontest.json"));
			try {
				againMap = (HashMap<String, Object>)obIn.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			System.out.println(againMap.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return againMap;
	}
			
	public void mapToJsonFile(StringBuilder sb) {
		
		File f = new File("./test/jsontest.json");
		try {
			FileOutputStream fout = new FileOutputStream(f);
			OutputStreamWriter outwr = new OutputStreamWriter(fout, Charset.forName("UTF-8"));
			try {
				outwr.append((sb.toString()));
			} catch (IOException e) {
				e.printStackTrace();
			}
			outwr.close();
			fout.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static StringBuilder mapToJsonStr(HashMap<String, Object> myMap) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(String.format("{\n"));
		
		for (String key : myMap.keySet()) {
			Object value = myMap.get(key);
			
			if(value instanceof String[]) {
				String[] strArr = (String[])value;
				
				sb.append(String.format("\"%s\" : [", key));
				for(int i = 0, len = strArr.length; i < len; i++) {
					StringBuilder s = (i != len - 1) ? 
							sb.append(String.format("'%s',", strArr[i])) 
							: sb.append(String.format("'%s'", strArr[i]));
				}
				sb.append(String.format("],\n"));
			}else if(value instanceof Integer[]){
				Integer[] intArr = (Integer[])value;
				
				sb.append(String.format("\"%s\" : [", key));
				for(int i = 0, len = intArr.length; i < len; i++) {
					StringBuilder s = (i != len - 1) ? 
							sb.append(String.format("'%s',", intArr[i])) 
							: sb.append(String.format("'%s'", intArr[i]));
				}
				sb.append(String.format("],\n"));
				
			}else {
				if(value == null) {
					value = "null";
					sb.append(String.format("\"%s\" : \"%s\",\n", key, value.toString()));
				}else if (key.equals("age")) {
					sb.append(String.format("\"%s\" : %s,\n", key, value.toString()));
				}else {
					sb.append(String.format("\"%s\" : \"%s\",\n", key, value.toString()));	
				}
			}
		}	
		sb.append(String.format("}"));
		System.out.println(sb.toString());
		return sb;
	}

}
