package com.sist.music;

import java.io.FileReader;

public class MelonMusic extends MusicSystem{

	@Override
	public void init() {
		// TODO Auto-generated method stub
		try
		{
			FileReader fr=new FileReader("c:\\javaDev\\melon.txt");
			StringBuffer sb=new StringBuffer();
			int i=0;
			while((i=fr.read())!=-1)// 파일의 끝 
			{
				sb.append((char)i);
			}
			fr.close();
			
			// buffer => 임시 기억장소 => 누적 
			String data=sb.toString();
			// String은 문자의 제한이 없다
			String[] mdata=data.split("\n");
			i=0;
			for(String s:mdata)
			{
				//System.out.println(s);
				if(i>50) break;
				
				musics[i]=new Music();
				String[] temp=s.split("\\|");// 정규식 => ^ , $ , . , ? , | , + , *
			    /*
			     *   60|
			     *   사랑은 늘 도망가|
			     *   임영웅|
			     *   신사와 아가씨 OST Part.2
			     *   |
			     *   //image.genie.co.kr/Y/IMAGE/IMG_ALBUM/082/322/594/82322594_1633671778123_1_140x140.JPG/dims/resize/Q_80,0|
			     *   LKQ-18LoFQk\u0026pp=ygUX7IKs656R7J2AIOuKmCDrj4Trp53qsIA%3D

			     */
				musics[i].setMno(temp[0]);
				musics[i].setTitle(temp[1]);
				musics[i].setSinger(temp[2]);
				musics[i].setAlbum(temp[3]);
				musics[i].setPoster(temp[4]);
				i++;
				
			}
		}catch(Exception ex){}
	}

}
