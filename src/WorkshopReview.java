import Exceptions.WorkshopReviewInvalidScore;

public class WorkshopReview {
	private int rScore;
	private String rReview;
	private static String[] rOutputs = new String[]{"*","**","***","****","*****"};
	
	public WorkshopReview() {
		rScore = 1; // Changed default score to 1 : Benjamin Charlton
		rReview = "";
	}
	
	public WorkshopReview(int rScore, String rReview) throws WorkshopReviewInvalidScore {
		if( rScore < 1 || rScore > 5) {
			throw new WorkshopReviewInvalidScore();
		} // Added check for out of bounds Score : Benjamin Charlton
		this.rScore = rScore;
		this.rReview = rReview;
	}
	public int getrScore() {
		return rScore;
	}
	public void setrScore(int rScore) throws WorkshopReviewInvalidScore {
		if( rScore < 1 || rScore > 5) {
			throw new WorkshopReviewInvalidScore();
		} // Added check for out of bounds Score : Benjamin Charlton
		this.rScore = rScore;
	}
	public String getrReview() {
		return rReview;
	}
	public void setrReview(String rReview) {
		this.rReview = rReview;
	}

	@Override
	public String toString() {
		return "Score = " + rOutputs[rScore -1] + "\nReview: " + rReview + "\n"; // Changed rOutputs to index the array correctly : Benjamin Charlton
	}
	
	
	
}
