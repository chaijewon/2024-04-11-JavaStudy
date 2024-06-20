package com.sist.dao;
/*
 *   CNO                                       NOT NULL NUMBER
 ID                                                 VARCHAR2(20)
 GNO                                                NUMBER
 ACCOUNT                                            NUMBER
 PRICE                                              NUMBER
 REGDATE                                            DATE
 */
import java.util.*; // 자바 <=> 오라클 ===> 데이터를 모아서 관리 (송수신) 

import lombok.Data;
// DTO => Data Transfor Object
// => 서브쿼리 , 조인 => 해당 VO를 포함 
// => VO는 반드시 테이블 한개만 연결 
@Data
public class CartVO {
  private int cno,gno,price,account;
  private String id;
  private Date regdate;
  private GoodsVO gvo=new GoodsVO();
}
