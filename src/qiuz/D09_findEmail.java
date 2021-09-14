package qiuz;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class D09_findEmail {
	
	/*
	 * 이메일을 판별할 수 있는 정규 표현식을 작성하고 테스트
	 * 
	 * */
	public static void main(String[] args) {
		
		//다음 문자열에서 이메일만 골라서 ArrayList에 차곡차곡 정리한 후 한번씩 출력해보기
		//제대로된 이메일이 몇개인지도 세보기
		
		System.out.println(Pattern.matches("[\\w]*@[\\w]+\\.[\\w]+", "tlsdal@na3er.com"));
		String text = "조선일보	가정/육아	박은주	zeeny@chosun.com\r\n" + 
				"문화일보	가정/육아	박양수	yspark@munhwa.com\r\n" + 
				"경향신문	가정/육아	황경상	yellowpig@kyunghyang.com\r\n" + 
				"동아일보	가정/육아	우경임	woohaha@donga.com\r\n" + 
				"동아일보	가정/육아	정효진	wiseweb@donga.com\r\n" + 
				"MBC뉴스	가정/육아	박선하	vividsun@imbc.com\r\n" + 
				"서울신문	가정/육아	이언탁	utl@seoul.co.kr\r\n" + 
				"국민일보	가정/육아	문수정	thursday@kmib.co.kr\r\n" + 
				"중앙일보	가정/육아	이유림	tamaro@joongang.co.kr\r\n" + 
				"동아일보	가정/육아	이진구	sys1201@donga.com\r\n" + 
				"조선일보	가정/육아	김성모	sungmo@chosun.com\r\n" + 
				"한겨례	가정/육아	구본권	starry9@hani.co.kr\r\n" + 
				"조선일보	가정/육아	박종인	seno@chosun.com\r\n" + 
				"동아일보	가정/육아	양현모	ranbi@donga.com\r\n" + 
				"서울신문	가정/육아	이재연	oscal@seoul.co.kr\r\n" + 
				"중앙일보	가정/육아	황정욱	ok76@joongang.co.kr\r\n" + 
				"조선일보	가정/육아	김미리	miri@chosun.com\r\n" + 
				"한국경제	가정/육아	김은영	mellisa@hankyung.com\r\n" + 
				"서울신문	가정/육아	전경하	lark3@seoul.co.kr\r\n" + 
				"코메디	가정/육아	강경훈	kwkang@kormedi.com\r\n" + 
				"뉴시스	가정/육아	김명원	kmx1105@newsis.com\r\n" + 
				"연합뉴스	가정/육아	김승욱	kind3@yna.co.kr\r\n" + 
				"중앙일보	가정/육아	김진원	jwbest7@joongang.co.kr\r\n" + 
				"서울신문	가정/육아	정현용	junghy77@seoul.co.kr\r\n" + 
				"조선일보	가정/육아	이현주	jooya@chosun.com]\r\n" + 
				"연합뉴스	가정/육아	정주호	jooho@yna.co.kr\r\n" + 
				"서울신문	가정/육아	심재억	jeshim@seoul.co.kr\r\n" + 
				"YTN	가정/육아	김잔디	jandi@ytn.co.kr\r\n" + 
				"동아일보	가정/육아	노지현	isityou@donga.com\r\n" + 
				"경향신문	가정/육아	장은교	indi@kyunghyang.com\r\n" + 
				"동아일보	가정/육아	이미지	image@donga.com\r\n" + 
				"조선일보	가정/육아	홍유미	hym@chosun.com\r\n" + 
				"중앙일보	가정/육아	김혜영	hyeyeong@joongang.co.kr\r\n" + 
				"서울신문	가정/육아	오이석	hot@seoul.co.kr\r\n" + 
				"동아일보	가정/육아	곽민영	havefun@donga.com\r\n" + 
				"한국경제	가정/육아	박영주	gogogirl@bntnews.co.kr\r\n" + 
				"헤럴드경제	가정/육아	조문술	freiheit@heraldm.com\r\n" + 
				"연합뉴스	가정/육아	김영묵	economan@yna.co.kr\r\n" + 
				"한겨례	가정/육아	고나무	dokko@hani.co.kr\r\n" + 
				"조선일보	가정/육아	김철중	doctor@chosun.com\r\n" + 
				"동아일보	가정/육아	이종식	bell@donga.com\r\n" + 
				"내일신문	가정/육아	김영희	beauty02k@hanmail.net\r\n" + 
				"매일경제	건강상식	김지수	winfrey@mkhealth.co.kr\r\n" + 
				"중앙일보	건강상식	이세라	slwitch@joongang.co.kr\r\n" + 
				"한국경제	건강상식	정종호	rumba@hankyung.com\r\n" + 
				"헤럴드	건강상식	유지현	prodigy@heraldm.com\r\n" + 
				"중앙일보	건강상식	황정옥	ok76@joongang.co.kr\r\n" + 
				"헤럴드	건강상식	김재현	madpen@heraldm.com\r\n" + 
				"동아일보	건강상식	이진한	likeday@donga.com\r\n" + 
				"중앙일보	건강상식	김경록	kimkr8486@joongang.co.kr\r\n" + 
				"중앙일보	건강상식	김은정	hapia@joongang.co.kr\r\n" + 
				"한국일보	건강상식	권대익	dkwon@hk.co.kr\r\n" + 
				"동아일보	건강상식	김상훈	corekim@donga.com\r\n" + 
				"조선일보	건강상식	배지영	baejy@chosun.com\r\n" + 
				"아이뉴스24	게임/E스포츠	구윤희	yuni@inews24.com\r\n" + 
				"조선일보	게임/E스포츠	이관우	temz@chosun.com\r\n" + 
				"동아일보	게임/E스포츠	김남규	rain@gamedonga.co.kr\r\n" + 
				"동아일보	게임/E스포츠	김형근	noarose@gamedonga.co.kr\r\n" + 
				"동아일보	게임/E스포츠	최호경	neoncp@gamedonga.co.kr\r\n" + 
				"중앙일보	게임/E스포츠	박명기	mkpark@joongang.co.kr\r\n" + 
				"조선일보	게임/E스포츠	최종배	jovia@chosun.com\r\n" + 
				"서울경제	게임/E스포츠	임지훈	jhlim@sed.co.kr\r\n" + 
				"노컷뉴스	게임/E스포츠	지봉철	janus@nocutnews.co.kr\r\n" + 
				"조선일보	게임/E스포츠	편집국	gamedesk@chosun.com\r\n" + 
				"조선일보	게임/E스포츠	곽승훈	european@sportschosun.com\r\n" + 
				"동아일보	게임/E스포츠	김한준	endoflife81@gamedonga.co.kr\r\n" + 
				"지디넷코리아	게임/E스포츠	봉성창	bong@zdnet.co.kr\r\n" + 
				"프라임경제	경제	조민경	cmk@newsprime.co.kr\r\n" + 
				"머니투데이	경제일반	홍정규	zheng@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	이율	yulsid@yna.co.kr\r\n" + 
				"머니투데이	경제일반	현영복	youngbok@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	윤진섭	yjs@edaily.co.kr\r\n" + 
				"연합뉴스	경제일반	김연정	yjkim84@yna.co.kr\r\n" + 
				"경향신문	경제일반	황보연	whynot@hani.co.kr\r\n" + 
				"연합뉴스	경제일반	이은파	sw21@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	장성구	sunggu@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	박용주	speed@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	이상민	smlee@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	김세진	smile@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	송기용	sky@moneytoday.co.kr\r\n" + 
				"연합뉴스	경제일반	임승규	sklim@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	서진발	sjb@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	정성호	sisyphe@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	김선한	shkim@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	전승현	shchon@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	지성호	shchi@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	조성대	sdcho@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	손상원	sangwon700@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	류종원	rjk@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	이연정	rainmaker@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	구정모	pseudojm@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	정준영	prince@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	심언철	press108@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	심재훈	president21@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	배상현	praxis@newsis.com\r\n" + 
				"연합뉴스	경제일반	국기헌	penpia21@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	박대한	pdhis959@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	송형일	nicepen@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	이명조	mingjoe@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	조성민	min365@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	최윤정	merciel@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	맹찬형	mangels@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	권혜진	lucid@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	이귀원	lkw777@yna.co.kr\r\n" + 
				"한겨례	경제일반	홍지인	ljungberg@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	이승우	leslie@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	이상현	leeyoo@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	김경희	kyunghee@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	김성용	ksy@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	김경석	kskim@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	고일환	koman@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	김현재	kn0209@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	김문성	kms1234@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	김재선	kjsun@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	전승엽	kirin@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	박상돈	kaka@yna.co.kr\r\n" + 
				"이데일리	경제일반	황정우	jungwoo@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	이준서	jun@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	김종수	jsking@yna.co.kr\r\n" + 
				"뉴시스	경제일반	홍제성	jsa@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	조성흠	josh@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	김상현	joseph@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	김준기	jkkim@kyunghyang.com\r\n" + 
				"연합뉴스	경제일반	류지복	jbryoo@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	김중배	jbkim@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	김재홍	jaehong@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	윤선희	indigo@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	신수영	imlac@moneytoday.co.kr\r\n" + 
				"머니투데이	경제일반	홍인철	ichong@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	남현호	hyunho@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	강훈상	hskang@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	이동경	hopema@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	김지훈	hoonkim@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	김호준	hojun@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	이승형	haru@yna.co.kr\r\n" + 
				"머니투데이	경제일반	최현석	harrison@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	조재영	fusionjc@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	김재순	fidelis21c@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	경수현	evan@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	임동욱	dwlim@moneytoday.co.kr\r\n" + 
				"연합뉴스	경제일반	김정태	dbman7@moneytoday.co.kr\r\n" + 
				"연합뉴스	경제일반	신창용	changyong@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	김창선	changsun@yna.co.kr\r\n" + 
				"이데일리	경제일반	황봉규	bong@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	여운창	betty@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	김재은	aladin@edaily.co.kr\r\n" + 
				"연합뉴스	경제일반	최인영	abbie@yna.co.kr\r\n" + 
				"연합뉴스	경제일반	박성우	3pedcrow@yna.co.kr\r\n" + 
				"조선일보	과학	이영완	ywlee@chosun.com\r\n" + 
				"조선일보	과학	백승재	whitesj@chosun.com\r\n" + 
				"아시아	과학	최창준	thispro@asiae.co.kr\r\n" + 
				"전자신문	과학	황태호	thhwang@etnews.co.kr\r\n" + 
				"부산일보	과학	송현수	songh@busan.com\r\n" + 
				"연합뉴스	과학	임상현	shlim@yna.co.kr\r\n" + 
				"연합뉴스	과학	송진원	san@yna.co.kr\r\n" + 
				"연합뉴스	과학	홍창진	realism@yna.co.kr\r\n" + 
				"헤럴드경제	과학	유지현	prodigy@heraldm.com\r\n" + 
				"SBSTV	과학	이상엽	narciso@sbs.co.kr\r\n" + 
				"연합뉴스	과학	김현태	mtkht@yna.co.kr\r\n" + 
				"연합뉴스	과학	김준호	kjunho@yna.co.kr\r\n" + 
				"연합뉴스	과학	김영섭	kimys@yna.co.kr\r\n" + 
				"아시아	과학	김현철	kch@asiae.co.kr\r\n" + 
				"지디넷코리아	과학	송주영	jysong@zdnet.co.kr\r\n" + 
				"YTN	과학	박종혁	johnpark@ytn.co.kr\r\n" + 
				"지디넷코리아	과학	이재구	jklee@zdnet.co.kr\r\n" + 
				"연합뉴스	과학	박지호	jihopark@yna.co.kr\r\n" + 
				"YTN	과학	김재형	jhkim032ytn.co.kr\r\n" + 
				"동아일보	과학	전동혁	jermes@donga.com\r\n" + 
				"연합뉴스	과학	임형섭	hysup@yna.co.kr\r\n" + 
				"서울신문	과학	송혜민	huimin0217@seoul.co.kr\r\n" + 
				"전자신문	과학	박희범	hbpark@etnews.co.kr\r\n" + 
				"전자신문	과학	황지혜	gotit@etnews.co.kr\r\n" + 
				"노컷뉴스	과학	구용회	goodwill@cbs.co.kr\r\n" + 
				"파이낸셜뉴스	과학	이재원	economist@fnnews.com\r\n" + 
				"동아일보	과학	김상연	dream@donga.com\r\n" + 
				"뉴시스	과학	임영주	dasee@newsis.com\r\n" + 
				"연합뉴스	과학	오철우	cheolwoo@hani.co.kr\r\n" + 
				"동아일보	과학	이동영	argus@donga.com\r\n" + 
				"머니투데이	과학	최종일	allday33@moneytoday.co.kr\r\n" + 
				"아이뉴스24	과학 정책	김현철	fluxus19@inews24.com\r\n" + 
				"머니투데이	과학 정책	최종일	allday33@moneytoday.co.kr\r\n" + 
				"서울신문	과학/우주	강경윤	newsluv@seoul.co.kr\r\n" + 
				"파이낸셜	과학정책	정상균	skjung@fnnews.com\r\n" + 
				"조선일보	과학정책	안석배	sbahn@chosun.com\r\n" + 
				"뉴시스	과학정책	박준호	pjh@newsis.com\r\n" + 
				"한국일보	과학정책	박철현	karam@hk.co.kr\r\n" + 
				"전자신문	과학정책	정지연	jyjung@etnews.co.kr\r\n" + 
				"연합뉴스	과학정책	강훈상	hskang@yna.co.kr\r\n" + 
				"서울신문	과학정책	오이석	hot@seoul.co.kr\r\n" + 
				"서울경제	과학정책	황정원	garden@sed.co.kr\r\n" + 
				"파이낸셜	과학정책	이재원	economist@fnnews.com\r\n" + 
				"조선일보	과학정책	김동섭	dskim@chosun.com\r\n" + 
				"동아일보	과학정책	김범석	bsism@donga.com\r\n" + 
				"연합뉴스	과학정책	김인철	aupfe@yna.co.kr\r\n" + 
				"머니투데이	글로벌경제	김유경	yunew@moneytoday.co.kr\r\n" + 
				"머니투데이	글로벌경제	김성휘	sunnykim@moneytoday.co.kr\r\n" + 
				"아시아경제	글로벌경제	조민서	summer@asiae.co.kr\r\n" + 
				"파이낸셜	글로벌경제	서혜진	sjmary@fnnews.com\r\n" + 
				"연합뉴스	글로벌경제	박상현	shpark@yna.co.kr\r\n" + 
				"연합인포맥스	글로벌경제	유승기	sgyoo@yna.co.kr\r\n" + 
				"머니투데이	글로벌경제	조청희	samsara@moneytoday.co.kr\r\n" + 
				"파이낸셜	글로벌경제	김기석	kkskim@fnnews.com\r\n" + 
				"서울신문	글로벌경제	나길회	kkirina@seoul.co.kr\r\n" + 
				"연합뉴스	글로벌경제	김종현	kimjh@yna.co.kr\r\n" + 
				"뉴시스	글로벌경제	이남진	jeans@newsis.com\r\n" + 
				"연합뉴스	글로벌경제	강종구	inyon@yna.co.kr\r\n" + 
				"연합인포맥스	글로벌경제	이효지	hjlee2@yna.co.kr\r\n" + 
				"이데일리	글로벌경제	양미영	flounder@moneytoday.co.kr\r\n" + 
				"뉴시스	글로벌경제	이진례	eeka232@newsis.com\r\n" + 
				"서울신문	글로벌경제	오달란	dallan@seoul.co.kr\r\n" + 
				"연합뉴스	글로벌경제	김대호	daeho@yna.co.kr\r\n" + 
				"머니투데이	글로벌경제	안정준	7up@moneytoday.co.kr\r\n" + 
				"머니투데이	금융/증시	유윤정	youyj@moneytoday.co.kr\r\n" + 
				"문화일보	금융/증시	유회경	yoology@munhwa.com\r\n" + 
				"이데일리	금융/증시	이진우	voice@edaily.co.kr\r\n" + 
				"머니투데이	금융/증시	도병욱	tongjorim@moneytoday.co.kr\r\n" + 
				"머니투데이	금융/증시	박재범	swallow@moneytoday.co.kr\r\n" + 
				"한겨례	금융/증시	김경락	sp96@hani.co.kr\r\n" + 
				"경향신문	금융/증시	정유진	sogun77@kyunghyang.com\r\n" + 
				"서울경제	금융/증시	문승관	skmoon@sed.co.kr\r\n" + 
				"뉴시스	금융/증시	김민자	rululu20@newsis.com\r\n" + 
				"이데일리	금융/증시	안재만	rommel@edaily.co.kr\r\n" + 
				"한국경제	금융/증시	김현식	realist@hankyung.com\r\n" + 
				"이데일리	금융/증시	최한나	ray@edaily.co.kr\r\n" + 
				"한국일보	금융/증시	최진주	pariscom@hk.co.kr\r\n" + 
				"머니투데이	금융/증시	이새누리	newworld@moneytoday.co.kr\r\n" + 
				"파이낸셜	금융/증시	황민정	mchan@fnnews.com\r\n" + 
				"헤럴드	금융/증시	김형곤	kimhg@heraldm.com\r\n" + 
				"아시아경제	금융/증시	김지은	jekim@asiae.co.kr\r\n" + 
				"이데일리	금융/증시	이준기	jeke1@edaily.co.kr\r\n" + 
				"한국일보	금융/증시	김용식	jawohl@hk.co.kr\r\n" + 
				"동아일보	금융/증시	정재윤	jaeyuna@donga.com\r\n" + 
				"국민일보	금융/증시	황일송	ilsong@kmib.co.kr\r\n" + 
				"뉴시스	금융/증시	류영상	ifyouare@newsis.com\r\n" + 
				"문화일보	금융/증시	임대환	hwan91@munhwa.com\r\n" + 
				"세계일보	금융/증시	최현태	htchoi@segye.com\r\n" + 
				"머니투데이	금융/증시	권화순	hstree@moneytoday.co.kr\r\n" + 
				"한국경제	금융/증시	박세환	greg@hankyung.com\r\n" + 
				"문화일보	금융/증시	박수균	freewill@munhwa.com\r\n" + 
				"문화일보	금융/증시	박영출	even@munhwa.com\r\n" + 
				"머니투데이	금융/증시	김익태	epping@moneytoday.co.kr\r\n" + 
				"머니투데이	금융/증시	최환웅	chw1414@moneytoday.co.kr\r\n" + 
				"동아일보	금융/증시	차지완	cha@donga.com\r\n" + 
				"머니투데이	금융/증시	배성민	baesm@moneytoday.co.kr\r\n" + 
				"연합뉴스	기업/재계	김영만	ymkim@yna.co.kr\r\n" + 
				"머니투데이	기업/재계	오수현	so2218@moneytoday.co.kr\r\n" + 
				"연합뉴스	기업/재계	서미숙	sms@yna.co.kr\r\n" + 
				"연합뉴스	기업/재계	임미나	mina@yna.co.kr\r\n" + 
				"연합뉴스	기업/재계	권수현	inishmore@yna.co.kr\r\n" + 
				"머니투데이	기업/재계	최인웅	hp017@moneytoday.co.kr\r\n" + 
				"아시아경제	기업/재계	이현정	hjlee303@asiae.co.kr\r\n" + 
				"문화일보	기업/재계	이관범	frog72@munhwa.com\r\n" + 
				"머니투데이	기업/재계	장웅조	colorpen@moneytoday.co.kr\r\n" + 
				"노컷뉴스	노동	이재준	zzlee@cbs.co.kr\r\n" + 
				"아시아	노동	조용주	yjcho@asiae.co.kr\r\n" + 
				"조선일보	노동	이인열	yiyul@chosun.com\r\n" + 
				"동아일보	노동	이원주	takeoff@donga.com\r\n" + 
				"뉴시스	노동	권혁진	shinpd44@newsis.com\r\n" + 
				"조선일보	노동	최현묵	seanch@chosun.com\r\n" + 
				"프레시안	노동	김하영	richkhy@pressian.com\r\n" + 
				"연합뉴스	노동	안희	prayerahn@yna.co.kr\r\n" + 
				"조선일보	노동	정시행	polygon@chosun.com\r\n" + 
				"뉴시스	노동	고아라	peacera@newsis.com\r\n" + 
				"조선일보	노동	김경화	peace@chosun.com\r\n" + 
				"한국일보	노동	정상원	ornot@hk.co.kr\r\n" + 
				"동아일보	노동	정원수	needjung@donga.com\r\n" + 
				"연합뉴스	노동	형민우	minu21@yna.co.kr\r\n" + 
				"조선일보	노동	김민철	mckim@chosun.com\r\n" + 
				"경향신문	노동	김연세	kys@kyunghyang.com\r\n" + 
				"SBSTV	노동	김형주	kimmyworld@sbs.co.kr\r\n" + 
				"한국경제	노동	고경봉	kgb@hankyung.com\r\n" + 
				"파이낸셜	노동	정지우	jjw@fnnews.com\r\n" + 
				"경향신문	노동	정제혁	jhjung@kyunghyang.com\r\n" + 
				"연합뉴스	노동	정찬욱	jchu2000@yna.co.kr\r\n" + 
				"MBC뉴스	노동	김재영	jaykim@mbc.co.kr\r\n" + 
				"연합뉴스	노동	김재현	jahn@yna.co.kr\r\n" + 
				"조선일보	노동	김수혜	goodluck@chosun.com\r\n" + 
				"문화일보	노동	음성원	esw@munhwa.com\r\n" + 
				"서울신문	노동	유대근	dynamic@seoul.co.kr\r\n" + 
				"한겨례	노동	송호진	dmzsong@hani.co.kr\r\n" + 
				"아이뉴스24	노동	추미애	dedanhi@inews24.com\r\n" + 
				"국민일보	노동	손병호	bhson@kmib.co.kr\r\n" + 
				"뉴시스	노동	진현철	agacul@newsis.com\r\n" + 
				"한겨례	다이어트 정보	현시원	sonvadak25@hanmail.net\r\n" + 
				"한겨례	다이어트 정보	박두원	p7@mkmedia.co.kr\r\n" + 
				"한겨례	다이어트 정보	남은주	mifoco@hani.co.kr\r\n" + 
				"한겨례	다이어트 정보	박미향	mh@hani.co.kr\r\n" + 
				"한겨례	다이어트 정보	정혁준	june@hani.co.kr\r\n" + 
				"아시아	다이어트 정보	신범수	answer@asiae.co.kr\r\n" + 
				"한겨례	다이어트 정보	양선아	anmadang@hani.co.kr\r\n" + 
				"한국경제	다이어트정보	조수란	whtnfks@bntnews.co.kr\r\n" + 
				"국민일보	다이어트정보	민태원	twmin@kmib.co.kr\r\n" + 
				"OSEN	다이어트정보	생활경제팀	osenlife@osen.co.kr\r\n" + 
				"한국경제	다이어트정보	뉴스팀	newsinfo@hankyung.com\r\n" + 
				"한국경제	다이어트정보	오나래	naraeoh@bntnews.co.kr\r\n" + 
				"한국경제	다이어트정보	김민규	minkyu@bntnews.co.kr\r\n" + 
				"한국경제	다이어트정보	생활팀	life@bntnews.co.kr\r\n" + 
				"연합뉴스	다이어트정보	왕지웅	jwwang@yna.co.kr\r\n" + 
				"매일경제	다이어트정보	정은지	jeje@mkhealth.co.kr\r\n" + 
				"한국경제	다이어트정보	이현아	hyuna@bntnews.co.kr\r\n" + 
				"조선일보	다이어트정보	윤주헌	calling@chosun.com\r\n" + 
				"서울경제신문	도로/교통	윤종열	yjyun@sed.co.kr\r\n" + 
				"노컷뉴스	도로/교통	강현석	wicked@cbs.co.kr\r\n" + 
				"연합뉴스	도로/교통	김태종	taejong75@yna.co.kr\r\n" + 
				"YTN	도로/교통	임승환	shlim@ytn.co.kr\r\n" + 
				"파이낸셜	도로/교통	박인옥	pio@fnnews.com\r\n" + 
				"연합뉴스	도로/교통	이성한	ofcourse@yna.co.kr\r\n" + 
				"연합뉴스	도로/교통	박성민	min76@yna.co.kr\r\n" + 
				"MBC뉴스	도로/교통	노재필	jaepil@imbc.com\r\n" + 
				"경향신문	도로/교통	최인진	ijchoi@kyunghyang.com\r\n" + 
				"국민일보	도로/교통	김도영	doyoung@kmib.co.kr\r\n" + 
				"연합뉴스	도로/교통	백도인	doin100@yna.co.kr\r\n" + 
				"한국일보	도로/교통	강주형	cubie@hk.co.kr\r\n" + 
				"한국일보	도로/교통	김창훈	chkim@hk.co.kr\r\n" + 
				"한국경제	도로/교통	김일규	black0419@hankyung.com\r\n" + 
				"연합뉴스	도로/교통	이복한	bhlee@yna.co.kr\r\n" + 
				"뉴시스	도로/교통	황의영	apex@newsis.com\r\n" + 
				"노컷뉴스	도로/교통	조은정	aori@cbs.co.kr\r\n" + 
				"연합뉴스	도로/교통	안용수	aayyss@yna.co.kr\r\n" + 
				"굿데이 스포츠	디지털뉴스팀	김계준	kkj@gooddaysports.co.kr\r\n" + 
				"SBSTV	문화/예술 일반	하대석	bigstone@sbs.co.kr\r\n" + 
				"헤럴드	문화/예술일반	이영란	yrlee2heraldm.com\r\n" + 
				"경향신문	문화/예술일반	한윤정	yjhan@kyunghyang.com\r\n" + 
				"헤럴드	문화/예술일반	김소민	som@heraldm.com&nbsp;\r\n" + 
				"동아일보	문화/예술일반	신성미	savoring@donga.com\r\n" + 
				"연합뉴스	문화/예술일반	박종국	pjk@yna.co.kr\r\n" + 
				"시사인	문화/예술일반	오윤현	noma@sisain.co.kr\r\n" + 
				"세계일보	문화/예술일반	강민영	mykang@sportsworldi.com\r\n" + 
				"파이낸셜	문화/예술일반	박문순	mskang@fnnews.com\r\n" + 
				"서울신문	문화/예술일반	이경원	leekw@seoul.co.kr\r\n" + 
				"연합뉴스	문화/예술일반	고한성	koh@yna.co.kr\r\n" + 
				"경향신문	문화/예술일반	김지환	kjh1010@kyunghyang.com\r\n" + 
				"연합뉴스	문화/예술일반	김윤구	kimyg@yna.co.kr\r\n" + 
				"한겨례	문화/예술일반	송채경화	khsong@hani.co.kr\r\n" + 
				"한국일보	문화/예술일반	이인선	kelly@hk.co.kr\r\n" + 
				"세계일보	문화/예술일반	조정진	jjj@segye.com\r\n" + 
				"서울신문	문화/예술일반	홍지민	icarus@seoul.co.kr\r\n" + 
				"동아일보	문화/예술일반	이새샘	iamsam@donga.com\r\n" + 
				"뉴시스	문화/예술일반	박희송	heesking@newsis.com\r\n" + 
				"동아일보	문화/예술일반	유윤종	gustav@donga.com\r\n" + 
				"동아일보	문화/예술일반	금동근	gold@donga.com\r\n" + 
				"연합뉴스	문화/예술일반	권영전	comma@yna.co.kr\r\n" + 
				"조선일보	문화/예술일반	박돈규	coeur@chosun.com\r\n" + 
				"뉴시스	문화/예술일반	강경지	bright@newsis.com\r\n" + 
				"한겨례	문화/예술일반	구본준	bonbon@hani.co.kr\r\n" + 
				"서울신문	문화/예술일반	손원천	angler@seoul.co.kr\r\n" + 
				"한겨례	문화인물 스케치	정상연	chung@hani.co.kr\r\n" + 
				"연합뉴스	문화인물스케치	황희경	zitrone@yna.co.kr\r\n" + 
				"서울신문	문화인물스케치	박록삼	youngtan@seoul.co.kr\r\n" + 
				"중앙일보	문화인물스케치	김호정	wisehj@joongang.co.kr\r\n" + 
				"한국일보	문화인물스케치	황수현	sooh@hk.co.kr\r\n" + 
				"경향신문	문화인물스케치	문학수	sachimo@kyunghyang.com\r\n" + 
				"조선일보	문화인물스케치	이진환	reallusiper@hanmail.net\r\n" + 
				"한국일보	문화인물스케치	이재원	jjstar@sportshankook.co.kr\r\n" + 
				"문화일보	문화인물스케치	김승현	hyeon@munhwa.com\r\n" + 
				"조선일보	문화인물스케치	최순호	choish@chosun.com\r\n" + 
				"경향신문	부동산	이주영	young78@kyunghyang.com\r\n" + 
				"조선일보	부동산	유하룡	you11@chosun.com\r\n" + 
				"파이낸셜	부동산	이경호	victoria@fnnews.com\r\n" + 
				"문화일보	부동산	김순환	soon@munhwa.com\r\n" + 
				"서울신문	부동산	윤설영	snow0@seoul.co.kr\r\n" + 
				"머니투데이	부동산	장시복	sibokism@moneytoday.co.kr\r\n" + 
				"머니투데이	부동산	김수홍	shong@mtn.co.kr\r\n" + 
				"한겨례	부동산	황춘화	sflower@hani.co.kr\r\n" + 
				"머니투데이	부동산	서동욱	sdw70@moneytoday.co.kr\r\n" + 
				"연합뉴스	부동산	이지헌	pan@yna.co.kr\r\n" + 
				"프레시안	부동산	전홍기혜	onscar@pressian.com\r\n" + 
				"헤럴드	부동산	강주남	namkang@heraldm.com\r\n" + 
				"파이낸셜	부동산	김명지	mjkim@fnnews.com\r\n" + 
				"서울경제신문	부동산	김경미	kmkim@sed.co.kr\r\n" + 
				"노컷뉴스	부동산	윤지나	jina13@cbs.co.kr\r\n" + 
				"국민일보	부동산	박재찬	jeep@kmib.co.kr\r\n" + 
				"연합뉴스	부산	조정호	ccho@yna.co.kr\r\n" + 
				"연합뉴스	빛나는 문화유산	현윤경	ykhyun14@yna.co.kr\r\n" + 
				"문화일보	빛나는 문화유산	최영창	ycchoi@munhwa.com\r\n" + 
				"연합뉴스	빛나는 문화유산	김태식	taeshik@yna.co.kr\r\n" + 
				"조선일보	빛나는 문화유산	조호진	superstory@chosun.com\r\n" + 
				"한국경제	빛나는 문화유산	서화동	fireboy@hankyung.com\r\n" + 
				"YTN	빛나는문화유산	오점곤	ohjumgon@ytn.co.kr\r\n" + 
				"한겨례	빛나는문화유산	노형성	nuge@hani.co.kr\r\n" + 
				"뉴시스	빛나는문화유산	이종익	007news@newsis.com\r\n" + 
				"동아일보	사회	김윤종	zozo@donga.com\r\n" + 
				"서울신문	사회	장형우	zangzak@seoul.co.kr\r\n" + 
				"동아일보	사회	장윤정	yunjung@donga.com\r\n" + 
				"문화일보	사회	이상원	ysw@munhwa.com\r\n" + 
				"뉴시스	사회	유명식	yeujin@newsis.com\r\n" + 
				"연합뉴스	사회	우영식	wyshik@yna.co.kr\r\n" + 
				"SBSTV	사회	우상욱	woosu@sbs.co.kr\r\n" + 
				"연합뉴스	사회	신재우	withwit@yna.co.kr\r\n" + 
				"서울신문	사회	유지혜	wisepen@seoul.co.kr\r\n" + 
				"연합뉴스	사회	김선호	wink@yna.co.kr\r\n" + 
				"머니투데이	사회	심재현	urme@moneytoday.co.kr\r\n" + 
				"동아일보	사회	하태원	triplets@donga.com\r\n" + 
				"노컷뉴스	사회	박슬기	thu22@cbs.co.kr\r\n" + 
				"연합뉴스	사회	김귀근	threek@yna.co.kr\r\n" + 
				"동아일보	사회	박선희	teller@donga.com\r\n" + 
				"연합뉴스	사회	김태균	tae@yna.co.kr\r\n" + 
				"문화일보	사회	곽시열	sykwak@munhwa.com\r\n" + 
				"한국일보	사회	고성호	sungho@hk.co.kr\r\n" + 
				"세계일보	사회	장원주	strum@segye.com\r\n" + 
				"동아일보	사회	이성호	starsky@donga.com\r\n" + 
				"경향신문	사회	선근형	ssun@kyunghyang.com\r\n" + 
				"서울경제	사회	송주희	ssong@sed.co.kr\r\n" + 
				"조선일보	사회	김성현	shkim@chosun.com\r\n" + 
				"뉴시스	사회	신형근	shk@newsis.com\r\n" + 
				"한국일보	사회	김혜영	shine@hk.co.kr\r\n" + 
				"국민일보	사회	신은정	sej@kmib.co.kr\r\n" + 
				"연합뉴스	사회	이정훈	seaman@yna.co.kr\r\n" + 
				"뉴시스	사회	정필재	rush@newsis.com\r\n" + 
				"조선일보	사회	이인묵	redsox@chosun.com\r\n" + 
				"뉴시스	사회	이재훈	realpaper7@newsis.com\r\n" + 
				"MBC뉴스	사회	송양환	rainbow@mbc.co.kr\r\n" + 
				"연합뉴스	사회	윤고은	pretty@yna.co.kr\r\n" + 
				"프레시안	사회	선명수	praxis@pressian.com\r\n" + 
				"조선일보	사회	조홍복	powerbok@chosun.com\r\n" + 
				"연합뉴스	사회	김재홍	pitbull@yna.co.kr\r\n" + 
				"뉴시스	사회	김윤호	pen@newsis.com\r\n" + 
				"문화일보	사회	박팔령	park80@munhwa.com\r\n" + 
				"연합뉴스	사회	오수희	osh9981@yna.co.kr\r\n" + 
				"문화일보	사회	오명근	omk@munhwa.com\r\n" + 
				"연합뉴스	사회	고현실	okko@yna.co.kr\r\n" + 
				"문화일보	사회	강버들	oiseau@munhwa.com\r\n" + 
				"조선일보	사회	강훈	nukus@chosun.com\r\n" + 
				"노컷뉴스	사회	박종률	nowhere@cbs.co.kr\r\n" + 
				"경향신문	사회	배명재	ninaplus@kyunghyang.com\r\n" + 
				"SBSTV	사회	김아영	nina@sbs.co.kr\r\n" + 
				"노컷뉴스	사회	고영호	newsman@cbs.co.kr\r\n" + 
				"정경뉴스	사회	안병선	naya9876@nate.com\r\n" + 
				"연합뉴스	사회	백나리	nari@yna.co.kr\r\n" + 
				"뉴시스	사회	김미영	mykim@newsis.com\r\n" + 
				"연합뉴스	사회	문성규	moonsk@yna.co.kr\r\n" + 
				"노컷뉴스	사회	정민기	mkjung@cbs.co.kr\r\n" + 
				"동아일보	사회	신민기	minki@donga.com\r\n" + 
				"국민일보	사회	신혜민	min827@gmail.com\r\n" + 
				"한국일보	사회	한준규	manbok@hk.co.kr\r\n" + 
				"SBSTV	사회	이한석	lucaside@sbs.co.kr\r\n" + 
				"조선일보	사회	조백건	loogun@chosun.com\r\n" + 
				"뉴시스	사회	이국현	lgh@newsis.com\r\n" + 
				"SBSTV	사회	김경희	kyung@sbs.co.kr\r\n" + 
				"헤럴드경제	사회	이권형	kwonhl@heraldm.com\r\n" + 
				"연합뉴스	사회	김승옥	ksw08@yna.co.kr\r\n" + 
				"조선일보	사회	정한국	korejung@chosun.com\r\n" + 
				"연합뉴스	사회	김남권	kong79@yna.co.kr\r\n" + 
				"연합뉴스	사회	김남권	kong79@yna.co\r\n" + 
				"문화일보	사회	박천학	kobbla@munhwa.com\r\n" + 
				"뉴시스	사회	송윤세	knaty@newsis.com\r\n" + 
				"아시아	사회	구경민	kkm@asiae.co.kr\r\n" + 
				"연합뉴스	사회	김종환	kkk@yna.co.kr\r\n" + 
				"연합뉴스	사회	김정은	kje@yna.co.kr\r\n" + 
				"YTN	사회	김현아	kimhaha@ytn.co.kr\r\n" + 
				"문화일보	사회	고광일	kik@munhwa.com\r\n" + 
				"파이낸셜	사회	최경환	khchoi@fnnews.com\r\n" + 
				"헤럴드경제	사회	백웅기	kgungi@heraldm.com\r\n" + 
				"연합뉴스	사회	강의영	keykey@yna.co.kr\r\n" + 
				"국민일보	사회	강창욱	kcw@kmib.co.kr\r\n" + 
				"동아일보	사회	황금천	kchwang@donga.com\r\n" + 
				"서울신문	사회	김병철	kbchul@seoul.co.kr\r\n" + 
				"조선일보	사회	유석재	karma@chosun.com\r\n" + 
				"머니투데이	사회	백진엽	jyback@moneytoday.co.kr\r\n" + 
				"뉴시스	사회	신정원	jwshin@newsis.com\r\n" + 
				"뉴시스	사회	박진완	jwpark@newsis.com\r\n" + 
				"노컷뉴스	사회	박중석	jspark@cbs.co.kr\r\n" + 
				"연합뉴스	사회	이준삼	jslee@yna.co.kr\r\n" + 
				"SBSTV	사회	김지성	jisung@sbs.co.kr\r\n" + 
				"연합뉴스	사회	조준형	jhcho@yna.co.kr\r\n" + 
				"연합뉴스	사회	이한승	jesus7864@yna.co.kr\r\n" + 
				"연합뉴스	사회	박기성	jeansap@yna.co.kr\r\n" + 
				"YTN	사회	장아영	jay24@ytn.co.kr\r\n" + 
				"뉴시스	사회	이재우	ironn108@newsis.com\r\n" + 
				"연합뉴스	사회	최정인	in@yna.co.kr\r\n" + 
				"한겨례	사회	임인택	imit@hani.co.kr\r\n" + 
				"헤럴드경제	사회	임희윤	imi@heraldm.com\r\n" + 
				"연합뉴스	사회	황철환	hwangch@yna.co.kr\r\n" + 
				"뉴시스	사회	함상환	hsh3355@newsis.com\r\n" + 
				"세계일보	사회	김재홍	hong@segye.com\r\n" + 
				"연합뉴스	사회	이상헌	honeybee@yna.co.kr\r\n" + 
				"아시아	사회	김효진	hjn2529@asiae.co.kr\r\n" + 
				"YTN	사회	김혜은	henism@ytn.co.kr\r\n" + 
				"조선일보	사회	김동현	hellopik@chosun.com\r\n" + 
				"SBSTV	사회	권란	harasho@sbs.co.kr\r\n" + 
				"연합뉴스	사회	이상현	hapyry@yna.co.kr\r\n" + 
				"노컷뉴스	사회	장규석	hahoi@cbs.co.kr\r\n" + 
				"뉴시스	사회	조현아	hacho@newsis.com\r\n" + 
				"MBC뉴스	사회	고은상	gotostorm@naver.com\r\n" + 
				"문화일보	사회	정우천	goodpen@munhwa.com\r\n" + 
				"문화일보	사회	박세영	go@munhwa.com\r\n" + 
				"연합뉴스	사회	이우성	gaonnuri@yna.co.kr\r\n" + 
				"연합뉴스	사회	최우정	friendship@yna.co.kr\r\n" + 
				"세계일보	사회	이귀전	frei5922@segye.com\r\n" + 
				"동아일보	사회	김희균	foryou@donga.com\r\n" + 
				"노컷뉴스	사회	정재훈	floyd@co.kr\r\n" + 
				"뉴시스	사회	박성규	exculpate2@newsis.com\r\n" + 
				"SBSTV	사회	김정인	europa@sbs.co.kr\r\n" + 
				"조선일보	사회	채성신	dudmie@chosun.com\r\n" + 
				"한겨례	사회	유선희	duck@hani.co.kr\r\n" + 
				"조선일보	사회	김성민	dori2381@chosun.com\r\n" + 
				"동아일보	사회	최우열	dnsp@donga.com\r\n" + 
				"연합뉴스	사회	김동규	dkkim@yna.co.kr\r\n" + 
				"연합뉴스	사회	이동직	djlee@cbs.co.kr\r\n" + 
				"헤럴드경제	사회	김대우	dewkim@heraldm.com\r\n" + 
				"동아일보	사회	전성철	dawn@donga.com\r\n" + 
				"문화일보	사회	정충신	csjung@munhwa.com\r\n" + 
				"SBSTV	사회	임찬종	cjyim@sbs.co.kr\r\n" + 
				"연합뉴스	사회	전성훈	cielo78@yna.co.kr\r\n" + 
				"연합뉴스	사회	최병길	choi21@yna.co.kr\r\n" + 
				"동아일보	사회	최창봉	ceric@donga.com\r\n" + 
				"서울신문	사회	안석	ccto@seoul.co.kr\r\n" + 
				"연합뉴스	사회	장덕종	cbebop@yna.co.kr\r\n" + 
				"서울신문	사회	최치봉	cbchoi@seoul.co.kr\r\n" + 
				"노컷뉴스	사회	오지예	calling@cbs.co.kr\r\n" + 
				"조선일보	사회	이철원	burbuck@chosun.com\r\n" + 
				"문화일보	사회	박영수	buntle@munhwa.com\r\n" + 
				"머니투데이	사회	류철호	bumblebee75@moneytoday.co.kr\r\n" + 
				"동아일보	사회	남윤서	baron@donga.com\r\n" + 
				"경향신문	사회	김지환	baldkim@kyunghyang.com\r\n" + 
				"SBSTV	사회	안서현	ash@sbs.co.kr\r\n" + 
				"노컷뉴스	사회	최인수	apple@cbs.co.kr\r\n" + 
				"한국일보	사회	이영창	anti092@hk.co.kr\r\n" + 
				"문화일보	사회	김기현	ant735@munhwa.com\r\n" + 
				"연합뉴스	사회	안홍석	ahs@yna.co.kr\r\n" + 
				"연합뉴스	사회	이웅	abullapia@yna.co.kr\r\n" + 
				"연합뉴스	생활경제	이윤영	yy@yna.co.kr\r\n" + 
				"한국일보	생활경제	이영태	ytlee@hk.co.kr\r\n" + 
				"한국경제	생활경제	송태형	toughlb@hankyung.com\r\n" + 
				"이데일리	생활경제	안준형	there@edaily.co.kr\r\n" + 
				"weekly경향	생활경제	서상준	ssjun@kyunghyang.com\r\n" + 
				"이데일리	생활경제	이성재	shower@edaily.co.kr\r\n" + 
				"조선일보	생활경제	김승범	sbkim@chosun.com\r\n" + 
				"SBSTV	생활경제	박민하	mhpark@sbs.co.kr\r\n" + 
				"동아일보	생활경제	조이영	lycho@donga.com\r\n" + 
				"한겨례	생활경제	이정훈	ljh9242@hani.co.kr\r\n" + 
				"서울경제신문	생활경제	김태성	kojjang@sed.co.kr\r\n" + 
				"서울경제신문	생활경제	이재용	jylee@sed.co.kr\r\n" + 
				"연합뉴스	생활경제	이정내	jnlee@yna.co.kr\r\n" + 
				"한국경제	생활경제	최진석	iskra@hankyung.com\r\n" + 
				"조선일보	생활경제	탁상훈	if@chosun.com\r\n" + 
				"광남일보	생활경제	기수희	hiyaa1020@gwangnam.co.kr\r\n" + 
				"머니투데이	생활경제	김희정	dontsigh@moneytoday.co.kr\r\n" + 
				"노컷뉴스	생활경제	육덕수	cosmos@cbs.co.kr\r\n" + 
				"프라임경제	생활경제	전지현	cjh@newsprime.co.kr\r\n" + 
				"연합뉴스	생활경제	추승호	chu@yna.co.kr\r\n" + 
				"한국일보	생활경제	손재언	chinason@hk.co.kr\r\n" + 
				"아이뉴스24	생활경제	박연미	change@inews24.com\r\n" + 
				"머니투데이	생활경제	박상완	basawa@mtn.co.kr\r\n" + 
				"머니투데이	생활경제	유은정	apple@moneytoday.co.kr\r\n" + 
				"SBSTV	생활경제	권애리	ailee17@sbs.co.kr\r\n" + 
				"서울경제신문	생활경제	김지영	abc@sed.co.kr\r\n" + 
				"주간한국	생활정보/트렌드	송준호	tristan@hk.co.kr\r\n" + 
				"코메디	생활정보/트렌드	박양명	toann@kormedi.com\r\n" + 
				"한국일보	생활정보/트렌드	강성명	smkang@hk.co.kr\r\n" + 
				"동아일보	생활정보/트렌드	이지은	smiley@donga.com\r\n" + 
				"서울경제신문	생활정보/트렌드	송대웅	sdw@sed.co.kr\r\n" + 
				"코메디	생활정보/트렌드	김나은	razana@kormedi.com\r\n" + 
				"파이낸셜뉴스	생활정보/트렌드	정명진	pompom@fnnews.com\r\n" + 
				"메디포뉴스	생활정보/트렌드	이철영	paris177@medifonews.com\r\n" + 
				"뉴시스	생활정보/트렌드	오종택	ohjt@newsis.com\r\n" + 
				"헤럴드	생활정보/트렌드	김지연	madpen@heraldm.com\r\n" + 
				"매일경제	생활정보/트렌드	이상미	lsmclick@mkhealth.co.kr\r\n" + 
				"뉴시스	생활정보/트렌드	이현주	lovelypsyche@newsis.com\r\n" + 
				"뉴시스	생활정보/트렌드	이지현	ljh@newsishealth.com\r\n" + 
				"동아일보	생활정보/트렌드	박근태	kunta@donga.com\r\n" + 
				"강원일보	생활정보/트렌드	김형기	khk@kwnews.co.kr\r\n" + 
				"경향신문	생활정보/트렌드	이준규	jklee@kyunghyang.com\r\n" + 
				"연합뉴스	생활정보/트렌드	장재은	jangje@yna.co.kr\r\n" + 
				"코메디	생활정보/트렌드	김혜민	haemin@kormedi.com\r\n" + 
				"문화일보	생활정보/트렌드	이용권	freeuse@munhwa.com\r\n" + 
				"조선일보	생활정보/트렌드	김나라	flaras@chosun.com\r\n" + 
				"문화일보	생활정보/트렌드	심은정	fearless@munhwa.com\r\n" + 
				"국민일보	생활정보/트렌드	박주호	epi0212@kmib.co.kr\r\n" + 
				"조선일보	생활정보/트렌드	송혜진	enavel@chosun.com\r\n" + 
				"국민일보	생활정보/트렌드	조규봉	ckb@kmib.co.kr\r\n" + 
				"연합뉴스	생활정보/트렌드	김지연	cherora@yna.co.kr\r\n" + 
				"동아일보	생활정보/트렌드	이지연	chance@donga.com\r\n" + 
				"동아일보	생활정보/트렌드	김현진	bright@donga.com\r\n" + 
				"연합뉴스	생활정보/트렌드	김길헌	bio@yna.co.kr\r\n" + 
				"동아일보	생활정보/트렌드	이혜민	behappy@donga.com\r\n" + 
				"연합뉴스	생활정보/트렌드	윤종석	banana@yna.co.kr\r\n" + 
				"한국일보	생활정보/트렌드	이태무	abcdefg@hk.co.kr\r\n" + 
				"문화일보	식품/의료	김영번	zerokim@munhwa.com\r\n" + 
				"경향신문	식품/의료	정유미	youme@kyunghyang.com\r\n" + 
				"SBSTV	식품/의료	조성원	wonnie@sbs.co.kr\r\n" + 
				"연합뉴스	식품/의료	하채림	tree@yna.co.kr\r\n" + 
				"연합뉴스	식품/의료	김세영	thedopest@yna.co.kr\r\n" + 
				"뉴시스	식품/의료	서유정	teenie@newsis.com\r\n" + 
				"아시아	식품/의료	김성곤	skzero@asiae.co.kr\r\n" + 
				"노컷뉴스	식품/의료	최승진	sjchoi@cbs.co.kr\r\n" + 
				"연합뉴스	식품/의료	심인성	sims@yna.co.kr\r\n" + 
				"뉴시스	식품/의료	강수윤	shoon@newsis.com\r\n" + 
				"세계일보	식품/의료	신진호	ship67@segye.com\r\n" + 
				"한겨례	식품/의료	안선희	shan@hani.co.kr\r\n" + 
				"서울신문	식품/의료	정서린	rin@seoul.co.kr\r\n" + 
				"시사인	식품/의료	이종태	peeker@sisain.co.kr\r\n" + 
				"세계일보	식품/의료	이상혁	next@segye.com\r\n" + 
				"헤럴드	식품/의료	임희윤	mi@heraldm.com\r\n" + 
				"동아일보	식품/의료	고기정	koh@donga.com\r\n" + 
				"서울신문	식품/의료	김지훈	kjh@seoul.co.kr\r\n" + 
				"노컷뉴스	식품/의료	강인영	kangin@cbs.co.kr\r\n" + 
				"연합뉴스	식품/의료	강영두	k0279@yna.co.kr\r\n" + 
				"문화일보	식품/의료	김상협	jupiter@munhwa.com\r\n" + 
				"뉴시스	식품/의료	박준형	jun@newsis.com\r\n" + 
				"연합뉴스	식품/의료	홍정표	jphong@yna.co.kr\r\n" + 
				"뉴시스	식품/의료	강재남	hynikos@newsis.com\r\n" + 
				"뉴시스	식품/의료	권혁진	hjkwon@newsis.com\r\n" + 
				"파이낸셜	식품/의료	김학재	hjkim01@fnnews.com\r\n" + 
				"한겨례	식품/의료	김양중	himtrain@hani.co.kr\r\n" + 
				"머니투데이	식품/의료	여한구	han19@moneytoday.co.kr\r\n" + 
				"SBSTV	식품/의료	조성현	eyebrow@sbs.co.kr\r\n" + 
				"뉴시스	식품/의료	우은식	eswoo@newsis.com\r\n" + 
				"헤럴드	식품/의료	조동석	dscho@heraldm.com\r\n" + 
				"머니투데이	식품/의료	보도자료기사	bodo@moneytoday.co.kr\r\n" + 
				"머니투데이	신차 출시/시승기	김보형	kph21c@moneytoday.co.kr\r\n" + 
				"머니투데이	신차 출시/시승기	김훈남	hoo13@moneytoday.co.kr\r\n" + 
				"마이데일리	신차 출시/시승기	송일섭	andlyu@mydaily.co.kr\r\n" + 
				"연합뉴스	신차출시/시승기	진성철	zjin@yna.co.kr\r\n" + 
				"경향신문	신차출시/시승기	김한용	whynot@khan.co.kr\r\n" + 
				"조선일보	신차출시/시승기	김윤현	unyon@chosun.com\r\n" + 
				"아시아	신차출시/시승기	조태진	tjjo@asiae.co.kr\r\n" + 
				"문화일보	신차출시/시승기	김남석	namdol@munhwa.com\r\n" + 
				"헤럴드	신차출시/시승기	이충희	hamlet@heraldm.com\r\n" + 
				"연합뉴스	신차출시/시승기	권혁창	faith@yna.co.kr\r\n" + 
				"아시아	신차출시/시승기	손현진	everwhite@asiae.co.kr\r\n" + 
				"아시아	신차출시/시승기	윤동주	doso7@asiae.co.kr\r\n" + 
				"한겨례	신차출시/시승기	최원형	circle@hani.co.kr\r\n" + 
				"서울신문	신차출시/시승기	정치연	chiyeon@seoul.co.kr\r\n" + 
				"한국일보	신차출시/시승기	박상준	buttonpr@hk.co.kr\r\n" + 
				"이데일리	신차출시/시승기	김보리	boris@edaily.co.kr\r\n" + 
				"한국일보	신차출시/시승기	송태희	bigsmile@hk.co.kr\r\n" + 
				"연합뉴스	언론/미디어	임주영	zoo@yna.co.kr\r\n" + 
				"파이낸셜	언론/미디어	조윤주	yjjoe@fnnews.com\r\n" + 
				"뉴시스	언론/미디어	박세준	yaiyaiya@newsis.com\r\n" + 
				"한국일보	언론/미디어	허정현	xscope@hk.co.kr\r\n" + 
				"한국일보	언론/미디어	김정우	wookim@hk.co.kr\r\n" + 
				"조선일보	언론/미디어	최원규	wkchoi@chosun.com\r\n" + 
				"조선일보	언론/미디어	류정	well@chosun.com\r\n" + 
				"시사인	언론/미디어	김수지	webmaster@sisain.co.kr\r\n" + 
				"SBSTV	언론/미디어	손승욱	ssw@sbs.co.kr\r\n" + 
				"서울신문	언론/미디어	박승기	skpark@seoul.co.kr\r\n" + 
				"연합뉴스	언론/미디어	이세원	sewonlee@yna.co.kr\r\n" + 
				"머니투데이	언론/미디어	김성현	sean@moneytoday.co.kr\r\n" + 
				"시사인	언론/미디어	고재열	scoop@sisain.co.kr\r\n" + 
				"조선일보	언론/미디어	김정훈	runto@chosun.com\r\n" + 
				"연합뉴스	언론/미디어	나확진	rao@yna.co.kr\r\n" + 
				"뉴시스	언론/미디어	박주연	pjy@newsis.com\r\n" + 
				"뉴시스	언론/미디어	정재호	next0808@newsis.com\r\n" + 
				"한겨례	언론/미디어	김남일	namfic@hani.co.kr\r\n" + 
				"조선일보	언론/미디어	이명진	mjlee@chosun.com\r\n" + 
				"시사인	언론/미디어	정희상	minju518@sisain.co.kr\r\n" + 
				"조선일보	언론/미디어	김홍진	mailer@chosun.com\r\n" + 
				"조선일보	언론/미디어	염강수	ksyoum@chosun.com\r\n" + 
				"머니투데이	언론/미디어	김선주	ksj16@moneytoday.co.kr\r\n" + 
				"노컷뉴스	언론/미디어	오대일	kkorazi@cbs.co.kr\r\n" + 
				"뉴시스	언론/미디어	김종민	kim9416@newsis.com\r\n" + 
				"노컷뉴스	언론/미디어	한재호	kali@cbs.co.kr\r\n" + 
				"연합뉴스	언론/미디어	최재구	jjaeck9@yna.co.kr\r\n" + 
				"뉴시스	언론/미디어	서재훈	jhseo@newsis.com\r\n" + 
				"동아일보	언론/미디어	이태훈	jefflee@donga.com\r\n" + 
				"뉴시스	언론/미디어	윤근영	iamygy@newsis.com\r\n" + 
				"이데일리	언론/미디어	양효석	hsyang@edaily.co.kr\r\n" + 
				"SBSTV	언론/미디어	환승환	hsh15@sbs.co.kr\r\n" + 
				"경향신문	언론/미디어	이호준	hjlee@kyunghyang.com\r\n" + 
				"서울신문	언론/미디어	임주형	hermes@seoul.co.kr\r\n" + 
				"국민일보	언론/미디어	양진영	hansin@kmib.co.kr\r\n" + 
				"한겨례	언론/미디어	권귀순	gskwon@hani.co.kr\r\n" + 
				"한겨례	언론/미디어	노현웅	goloke@hani.co.kr\r\n" + 
				"한겨례	언론/미디어	송경화	freehwa@hani.co.kr\r\n" + 
				"한겨례	언론/미디어	박현철	fkcool@hani.co.kr\r\n" + 
				"연합뉴스	언론/미디어	강건택	firstcircle@yna.co.kr\r\n" + 
				"한겨례	언론/미디어	정유경	edge@hani.co.kr\r\n" + 
				"노컷뉴스	언론/미디어	조기호	cjkh@cbs.co.kr\r\n" + 
				"노컷뉴스	언론/미디어	조근호	chokeunho21@cbs.co.kr\r\n" + 
				"서울신문	언론/미디어	조태성	cho1904@seoul.co.kr\r\n" + 
				"파이낸셜	언론/미디어	최갑천	cgapc@fnnews.com\r\n" + 
				"프레시안	언론/미디어	채은하	bluesky@pressian.com\r\n" + 
				"조선일보	언론/미디어	손진석	aura@chosun.com\r\n" + 
				"노컷뉴스	언론/미디어	안성용	ahn89@cbs.co.kr\r\n" + 
				"연합뉴스	얼리어답터	서명곤	seephoto@yna.co.kr\r\n" + 
				"지디넷코리아	얼리어답터	류준영	see@zdnet.co.kr\r\n" + 
				"전자신문	얼리어답터	김상하	kori2saljp@gmail.com\r\n" + 
				"지디넷코리아	얼리어답터	남혜연	hyun@zdnet.co.kr\r\n" + 
				"전자신문	얼리어답터	김달훈	goodnews@ebuzz.co.kr\r\n" + 
				"블로터닷넷	얼리어답터	주민영	ezoomin@bloter.net\r\n" + 
				"전자신문	얼리어답터	배일한	bailh@etnews.co.kr\r\n" + 
				"조선일보	여행/레저	박영철	ycpark@chosun.com\r\n" + 
				"연합뉴스	여행/레저	이병욱	wooklee@hankooki.com\r\n" + 
				"조선일보	여행/레저	김승완	wanfoto@chosun.com\r\n" + 
				"동아일보	여행/레저	조성하	summer@donga.com\r\n" + 
				"서울신문	여행/레저	이철연	sky@seoul.co.kr\r\n" + 
				"조선일보	여행/레저	김우성	raharu@chosun.com\r\n" + 
				"문화일보	여행/레저	박경일	parking@munhwa.com\r\n" + 
				"국민일보	여행/레저	박강섭	kspark@kmib.co.kr\r\n" + 
				"동아일보	여행/레저	김기용	kky@donga.com\r\n" + 
				"서울경제	여행/레저	정민정	jminj@sed.co.kr\r\n" + 
				"노컷뉴스	여행/레저	박형주	jedirush@cbs.co.kr\r\n" + 
				"조선일보	여행/레저	어수웅	jan10@chosun.com\r\n" + 
				"조이뉴스	여행/레저	정은미	indiun@inews24.com\r\n" + 
				"조선일보	여행/레저	강신혜	dullook85@gmail.com\r\n" + 
				"시사인	여행/레저	이오성	dodash@sisain.co.kr\r\n" + 
				"조선일보	여행/레저	유창호	canyou@chosun.com\r\n" + 
				"연합뉴스	여행/레저	배연호	byh@yna.co.kr\r\n" + 
				"헤럴드	여행/레저	김영화	bettykim@heraldm.com\r\n" + 
				"문화일보	음식/맛집	신세미	ssemi@munhwa.com\r\n" + 
				"한국일보	음식/맛집	황수연	sooh@hk.co.kr\r\n" + 
				"조선일보	음식/맛집	황수연	p0y0u@korea.ac.kr\r\n" + 
				"서울신문	음식/맛집	이민영	min@seoul.co.kr\r\n" + 
				"머니투데이	음식/맛집	전혜영	mfuture@moneytoday.co.kr\r\n" + 
				"동아일보	음식/맛집	김화성	mars@donga.com\r\n" + 
				"연합뉴스	음식/맛집	김도윤	kyoon@yna.co.kr\r\n" + 
				"조선일보	음식/맛집	김진	holyjjin@hanmail.net\r\n" + 
				"한국일보	음식/맛집	임재범	happyyjb@hk.co.kr\r\n" + 
				"조선일보	음식/맛집	김성윤	gourmet@chosun.com\r\n" + 
				"중앙일보	음식/맛집	이상은	coolj8@joongang.co.kr\r\n" + 
				"부산일보	음식/맛집	김종열	bell10@busan.com\r\n" + 
				"한겨례	음식/맛집	안수찬	ahn@hani.co.kr\r\n" + 
				"시사인	인권/복지	임지영	toto@sisain.co.kr\r\n" + 
				"경향신문	인권/복지	이상호	shlee@kyunghyang.com\r\n" + 
				"한겨례	인권/복지	김민경	salmat@hani.co.kr\r\n" + 
				"프레시안	인권/복지	허환주	kakiru@pressian.com\r\n" + 
				"시사인	인권/복지	장일호	ilhostyle@sisain.co.kr\r\n" + 
				"문화일보	인권/복지	채현식	hschae@munhwa.com\r\n" + 
				"K모바일	인터넷	홍민기	news@kmobile.co.kr\r\n" + 
				"MBC뉴스	인터넷/컨텐츠	조현용	star@mbc.co.kr\r\n" + 
				"국민일보	인터넷/컨텐츠	김경택	ptyx@kmib.co.kr\r\n" + 
				"파이낸셜	인터넷/컨텐츠	권해주	postman@fnnews.com\r\n" + 
				"이데일리	인터넷/컨텐츠	임일곤	igon@edaily.co.kr\r\n" + 
				"머니투데이	인터넷/컨텐츠	정현수	gustn99@moneytoday.co.kr\r\n" + 
				"헤럴드	인터넷/컨텐츠	김상수	dlcw@heraldm.com\r\n" + 
				"동아일보	재테크	문병기	weappon@donga.com\r\n" + 
				"조선일보	재테크	김재곤	truman@chosun.com\r\n" + 
				"머니투데이	재테크	김태은	taien@moneytoday.co.kr\r\n" + 
				"동아일보	재테크	김재영	redfoot@donga.com\r\n" + 
				"조선일보	재테크	최규민	qmin@chosun.com\r\n" + 
				"조선일보	재테크	정철환	plomat@chosun.com\r\n" + 
				"세계일보	재테크	나기천	na@segye.com\r\n" + 
				"한국일보	재테크	임현주	korearu@hk.co.kr\r\n" + 
				"이데일리	재테크	권소현	juddie@edaily.co.kr\r\n" + 
				"동아일보	재테크	정혜진	hyejin@donga.com\r\n" + 
				"조선일보	재테크	이경은	diva@chosun.com\r\n" + 
				"SBSTV	재테크	정명원	cooldude@sbs.co.kr\r\n" + 
				"동아일보	재테크	하임숙	artemes@donga.com\r\n" + 
				"정경뉴스	정보	전민웅	sadplayer@naver.com\r\n" + 
				"매경헬스	종합	송병기	bgsong@mkhealth.co.kr\r\n" + 
				"서울경제	차업계 새소식	심희정	yvette@sed.co.kr\r\n" + 
				"파이낸셜	차업계 새소식	조용성	yscho@fnnews.com\r\n" + 
				"조선일보	차업계 새소식	최원석	ws-choi@chosun.com\r\n" + 
				"이데일리	차업계 새소식	김경민	min07@edaily.co.kr\r\n" + 
				"한국경제	차업계 새소식	이미아	mia@hankyung.com\r\n" + 
				"노컷뉴스	차업계 새소식	양승진	broady01@cbs.co.kr\r\n" + 
				"헤럴드	차업계새소식	윤정식	yjs@heraldm.com\r\n" + 
				"한겨례	차업계새소식	이형섭	sublee@hani.co.kr\r\n" + 
				"머니투데이	차업계새소식	서명훈	mhsuh@moneytoday.co.kr\r\n" + 
				"뉴시스	차업계새소식	김종현	kim-jh@newsis.com\r\n" + 
				"MBC뉴스	차업계새소식	서혜연	hyseo@mbc.co.kr\r\n" + 
				"머니투데이	차업계새소식	유동일	eddie@moneytoday.co.kr\r\n" + 
				"아시아경제	차업계새소식	최대열	dychoi@asiae.co.kr\r\n" + 
				"연합뉴스	창원산업	황봉규	bong@yna.co.kr\r\n" + 
				"지디넷코리아	컴퓨터/보안	정윤희	yuni@zdnet.co.kr\r\n" + 
				"디지털데일리	컴퓨터/보안	이유지	yjlee@ddaily.co.kr&nbsp;\r\n" + 
				"헤럴드	컴퓨터/보안	양춘병	yang@heraldm.com\r\n" + 
				"경향신문	컴퓨터/보안	송진식	truejs@kyunghyang.com\r\n" + 
				"뉴시스	컴퓨터/보안	김정남	surrender@newsis.com\r\n" + 
				"노컷뉴스	컴퓨터/보안	정영철	steel@cbs.co.kr\r\n" + 
				"연합뉴스	컴퓨터/보안	박창수	pcs@yna.co.kr\r\n" + 
				"MBC뉴스	컴퓨터/보안	박영회	nofootbird@imbc.com\r\n" + 
				"서울경제	컴퓨터/보안	최인철	michel@sed.co.kr\r\n" + 
				"노컷뉴스	컴퓨터/보안	임진수	jslim@cbs.co.kr\r\n" + 
				"전자신문	컴퓨터/보안	서정덕	jdseo@pcliine.co.kr\r\n" + 
				"지디넷코리아	컴퓨터/보안	임민철	imc@zdnet.co.kr\r\n" + 
				"서울신문	컴퓨터/보안	김승훈	hunnam@seoul.co.kr\r\n" + 
				"전자신문	컴퓨터/보안	서한	hseo@etnews.co.kr\r\n" + 
				"한국경제	컴퓨터/보안	이미나	helper@hankyung.com\r\n" + 
				"이데일리	컴퓨터/보안	김세형	eurio@edaily.co.kr\r\n" + 
				"조선일보	컴퓨터/보안	최민기	chaepline@chosun.com\r\n" + 
				"아이뉴스24	컴퓨터/보안	안희권	argon@inews24.com\r\n" + 
				"SBSTV	컴퓨터/보안	이병희	able@sbs.co.kr\r\n" + 
				"경향신문	통신/뉴미디어	박지희	violet@kyunghyang.com\r\n" + 
				"머니투데이	통신/뉴미디어	김응열	uykim@moneytoday.co.kr\r\n" + 
				"경향신문	통신/뉴미디어	손재철	son@khan.co.kr\r\n" + 
				"전자신문	통신/뉴미디어	이수환	shulee@ebuzz.co.kr\r\n" + 
				"머니투데이	통신/뉴미디어	신혜선	shinhs@moneytoday.co.kr\r\n" + 
				"한국경제	통신/뉴미디어	박영태	pyt@hankyung.com\r\n" + 
				"연합뉴스	통신/뉴미디어	박창욱	pcw@yna.co.kr\r\n" + 
				"헤럴드	통신/뉴미디어	박영훈	park@heraldm.com\r\n" + 
				"연합뉴스	통신/뉴미디어	이광빈	lkbin@yna.co.kr\r\n" + 
				"연합뉴스	통신/뉴미디어	이경욱	kyunglee@yna.co.kr\r\n" + 
				"한국경제	통신/뉴미디어	안정락	jran@hankyung.com\r\n" + 
				"조선일보	통신/뉴미디어	장상진	jhin@chosun.com\r\n" + 
				"지디넷코리아	통신/뉴미디어	김효정	hjkim@zdnet.co.kr\r\n" + 
				"MBC뉴스	통신/뉴미디어	남상호	fatshady@imbc.com\r\n" + 
				"뉴시스	통신/뉴미디어	정옥주	channa224@newsis.com\r\n" + 
				"머니투데이	통신/뉴미디어	김경미	camille@moneytoday.co.kr\r\n" + 
				"파이낸셜뉴스	통신/뉴미디어	이구순	cafe9@fnnews.com\r\n" + 
				"경향신문	통신/뉴미디어	권오용	bandy@kyunghyang.com\r\n" + 
				"세계일보	통신/뉴미디어	박성준	alex@segye.com\r\n" + 
				"조선일보	패션/뷰티	신정선	violet@chosun.com\r\n" + 
				"부산일보	패션/뷰티	김효정	teresa@busan.com\r\n" + 
				"한국경제	패션/뷰티	김명신	sin@hankyung.com\r\n" + 
				"한겨례	패션/뷰티	정세라	seraj@hani.co.kr\r\n" + 
				"조이뉴스	패션/뷰티	홍미경	mkhong@joynews24.com\r\n" + 
				"노컷뉴스	패션/뷰티	김정욱	jkim1999@cbs.co.kr\r\n" + 
				"스포츠월드	패션/뷰티	정정욱	jjay@sportsworldi.com\r\n" + 
				"한국경제	패션/뷰티	최지영	jiyoung@bntnews.co.kr\r\n" + 
				"한국경제	패션/뷰티	이지현	jihyun@bntnews.co.kr\r\n" + 
				"한국경제	패션/뷰티	송영원	fashion@bntnews.co.kr\r\n" + 
				"스포츠조선	패션/뷰티	김보라	boradori@sportschosun.com\r\n" + 
				"지디넷코리아	환경	김태정	tjkim@zdnet.co.kr\r\n" + 
				"연합뉴스	환경	신민재	smj@yna.co.kr\r\n" + 
				"한겨례	환경	권오성	sage5th@hani.co.kr\r\n" + 
				"뉴시스	환경	최일영	one@newsis.com\r\n" + 
				"SBSTV	환경	김범주	news4u@sbs.co.kr\r\n" + 
				"뉴시스	환경	배민욱	mkbae@newsis.com\r\n" + 
				"연합뉴스	환경	이우명	lwm123@yna.co.kr\r\n" + 
				"경향신문	환경	권기정	kwon@kyunghyang.com\r\n" + 
				"한겨례	환경	김광수	kskim@hani.co.kr\r\n" + 
				"동아일보	환경	허진석	jameshuh@donga.com\r\n" + 
				"연합뉴스	환경	박수현	ccho@yna.co.kr\r\n" + 
				"연합뉴스	환경	박병기	bgipark@yna.co.kr\r\n" + 
				"뉴시스	환경	우종원	atoz@newsis.com\r\n" + 
				"헤럴드	휴대폰/디지털기기	이영란	yrlee@heraldm.com\r\n" + 
				"지디넷코리아	휴대폰/디지털기기	김우용	yong2@zdnet.co.kr\r\n" + 
				"국민일보	휴대폰/디지털기기	김원철	wonchul@kmib.co.kr\r\n" + 
				"경향신문	휴대폰/디지털기기	윤민용	vista@kyunghyang.com\r\n" + 
				"전자신문	휴대폰/디지털기기	이정환	victolee@etnews.co.kr\r\n" + 
				"노컷뉴스	휴대폰/디지털기기	권민철	twinpine@cbs.co.kr\r\n" + 
				"아이뉴스24	휴대폰/디지털기기	서소정	ssj6@inews24.com\r\n" + 
				"프레시안	휴대폰/디지털기기	김봉규	srv@pressian.com\r\n" + 
				"머니투데이	휴대폰/디지털기기	송정렬	songjr@moneytoday.co.kr\r\n" + 
				"디지털데일리	휴대폰/디지털기기	심재석	sjs@ddaily.co.kr\r\n" + 
				"아이뉴스24	휴대폰/디지털기기	김익현	sini@inews24.com\r\n" + 
				"SBSTV	휴대폰/디지털기기	김수형	sean@sbs.co.kr\r\n" + 
				"지디넷코리아	휴대폰/디지털기기	이설영	ronia@zdnet.co.kr\r\n" + 
				"국민일보	휴대폰/디지털기기	천지우	mogul@kmib.co.kr\r\n" + 
				"디지털데일리	휴대폰/디지털기기	이민형	kiku@ddaily.co.kr\r\n" + 
				"뉴시스	휴대폰/디지털기기	강세훈	kangse@newsis.com\r\n" + 
				"한겨례	휴대폰/디지털기기	김재섭	jskim@hani.co.kr\r\n" + 
				"부산일보	휴대폰/디지털기기	이주환	jhwan@busanilbo.com\r\n" + 
				"MBC뉴스	휴대폰/디지털기기	현원섭	hyunny@imbc.com\r\n" + 
				"지디넷코리아	휴대폰/디지털기기	남혜연	hyun@zdnet.co.kr\r\n" + 
				"지디넷코리아	휴대폰/디지털기기	이장혁	hymagic@zdnet.co.kr\r\n" + 
				"아이뉴스24	휴대폰/디지털기기	정병묵	honnezo@inews24.com\r\n" + 
				"파이낸셜	휴대폰/디지털기기	홍석희	hong@fnnews.com\r\n" + 
				"아이뉴스24	휴대폰/디지털기기	임혜정	heather@inews24.com\r\n" + 
				"동아일보	휴대폰/디지털기기	김원겸	gyummy@donga.com\r\n" + 
				"동아일보	휴대폰/디지털기기	김동현	game@gamedonga.co.kr\r\n" + 
				"파이낸셜	휴대폰/디지털기기	백인성	fxman@fnnews.com&nbsp;\r\n" + 
				"조선일보	휴대폰/디지털기기	이동훈	flatron2@chosun.com\r\n" + 
				"블로터닷넷	휴대폰/디지털기기	도안구	eyeball@bloter.net\r\n" + 
				"아이뉴스24	휴대폰/디지털기기	강은성	esther@inews24.com\r\n" + 
				"전자신문	휴대폰/디지털기기	조중혁	doimoi00@gmail.com\r\n" + 
				"지디넷코리아	휴대폰/디지털기기	황치규	delight@zdnet.co.kr\r\n" + 
				"조선일보	휴대폰/디지털기기	정진영	cya@chosun.com\r\n" + 
				"한겨례	휴대폰/디지털기기	최성진	csj@hani.co.kr\r\n" + 
				"아이뉴스24	휴대폰/디지털기기	강호성	chaosing@inews24.com\r\n" + 
				"지디넷코리아	휴대폰/디지털기기	최병준	ccbbjj@zdnet.co.kr\r\n" + 
				"디지털타임스	휴대폰/디지털기기	이형근	bruprin@gmail.com\r\n" + 
				"전자신문	휴대폰/디지털기기	이성현	argos@etnews.co.kr\r\n" + 
				"디지털타임스	IT	정유진	yjin@dt.co.kr\r\n" + 
				"디지털타임스	IT	허우영	yenny@dt.co.kr\r\n" + 
				"지디넷코리아	IT	김태정	tjkim@zdnet.co.kr\r\n" + 
				"뉴시스경제	IT	김정남	surrender@newsis.com\r\n" + 
				"전자신문	IT	김원석	stone201@etnews.co.kr\r\n" + 
				"한국경제	IT	문혜정	selenmoon@hankyung.com\r\n" + 
				"한국경제	IT	박영태	pyt@hankyung.com\r\n" + 
				"디지털데일리	IT	한주엽	powerusr@ddaily.co.kr\r\n" + 
				"프라임경제	IT	나원재	nwj@newsprime.co.kr\r\n" + 
				"경제투데이	IT	김남규	ngkim@eto.co.kr\r\n" + 
				"아시아투데이	IT	정석만	naflnafl@asiatoday.co.kr\r\n" + 
				"디지털타임스	IT	강희종	mindle@dt.co.kr\r\n" + 
				"헤럴드생생뉴스	IT	이권형	kwonhl@heraldm.com\r\n" + 
				"경제투데이	IT	김태균	ksgit@eto.co.kr\r\n" + 
				"경제투데이	IT	한지운	juhan@eto.co.kr\r\n" + 
				"디지털타임스	IT	박지성	jspark@dt.co.kr\r\n" + 
				"전자신문	IT	김준배	joon@etnews.co.kr\r\n" + 
				"아시아경제	IT	조강욱	jomarok@asiae.co.kr\r\n" + 
				"아시아투데이	IT	김효정	jhkim@asiatoday.co.kr\r\n" + 
				"이데일리	IT	신혜리	hyeree@\r\n" + 
				"아주경제	IT	윤혜미	hm@ajnews.co.kr\r\n" + 
				"헤럴드경제	IT	황혜진	hhj6386@heraldm.com\r\n" + 
				"아시아경제	IT	이승종	hanarum@asiae.co.kr\r\n" + 
				"이투데이	It	최재혁	freshphase@etoday.co.kr\r\n" + 
				"디지털타임스	IT	심화영	dorothy@dt.co.kr\r\n" + 
				"한국경제	IT	김동훈	DHK@hankyung.com\r\n" + 
				"아이티투데이	IT	최고야	cky@ittoday.co.kr\r\n" + 
				"아이뉴스24	IT	박웅서	ckoudpark@inews24.com\r\n" + 
				"뉴시스	IT	정옥주	channa224@newsis.com\r\n" + 
				"지디넷코리아	IT	봉성창	bong@zdnet.co.kr\r\n" + 
				"보안뉴스	IT	김정완	boan3@boannews.com\r\n" + 
				"아주경제	It	조영빈	agamee81@ajnews.co.kr\r\n" + 
				"산업뉴스	IT	박영국	24pyk@ebn.co.kr\r\n" + 
				"디지털데일리	IT	이상일	2401@ddaily.co.kr\r\n" + 
				"아이뉴스24	IT/통신방송	박정일	comja@inews24.com\r\n" + 
				"이데일리	IT산업 동향/정책	지영한	yhji@edaily.co.kr\r\n" + 
				"한국경제	IT산업 동향/정책	서기열	philos@hankyung.com\r\n" + 
				"동아일보	IT산업 동향/정책	이헌진	mungchii@donga.com\r\n" + 
				"연합뉴스	IT산업 동향/정책	인교준	kjihn@yna.co.kr\r\n" + 
				"연합뉴스	IT산업 동향/정책	홍제성	jsa@yna.co.kr\r\n" + 
				"연합뉴스	IT산업 동향/정책	김재홍	jaehong@yna.co.kr\r\n" + 
				"연합뉴스	IT산업 동향/정책	김지훈	hoonkim@yna.co.kr\r\n" + 
				"연합뉴스	IT산업 동향/정책	함보현	hanarmdri@yna.co.kr\r\n" + 
				"머니투데이	IT산업동향/정책	김성현	sean@moneytoday.co.kr\r\n" + 
				"머니투데이	IT산업동향/정책	정현수	gustn99@moneytoday.co.kr\r\n" + 
				"SBSTV	IT산업동향/정책	표언구	eungoo@sbs.co.kr\r\n" + 
				"헤럴드	IT산업동향/정책	김상수	dlcw@heraldm.com\r\n" + 
				"머니투데이	IT산업동향/정책	김경미	camille@moneytoday.co.kr\r\n" + 
				"아이뉴스24	IT산업동향/정책	서정근	antilaw@inews24.com\r\n" + 
				"아시아투데이	　	김옥빈	obkim5153@hanmail.net\r\n" + 
				"매경헬스	　	이상미	lsmclick@mkhealth.co.kr\r\n" + 
				"블로터닷넷	　	주민영	ezoomin@bloter.net\r\n" + 
				"매일경제	　	황시영	@shinyandloose\r\n";
		
//		
//		Pattern pattern = Pattern.compile("[\\w\\S]+\\@[\\w\\S]+\\.\\w");
//		Matcher ma = pattern.matcher(text);
//		ArrayList<String> li = new ArrayList<>();
//		
//		int coun = 0;
//		while(ma.find()) {
//			li.add(ma.group());
//			System.out.println(ma.group());
//			coun++;
//		}
//		System.out.println(coun);
		
		
		
		Matcher found_email = Pattern.compile("[\\w]*@[\\w]+\\.[\\w]+").matcher(text);
		
		// chosun, hankyung                     //group()을 나누는 기준은 ()소괄호이다
		Matcher found_email2 = Pattern.compile("([\\w]+[@])(chosun|hankyung)[.]\\w+").matcher(text);
		
		ArrayList<String> emails = new ArrayList<>();
		int count = 0;     
		// find(): 다음에 찾은게 있는지 확인한 후, 커서가 넘어간다(이중역할을 해준다)
		while(found_email.find()) {
			
			emails.add(found_email.group());   //커서가 넘어가기 이전에 매칭된 값을 넘겨준다
//			System.out.println("default group: " + found_email2.group()); 
//			System.out.println("group 1: " + found_email2.group(1));
//			System.out.println("group 2: " + found_email2.group(2));
			count++;
		}
		
		System.out.println(count);
		
		HashSet<String> domains = new HashSet<>();
		
		for (String email : emails) {   
			//indexOf(): 문자열(string)에서 특정 문자나 문자열(searchvalue)을 찾고, 
			//검색된 문자열이 '첫번째'로 나타나는 위치 index를 리턴합니다.
			domains.add(email.substring(email.indexOf('@') + 1));
		}
		System.out.println(domains);
		//System.out.println("tlstmdal3@nver.".indexOf('@'));
	}
	
	

}
