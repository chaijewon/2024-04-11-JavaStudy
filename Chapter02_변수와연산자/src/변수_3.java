/*
 *   국어 영어 수학 => 총점 / 평균 / 학점 (ABCDF)
 */
public class 변수_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int kor=90;
        int eng=80;
        int math=75;
        int total=kor+eng+math;
        double avg=total/3.0;
        // 정수/정수=정수 
        System.out.println("국어 점수:"+kor);
        System.out.printf("평균:%.2f",avg);// 반올림 
        //  ==> 소수점 위치 
	}

}
