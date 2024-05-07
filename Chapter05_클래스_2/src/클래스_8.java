// 초기화 블록 사용법 
/*
 *   <ul class="common_sp_list_ul ea4" style="padding:0 0 0 8px;">
 *   <li class="common_sp_list_li">
                <div class="common_sp_thumb">
                    <a href="/recipe/7013562" class="common_sp_link">
                                                <img src="https://recipe1.ezmember.co.kr/cache/recipe/2023/11/14/ec47f478f8f7e5f900df69bedc108cb41_m.jpg">
                    </a>
                </div>
                <div class="common_sp_caption">
                    <div class="common_sp_caption_tit line2">새송이버섯볶음 간장버섯조림 어린이 밑반찬</div>
                    <div class="common_sp_caption_rv_name" style="display: inline-block; vertical-align: bottom;">
                        <a href="/profile/recipe.html?uid=16713232"><img src="https://recipe1.ezmember.co.kr/cache/rpf/2023/08/04/14e5112b18cc05d622094d2d21b6d60b1.f60bc376173010d6e30cb73d0c923c9a">뚜루</a>
                    </div>
                    <div class="common_sp_caption_rv">
                                                    <span class="common_sp_caption_rv_star"><img src="https://recipe1.ezmember.co.kr/img/mobile/icon_star2_on.png"><img src="https://recipe1.ezmember.co.kr/img/mobile/icon_star2_on.png"><img src="https://recipe1.ezmember.co.kr/img/mobile/icon_star2_on.png"><img src="https://recipe1.ezmember.co.kr/img/mobile/icon_star2_on.png"><img src="https://recipe1.ezmember.co.kr/img/mobile/icon_star2_on.png"></span>
                            <span class="common_sp_caption_rv_ea">(4)</span>
                                                <span class="common_sp_caption_buyer" style="vertical-align: middle;">조회수 8,796</span>
                    </div>
                </div>
            </li>
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

class Recipe2
{
	String title;
	String chef;
	String hit;
}
class RecipeSystem
{
	Recipe2[] recipes=new Recipe2[40]; //선언만 가능 => 외부에서 읽기(X) => 구현 
	
	//초기화 블록 => 생성자 => 외부에서 데이터를 얻는 경우 / 파일 데이터 읽기 
	{
		// 배열에 데이터 초기화 
		// class => selector => CSS 구분 (태그/class/id) 디자인  
		try
		{
			Document doc=Jsoup.connect("https://www.10000recipe.com/recipe/list.html").get(); // doc안에 모든 데이터가 저장된다 
			// 문서저장 클래스 => HTML을 저장 
			//System.out.println(doc.toString());
			
			Elements title=doc.select("ul.common_sp_list_ul li.common_sp_list_li div.common_sp_caption_tit");
			//System.out.println(title);
			// Element => 태그 <div> => 여러개 Elements 
			Elements chef=doc.select("ul.common_sp_list_ul li.common_sp_list_li div.common_sp_caption_rv_name");
			Elements hit=doc.select("ul.common_sp_list_ul li.common_sp_list_li span.common_sp_caption_buyer");
		
		    for(int i=0;i<title.size();i++)
		    {
		    	//size=> length
		    	recipes[i]=new Recipe2();
		    	recipes[i].title=title.get(i).text();
		    	recipes[i].chef=chef.get(i).text();
		    	recipes[i].hit=hit.get(i).text();
		    }
		}catch(Exception ex) {}  // 네트워크 , 서버 연결 , 파일 읽기 => 반드시 예외 처리 
		// 네트워크 (URL) => 웹서버 연결후 저장된 데이터 가지고 오기 => 웹 크롤링 
		// 예외 처리 => 8장 
		// 초기화 블록은 JVM에 의해 자동으로 호출 
	}
}
public class 클래스_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        RecipeSystem rs=new RecipeSystem();
        int i=1;
        for(Recipe2 r:rs.recipes)
        {
        	System.out.println("레시피번호:"+i);
        	System.out.println("레시피명:"+r.title);
        	System.out.println("쉐프명:"+r.chef);
        	System.out.println(r.hit);
        	System.out.println("=======================================");
        	i++;
        }
	}

}
