package bookingSystem;


    public class Grade {
        private String courseCode;
        private String courseName;
        private double numericGrade;
        private String letterGrade;
        private int creditHours;
        private double gradePoints;

        public Grade(String courseCode, String courseName, double numericGrade, int creditHours) {
            this.courseCode = courseCode;
            this.courseName = courseName;
            this.numericGrade = numericGrade;
            this.creditHours = creditHours;
            this.letterGrade = calculateLetterGrade(numericGrade);
            this.gradePoints = calculateGradePoints(letterGrade);
        }

        // Getters and Setters
        public String getCourseCode() { return courseCode; }
        public void setCourseCode(String courseCode) { this.courseCode = courseCode; }

        public String getCourseName() { return courseName; }
        public void setCourseName(String courseName) { this.courseName = courseName; }

        public double getNumericGrade() { return numericGrade; }
        public void setNumericGrade(double numericGrade) {
            this.numericGrade = numericGrade;
            this.letterGrade = calculateLetterGrade(numericGrade);
            this.gradePoints = calculateGradePoints(letterGrade);
        }

        public String getLetterGrade() { return letterGrade; }

        public int getCreditHours() { return creditHours; }
        public void setCreditHours(int creditHours) { this.creditHours = creditHours; }

        public double getGradePoints() { return gradePoints; }

        private String calculateLetterGrade(double numericGrade) {
            if (numericGrade >= 90) return "A";
            else if (numericGrade >= 80) return "B";
            else if (numericGrade >= 70) return "C";
            else if (numericGrade >= 60) return "D";
            else return "F";
        }

        private double calculateGradePoints(String letterGrade) {
            switch (letterGrade) {
                case "A": return 4.0;
                case "B": return 3.0;
                case "C": return 2.0;
                case "D": return 1.0;
                case "F": return 0.0;
                default: return 0.0;
            }
        }

        @Override
        public String toString() {
            return String.format("Grade{Course='%s (%s)', Numeric=%.1f, Letter='%s', Credits=%d, Points=%.1f}",
                    courseCode, courseName, numericGrade, letterGrade, creditHours, gradePoints);
        }
    }

