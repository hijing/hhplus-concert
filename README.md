# hhplus-concert

# 콘서트 예약
- **`콘서트 예약 서비스`**를 구현해 봅니다.
- 대기열 시스템을 구축하고, 예약 서비스는 작업가능한 유저만 수행할 수 있도록 해야합니다.
- 사용자는 좌석예약 시에 미리 충전한 잔액을 이용합니다.
- 좌석 예약 요청시에, 결제가 이루어지지 않더라도 일정 시간동안 다른 유저가 해당 좌석에 접근할 수 없도록 합니다.

## Requirements
- 아래 5가지 API 를 구현합니다.
    - 유저 토큰 발급 API
    - 예약 가능 날짜 / 좌석 API
    - 좌석 예약 요청 API
    - 잔액 충전 / 조회 API
    - 결제 API
- 각 기능 및 제약사항에 대해 단위 테스트를 반드시 하나 이상 작성하도록 합니다.
- 다수의 인스턴스로 어플리케이션이 동작하더라도 기능에 문제가 없도록 작성하도록 합니다.
- 동시성 이슈를 고려하여 구현합니다.
- 대기열 개념을 고려해 구현합니다.

## Milestone
![마일스톤](https://github.com/user-attachments/assets/47fa3f00-1157-4768-bf08-f876ed62485b)

## Sequence Diagram
### 유저 대기열 토큰 기능
```mermaid
sequenceDiagram
    actor User
    User ->> Client: 서비스 접속 요청
    Client ->> Queue: 대기열 참여 요청
    Queue ->> Queue: 대기 순서 할당
    Queue -->> Client: 대기 번호 반환
    Client -->> User: 대기 상태 표시
    
    loop 대기 상태 확인
    Client ->> Queue: 대기 상태 확인 요청
    Queue -->> Client: 대기 상태 응답
    Client -->> User: 대기 상태 업데이트
    end
    
    Queue ->> Queue: 사용자 차례 도달
    Queue ->> Auth: 토큰 발급 요청
    Auth ->> Auth: 토큰 생성
    Auth -->> Queue: 토큰 반환
    Queue -->> Client: 접속 토큰 전달
    Client -->> User: 서비스 접속 허용
```

### 예약 가능 날짜 / 좌석 API
```mermaid
sequenceDiagram
    사용자 ->> 토큰 컨트롤러 : API 요청
    토큰 컨트롤러 ->> 토큰 서비스 : 토큰 검증 요청
    토큰 서비스 ->> 토큰 서비스 : 토큰 검증
    토큰 서비스 ->> 토큰 컨트롤러 : 토큰 검증 응답
    토큰 컨트롤러 ->> 예약 좌석 : 예약 가능 날짜 / 좌석 요청
    예약 좌석 ->> DB : 예약 가능 날짜 / 좌석 요청
    DB ->> DB : 좌석 조회
    DB ->> 예약 좌석 : 예약 가능 날짜 / 좌석 요청
    예약 좌석 ->> 사용자 : API 응답
```

### 좌석 예약 요청 API
```mermaid
sequenceDiagram
    사용자 ->> 토큰 컨트롤러 : API 요청
    토큰 컨트롤러 ->> 토큰 서비스 : 토큰 검증 요청
    토큰 서비스 ->> 토큰 서비스 : 토큰 검증
    토큰 서비스 ->> 토큰 컨트롤러 : 토큰 검증 응답
    토큰 컨트롤러 ->> 좌석 예약  : 좌석 예약 요청
    좌석 예약 ->> DB : 좌석 예약 요청
    DB ->> DB  : 좌석 예약
    DB ->> 좌석 예약  : 좌석 예약 응답
    좌석 예약 ->> 사용자 : API 응답
```

### 잔액 충전 / 조회 API
```mermaid
sequenceDiagram
    사용자 ->> 토큰 컨트롤러 : API 요청
    토큰 컨트롤러 ->> 토큰 서비스 : 토큰 검증 요청
    토큰 서비스 ->> 토큰 서비스 : 토큰 검증
    토큰 서비스 ->> 토큰 컨트롤러 : 토큰 검증 응답
    토큰 컨트롤러 ->> 잔액 정보 : 잔액 충전 / 조회 요청
    잔액 정보 ->> DB : 잔액 충전 / 조회 요청
    DB ->> DB : 잔액 충전 / 조회
    DB ->> 잔액 정보 : 잔액 충전 / 조회 응답
    잔액 정보 ->> 사용자 : API 응답
```

### 결제 API
```mermaid
sequenceDiagram
    사용자 ->> 토큰 컨트롤러 : API 요청
    토큰 컨트롤러 ->> 토큰 서비스 : 토큰 검증 요청
    토큰 서비스 ->> 토큰 서비스 : 토큰 검증
    토큰 서비스 ->> 토큰 컨트롤러 : 토큰 검증 응답
    토큰 컨트롤러 ->> 결제 : 결제 요청
    결제 ->> 좌석 : 유효한 좌석 체크
    좌석 ->> 결제 : 유효한 좌석
    결제 ->> 잔액 : 잔액 차감
    잔액 ->> DB : 잔액 검증 요청
    DB ->> DB : 잔액 검증
    DB ->> 잔액 : 잔액 검증 응답
    잔액 ->> 결제 : 결제 성공
    결제 ->> 좌석 : 결제 완료 (좌석배정)
    좌석 ->> 결제 : 좌성 배정
    결제 ->> 사용자 : API 응답
```


## ERD
```mermaid
erDiagram
    User{
        Long id PK
        varchar(255) name "이름"
        int amount "잔액"
        LocalDateTime create_at "생성 시간"
        LocalDateTime update_at "수정 시간"
    }
    
    Tokens {
        Long id PK
        Long user_id FK
        varchar(500) token "대기열 토큰"
        enum status "대기열 상태 (stand by, active, expired)"
        LocalDateTime create_dt "대기열 생성일"
        LocalDateTime expired_dt "대기열 만료일"
    }
    
    Concert {
        Long id PK
        varchar(255) name "콘서트 제목"
        LocalDate event_dt "콘서트 시작일"
        LocalDateTime start_at "콘서트 시작 시간"
        LocalDateTime time "콘서트 소요 시간"
    }
    
    Seat {
        Long id PK
        Long concert_id FK
        int seat_num "좌석 번호"
        int price "좌석 금액"
        enum status "좌석 상태 (reserved, stand by)"
    }
    
    Reservation {
        Long id PK
        Long user_id FK
        Long concert_id FK
        Long seat_id FK
        enum status "예약 상태 (reserved, canceled)"
        LocalDateTime reservation_dt "예약 일자"
    }
    
    Payment {
        Long id PK
        Long user_id FK
        Long reservation_id FK
        int price "결제 금액"
        enum status "결제 상태 (succeed, failed)"
        LocalDateTime create_at "생성시간"
    }


    User ||--o{ Tokens: ""
    User ||--o{ Payment: ""
    Reservation ||--|| Payment: ""
    User ||--o{ Reservation: ""
    Seat ||--o{ Reservation: ""
    Concert ||--o{ Seat: ""
    Concert ||--o{ Reservation: ""
```


