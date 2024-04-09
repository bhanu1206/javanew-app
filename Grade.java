public class Grade {
    private String courseName;
    private int credits;
    private String letterGrade;

    public Grade(String courseName, int credits, String letterGrade) {
        this.courseName = courseName;
        this.credits = credits;
        this.letterGrade = letterGrade;
    }

    public int getCredits() {
        return credits;
    }

    public double getGradePoints() {
        switch (letterGrade) {
            case "A": return 4.0;
            case "B": return 3.0;
            case "C": return 2.0;
            case "D": return 1.0;
            default: return 0.0;
        }
    }
}
