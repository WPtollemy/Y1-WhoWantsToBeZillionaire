package mainPackage;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuestionTest {

	@Test
	public void testGetAnswer() {
		Question testQuestion = new Question();
		testQuestion.setAnswerThree("test answer");
		
		assertEquals("test answer", testQuestion.getAnswer(2));
	}
}
