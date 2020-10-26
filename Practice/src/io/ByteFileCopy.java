package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteFileCopy {

	public static void main(String[] args) throws IOException {
		
		InputStream in = new FileInputStream("org.pdf");
		OutputStream out = new FileOutputStream("org_copy.pdf");
		
		int copyByte = 0;	// 복사한 사이즈
		// int bData = 0;		// 원본에서 복사한 byte 사이즈의 데이터
		
		byte[] buf = new byte[1024]; // 1kb 버퍼 생성
		int readLength = 0;
		
		System.out.println("복사를 시작합니다.");
		
		while(true) {
			// bData = in.read();
			readLength = in.read(buf);
			
			// if(bData==-1) {	// 더 이상 가져올게 없으면 -1 반환
			if(readLength==-1) { 
			break;
			}
			// out.write(bData); // 출력 : 파일에 바이너리 코드를 쓴다. 
			out.write(buf, 0, readLength);
			copyByte += readLength;
		}
		
		in.close();	// 스트링 인스턴스 소멸
		out.close();
		
		System.out.println("복사 완료");
		System.out.println("복사된 사이즈 : " +copyByte +"byte");

	}

}
