package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import dto.AddressDto;
import singleton.Singleton;

public class FileProc {

	private File file = null;
	
	public FileProc(String filename) {
		file = new File("c:\\tmp\\" + filename + ".txt");
		
		try {
			if(file.createNewFile()) {
				System.out.println("파일 생성 성공!");
			}else {
				System.out.println("파일 생성 실패~");
			}
		} catch (IOException e) {			
			e.printStackTrace();
		}		
	}
	
	public void write() {
		
		Singleton s = Singleton.getInstance();
		
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			
			for (int i = 0; i < s.addressList.size(); i++) {
				AddressDto dto = s.addressList.get(i); 
				pw.println(dto.print());
			}
			
			pw.close();
			
		} catch (IOException e) {			
			e.printStackTrace();
		}	
		
		System.out.println("파일에 저장되었습니다");
	}
	public void read() {
		Singleton s = Singleton.getInstance();
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String str ="";
			
			while((str = br.readLine()) !=null) {
				//System.out.println(str);
				
				String split[] = str.split("-");
				
				AddressDto dto = new AddressDto(split[0],Integer.parseInt(split[1]),split[2],split[3],split[4]);
				s.addressList.add(dto);
				System.out.println(dto);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("데이터를 모두 읽어드립니다.");
	}
}
