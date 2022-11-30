package weekend_homework3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import lombok.Data;

@Data
public class PostManager implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 221217547999939984L;

	private ArrayList<Post> list = new ArrayList<Post>();
	private static int postLatestNum ;
	private Client user;
	
	
	
	public void addPost( Client client) throws Exception  {
		if(!Client.checkVerified(client)) {
			System.out.println("비회원은 글의 작성과 수정이 불가능합니다.");
			return;
		} else {
			Scanner scan = new Scanner(System.in);
			Member verfiedMem = (Member)client;
			Post tmp =makePost(scan, verfiedMem);
			
			postLatestNum++;
			list.add(tmp);
		
		}
	}
	
	private Post makePost(Scanner scan, Member verfiedMem) {
		System.out.println("글의 분류를 기입하여 주십시오");
		System.out.println("분류 : (공지사항/잡담/질의응답/건의사항)");
		postSort sort = postSort.valueOf(scan.next());
		
		System.out.println("제목을 기입해 주십시오");
		System.out.println("제목 : ");
		scan.nextLine();
		String title = scan.nextLine();
		
		System.out.println("내용을 기입해 주십시오");
		System.out.println("내용 : ");
		String contents = scan.nextLine();

		
		return new Post(sort, title, verfiedMem.getId(), contents);
	}

	public static int getPostLatestNum() {
		return postLatestNum;
	}

	// 게시글 열람시 내 글이면 수정 삭제 메뉴 뜨게 하기
	
	public void printPage(int page, ArrayList<Post> list){
		if(list==null||list.size()==0) {
			System.out.println("아직 게시글이 없습니다.");
			return ;
		}
		
		Collections.sort(list, Collections.reverseOrder());
		ArrayList<Post> tmpList = new ArrayList<Post>();
		for(int i = 0; i<(list.size()-page*10); i++) {
			tmpList.add(list.get(i+page*10));				
		}
		System.out.println();
		System.out.println("------------------");
		for(Post tmp : tmpList) {
			System.out.printf("%s %02d번 %s 글쓴이 : %s view : %d\n", tmp.getSort(), tmp.getNum(), tmp.getTitle(),tmp.getAuthor(), tmp.getViews());
		
		}
		System.out.println("------------------");
		System.out.println();
	}
	
	public void printMenu(int page) {
		System.out.println("게시판 접속");
		System.out.println("1. 게시글 열람");
		System.out.println("2. 게시글 쓰기");
		if(page>0)
			System.out.println("3. 이전 페이지 가기");
		if(list.size()-page*10>10)
			System.out.println("4. 다음 페이지 가기");
		System.out.println("5. 게시글 내용 검색 ");
		System.out.println("6. 게시글 글쓴이 검색");
		System.out.println("7. 뒤로 가기");
	}
	
	public void runMenu(int menu, int page, Client client) {
		Scanner scan = new Scanner(System.in);
		printPage(page, list);
		switch(menu) {	
			case 1: System.out.println("열람할 게시글 번호를 입력");
					int num = scan.nextInt();
					scan.nextLine();
					if(list.size()>=num&&list.get(num)!=null) {
						list.get(num).setViews(+1);
						printPost(num, client, list);
					}
					
			break;
			case 2: try {
				addPost(client);
			} catch (Exception e) {
				e.printStackTrace();
			} break;
			case 3:
				page = (page>=1)?page-1:page;	
				break;
			case 4: 
				page = (list.size()-page*10>10)?page+1:page; 
				break;
			case 5: searchPost(scan, client); 
				break;
			case 6: searchPostByAuthor(scan, client);
				break;
			case 7: break;
			default: System.out.println("잘못된 메뉴입니다.");
		
		}
	}

	private void searchPost(Scanner scan, Client client) {
		System.out.println("검색할 문자열을 입력해주세요.");
		String tmp = scan.nextLine();
		ArrayList<Post> searchList = new ArrayList<Post>();
		searchList.removeAll(searchList);
		for(Post tmpPost : list) {
			if(tmpPost.getTitle().contains(tmp)||tmpPost.getContents().contains(tmp)) {
				searchList.add(tmpPost);
			}
		}
		if(searchList.size()!=0) {
			System.out.println("총 "+searchList.size()+"개의 포스트를 찾았습니다.");
			for(Post tmpPost : searchList) {
				printPage(0, searchList);
				int tmpIndex = scan.nextInt();
				printPost(tmpIndex, client, list);
			}
		}else {
			System.out.println("검색 결과가 없습니다.");
		}

		
	}
	private void searchPostByAuthor(Scanner scan, Client client) {
		if(list==null||list.size()==0) {
			System.out.println("작성된 게시글이 없습니다.");
			return ;
		}
		System.out.println("검색할 문자열을 입력해주세요.");
		String tmp = scan.nextLine();
		ArrayList<Post> searchList = new ArrayList<Post>();
		searchList.removeAll(searchList);
		for(Post tmpPost : list) {
			if(tmpPost.getAuthor().contains(tmp)) {
				searchList.add(tmpPost);
			}
		}
		if(searchList.size()!=0) {
			System.out.println("총 "+searchList.size()+"개의 포스트를 찾았습니다.");
			for(Post tmpPost : searchList) {
				printPage(0, searchList);
				int tmpIndex = scan.nextInt();
				printPost(tmpIndex, client, list);
			}
		}else {
			System.out.println("검색 결과가 없습니다.");
		}

		
	}

	private void printPost(int num, Client client, ArrayList<Post> list) {
		System.out.println("분류 : "+ list.get(num).getSort()+"번호 : "+ list.get(num).getNum());
		System.out.println("작성자 : "+list.get(num).getAuthor());
		System.out.println("제목 : "+ list.get(num).getTitle());
		System.out.println("------------------------------------");
		System.out.println("내용 : " + list.get(num).getContents());
		System.out.println("------------------------------------");
		System.out.println("열람 횟수 :" + list.get(num).getViews());
		if(client instanceof Qualifiable) {
			Member tmp = (Member)client;
			if(tmp.getId()==list.get(num).getAuthor()) {
				System.out.println("1. 돌아가기");
				System.out.println("2. 수정");
				System.out.println("3. 삭제");
				System.out.println("--------------");
				Scanner scan = new Scanner(System.in);
				int menu = scan.nextInt();
				switch(menu) {
				case 1: break;
				case 2: list.add(num, makePost(scan, tmp));
					System.out.println("포스트 수정이 완료되었습니다.");
					break;
				case 3: list.remove(num);
					System.out.println("포스트 삭제가 완료되었습니다.");
					break;
					default:
					
				}
			}
		}
		
	}
	
	
	
	
	
	

	public void run(Client user) {
		Scanner scan = new Scanner(System.in);
		setUser(user);
		postLatestNum = (list.size()!=0)?list.size()-1:0;
		int page = 0;
		int menu = -1;
		do {
		printPage(page, list);
		printMenu(page);
		 menu = scan.nextInt();
		runMenu(menu, page, user);
		}while(menu!=7);

	}
	
}
