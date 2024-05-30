package com.sist.ann;

public class BoardSystem {
   @RequestMapping("insert.jsp")
   public void boardInsert()
   {
	   System.out.println("오라클에 데이터 추가");
   }
   @RequestMapping("update.jsp")
   public void boardUpdate()
   {
	   System.out.println("오라클에 데이터 수정");
   }
   @RequestMapping("delete.jsp")
   public void boardDelete()
   {
	   System.out.println("오라클에 데이터 삭제");
   }
   @RequestMapping("select.jsp")
   public void boardSelect()
   {
	   System.out.println("오라클에 데이터 읽기");
   }
   @RequestMapping("find.jsp")
   public void boardFind()
   {
	   System.out.println("오라클에 데이터 검색");
   }
}
