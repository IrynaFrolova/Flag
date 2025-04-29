package ua.edu.znu.flags;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class QuizApp {

    private JFrame frame;
    private JTextArea questionArea;
    private JPanel answerPanel;
    private JButton nextButton;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private List<Question> questions;
    private String userName = "Анонім";

    public QuizApp() {
        initializeQuestions();
        initializeUI();
    }

    private void initializeQuestions() {
        questions = new ArrayList<>();

        // Одноваріантне питання
        questions.add(new Question(
                "Яка столиця України?",
                Arrays.asList("Київ", "Львів", "Одеса"),
                Arrays.asList(0),
                false
        ));

        // Багатоваріантне питання
        questions.add(new Question(
                "Які з цих міста знаходяться в Україні?",
                Arrays.asList("Київ", "Москва", "Лондон", "Львів"),
                Arrays.asList(0, 3),
                true
        ));
    }

    private void initializeUI() {
        frame = new JFrame("Тестування");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Меню
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Меню");
        JMenuItem enterNameItem = new JMenuItem("Ввести ім’я");
        enterNameItem.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(frame, "Введіть ім’я:");
            if (input != null && !input.trim().isEmpty()) {
                userName = input.trim();
            } else if (input != null) {
                JOptionPane.showMessageDialog(frame,
                        "Ім’я не може бути порожнім.",
                        "Попередження",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        menu.add(enterNameItem);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        // Питання
        questionArea = new JTextArea();
        questionArea.setEditable(false);
        questionArea.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(questionArea, BorderLayout.NORTH);

        // Панель відповідей
        answerPanel = new JPanel();
        answerPanel.setLayout(new BoxLayout(answerPanel, BoxLayout.Y_AXIS));
        frame.add(answerPanel, BorderLayout.CENTER);

        // Кнопка
        nextButton = new JButton("Далі");
        nextButton.addActionListener(e -> processAnswer());
        frame.add(nextButton, BorderLayout.SOUTH);

        displayQuestion();

        frame.setVisible(true);
    }

    private void displayQuestion() {
        answerPanel.removeAll();

        if (currentQuestionIndex >= questions.size()) {
            showResult();
            return;
        }

        Question q = questions.get(currentQuestionIndex);
        questionArea.setText("Питання " + (currentQuestionIndex + 1) + ": " + q.getQuestionText());

        ButtonGroup group = new ButtonGroup();
        for (int i = 0; i < q.getOptions().size(); i++) {
            AbstractButton button;
            if (q.isMultiple()) {
                button = new JCheckBox(q.getOptions().get(i));
            } else {
                button = new JRadioButton(q.getOptions().get(i));
                group.add(button);
            }
            button.setActionCommand(String.valueOf(i));
            answerPanel.add(button);
        }

        answerPanel.revalidate();
        answerPanel.repaint();
    }

    private void processAnswer() {
        List<Integer> userAnswers = new ArrayList<>();
        Component[] components = answerPanel.getComponents();

        for (Component comp : components) {
            if (comp instanceof AbstractButton) {
                AbstractButton button = (AbstractButton) comp;
                if (button.isSelected()) {
                    userAnswers.add(Integer.parseInt(button.getActionCommand()));
                }
            }
        }

        if (userAnswers.isEmpty()) {
            JOptionPane.showMessageDialog(frame,
                    "Будь ласка, оберіть хоча б одну відповідь!",
                    "Помилка вводу",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (questions.get(currentQuestionIndex).isCorrect(userAnswers)) {
            score++;
        }

        currentQuestionIndex++;
        displayQuestion();
    }

    private void showResult() {
        JOptionPane.showMessageDialog(frame,
                userName + ", ваш результат: " + score + " з " + questions.size(),
                "Результат",
                JOptionPane.INFORMATION_MESSAGE);
        frame.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(QuizApp::new);
    }
}
