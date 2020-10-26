package io;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class PrintWriterStream {

	public static void main(String[] args) throws IOException {

		PrintWriter out = new PrintWriter(new FileWriter("print.txt"));
	
		out.printf("안녕하세요. 저는 %d살 %s 입니다.", 12, "철수");
		out.println();
		out.print("저는 자바를 좋아합니다.");
		out.println("IO 재미있어요.");
		out.close();
		
		System.out.println("파일 작성 완료");
		
		

	}

}
