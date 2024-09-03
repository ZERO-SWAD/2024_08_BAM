import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		System.out.println("== 프로그램 시작 ==");
		
		Scanner sc = new Scanner(System.in);
		int lastArticleId = 0;
		
		while(true) {
			System.out.printf("명령어 > ");
			String command = sc.nextLine();
			
			if (command.length() == 0) {
				System.out.println("명령어가 입력되지 않았습니다.");
				continue;
			}
			
			if(command.equals("exit")) {
				break;
			}
			
			if(command.equals("article list")) {
				if(lastArticleId > 0) {
					System.out.printf("게시글이 %d개 있습니다.\n", lastArticleId);
				}
				else {
					System.out.println("게시글이 없습니다.");
				}
			}
			else if(command.equals("article write")) {
				int count = lastArticleId + 1;
				System.out.printf("제목 : ");
				String title = sc.nextLine();
				System.out.printf("내용 : ");
				String body = sc.nextLine();
				
//				System.out.println("입력된 제목 : " + title);
//				System.out.println("입력된 내용 : " + body);
				
				System.out.printf("%d번 글이 생성되었습니다.\n", count);
				lastArticleId++;
			}
			else {
				System.out.println("존재하지 않는 명령어입니다.");
				continue;
			}
		}
		
		System.out.println("== 프로그램 종료 ==");
		
		sc.close();
	}
}
