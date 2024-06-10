package com.sist.dao;
import java.util.*; // 오라클 데이터형 => DATE => java.util.Date

import lombok.Data;
@Data
public class EmpVO {
   private int empno;
   private String ename,job;
   private Date hiredate;
   private int sal,mgr,comm,deptno;
   // 부서 정보 => JOIN
   private DeptVO dvo=new DeptVO(); // 포함 클래스를 만든다 
   /*
    *   private int deptno;
        private String dname,loc;
    */
   
}
