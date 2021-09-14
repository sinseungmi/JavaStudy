import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public class E07_JSON {
	/*
	 * # JSON
	 * 
	 * -JavaScipt의 Object타입과 굉장히 유사한 형태의 데이터 표현 방식
	 * -문자열만으로도 다양한 데이터를 간결하게 표혈할 수 있어서 인기가 많다
	 * -{"key" : value, "key" : value, ...}
	 *
	 *# JSON의 value에 표현 가능한 타입들
	 *
	 *-'',"" : String
	 *-숫자,소수 : Number
	 *-[] : Array
	 *-{} : Object(JAVA의 Map)
	 * 
	 * 
	 * */
	public static void main(String[] args) {
		
		//myMap에 저장된 데이터들을 JSON형태의 문자열로 만들어 파일에 출력하는 메서드를 만들어보세요
		// (확장자는 .json)
		HashMap<String, Object> myMap = new HashMap<>();
		
		myMap.put("name", "홍길동");
		myMap.put("age", 123);
		myMap.put("tel", "010-1234-1234");
		myMap.put("tel2", null);
		myMap.put("language", new String[] {"C","JAVA","Javascript", "React"});
		myMap.put("lotto", new Integer[] {1, 2, 3, 4, 5, 6, 7});
		
		StringBuilder str = mapToJsonStr(myMap);
		
		E07_JSON json = new E07_JSON();
		json.mapToJsonFile(str);
		json.entryMap(json.maping());
		
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
	
	public String[] alternative(String[] arr) {
		for(int index = 0; index < arr.length; index++) {
			arr[index] = arr[index].replace("[", "");
			arr[index] = arr[index].replace("]", "");
			arr[index] = arr[index].replace("'", "");
	}
		return arr;
	}
	
	public HashMap<String, Object> maping() {
		try {
			FileInputStream in = new FileInputStream("./data/JSON.json");
			InputStreamReader inreader = new InputStreamReader(in, Charset.forName("UTF-8"));
			
			String str = "";
			int ch;
			while ((ch = inreader.read()) != -1) {
				str += (char)ch;
			}
					
			str = str.replace("{", " ");
			str = str.replace("}", " ");
			str = str.trim();
			
			str = str.replace(":", ",");
			String[] strArr = str.split(",");
			
			ArrayList<String> list = new ArrayList<>(); 
			for(String s : strArr) {
				s = s.trim();
				list.add(s);
			}
			
			ArrayList<String> remoStrList = new ArrayList<>(); 
			ArrayList<String> remoIntList = new ArrayList<>(); 
			
			int size = list.size();
			int cIndex = 0, oneInex = 0;
			cIndex = list.indexOf("['C'");
			
			// [1, 2, 3, 4, 5]    
			// [2, 3, 4, 5]    값을 하나씩 지웠을 때 그 값에 인덱스가 바뀐다는 걸 명심!
						//2는 원래 인덱스가 1이였지만, 1이 remove되면서 2의 인덱스는 0이된다.
					    //그래서 2가 안지워지는 것. i는 계속 증가하고 있으므로. 하나 건너뛰어지면서 지워지는 식이 되버림
			for(int i = 0; i < list.size(); i++) { 
				if(list.get(i).contains("C") ||
						list.get(i).contains("J") || 
						list.get(i).contains("R")) {
					remoStrList.add(list.remove(i));
					size--;
					i--;
					
					oneInex = list.indexOf("'2'");
					
				}else {
					int intNum = 0; 
					while(++intNum <= 7) {
						if(list.get(i).contains(String.format("'%d'", intNum))) {
							remoIntList.add((list.remove(i)));
							i--;
							size--;
					    }
					}
				}
			}
			list.add(cIndex,String.join(",",remoStrList));
			list.add(oneInex, String.join(",", remoIntList));
			
//			for(String s : list) {
//				System.out.println(s);
//			}
			
			HashMap<String, Object> againMap = new HashMap<>();
			
			for(int i = 0, j = 1; i < list.size(); i+=2, j+=2) {
				String listI = list.get(i);
				String listJ = list.get(j);
				
				if (listJ.equals("\"null\"")) {
					againMap.put(listI, null);
				}else if(Pattern.matches("\"[가-힣]{2,}\"", listJ)) {
					againMap.put(listI, (String)listJ);
				}else if(Pattern.matches("\"0\\d{2}-?\\d{3,4}-?\\d{4}\"", listJ)) {
					againMap.put(listI, (String)listJ);
										// \\[ <- 이렇게 표현한 이유는 []자체가 표현식인데 [[]이렇게 해버리면
										//문자 [가 아닌 표현식 [로 인식해서!!
				}else if(Pattern.matches("\\[[\',a-zA-Z]*\\]", listJ)) {
					String[] strarr2 = listJ.split(",");
					againMap.put(listI, alternative(strarr2));					
				}else if(Pattern.matches("\\[[0-9\',]*\\]", listJ)) {
					 String[] keep = listJ.split(",");
					 Integer[] intArr = new Integer [keep.length];
					 for(int index = 0; index < keep.length; index++) {
						 keep = alternative(keep);
						 int num = Integer.parseInt(keep[index]);
						 intArr[index] = num;
					 }
					againMap.put(listI, intArr);					
				}else {
					againMap.put(listI, Integer.parseInt(listJ));					
				}
			}
			//System.out.println(againMap);
			
			return againMap;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	public void mapToJsonFile(StringBuilder sb) {
		
		File f = new File("./data/JSON.json");
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






