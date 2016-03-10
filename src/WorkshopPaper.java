package FSE.CW4;

public class WorkshopPaper {
	private String PTitle;
	private WorkshopReview[] PReviews;
	private static String[] ROutputs = new String[]{"*","**","***","****","*****"};

	public WorkshopPaper() {
		this("New Paper");
		// Changed constructor to call the other for less repeated code : Benjamin Charlton, Oscar Mason, Jonathan Dilks
	}

	public WorkshopPaper(String pTitle) {
		PTitle = pTitle;
		PReviews = new WorkshopReview[3];
		for(int i = 0; i < PReviews.length; i++)
		{
			PReviews[i] = null;
		} // Changed to for loop for easy scalability : Benjamin Charlton
	}


	public String getPTitle() {
		return PTitle;
	}

	public void setPTitle(String pTitle) {
		PTitle = pTitle;
	}

	public void addReview(WorkshopReview nReview) {
		for(int i = 0; i < PReviews.length; i++)
		{
			if (PReviews[i] == null) {
				PReviews[i] = nReview;
			}
		} // Changed if statements to for loop for easy scalability : Benjamin Charlton
	}

	public float getAverageScore(){
		float AvgScore = 0;
		int numReviews = 0;

		for(int i = 0; i < PReviews.length; i++)
		{
			if (PReviews[i] != null) {
				AvgScore += PReviews[i].getRScore();
				numReviews++;
			}
		} // Changed if statements to for loop for easy scalability : Benjamin Charlton

		// TODO Add exception for numReviews == 0

		AvgScore = AvgScore/numReviews;
		return AvgScore;
	}

	public String toString(){
		String myoutput = "";
		int roundScore = Math.round(getAverageScore()); //Changed Math.round(getAverageScore()) to stored to allow for error checking : Benjamin Charlton
		if( roundScore == 0 )
		{
			return "No reviews submitted yet.";
		} // Added error checking for no reviews : Benjamin Charlton
		else
		{
			myoutput = "Average Score = " + ROutputs[roundScore-1] + "\n\n"; //Changed ROutputs[roundScore] to ROutputs[roundScore-1] : Benjamin Charlton
			for(int i = 0; i < PReviews.length; i++)
			{
				if (PReviews[i] != null) {
					myoutput += "Review " + i +":\n" + PReviews[i].toString() + "\n";
				}
			} // Changed to for loop to allow for scalabilty and also added condtion to check if review has data : Benjamin Charlton
			return myoutput;
		}
	}

	public WorkshopReview[] getPReviews(){
		return PReviews;
	}

}
