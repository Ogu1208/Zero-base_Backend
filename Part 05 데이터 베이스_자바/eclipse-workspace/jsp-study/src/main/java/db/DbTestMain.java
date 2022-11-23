package db;

import java.util.Scanner;

public class DbTestMain {

	public static void main(String[] args) {
		
		MemberService memberService = new MemberService();
		memberService.list();
		
	}
	

	public static void _main(String[] args) {
		MemberService memberService = new MemberService();
//        DBtest.dbSelect();
//        DBtest.dbInsert();
//        DBtest.dbUpdate();
//        DBtest.dbDelete();

		Scanner scanner = new Scanner(System.in);

		String memberType = "email";

		System.out.println("탈퇴할 회원 아이디를 입력해 주세요.");
		System.out.print("아이디 입력 >> ");
		String userId = scanner.next(); // next()는 String을 return

		/*
		 * System.out.print("비밀번호 입력 >> "); String password = scanner.next();
		 * System.out.print("이름 입력 >> "); String name = scanner.next();
		 */

		Member member = new Member();
		member.setMemberType(memberType);
		member.setUserId(userId);
//        member.setPassword(password);
//        member.setName(name);

		memberService.withdraw(member);
	}
}
