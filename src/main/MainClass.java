package main;

import java.io.File;
import java.util.Scanner;

import dao.AddressDao;
import file.FileProc;

public class MainClass {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		AddressDao dao = new AddressDao();
		FileProc fp = new FileProc("addressbook");
		// 메뉴
		// file 
		
		boolean on = false;
		while(!on) {
			System.out.println("address book menu -----------");
			System.out.println("1. 주소추가");
			System.out.println("2. 주소삭제");
			System.out.println("3. 주소검색");
			System.out.println("4. 주소수정");
			System.out.println("5. 모두출력");
			System.out.println("6. 종료");
			System.out.println("7. 파일저장");
			System.out.println("8. 파일출력");
			
			System.out.print("menu number >>");
			int menuNumber = sc.nextInt();
			
			switch (menuNumber) {
			case 1:
				dao.insert();
				break;
			case 2:
				dao.delete();
				break;
			case 3:
				dao.select();
				break;
			case 4:
				dao.update();
				break;
			case 5:
				dao.allDataPrint();
				break;
			case 6:
				System.out.println("종료합니다");
				on = true;
				break;
			case 7:
				fp.write();
				break;
			case 8:
				fp.read();
				break;
			default:
				System.out.println("다시입력해주세요");
				continue;
			}
		}
	}
}
