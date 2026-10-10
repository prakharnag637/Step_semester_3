import java.util.*;
abstract class Question {
    String question;
    int marks;
    Question(String question, int marks) {
        this.question = question;
        this.marks = marks;
    }
    abstract boolean checkAnswer(String answer);
}
class MCQQuestion extends Question {
    String correctAnswer;
    MCQQuestion(String question, int marks, String correctAnswer) {
        super(question, marks);
        this.correctAnswer = correctAnswer;
    }
    boolean checkAnswer(String answer) {
        return correctAnswer.equalsIgnoreCase(answer);
    }
}
class TrueFalseQuestion extends Question {
    String correctAnswer;
    TrueFalseQuestion(String question, int marks, String correctAnswer) {
        super(question, marks);
        this.correctAnswer = correctAnswer;
    }
    boolean checkAnswer(String answer) {
        return correctAnswer.equalsIgnoreCase(answer);
    }
}
class Student {
    String name;
    Student(String name) {
        this.name = name;
    }
}
class Examination {
    String name;
    ArrayList<Question> questions = new ArrayList<>();
    Examination(String name) {
        this.name = name;
    }
    void addQuestion(Question q) {
        questions.add(q);
    }
}
class Attempt {
    Student student;
    Examination exam;
    HashMap<Integer, String> answers = new HashMap<>();
    boolean submitted = false;
    Attempt(Student student, Examination exam) {
        this.student = student;
        this.exam = exam;
    }
    void startExam() {
        System.out.println(exam.name + " started by " + student.name);
    }
    void answerQuestion(int questionNo, String answer) {
        if (submitted) {
            System.out.println("Cannot change answers for a submitted examination.");
            return;
        }
        if (questionNo < 1 || questionNo > exam.questions.size()) {
            System.out.println("Invalid question number.");
            return;
        }
        answers.put(questionNo - 1, answer);
        System.out.println("Answer recorded for Question " + questionNo);
    }
    void submitExam() {
        if (submitted) {
            System.out.println("Examination already submitted.");
            return;
        }
        submitted = true;
        int score = 0;
        int total = 0;
        System.out.println(exam.name + " submitted by " + student.name);
        for (int i = 0; i < exam.questions.size(); i++) {
            Question q = exam.questions.get(i);
            total += q.marks;
            String answer = answers.get(i);
            if (answer != null && q.checkAnswer(answer)) {
                score += q.marks;
                System.out.println("Question " + (i + 1) + ": Correct (" + q.marks + " points)");
            } else {
                System.out.println("Question " + (i + 1) + ": Incorrect (0 points)");
            }
        }
        System.out.println("Total score: " + score + "/" + total);
    }
}
public class Exam {
    public static void main(String[] args) {
        Student s1 = new Student("Student 1");
        Examination exam = new Examination("Exam A");
        exam.addQuestion(new MCQQuestion("Question 1", 5, "C"));
        exam.addQuestion(new TrueFalseQuestion("Question 2", 5, "False"));
        Attempt attempt = new Attempt(s1, exam);
        attempt.startExam();
        attempt.answerQuestion(1, "C");
        attempt.answerQuestion(2, "True");
        attempt.submitExam();
        attempt.answerQuestion(1, "B");
    }
}
