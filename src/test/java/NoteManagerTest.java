import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.note.manager.Subject;
import org.note.manager.Exam;


public class NoteManagerTest {
    Subject subject;

    @BeforeEach
    public void createSubjectTest() {
        subject = new Subject("Math");
        assertEquals("Math", subject.getName());
    }

    @Test
    @DisplayName("Add Exams")
    public void addExamResultTest() {
        subject = new Subject("Math");
        Exam exam = new Exam("Test1", 5.5);
        subject.addExam(exam);
        assertEquals(1, subject.getExams().size());
        assertTrue(subject.getExams().contains(exam));
    }

    @Test
    @DisplayName("Calculate Exam")
    public void calculateNoteTest() throws Exception {
        subject = new Subject("Math");
        Exam exam1 = new Exam("Test 1", 4.8);
        Exam exam2 = new Exam("Test 2", 3.5);
        subject.addExam(exam1);
        subject.addExam(exam2);

        double calculatedNote = subject.calculateNote();
        double delta = 0.0001;
        assertEquals(4.15, calculatedNote, delta);
    }

    @Test
    public void calculateNoteWithoutExamsT() {
        subject = new Subject("Math");
        Exception exception = assertThrows(Exception.class, subject::calculateNote);
        assertEquals("No Exams added!", exception.getMessage());
    }
}
