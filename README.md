# ๐ redis ํ์ต์ ์ํ ํ๋ก์ ํธ ๐

์ด ํ๋ก์ ํธ๋ `์ฐ์ํ ํํฌ์บ ํPro2๊ธฐ` ๊ณผ์ ์ ์งํํ๋ฉด์ ์๊ฒ ๋ redis๋ฅผ ์ฌ๋ฐ๋ก ์ฌ์ฉํ๊ธฐ ์ํ ํ์ต์ ๋ชฉ์ ์ผ๋ก ํ๋ ํ๋ก์ ํธ์๋๋ค.

- redis๋ฅผ ํ๋ก์ ํธ์ ์ ์ฉํด ๋ด๋๋ค.
- redis ์๋ฒ์ ์ ์ฅ ๋ ๋ฐ์ดํฐ๋ฅผ ๋ค๋ฃจ๋ ๋ฐฉ๋ฒ์ ํ์ตํฉ๋๋ค.
- ์ ๊ณผ์ ์ ์ขํฉํ์ฌ ์ฝ๋์์ redis ์๋ฒ์ ์ ์ฅ ๋ ๋ฐ์ดํฐ๋ฅผ ๋ค๋ฃจ๋ ๋ฐฉ๋ฒ์ ํ์ตํฉ๋๋ค.

### ํ๋ก์ ํธ ๊ฐ๋ฐ ํ๊ฒฝ

- Project Java version : 11
- Build : gradle
- Testing Framework : junit 5
- Persistent Framework : JPA(Hibernate)
- Database
    + Test - H2
    + Local - MySQL

### ํ๋ก์ ํธ ์งํ ์์ 

#### Step1. ๊ฐ๋ฐํ๊ฒฝ ๊ตฌ์ฑ

1. redis ํ์ต์ ์ํ ์ธ๋ถ ํ๊ฒฝ ๊ตฌ์ฑ
    - [X] docker๋ฅผ ์ฌ์ฉํ์ฌ ํ์คํธ์ฉ MySQL Server ์คํ
        + ํ์ฌ๋ ์ด๊ธฐ ์ด๋ฏธ์ง ์์ฑ ์ํ. ๋ฐ์ดํฐ ์ถ๊ฐํ๋ ๊ณผ์ ์ ํฌํจํด์ ์๋ฐ์ดํธ ์์ 
        ```shell
        # ์ด๋ฏธ์ง ๋ค์ด๋ก๋ ๋ฐ MySQL Server ์คํ
        # ๊ณ์ /๋น๋ฒ : root/root
        $ docker pull hilu0318/mysql-for-test:0.0.1
        $ docker run -d -p 3306:3306 --name [์ฌ์ฉํ _์ปจํ์ด๋_์ด๋ฆ] hilu0318/mysql-for-test:0.0.1
        ```
    - [X] docker๋ฅผ ์ฌ์ฉํ์ฌ redis ์๋ฒ ์คํ
        ```shell
        $ docker pull redis
        $ docker run -d -p 6379:6379 --name [์ฌ์ฉํ _์ปจํ์ด๋_์ด๋ฆ] redis
        ```

2. ํ๋ก์ ํธ ๊ธฐ๋ณธ ๊ตฌ์ฑ
    - [X] ํ๋ก์ ํธ์ ํ์ํ ์์กด์ฑ ์ถ๊ฐ.
    - [X] ํ๋ก์ ํธ ๋ฒ์  ๋ฑ ์ธ๋ถ ์ค์ 
        - [X] properties ๊ตฌ์ฑ

#### Step2. ์งํ์ฒ ์ญ ๊ด๋ฆฌ ๊ธฐ๋ฅ ๊ตฌํ

- ์งํ์ฒ ์ญ ๊ด๋ฆฌ api ๊ตฌํ
    + [X] Station Entity & Repository ๊ตฌํ
    + [X] Service & RestController ๊ตฌํ
        * [X] ํ๊ฑด ์กฐํ
        * [X] ์ ์ฒด ์กฐํ
        * [X] ๋ฑ๋ก
        * [X] ์์ 
        * [X] ์ญ์ 

#### Step3. ๊ธฐ์กด ์๋น์ค์ Redis ์ ์ฉ
##### 1. Redis ํ์ต!
1. Redis๋ ๋ฌด์์ธ๊ฐ?
2. Redis์ ํน์ง
3. Redis์ ์ฅ/๋จ์ 
4. Redis์ Memcached์ ๋น๊ต.

##### 2. Redis ์ค์ต!
    
#### * ์ถํ ์๋ฐ์ดํธ ์์ 
