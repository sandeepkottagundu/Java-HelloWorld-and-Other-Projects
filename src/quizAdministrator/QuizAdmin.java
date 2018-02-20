package quizAdministrator;

import java.io.IOException;

public class QuizAdmin {

	public static void main(String[] args) {
		Quizzer q;
		try {
			q = new Quizzer("C:\\Users\\Stefanie\\workspace\\HelloWorld\\src\\quizAdministrator\\quiz.txt");
			q.startTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
