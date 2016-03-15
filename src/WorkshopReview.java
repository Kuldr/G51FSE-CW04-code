

public class WorkshopReview {
	private int RScore;
	private String RReview;
	private static String[] ROutputs = new String[]{"*","**","***","****","*****"};
	
	public WorkshopReview() {
		RScore = 1; // Changed default score to 1 : Benjamin Charlton
		RReview = "No Review";
	}
	
	public WorkshopReview(int rScore, String rReview) {
		if( rScore < 1 || rScore > 5)
		{
			rScore = 1;
		} // Added check for out of bounds Score : Benjamin Charlton
		RScore = rScore;
		RReview = rReview;
	}
	public int getRScore() {
		return RScore;
	}
	public void setRScore(int rScore) {
		if( rScore < 1 || rScore > 5)
		{
			rScore = 1;
		} // Added check for out of bounds Score : Benjamin Charlton
		RScore = rScore;
	}
	public String getRReview() {
		return RReview;
	}
	public void setRReview(String rReview) {
		RReview = rReview;
	}

	@Override
	public String toString() {
		return "Score = " + ROutputs[RScore-1] + "\n Review: " + RReview + "\n"; // Changed ROutputs to index the array correctly : Benjamin Charlton
	}
	
	
	
}
