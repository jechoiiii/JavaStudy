package io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileWriterStream {
	
	public static void main(String[] args) throws IOException {
		
		// 파일 생성
		Writer out = new FileWriter("paper.text");
		
		out.write('A');
		out.write('B');
		out.append('C');
		
		out.close();
		System.out.println("파일 생성 완료");
		
	}
	
}
