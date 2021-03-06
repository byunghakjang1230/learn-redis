# 📀 redis 학습을 위한 프로젝트 📀

이 프로젝트는 `우아한 테크캠프Pro2기` 과정을 진행하면서 알게 된 redis를 올바로 사용하기 위한 학습을 목적으로 하는 프로젝트입니다.

- redis를 프로젝트에 적용해 봅니다.
- redis 서버에 저장 된 데이터를 다루는 방법을 학습합니다.
- 위 과정을 종합하여 코드에서 redis 서버에 저장 된 데이터를 다루는 방법을 학습합니다.

### 프로젝트 개발 환경

- Project Java version : 11
- Build : gradle
- Testing Framework : junit 5
- Persistent Framework : JPA(Hibernate)
- Database
    + Test - H2
    + Local - MySQL

### 프로젝트 진행 순선

#### Step1. 개발환경 구성

1. redis 학습을 위한 외부 환경 구성
    - [X] docker를 사용하여 테스트용 MySQL Server 실행
        + 현재는 초기 이미지 생성 상태. 데이터 추가하는 과정을 포함해서 업데이트 예정
        ```shell
        # 이미지 다운로드 및 MySQL Server 실행
        # 계정/비번 : root/root
        $ docker pull hilu0318/mysql-for-test:0.0.1
        $ docker run -d -p 3306:3306 --name [사용할_컨테이너_이름] hilu0318/mysql-for-test:0.0.1
        ```
    - [X] docker를 사용하여 redis 서버 실행
        ```shell
        $ docker pull redis
        $ docker run -d -p 6379:6379 --name [사용할_컨테이너_이름] redis
        ```

2. 프로젝트 기본 구성
    - [X] 프로젝트에 필요한 의존성 추가.
    - [X] 프로젝트 버전 등 세부 설정
        - [X] properties 구성

#### Step2. 지하철역 관리 기능 구현

- 지하철역 관리 api 구현
    + [X] Station Entity & Repository 구현
    + [X] Service & RestController 구현
        * [X] 한건 조회
        * [X] 전체 조회
        * [X] 등록
        * [X] 수정
        * [X] 삭제

#### Step3. 기존 서비스에 Redis 적용
##### 1. Redis 학습!
1. Redis란 무엇인가?
2. Redis의 특징
3. Redis의 장/단점
4. Redis와 Memcached의 비교.

##### 2. Redis 실습!
    
#### * 추후 없데이트 예정
