package io;

import java.io.File;

public class FileMove {

	public static void main(String[] args) {
		// File 클래스는 경로를 저장 -> 파일/폴더의 속성 변경/삭제 생성 가능
		// 파일의 경로, 폴더의 경로
		
		// 현재 존재하는 파일의 경로 생성
		File myFile = new File("c:\\maJava\\ma.bin");
		
		if(!myFile.exists()) {
			System.out.println("원본 파일이 준비되어 있지 않음.");
			return;
		}
		System.out.println("파일 존재!!");
		
		File reDir = new File("c:\\urJava");
		reDir.mkdir();	// 해당 경로에 폴더 존재하면 유지, 없으면 폴더 생성
		System.out.println("폴더 생성 성공!!");
		
		// 파일 이동할 새 경로 생성
		File reFile = new File(reDir, "ur.bin");
		
		System.out.println("파일 존재 유무 : "+ reFile.exists());
		
		// 파일 이동
		myFile.renameTo(reFile);

		if(reFile.exists()) {
			System.out.println("파일 이동 성공!!");
		} else {
			System.out.println("파일 이동 실패!!");
		}
		
	}

}
