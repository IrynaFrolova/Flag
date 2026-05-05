package ua.edu.znu.flags;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 * Застосунок-тест із одно- та багатоваріантними питаннями.
 */
public final class QuizApp {

    private static final QuestionRenderer SINGLE = new SingleChoiceRenderer();
    private static final QuestionRenderer MULTI  = new MultiChoiceRenderer();

    private JFrame frame;
    private JTextArea questionArea;
    private JPanel answerPanel;

    private final List<Question> questions = new ArrayList<>();
    private int currentQuestionIndex;
    private int score;
    private String userName = "Анонім";

    /**
     * Створює застосунок: ініціалізує список питань і будує користувацький інтерфейс.
     */
    public QuizApp() {
        initializeQuestions();
        initializeUI();
    }

    private void initializeQuestions() {
        questions.add(new Question(
                "Яка столиця України?",
                List.of("Київ", "Львів", "Одеса"),
                List.of(0),
                SINGLE));
        questions.add(new Question(
                "Які з цих міст знаходяться в Україні?",
                List.of("Київ", "Москва", "Лондон", "Львів"),
                List.of(0, 3),
                MULTI));
    }

    private void initializeUI() {
        frame = createMainFrame();
        frame.setJMenuBar(buildMenuBar());
        frame.add(buildQuestionArea(), BorderLayout.NORTH);
        frame.add(buildAnswerPanel(), BorderLayout.CENTER);
        frame.add(buildNextButton(), BorderLayout.SOUTH);
        displayQuestion();
        frame.setVisible(true);
    }

    private JFrame createMainFrame() {
        JFrame f = new JFrame("Тестування");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setSize(600, 400);
        f.setLayout(new BorderLayout());
        return f;
    }

    private JMenuBar buildMenuBar() {
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("Меню");
        JMenuItem enterName = new JMenuItem("Ввести ім'я");
        enterName.addActionListener(e -> askUserName());
        menu.add(enterName);
        bar.add(menu);
        return bar;
    }

    private void askUserName() {
        String input = JOptionPane.showInputDialog(frame, "Введіть ім'я:");
        if (input == null) {
            return;
        }
        String trimmed = input.trim();
        if (trimmed.isEmpty()) {
            showWarning("Попередження", "Ім'я не може бути порожнім.");
        } else {
            userName = trimmed;
        }
    }

    private JTextArea buildQuestionArea() {
        questionArea = new JTextArea();
        questionArea.setEditable(false);
        questionArea.setFont(new Font("Arial", Font.BOLD, 16));
        return questionArea;
    }

    private JPanel buildAnswerPanel() {
        answerPanel = new JPanel();
        answerPanel.setLayout(new BoxLayout(answerPanel, BoxLayout.Y_AXIS));
        return answerPanel;
    }

    private JButton buildNextButton() {
        JButton button = new JButton("Далі");
        button.addActionListener(e -> processAnswer());
        return button;
    }

    private void displayQuestion() {
        answerPanel.removeAll();
        if (currentQuestionIndex >= questions.size()) {
            showResult();
            return;
        }
        Question q = questions.get(currentQuestionIndex);
        questionArea.setText("Питання " + (currentQuestionIndex + 1)
                + ": " + q.getQuestionText());
        q.getRenderer().renderInto(answerPanel, q);
        answerPanel.revalidate();
        answerPanel.repaint();
    }

    private void processAnswer() {
        Question q = questions.get(currentQuestionIndex);
        List<Integer> userAnswers = q.getRenderer().collectAnswers(answerPanel);

        if (userAnswers.isEmpty()) {
            showWarning("Помилка вводу",
                    "Будь ласка, оберіть хоча б одну відповідь!");
            return;
        }
        if (q.isCorrect(userAnswers)) {
            score++;
        }
        advance();
    }

    private void advance() {
        currentQuestionIndex++;
        displayQuestion();
    }

    private void showWarning(final String title, final String message) {
        JOptionPane.showMessageDialog(frame, message, title,
                JOptionPane.WARNING_MESSAGE);
    }

    private void showResult() {
        JOptionPane.showMessageDialog(frame,
                userName + ", ваш результат: " + score + " з " + questions.size(),
                "Результат",
                JOptionPane.INFORMATION_MESSAGE);
        frame.dispose();
    }

    /**
     * Точка входу у програму.
     *
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(final String[] args) {
        SwingUtilities.invokeLater(QuizApp::new);
    }
}
