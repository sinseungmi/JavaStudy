import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class E04_StreamToChar {

	/*
	 * # Reader/Writer
	 * 
	 * - InputStream과 OutputStream은 데이터를 바이터 단위로 읽고쓴다
	 * - 바이트 단위로 데이터를 사용하기 때문에 원하는 타입으로의 재구성이 필요
	 * - reader와 writer는 데이터를 문자 단위로 읽고 쓰는 클래스들이다
	 * - InputStream/OutputStream을 reader/writer로 한번 더 감싸서 사용한다
	 * 
	 * # abstract class Reader
	 * 
	 * - BufferdReader, InputStreamReader, FileReader ...등은
	 *  모두 Reader 클래스를  상속 받아 구현한 클래스들이다
	 * - Stream으로 읽은 데이터를 문자로 재구성하여 프로그래머가 사용하기 편하게 해준다
	 * - 문자로 합치거나 바이트로 변환할 때 사용할 인코딩 타입을 결정할 수 있다.
	 * 
	 * # Charset(문자집합)
	 * - 글자나 기호들의 집합을 정의한 것이다.
	 * 	아스키(ASCII)와 같이 문자가 추가될수 없는 것과 유니코드(Unicode)와 같이 문자가 추가될 수 있는 것이 존재한다.
	 * 	유니코드는 현존하는 문자인코딩 방법들을 유니코드로 교체하는 것이 목적이며 XML이나 자바 운영체제등에서도 지원한다.
	 * 
	 * 
	 * */
	
	public static void main(String[] args) {
		
		//System.out.println(Charset.availableCharsets());
		
		try {
			InputStreamReader in = new InputStreamReader(
					new FileInputStream(new File("./note/01_Git.txt")), 
					Charset.forName("UTF-8")); 
					//지정된 인코딩을 사용하는 InputStreamReader를 생성한다.
			//ABCD -> encoding -> 65666768 -> decoding -> ABCD
			//한글 -> encoding(UTF-8) -> code -> decoding(MS949) -> ???
			
					  //원래는 1바이트만 들어가야지 안깨지게 읽을 수 있는데,
			int ch;   //2바이트인 한글 같은게 들어올 때도 안깨지게끔 위에서 해결해줌.(바이트를 문자로 변환해줌)
			while ((ch = in.read()) != -1) {
				System.out.print((char)ch);
			}
			
			in.close();
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			
			//FileWriter랑 OutputStreamWriter랑 똑같다고 보면 됨
			OutputStreamWriter out = new OutputStreamWriter(
					new FileOutputStream("./data/output.py"),
					"UTF-8");
			out.write("니냐니뇨");
			out.append("print('hello, python')\n"); //이제 String을 전달해도 바이트 변환을 내가 지정안해줘도 
												    //알아서 바이트로 변환해준다
			out.append("if True:\n");
			out.append("\tprint('that\\'s true')");
	
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}


























