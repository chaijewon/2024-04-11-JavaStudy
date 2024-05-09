package com.sist.vo;

import lombok.Data;

/*
 *   1|
 *   쇼생크 탈출|
 *   드라마|https://movie-phinf.pstatic.net/20160119_278/14531650465287bcuk_JPEG/movie_image.jpg?type=m77_110_2
 *   |팀 로빈스(앤디 듀프레인), 모건 프리먼(엘리스 보이드 레드 레딩)
 *   |2016 .02.24 재개봉, 1995 .01.28 개봉
 *   |15세 관람가|프랭크 다라본트

 */
@Data
public class Movie {
  // 접근지정어 => default => 같은 패키지에서만 접근이 가능 
  private String mno;
  private String title;
  private String genre;
  private String poster;
  private String actor;
  private String regdate;
  private String grade;
  private String director;
  // Movie클래스에서만 사용이 가능=> 다른 클래스에서는 사용이 불가능 
  // => 사용이 가능하게 => 기능을 추가 (변수: 저장 / 값읽기) => getter/setter
}
