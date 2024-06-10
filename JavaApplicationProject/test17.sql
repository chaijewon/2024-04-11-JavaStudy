-- 2024-06-05 3장 정리 => SELECT문장 / 연산자 / 내장함수 =>  검색 
/*
      145page 
        주의점 : => 문장이 끝나면 ;을 사용한다 
                        단 => 자바에서는 ;을 사용하면 안된다 => 자동으로 추가 
                                                                              --------------- ; , COMMIT
                        공백 => 키워드뒤에는 공백을 사용
                                   ----------------------------- 오류 발생이 많다 
                                   웹프로그래머 => 모든 SQL을 자바에서 전송 
                                                         -----------------------------
                                                          SQL문장이 자바에서는 문자열로 되어 있다  
                         테이블명 / 컬럼명이 긴 경우 : 별칭을 사용한다 => 조인 
                         1) COMMIT을 미리 설정하지 않는다 => ROLLBACK이 수행이 안된다 
                            ----------- 먼저 데이터 확인 (정상적이면 => COMMIT) 
                            => 프로젝트 / 웹 연습 => 크롤링한 데이터 
       
        SELECT : 데이터 검색 
                    1. 형식 
                        = SELECT문장 형식
                           --------- 오라클에서 실행시 for => WHERE if , JOIN은 2차 for 
                           SELECT [DISTINCT] * | column1 , column2 ....  (* => 모든 컬럼의 데이터 값 읽기) 
                                     ------------ 중복 제거 => HashSet
                           FROM table_name : 관련된 데이터만 모아서 관리 ( 사원정보 / 부서정보 )
                           ---------------------------------------------------------------------------------- 필수 
                           [
                               ** 사용자 요청값 => 검색 , 상세보기 
                               WHERE 조건문 => true/false => 연산자 
                               --------------------------------------
                               GROUP BY  그룹컬럼 / 내장함수 
                               HAVING 그룹에 대한 조건 
                               -------------------------------------- 나눠서 통계 (부서별,년도별,직위별)
                               ORDER BY 컬럼/내장 함수  (ASC|DESC) => 정렬 
                                                                  ----- ------
                                                                         | 내림차순
                                                                  | 올림차순 =====> 생략이 가능 
                               *** 이중 정렬 
                                    ORDER BY sal DSEC , ename ASC
                                                             ---
                                    100 aaa
                                    ----------
                                    200 bbb
                                    200 ccc
                                    ---------- 우선순위 먼저 등록된 데이터
                                    300 ddd
                           ]
                                     === 결과값
                                      300 ddd
                                      200 bbb
                                      200 ccc
                                      100 aaa
                           ==> 답변형 게시판 (묻고 답하기) 
                                  aaaaa 
                                     =>  bbbb
                                     => dddd
                                       => cccc
                           SELECT ------------------- 5
                           FROM  -------------------  1
                           WHERE ------------------ 2
                           GROUP ------------------ 3
                           HAVING ----------------- 4
                           ORDER BY  -------------- 6
                        = 데이터형 (오라클)
                           => 문자열 / 날짜 => ''
                           => 숫자는 그냥 사용 
                           => 2차 (JSP) => 이력서 => 데이터베이스 모델링 
                           1) 문자형 (문자/문자열) => CHAR / VARCHAR2 / CLOB => String
                                                         => byte단위로 저장 
                                                              CHAR(1~2000byte) => 고정적 
                                                              CHAR(2000) => 'A' => 같은 byte 
                                                                     => 남자/여자 
                                                                     => CHAR(6) => 오류 
                                                              메모리 10byte 
                                                              VARCHAR2(1~4000byte) => 가변형 
                                                              VARCHAR2(4000) => 'A'
                                                              메모리 1byte
                                                              CLOB : 4기가 
                                                              *** 한글은 한글자당 => 3byte
                           2) 숫자형 (정수/실수) => NUMBER(38,128) 
                                                                            ---- 실수의 자리수 
                                                                       --- 정수의 자리수
                                                      => NUMBER 
                                                          --------------- 8 , 2 => default 
                                                      => NUMBER(4) => 4자리 정수 사용 
                                                      => NUMBER(7,2) => 정수 => 7자리 
                                                                             => 7자리중에 2자리를 소수점 
                                                                                 --- 앞에 사용은 5자리까지 사용이 가능 
                           3) 날짜형 => DATE 
                           4) 기타형 => BFILE / BLOB => 동영상 , 사진 저장 => 4기가 
                           ===> DESC table명 
                                   ------------------- 컬럼/데이터형 확인시 
                    2. 연산자 => WHERE 
                    3. 데이터 조작 => 내장함수 
                    4. 그룹별 처리 => GROUP BY => 157page => 다음주 => 서브쿼리 
                    --------------------------------------- 문법 형식에 주력 
                    5. 테이블 연결 => JOIN  ==> 응용 => SQL 문장이 길어진다 => 정규화 (중복 최소화)
                                           INNERT JOIN
                                            ----------------------------------------------------
                                             ***= EQUI_JOIN : 교집합 => INTERSECT
                                             = NON_EQUI_JOIN => 포함된 데이터값
                                            -----------------------------------------------------비교시 컬럼명이 틀릴 수 있다
                                             = NATUREL JOIN => 자동으로 값을 찾아준다 
                                             = JOIN ~ USING 
                                            ---------------------------------------------------- 컬럼명이 동일 
                                           OUTER JOIN 
                                              = LEFT OUTER JOIN  ===> INTERSECT + MINUS 
                                              = RIGHT OUTER JOIN
                    6. SQL문장 연결 => 서브쿼리  
                                              = 서브쿼리 : 조건=> 다른 테이블을 이용해서 => WHERE
                                              = 스칼라 서브쿼리 => 컬럼대신 => SELECT
                                              = 인라인뷰 => 테이블 대신 => FROM
*/
-- 회원가입 
/*
CREATE TABLE member(
    id VARCHAR2(20) PRIMARY KEY,
    pwd VARCHAR2(10) NOT NULL,
    name VARCHAR2(51) NOT NULL,
    sex CHAR(6) CHECK(sex IN('남자','여자')),
    birthday VARCHAR2(10),
    post VARCHAR2(7) NOT NULL,
    addr1 VARCHAR2(150) NOT NULL,
    addr2 VARCHAR2(150),
    phone VARCHAR2(13) UNIQUE,
    email VARCHAR2(100) UNIQUE,
    content CLOB,
    regdate DATE DEFAULT SYSDATE
);
*/
-- CHAR , VARCHAR2 CLOB => '' 
INSERT INTO member VALUES('hong','1234','홍길동','남자','2000-02-05','000-000','서울시 마포구 월드컵북로 21',
                                       '','010-1111-1111','hong@co.kr','홍길동입니다',SYSDATE);
COMMIT;

ALTER TABLE member ADD admin CHAR(1) DEFAULT 'n';

