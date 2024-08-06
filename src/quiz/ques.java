package quiz;

import java.util.List;

public class ques {

	
		private String questionText; 
	    private List<String> options; 
	    private int correctOption ;
	    
	    public ques(String qutxt, List<String> strop, int correctoption)
	    {
	    	this.questionText=qutxt;
	    	this.options = strop;
	    	this.correctOption = correctoption;
	    }

		public String getQuestionText() {
			return questionText;
		}

		

		public List<String> getOptions() {
			return options;
		}

		

		public int getCorrectOption() {
			return correctOption;
		}

		

	

}
