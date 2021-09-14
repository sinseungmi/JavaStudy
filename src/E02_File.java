import java.io.File;

public class E02_File {
	
	/*
	 *  # java.util.File
	 *  
	 *  -파일 시스템의 파일 정보를 담을 수 있는 클래스(파일 자체는 아님)
	 *  -파일 클래스는 파일에 대한 정보들을 파악하기 위한 메소드들로 구성되어 있다.
	 *   파일을 생성하고 삭제하며 지정된 파일이 읽기 가능한지 또는 현재 디렉토리에 어떤 파일들이 
	 *   있는지를 검사하는  다양한 메소드들이 있다.
	 *  -인스턴스에 담겨 있는 정보를 바탕으로 새로운 파일이나 디렉토리를 생성할 수 있다
	 * 	-이미 존재하는 파일 또는 디렉터리의 정보를 불러오기도 한다
	 * 
	 * */
	public static void main(String[] args) {
		
		//생성자로 경로를 전달
		File a = new File("a.txt");
		File b = new File("b.txt");
		File dir = new File("D:/files");
		File dir2 = new File("D:/images/");
		
		System.out.println("읽기 권한이 있는 파일?" + a.canRead());
		System.out.println("실행 권한이 있는 파일?" + a.canExecute());
		System.out.println("쓰기 권한이 있는 파일?" + a.canWrite());
		
	
		//절대 경로 알아오기
		System.out.println(a.getAbsolutePath());
		
		//a에 담긴 경로가 절대 경로인가?
		System.out.println(a.isAbsolute());
		
		//a에 담긴 파일 인스턴스는 디렉토리인가?
		System.out.println("is a directory?" + a.isDirectory());
		System.out.println("is dir directory?" + dir.isDirectory());
	
		System.out.println("a가 현재 존재하나?" + a.exists());
		System.out.println("dir이 현재 존재하나?" + dir.exists());
		System.out.println("dir2가 현재 존재하나?" + dir2.exists());
	
		//존재하지 않으면 디렉토리 생성하기
		if(!dir2.exists()) {
			dir2.mkdir();
		}else {
			System.out.println("이미 존재하는 디렉토리입니다");
		}
	}

}












