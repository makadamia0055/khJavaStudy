package day28;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import lombok.Data;

@Data
public class PostManager implements Serializable{
	private ArrayList<Post> postList = new ArrayList<Post>();
	private ArrayList<String> Sort = new ArrayList<String>(Arrays.asList("공지", "자유"));
	
	
	
	public void deletePost(Client client) {
		Scanner scan = new Scanner(System.in);
		System.out.println("삭제할 글의 번호를 입력해 주십시오.");
		int editNum = scan.nextInt();
		if(postList.get(editNum)==null) {
			System.out.println("해당 번호의 글이 없습니다.");
			return ;
		}
		if(!client.getId().equals(postList.get(editNum).getAuthor())&&!Viewer.verifiedMaster(client)) {
			System.out.println("글 작성자만이 수정/삭제 할 수 있습니다.");
			return;
		}
		char yn = 'a';
		do {
		System.out.println("정말로 삭제하시겠습니까? Y/N");
		yn = scan.next().toUpperCase().charAt(0);
		if(yn=='Y') {
			
			postList.remove(editNum);
			System.out.println("삭제를 완료했습니다.");
		}else if(yn=='N') {
			System.out.println("취소하고 메뉴로 돌아갑니다.");
			return;
		}else {
			System.out.println("올바른 값을 입력하십시오.");
		}
		}while(yn!='Y'&&yn!='N');
		
	}
	
	
	public void editPost(Client client) {
		Scanner scan = new Scanner(System.in);
		System.out.println("수정할 글의 번호를 입력해 주십시오.");
		int editNum = scan.nextInt();
		if(postList.get(editNum)==null) {
			System.out.println("해당 번호의 글이 없습니다.");
			return ;
		}
		if(!client.getId().equals(postList.get(editNum).getAuthor())&&!Viewer.verifiedMaster(client)) {
			System.out.println("글 작성자만이 수정/삭제 할 수 있습니다.");
			return;
		}
		char yn = 'a';
		do {
		System.out.println("정말로 수정하시겠습니까? Y/N");
		yn = scan.next().toUpperCase().charAt(0);
		if(yn=='Y') {
			System.out.print("분류 : ");
			for(String tmp :Sort) {
				System.out.print(tmp + "/");
			}
			System.out.println();
			String sort;
			do {
				sort = scan.next();
			if(Sort.contains(sort)) {
				break;
			}
				System.out.println("카테고리를 정확히 입력해 주십시오.");
			}while(true);	
				
			scan.nextLine();
			System.out.println("제목 : ");
			String title = scan.nextLine();
			System.out.println("내용 : ");
			String contents = scan.nextLine();
			
			Post tmp = new Post(sort, title, contents, client, getSize(), postList.get(editNum).getView());
			postList.set(editNum, tmp);
			System.out.println("수정을 완료했습니다.");
		}else if(yn=='N') {
			System.out.println("취소하고 메뉴로 돌아갑니다.");
			return;
		}else {
			System.out.println("올바른 값을 입력하십시오.");
		}
		}while(yn!='Y'&&yn!='N');
		
	}
	
	public void addPost(Client client) {
		Scanner scan = new Scanner(System.in);
		System.out.print("분류 : ");
		for(String tmp :Sort) {
			System.out.print(tmp + "/");
		}
		System.out.println();
		String sort;
		do {
			sort = scan.next();
		if(Sort.contains(sort)) {
			break;
		}
			System.out.println("카테고리를 정확히 입력해 주십시오.");
		}while(true);	
		scan.nextLine();
		System.out.println("제목 : ");
		String title = scan.nextLine();
		System.out.println("내용 : ");
		String contents = scan.nextLine();
		
		Post tmp = new Post(sort, title, contents, client, getSize());
		postList.add(tmp);
		
	}
	public void printPostTitle() {
		System.out.println("--------------------------");
		if(postList==null||postList.size()==0) {
			System.out.println("등록된 게시글이 없습니다.");
		}else {
			for(Post tmp : postList) {
				System.out.printf("%2d번 %s : %s \t view : %d\n", tmp.getNum(), tmp.getAuthor(), tmp.getTitle(), tmp.getView());
			}
		}
		System.out.println("--------------------------");
		
	}
	
	public int getSize() {
		if(postList==null||postList.size()==0) {
			return 0;
		}else {
			return postList.size();
		}
			
	}
	public void print(int index) {
		if(postList.get(index)==null) {
			System.out.println("해당 게시글이 없습니다.");
		}else {
			postList.get(index).setView(+1);
			System.out.println("---------------------");
			System.out.println();
			System.out.println(postList.get(index).getNum()+"번 -" +postList.get(index).getSort()+ "- 조회수 " + postList.get(index).getView());
			System.out.println("작성자 : " + postList.get(index).getAuthor());
			System.out.println("제목 : " + postList.get(index).getTitle());
			System.out.print("내용 : ");
			System.out.println(postList.get(index).getContents());
			System.out.println();
			System.out.println("---------------------");
		}
	}
	
}
