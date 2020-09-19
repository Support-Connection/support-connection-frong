# support-connection-front (Kotlin)
- 오류/유의 사항
1.	TextWatcher 사용할 경우 앱이 강종되는 현상
> RegisterActivity 외에는 따라서 값 입력했는지 안했는지 검사X
2.	회원가입할 때 이름 꼭 김서폿으로 입력해주고 처음 메인화면에 들어갔을 때 네비게이션바의 홈버튼 꼭 눌러주기
> Activity와 Fragment 간 data 전달할 때 오류가 난다(왜….?) 따라서 일단 임시 방편으로 메인화면 네비게이션바의 홈 버튼을 눌렀을 때 fragment의 컴포넌트에 MainActivity의 정보를 올려주는 방식d으로 작업 해놓았음

- 구현X
공통 (우선순위 순)
1.	초기 정보 입력 창들 ….
2.	자산, 정보 등 input 입력했을 경우 fragment 값 변경해주기 + fragment, activity 간 연결
3.	서버 연동
4.	쉬운 지원금 신청에서 recycler layout 제작
5.	지원금 잔액 관리, 마이페이지 구현
==========================================================================
6.	(다음으로) 버튼 누를 때 editText 값이 다 입력 안되었을 경우 입력X, 색 변경되는 요소
7.	Bottom sheet 모서리 둥글게 처리해주기
8.	Bottom sheet 선택할 경우 이미지 뷰 보여주기
9.	창 닫힘 버튼
fdcRecycler
1.	이미지 > 레이아웃으로 변경 후 margin 왼쪽, 오른쪽 35dp 씩 주기





- RecyclerView
-	Fragment_discount : <금융지원 보기>에서 사용
* fdc_recycler 리스트뷰 레이아웃
* revycler_Data 데이터 클래스
* CustomAdapter 어댑터 적용 클래스
* activity_shincung 신청 클릭할 경우 뜨는 drawer
클릭이벤트는 RealMainActivity에서 처리해줄 예정 . . .

-	Fragment_search : 쉬운지원금신청(recyclerview2개 선언, 아직 레이아웃 제작 전)

