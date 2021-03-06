package lab2;
import java.util.Random;
public class Lab2
{

	public static void main(String[] args)
	{

		PromptQ();
		int NumOQ = Integer.parseInt(System.console().readLine());
		
		StartingPhrase();
		
		Random random1 = new Random();
		int SCORE = 0;
		for (int x=0; x<NumOQ;x++)
		{
			// randomly generating question with it's answer.
			int index = random1.nextInt(20);
			String question = FULL_NAMES[index];
			String correct_answer = SHORT_NAMES[index];
			
			System.out.println(question);
			
			// timing user input time costs.
			double start = System.currentTimeMillis();
			String user_answer = System.console().readLine().toUpperCase();
			double end = System.currentTimeMillis();
			
			double MILLISECS_IN_SEC = 1000;
			double UsedTime = (end-start)/MILLISECS_IN_SEC;
			
			
			System.out.println(user_answer);
			

			if(user_answer.equals("QUIT"))
			{
				break;
			}
			
			else if(user_answer.equals(correct_answer))
			{
				++SCORE;
				CorrectInput(SCORE, UsedTime);
			}
			
			else
			{
				FalseInput(correct_answer, SCORE, UsedTime);
			}
	
		}

		EndingPhrase(SCORE,NumOQ);

	}
	
	
	
	
	/**
	 * informing quiz is starting.
	 */
	public static void StartingPhrase()
	{
		System.out.println("\n\nQuiz starts now: ");
	}
	
	/**
	 * taking in user input for numbers of question.
	 */
	public static void PromptQ()
	{
		System.out.println("How many sets of questions would you like to have?: ");
	}
	
	/**
	 * returning feedback for right user answer.
	 * @param b current score
	 * @param c time used for user input
	 */
	public static void CorrectInput(int b, double c)
	{
		System.out.println("Right. Score = "+ b + "; seconds = " + c + "\n\n");
	}
	
	/**
	 * returning feedback for false user answer.
	 * @param d the correct answer
	 * @param e current score
	 * @param f time used for user input
	 */
	public static void FalseInput(String d, int e, double f)
	{
		System.out.println("Wrong. should be " + d + "; Score = " + e + "; seconds = " + f + "\n\n");
	}
	
	/**
	 * inform quiz ends and returning final score.
	 * @param g final score
	 * @param h total score
	 */
	public static void EndingPhrase(int g, int h)
	{
		System.out.println("Quiz ended with score of " + g +" out of " + h);
	}
	
	public static String[] SHORT_NAMES = 
		{ "A","R", "N", "D", "C", "Q", "E", 
		"G",  "H", "I", "L", "K", "M", "F", 
		"P", "S", "T", "W", "Y", "V" };
	
	public static String[] FULL_NAMES = 
		{
		"alanine","arginine", "asparagine", 
		"aspartic acid", "cysteine",
		"glutamine",  "glutamic acid",
		"glycine" ,"histidine","isoleucine",
		"leucine",  "lysine", "methionine", 
		"phenylalanine", "proline", 
		"serine","threonine","tryptophan", 
		"tyrosine", "valine"};
}
