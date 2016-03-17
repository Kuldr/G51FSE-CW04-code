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
	public int getRScore() {
		return rScore;
	}
	public void setRScore(int rScore) throws WorkshopReviewInvalidScore {
		if( rScore < 1 || rScore > 5) {
			throw new WorkshopReviewInvalidScore();
		} // Added check for out of bounds Score : Benjamin Charlton
		this.rScore = rScore;
	}
	public String getRReview() {
		return rReview;
	}
	public void setRReview(String rReview) {
		this.rReview = rReview;
	}

	@Override
	public String toString() {
		return "Score = " + rOutputs[rScore -1] + "\nReview: " + rReview + "\n"; // Changed rOutputs to index the array correctly : Benjamin Charlton
	}



}
