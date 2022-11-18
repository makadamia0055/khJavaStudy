package day17;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

import day16.UserManagerService;

public class BoardManagerMain {

	private static Scanner scan = new Scanner(System.in);
	

	public static void main(String[] args) {
		/* 게시글 관리 프로그램을 작성하세요
		 * 1. 게시글 작성
		 * 2. 게시글 조회
		 * 3. 게시글 수정
		 * 4. 게시글 삭제
		 * 5. 프로그램 종료
		 * - 게시글은 번호, 제목, 내용, 작성자, 작성일, 조회수로 구성
		 * - 게시글 전체 조회는 나중에 작성된 게시글이 상단에 조회
		 * - 게시글 상세 조회는 게시글 번호를 입력하여 게시글 내용 확인
		 * - 게시글 상세 조회를 하면 조회수 1 증가
		 * - 게시글 수정은 게시글 번호를 선택하여 제목, 내용을 수정
		 * - 게시글 삭제는 게시글 번호를 선택하면 해당 게시글을 삭제
		 * 
		 * */
		
		day16.UserManagerService UMS = new day16.UserManagerServiceImp();
		
		ArrayList<Post> list = new ArrayList<Post>();
		
		int menu = -1;
		//
		addPost(list, "기러기", "우영우", "기러기 우영우");
		addPost(list, "제목", "master", "내용입니다.");
		addPost(list, "상세조회", "master2", "조회할 게시글 번호 입력");
		addPost(list, "한무무 조아용", "한무무빠", "한무무 개좋은");
		addPost(list, "marvel snap play", "벤브로드", "let's play");
		
		
		
		
		//
		do {
			UMS.printMenu("1. 게시글 작성\n"
					+ "2. 게시글 조회\n"
					+ "3. 게시글 수정\n"
					+ "4. 게시글 삭제\n"
					+ "5. 프로그램 종료");
			menu = UMS.selectMenu(scan, 1, 5);
			
			switch(menu) {
			case 1:
				addPost(list);
							
				break;
			case 2:
				System.out.println("상세 조회할 게시글의 번호를 입력하세요. ");
				
				Post rst = showPost(list, UMS);
				if(rst!=null) {
					System.out.println("조회를 끝내고 첫 화면으로 돌아갑니다.");
				}else {
					System.out.println("해당 번호의 게시글이 없습니다.");
				}
				break;
			case 3: 
				System.out.println("수정할 게시글을 선택해 주세요.");
				rst = showPost(list, UMS);
				if(rst!=null) {
					editPost(rst);
					
					System.out.println("게시물 수정이 완료되었습니다.");
				}else {
					System.out.println("해당 번호의 게시글이 없습니다.");
				}
				
				
				break;
			case 4:
				rst = showPost(list, UMS);
				if(rst!=null) {
					System.out.println("이 글을 삭제하시겠습니까? Y/N");
					char subch = scan.nextLine().charAt(0);
						if(subch=='Y'||subch=='y') {
							list.remove(rst);
							System.out.println("삭제를 완료했습니다.");
							
						}else if(subch=='N'||subch=='n') {
							System.out.println("게시글 삭제를 취소합니다.");
							break;
						}else {
					System.out.println("해당 번호의 게시글이 없습니다.");
						}
						
				} else {
					System.out.println("해당 번호의 게시글이 없습니다.");
					break;
				}
				
				break;
			case 5: 
				System.out.println("프로그램을 종료합니다.");
				break;
				default: System.out.println("잘못된 접근입니다.");
			}
			
			
		}while(menu !=5);
		
		
		
		
		
	}

	private static void editPost(Post rst) {
		System.out.println("게시글을 수정해주십시오");
		System.out.println("제목 : "+ rst.getTitle());
		System.out.print("새로운 제목 : ");
		String newTitle = scan.nextLine();
		System.out.println("작성자 : "+ rst.getAuthor());
		System.out.print("새로운 작성자 : ");
		String newAuthor = scan.next();
		scan.nextLine();
		System.out.println("내용 : "+ rst.getContents());
		System.out.print("새로운 내용 : ");
		String newContents = scan.nextLine();
		rst.setTitle(newTitle);
		rst.setAuthor(newAuthor);
		rst.setContents(newContents+"\n\n---"+rst.setDate()+"에 수정됨---");
		
	}

	private static void addPost(ArrayList<Post> list) {
		System.out.println("게시글을 작성해주십시오.");
		System.out.print("제목 : ");
		String tmpTitle = scan.nextLine();
		System.out.print("작성자 : ");
		String tmpAuthor = scan.next();
		scan.nextLine();
		System.out.println("내용 : ");
		String tmpContents = scan.nextLine();
		Post tmpPost = new Post(tmpTitle, tmpContents, tmpAuthor);
		list.add(tmpPost);
		Post.setOneTotalIndex();
		System.out.println("게시글이 정상적으로 입력되었습니다.");
	}
	/**
	 * 예제 만들기용 오버라이딩
	 * @param list
	 * @param tmpTitle 제목
	 * @param tmpContents 내용
	 * @param tmpAuthor 글쓴이
	 */
	private static void addPost(ArrayList<Post> list, String tmpTitle, String tmpContents, String tmpAuthor) {
		
		Post tmpPost = new Post(tmpTitle, tmpContents, tmpAuthor);
		list.add(tmpPost);
		Post.setOneTotalIndex();
	}
	

	private static Post showPost(ArrayList<Post> list, UserManagerService UMS) {
		Collections.sort(list, Collections.reverseOrder());
		for(Post tmpPost : list) {
			System.out.println(tmpPost);
		}
		
		int subIndex = UMS.selectMenu(scan, 1, Post.getTotalIndex());
		
		Post tmpPost = scanList(list, subIndex);
		if(tmpPost!=null) {
		tmpPost.setViews(1);
		System.out.println("--------------------------------");
		System.out.println(tmpPost);
		System.out.println("내용 : "+tmpPost.getContents());
		System.out.println("--------------------------------");
		return tmpPost;
		} else {
			return null;
			
		}
	}

	private static Post scanList(ArrayList<Post> list, int subIndex) {
		Iterator<Post> it = list.iterator();
		while(it.hasNext()) {
			Post tmpPost = it.next();
			
			if(tmpPost.getIndex()==subIndex) {
				return tmpPost;
			}else {
			
			}
	
		}
		return null;
		
		
	}

}
