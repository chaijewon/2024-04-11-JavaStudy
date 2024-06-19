package com.sist.dao;
/*
 *   NO                                        NOT NULL NUMBER
 NAME                                      NOT NULL VARCHAR2(51)
 SUBJECT                                   NOT NULL VARCHAR2(4000)
 CONTENT                                   NOT NULL CLOB
 PWD                                       NOT NULL VARCHAR2(10)
 REGDATE                                            DATE
 HIT                                                NUMBER
 */
import java.util.*;

import lombok.Data;
// => 오라클 데이터를 받아서 윈도우 / 브라우저에 전송할 목적 
/*
 *    데이터베이스 데이터형과 매칭 
 *    --------------------  컬럼명 = 변수명 
 *    CHAR / VARCHAR2 / CLOB =====> String
 *    NUMBER : 저장된 값을 확인 =====> int / double 
 *    DATE   ========> java.util.Date 
 *    ----------------------------------------
 */
@Data
public class BoardVO {
   private int no,hit;
   private String name,subject,content,pwd;
   private Date regdate;
}
