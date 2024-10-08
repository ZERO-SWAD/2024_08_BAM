import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		System.out.println("== 프로그램 시작 ==");
		
		Scanner sc = new Scanner(System.in);
		int lastArticleId = 0;
		
		List<Article> articles = new ArrayList<Article>();
		
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
				if(articles.size() == 0) {
					System.out.println("게시글이 없습니다.");
				}
				else {
					System.out.printf("게시글이 %d개 있습니다.\n", lastArticleId);
					System.out.println("번호\t/ 제목");
					for(int i = articles.size() - 1; i >= 0; i--) {
						Article article = articles.get(i);
						System.out.printf(" %d\t/ %s\n", article.id, article.title);
					}
				}
			}
			else if(command.equals("article write")) {
				int id = lastArticleId + 1;
				System.out.printf("제목 : ");
				String title = sc.nextLine();
				System.out.printf("내용 : ");
				String body = sc.nextLine();
				
//				System.out.println("입력된 제목 : " + title);
//				System.out.println("입력된 내용 : " + body);
				
				Article article = new Article(id, title, body);
				articles.add(article);
				
				System.out.printf("%d번 글이 생성되었습니다.\n", id);
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

class Article {
	int id;
	String title;
	String body;
	
	Article(int id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
	}
}
