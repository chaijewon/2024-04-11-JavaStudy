// 벤치마킹 => 프로그램에 맞는 데이터만 설정 => 메소드 설정 
/*
 *   프로젝트 
 *    => 모방 CGV 
 *    => 불편한 부분 / 추가되는 내용
 *                   | 카페/술집/맛집  
 *       --------------------
 *    => 캠핑장 예약 
 *       -------- 맛집 / 레시피 
 *    => 맛집 
 *       -------- 근처 공원, 명소 , 여행지 ..
 *    => 잡포털 
 *       -------- 자소서 쓰는 요령 
 *    
 */
class Recipe
{
	// 멤버변수 
	String title;
	String chef;
	String star;
	int hit;
	// 변수는 배열 / 클래스 
	int[] reserve= {13,14,15,20,25};
	// Reply r; => 댓글 
}
// 레시피가 많은 경우 
// Recipe[] repcipes=new Recipe[200]; => 데이터형이라 배열 사용이 가능 ...
// 사용자 정의 데이터형 => 배열 / 형변환 => 일반 변수와 동일하게 취급 
public class 클래스_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Recipe r1=new Recipe();
        r1.title="도시락 반찬으로 최고! 스팸감자조림♡";
        r1.chef="냠냠간단요리";
        r1.star="★★★★★";
        r1.hit=46000;
        System.out.println("레시피명:"+r1.title);
        System.out.println("쉐프명:"+r1.chef);
        System.out.println("별점:"+r1.star);
        System.out.println("조회수:"+r1.hit);
        System.out.println("예약 가능한 날");
        for(int i:r1.reserve)
        {
        	System.out.print(i+" ");
        }
	}

}
