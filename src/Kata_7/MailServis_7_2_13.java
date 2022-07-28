package Kata_7;

import java.util.*;
import java.util.function.Consumer;

public class MailServis_7_2_13 {


    public static class Sendable<T> {

        private final String from;
        private final String to;
        private final T content;

        public Sendable(String from, String to, T content) {
            this.from = from;
            this.to = to;
            this.content = content;
        }

        public String getFrom() {
            return from;
        }

        public String getTo() {
            return to;
        }

        public T getContent() {
            return content;
        }
    }

    public static class MailMessage extends Sendable<String> {
        public MailMessage(String from, String to, String message) {
            super(from, to, message);
        }
    }

    public static class Salary extends Sendable<Integer> {
        public Salary(String from, String to, Integer salary) {
            super(from, to, salary);
        }
    }

    public static class MailService<T> implements Consumer<Sendable<T>> {

        private final Map<String, List<T>> mailBox = new HashMap<>() {
            @Override
            public List<T> get(Object key) {
                if (this.containsKey(key)) {
                    return super.get(key);
                }
                return Collections.emptyList();
            }
        };

        public Map<String, List<T>> getMailBox() {
            return mailBox;
        }

        @Override
        public void accept(Sendable<T> tMail) {
            if (mailBox.containsKey(tMail.getTo())) {
                mailBox.get(tMail.getTo()).add(tMail.getContent());
            } else {
                ArrayList<T> newList = new ArrayList<>();
                newList.add(tMail.getContent());
                mailBox.put(tMail.getTo(), newList);
            }
        }
    }


    public static void main(String... args) {
//         Random variables
        String randomFrom = "ttt"; // Некоторая случайная строка. Можете выбрать ее самостоятельно.
        String randomTo = "ooo";  // Некоторая случайная строка. Можете выбрать ее самостоятельно.
        int randomSalary = 77;  // Некоторое случайное целое положительное число. Можете выбрать его самостоятельно.

        // Создание списка из трех почтовых сообщений.
        MailMessage firstMessage = new MailMessage(
                "Robert Howard",
                "H.P. Lovecraft",
                "This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"
        );

        assert firstMessage.getFrom().

                equals("Robert Howard") : "Wrong firstMessage from address";
        assert firstMessage.getTo().

                equals("H.P. Lovecraft") : "Wrong firstMessage to address";
        assert firstMessage.getContent().

                endsWith("Howard!") : "Wrong firstMessage content ending";

        MailMessage secondMessage = new MailMessage(
                "Jonathan Nolan",
                "Christopher Nolan",
                "Брат, почему все так хвалят только тебя, когда практически все сценарии написал я. Так не честно!"
        );

        MailMessage thirdMessage = new MailMessage(
                "Stephen Hawking",
                "Christopher Nolan",
                "Я так и не понял Интерстеллар."
        );

        List<MailMessage> messages = Arrays.asList(
                firstMessage, secondMessage, thirdMessage
        );

        // Создание почтового сервиса.
        MailService<String> mailService = new MailService<>();

// Обработка списка писем почтовым сервисом
        messages.stream().forEachOrdered(mailService);

        // Получение и проверка словаря "почтового ящика",
//   где по получателю можно получить список сообщений, которые были ему отправлены
        Map<String, List<String>> mailBox = mailService.getMailBox();

        assert mailBox.get("H.P. Lovecraft")
                .equals(Arrays.asList("This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"))
                : "wrong mailService mailbox content (1)";

        assert mailBox.get("Christopher Nolan").
                equals(Arrays.asList("Брат, почему все так хвалят только тебя, когда практически все сценарии написал я. Так не честно!",
                        "Я так и не понял Интерстеллар."))
                : "wrong mailService mailbox content (2)";

        assert mailBox.get(randomTo).
                equals(Collections.<String>emptyList()) : "wrong mailService mailbox content (3)";


        // Создание списка из трех зарплат.
        Salary salary1 = new Salary("Facebook", "Mark Zuckerberg", 1);
        Salary salary2 = new Salary("FC Barcelona", "Lionel Messi", Integer.MAX_VALUE);
        Salary salary3 = new Salary(randomFrom, randomTo, randomSalary);

        // Создание почтового сервиса, обрабатывающего зарплаты.
        MailService<Integer> salaryService = new MailService<>();

// Обработка списка зарплат почтовым сервисом
        Arrays.asList(salary1, salary2, salary3).
                forEach(salaryService);

        // Получение и проверка словаря "почтового ящика",
//   где по получателю можно получить список зарплат, которые были ему отправлены.
        Map<String, List<Integer>> salaries = salaryService.getMailBox();
        assert salaries.get(salary1.getTo()).
                equals(Arrays.asList(1)) : "wrong salaries mailbox content (1)";

        assert salaries.get(salary2.getTo()).
                equals(Arrays.asList(Integer.MAX_VALUE)) : "wrong salaries mailbox content (2)";

        assert salaries.get(randomTo).
                equals(Arrays.asList(randomSalary)) : "wrong salaries mailbox content (3)";
    }
}
