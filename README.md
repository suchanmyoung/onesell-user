### Onesell User API

<hr> 

#### How To Run

* Clone This Repository ```https://github.com/suchanmyoung/onesell-user.git```
* Use JDK 1.8
* Build Project ```./gradlew clean build```
* Run Application ```java -jar ./build/libs/user-0.0.1-SNAPSHOT.jar```
* Enter ```http://localhost:8080/swagger```

<hr>

#### Database
* In-memory H2 사용 
* 애플리케이션 구동 후 h2-console 웹 접근 가능 ```http://localhost:8080/h2-console```
* JDBC URL : jdbc:h2:mem:devdb
* User Name : sa
* 애플리케이션 구동 시 회원 테이블 생성 및 더미 데이터 49건 Insert ```resources > schema.sql / data.sql```

#### Logging
* 대상 : API Request / Response / Exception
* 방식 
  * LoggingFilter 클래스 사용
  * MDC에 Log ID를 담아 Request에서 Response 까지의 모든 과정 추적
  * 별도 파일로 남기지 않음

#### Dev List
- [x] Common
  - [x] 예외 규격 및 핸들러 정의
  - [x] 공통 응답 규격 정의
  - [x] API 로깅 설정
  - [x] Init Data 
  - [x] API Document 설정
  - [x] Auditing
  - [x] README 작성
- [x] 회원가입
  - [x] 기능구현
  - [x] 예외처리
  - [x] 패스워드 암호화
  - [x] 유효성검사
  - [x] 테스트
- [x] 회원목록조회
  - [x] 기능구현
  - [x] 페이징 처리
  - [x] 테스트
- [x] 회원수정
  - [x] 기능구현
  - [x] 예외처리
  - [x] 유효성검사
  - [x] 테스트

- [ ] after
  - [ ] 단위테스트
  - [ ] 인수테스트 케이스 추가 
