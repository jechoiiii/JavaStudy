package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Buffered {

	public static void main(String[] args) throws IOException {
		
		InputStream in = new FileInputStream("org.pdf");
		OutputStream out = new FileOutputStream("org_copy.pdf");
		// 해당 경로의 파일 존재하지 않으면 파일을 생성해서 write
		// 해당 경로의 파일 존재하면 덮어쓴다.
		
		// 필터스트림 인스턴스 생성
		BufferedInputStream bin = new BufferedInputStream(in, 1024*3);
		BufferedOutputStream bout = new BufferedOutputStream(out, 1024*3);
		
		int copyByte = 0;	// 복사한 사이즈
		int bData = 0;		// 원본에서 복사한 byte 사이즈의 데이터
		
		System.out.println("복사를 시작합니다.");
		
		while(true) {
			bData = in.read();
			
			if(bData==-1) {	// 더 이상 가져올게 없으면 -1 반환
				break;
			}
			out.write(bData); // 출력 : 파일에 바이너리 코드를 쓴다. 
		}
		
		in.close();	// 스트링 인스턴스 소멸
		out.close();
		
		System.out.println("복사 완료");
		System.out.println("복사된 사이즈 : " +copyByte +"byte");

	}

}
