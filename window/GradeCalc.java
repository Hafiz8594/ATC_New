import java.util.List;

/**
 * Utility to calculate grades
 * @author Sam Cheng COSC 439
 *
 */
public class GradeCalc {

	/**
	 * Calculate grades
	 * @param grades List of integer grades
	 * @return average of the grades
	 */
	public static double calculateGrades(List<Integer> grades){
		double total = 0;
		for (int i : grades) {
			total+=i;
		}
		return total/(double)grades.size();
	}
	
}
