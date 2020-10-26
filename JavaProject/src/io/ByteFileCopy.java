package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteFileCopy {
 
	public static void main(String[] args) throws IOException {
		
		// 읽어올 대상 파일의 InputStream 인스턴스 생성
		InputStream in = new FileInputStream("org.pdf");
		// 출력 대상 파일의 OutputStream 인스턴스 생성
		OutputStream out = new FileOutputStream("org_copy.pdf");
		// 해당 경로의 파일이 존재하지 않으면 파일을 생성해서  write
		// 해당 경로에 파일이 존재하면 덮어쓴다. 
		
		int copyByte=0; // 복사한 사이즈
		int bData=0;	// 원본에서 복사한 byte 사이즈의 데이터
		
		byte[] buf = new byte[1024];	// 1kb 버퍼 생성
		int readLength = 0;
		
		System.out.println("복사를 시작합니다.");
		
		while(true) {
			// bData = in.read();
			readLength = in.read(buf); // 더 이상 가져올 데이터 없으면 -1 반환
			
			// if(bDat==-1)
			if(readLength==-1) {
				break;
			}
			// out.write(bData);	// 출력 : 파일에 바이너리 코드를 쓴다. 
			out.write(buf, 0, readLength);
			copyByte += readLength;
		}
		
		in.close(); // 스트링 인스턴스 소멸
		out.close();
		
		System.out.println("복사가 완료되었습니다.");
		System.out.println("복사된 사이즈 : " + copyByte + "byte");
	}
}
