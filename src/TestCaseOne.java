
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TestCaseOne {
	
	public static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	public static void main(String args[]) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = -50; i < 50; i++) {
			list.add(i);
		}
		Collections.shuffle(list);
		
		try {
			File name = new File("testcase1000000.txt");
			name.createNewFile(); // 创建新文件
			BufferedWriter out = new BufferedWriter(new FileWriter(name));
			Random rand = new Random();
			for(int i = 0;i< 1000000;i++){
			    int randomNum = rand.nextInt((100 - -50) + 1) + -50;
			    System.out.println(randomNum);
			    out.write(randomNum + "\t");
			}
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}