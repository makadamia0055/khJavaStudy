package day11;

public class StringEx03 {
	public static void main(String[] args) {
		/*
		 * 주어진 파일명들 중에서 이미지 파일들을 찾아 파일명을 출력하세요.
		 * 이미지 파일 확장자는 jpg, png
		 */
		String[] list = { 
				"이미지1.jpg", "음악1.bmp", "이미지2.mp4", "이미지3.png", "jpg.mp3", "예제.txt"
		};
		//반복문
			//확장자 추출	
			//확장자가 이미지 확장자인지 확인하여 맞으면 파일명 추출
		
		//ex1) 
		for(String tmp : list) {
			if(tmp.contains("jpg")||tmp.contains("png")) {
				System.out.println(tmp);
			} // 파일 명이 jpg일 수 있기 때문에 이 예제는 잘못됨.
		}
		System.out.println("--------------");
		for(String tmp2 : list) {
			
			String tmpext = tmp2.substring(tmp2.lastIndexOf(".")+1);
			if(tmpext.equals("jpg")||tmpext.equals("png")) {
				System.out.println(tmp2);
			}
		}
		
		
		
	}

}
