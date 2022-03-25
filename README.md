# :pencil2: JavaStudy
>
> <br> 
>
> ### **메서드**
> - Arrays.toString(배열명) : 배열의 모든 요소를 문자열로 반환하여 출력한다. <br>
> - Integer.parseInt(변환하고 싶은 문자열 or 문자열이 들어있는 변수.) : 문자열을 정수로 변환하는 방법 <br>
> - double.parseDouble(문자열) : 문자열을 실수로 변환하는 방법 <br>
> - 반복할 문자열.repeat(반복횟수) : 문자열을 반복횟수 만큼 반복한 결과를 리턴합니다. <br> <br>
> 
> ### **단축키**
>
> - ctrl + space + enter를 누르면 **생성자**가 만들어진다. <br>
> - alt + shift + s를 누르면 **자동생성 메서드**들이 나온다(주로 getter,setter를 많이 씀).  <br>
> generate constructor using fields는 멤버 변수 초기값을 설정하는 생성자를 만들어 준다 <br> <br>
> 
> ### servlet-context.xml
>
> <**resources mapping**="/resources/**" location="/resources/" /> <br>
>
> <**resources mapping**="/css/**" location="/resources/css/" /> <br>
>
> - /css/abc.css 라는 클라이언트의 요청이 들어오면 이것을 /resources/css/abc.css로 매핑시켜준다. <br>
> - 즉, mapping으로 들어온 요청에 대해 location으로 매핑을 시켜주는 것이다. <br>
