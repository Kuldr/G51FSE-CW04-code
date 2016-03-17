import Exceptions.WorkshopPaperEmptyTitleException;
import Exceptions.WorkshopPaperExcessReviewException;
import Exceptions.WorkshopPaperNoReviewsYetException;

public class WorkshopPaper {
	private String pTitle;
	private WorkshopReview[] pReviews;
	private static String[] rOutputs = new String[]{"*","**","***","****","*****"};

	public WorkshopPaper() throws WorkshopPaperEmptyTitleException {
		this("New Paper");
		// Changed constructor to call the other for less repeated code : Benjamin Charlton, Oscar Mason, Jonathan Dilks
	}

	public WorkshopPaper(String pTitle) throws WorkshopPaperEmptyTitleException {
		if(pTitle.equals("")){
			throw new WorkshopPaperEmptyTitleException();
		} else {
			this.pTitle = pTitle;
		} //Changed to catch scenarios when the title is empty : Oscar Mason, Benjamin Charlton

		pReviews = new WorkshopReview[3];
		for(int i = 0; i < pReviews.length; i++)
		{
			pReviews[i] = null;
		} // Changed to for loop for easy scalability : Benjamin Charlton
	}

	public String getpTitle() {
		return pTitle;
	}

	public void setpTitle(String pTitle) throws WorkshopPaperEmptyTitleException {
		if(pTitle.equals("")){
			throw new WorkshopPaperEmptyTitleException();
		} // Added in the error checking : Oscar Mason, Benjamin Charlton
		else {
			this.pTitle = pTitle;
		}
	}

	public void addReview(WorkshopReview nReview) throws WorkshopPaperExcessReviewException {
		boolean added = false;
		for(int i = 0; i < pReviews.length; i++)
		{
			if (!added && pReviews[i] == null) {
				pReviews[i] = nReview;
				added = true;
			}
		} // Changed if statements to for loop for easy scalability : Benjamin Charlton
		if (!added) {
			throw new WorkshopPaperExcessReviewException();
		}
	}

	public float getAverageScore() throws WorkshopPaperNoReviewsYetException {
		float AvgScore = 0;
		int numReviews = 0;

		for(int i = 0; i < pReviews.length; i++)
		{
			if (pReviews[i] != null) {
				AvgScore += pReviews[i].getrScore();
				numReviews++;
			}
		} // Changed if statements to for loop for easy scalability : Benjamin Charlton

		if(numReviews == 0){
			throw new WorkshopPaperNoReviewsYetException();
		}else{
			AvgScore = AvgScore/numReviews;
		} //Changed to catch scenarios when number of reviews equals 0 : Oscar Mason, Benjamin Charlton
		return AvgScore;
	}

	public String toString(){
		String myoutput = "";
		int roundScore = 0;
		try {
			roundScore = Math.round(getAverageScore()); //Changed Math.round(getAverageScore()) to stored to allow for error checking : Benjamin Charlton
		}
		catch (WorkshopPaperNoReviewsYetException e){
			return "No reviews submitted yet.";
		} // Added error checking for no reviews : Benjamin Charlton

		myoutput = "Average Score = " + rOutputs[roundScore-1] + "\n\n"; //Changed rOutputs[roundScore] to rOutputs[roundScore-1] : Benjamin Charlton
		for(int i = 0; i < pReviews.length; i++)
		{
			if (pReviews[i] != null) {
				myoutput += "Review " + (i+1) +":\n" + pReviews[i].toString() + "\n";
			}
		} // Changed to for loop to allow for scalabilty and also added condtion to check if review has data : Benjamin Charlton
		return myoutput;
	}

	public WorkshopReview[] getpReviews(){
		return pReviews;
	}

}
