### ERD
```mermaid
erDiagram
    User{
        Long id PK
        varchar(255) name
        LocalDateTime create_at
        LocalDateTime update_at
    }
    
    Tokens {
        Long id PK
        Long user_id FK
        varchar(500) token "대기열 토큰"
        varchar(255) status "대기열 상태"
        LocalDateTime create_dt "대기열 생성일"
        LocalDateTime expired_dt "대기열 만료일"
    }
    
    Concert {
        Long id PK
        varchar(255) name "콘서트 제목"
        LocalDate event_dt "콘서트 시작일"
        LocalDateTime start_at "콘서트 시작 시간"
        LocalDateTime time "콘서트 소요 시간"
        int capacity "좌석수"
    }
    
    Seat {
        Long id PK
        Long concert_id FK
        Long seat_num "좌석 번호"
        int price "좌석 금액"
        varchar(255) status "좌석 상태"
    }
    
    Reservation {
        Long id PK
        Long user_id FK
        Long concert_id FK
        Long seat_id FK
        LocalDateTime reservation_dt "예약일자"
    }
    
    Payment {
        Long id PK
        Long user_id FK
        Long concert_id FK
        Long reservation_id FK
        int price "결제금액"
        varchar(255) status "결제상태"
    }


    User ||--o{ Tokens: ""
    User ||-- ||Payment: ""
    User ||--o{ Reservation: ""
    Seat ||--o{ Reservation: ""
    Concert ||--o{ Seat: ""
```
