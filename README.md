### MVC 패턴 기반 디렉토리 구조 (임시)
---
## Controller (사용자 요청 처리 및 매서드 호출, 결과 반환) <br> 
-
L AuthController.java (회원가입, 로그인, 로그아웃 기능) <br>
L ProfileControleer.java (프로필 작성 및 수정 기능) <br>
L MainPageController.java (메인 페이지 기능) <br>
L MyPageController.java (마이 페이지 기능) <br>
L ChattingController.java (채팅 페이지 기능) <br>
L MatchingController.java (매칭 기능) <br>
L MajorTingController.java (과팅 페이지 기능) <br>
L AlcoholTingController.java (술배팅 페이지 기능) <br>
L TaxiTingController.java (택시팅 페이지 기능) <br>
---
## Service (컨트롤러가 호출한 요청 처리 및 레포지토리와 상호작용 데이터 처리) <br>
-
L AuthService.java (회원가입 및 로그인 인증 로직) <br>
L ProfileService.java (프로필 생성 및 수정 로직) <br>
L MainPageService.java (메인 페이지 데이터 로직) <br>
L ChattingService.java (채팅 데이터 로직) <br>
L MatchingService.java (매칭 데이터 로직) <br>
L MyPageService.java (마이 페이지 데이터 로직) <br>
L MajorTingPageService.java (과팅 페이지 데이터 로직) <br>
L AlcoholTingPageService.java (술배팅 페이지 데이터 로직) <br>
L TaxiTingPageService.java (택시팅 페이지 데이터 로직) <br>
---
## Repository (데이터베이스와의 직접적인 상호작용) <br>
-
L UserRepository.java (사용자 정보를 DB에 저장 및 조회) <br>
L ProfileRepository.java (프로필 정보와 관련 데이터 저장 및 조회) <br>
L ChattingRepository.java (채팅 내역 데이터 저장 및 불러오기) <br>
L MatchingRepository.java (매칭 정보 데이터 저장 및 조회) <br>
L MajorTingRepository.java (과팅 게시글 데이터 저장 및 조회) <br>
L AlcoholTingRepository.java (술배팅 게시글 데이터 저장 및 조회) <br>
L TaxiTingRepository.java (택시팅 게시글 데이터 저장 및 조회) <br>
---
## Model (DB 테이블과 매핑되는 엔티티) <br>
-
L User.java (사용자 정보) <br>
L Profile.java (프로필 정보) <br>
L Chat.java (채팅 정보) <br>
L Match.java (매칭 정보) <br>
L MajorTing.java (과팅 정보) <br>
L AlcholTing.java (술배팅 정보) <br>
L TaxiTing.java (택시팅 정보) <br>
---
## DTO (Data Transfer Object의 약자, 클라이언트와 서버 간 데이터 전송) <br>
-
L UserDTO.java (사용자 정보 클라이언트로 전달) <br>
L ProfileDTO.java (프로필 정보 클라이언트로 전달) <br>
L ChatDTO.java (채팅 내역 클라이언트로 전달) <br>
L MatchDTO.java (매칭 정보 클라이언트로 전달) <br>
L MajorTingDTO.java (과팅 게시글 클라이언트로 전달 <br>)
L AlcoholTingDTO.java (술배팅 게시글 클라이언트로 전달) <br>
L TaxiTingDTO.java (택시팅 게시글 클라이언트로 전달) <br>
---
