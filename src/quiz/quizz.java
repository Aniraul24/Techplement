package quiz;
import java.util.*;
public class quizz 
{
	private static Map<String ,List<ques>> quizes = new HashMap<>();//create map to store quiz for topics
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		boolean running = true;
		while(running)
		{
			// Main page for quizz app
			System.out.println("Welcome to quiz generator");
			System.out.println("1.Create quiz");
			System.out.println("2.Take quiz");
			System.out.println("3.quit \n");
			
			
			System.out.println("CHOOSE THE OPTION");
			int choice=sc.nextInt();
		   switch(choice)
		   {
		   case 1: 
			   createquiz();
		        break;
		   case 2: 
			   takequiz();
		        break;
		   
		   case 3: 
			    running=false;
			    System.out.println("Exiting the program...");
		        break;
		    default : System.out.println("Enter valid value");
		   }
		}
		sc.close(); 
	}
	
	private static void createquiz() 
	{
		//Giving topic name
		Scanner sc = new Scanner(System.in);
		System.out.println("Give the Topic name");
		String topic =sc.nextLine();
		String addmore;
		
		//making list for questions
		List <ques> questions = new ArrayList<>();
		
		do
		{
			System.out.println("TOPIC NAME : "+topic +"\n");
			System.out.println("Enter the question");
			String qutxt=sc.nextLine();
			List<String> strop = new ArrayList<>();//list for options
			
			for(int i=1 ; i<=4 ; i++)
			{
				System.out.println("option" + i);
				strop.add(sc.nextLine());
			}
			System.out.println("Enter the correct option[1-4]");
			int correctoption= sc.nextInt();// entering correct options
			sc.nextLine();
			
			questions.add( new ques(qutxt,strop,correctoption));//adding question , option , correct option
			
			System.out.println("Are you want to add new question yes/No");
			addmore = sc.nextLine();
			 
	    
		}while(addmore.equalsIgnoreCase("yes"));
		quizes.put(topic,questions);//put the quiz in map 
		System.out.println("QUIZ CREATED SUCCESSFULLY !!!!");
	}
	
	
	private static void takequiz() 
	{
		//check  if quiz is there or not
		Scanner sc =new Scanner(System.in);
		if(quizes.isEmpty())
		{
			System.out.println("Quiz not found");
			return;
		}
		
		//display the available topics
		System.out.println("Quiz Available");
		int index=1;
		for(String topic : quizes.keySet())// retrieve key value ie topics
		{
			System.out.println(index++ + " . " + topic);
		
		}
		System.out.println("Choose the quiz");// choosing the quizz from list
		int chooseval=sc.nextInt();
		sc.nextLine();
		
		//get list of  for selected topic
		String selectedQuiz = new ArrayList<>(quizes.keySet()).get(chooseval - 1);
        List<ques> questions = quizes.get(selectedQuiz);
		
		int score = 0;// initialize score value
        for (ques q : questions) 
        {
        	
        	
            System.out.println(q.getQuestionText());//prints questions
            for (int i = 0; i < q.getOptions().size(); i++)//prints all options
            {
                System.out.println((i + 1) + ". " + q.getOptions().get(i));
            }

            System.out.print("Your answer: ");//ask for answer
            int answer = sc.nextInt();
            sc.nextLine(); 

            if (answer == q.getCorrectOption()) //checks for correct option
            {
                score++;//increment score value
            }
        }

        System.out.println("You scored: " + score + " out of " + questions.size());//give final score
    }
		
	}
	
	
	


	


