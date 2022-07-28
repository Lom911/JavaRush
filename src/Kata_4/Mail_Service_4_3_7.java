package Kata_4;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Mail_Service_4_3_7 {
/*
1) UntrustworthyMailWorker – класс, моделирующий ненадежного работника почты, который вместо того, чтобы передать
почтовый объект непосредственно в сервис почты, последовательно передает этот объект набору третьих лиц, а затем,
в конце концов, передает получившийся объект непосредственно экземпляру RealMailService. У UntrustworthyMailWorker
должен быть конструктор от массива MailService (результат вызова processMail первого элемента массива передается
на вход processMail второго элемента, и т. д.) и метод getRealMailService, который возвращает ссылку на внутренний
экземпляр RealMailService, он не приходит масивом в конструкторе и не настраивается извне класса.
 */
public static class UntrustworthyMailWorker implements MailService {
    private RealMailService realMailService;
    private MailService[] mailServices;

    public UntrustworthyMailWorker(MailService[] mailServices) {
        this.mailServices = mailServices;
        this.realMailService = new RealMailService();
    }

    @Override
    public Sendable processMail(Sendable mail) {


        for (int i = 0; i < mailServices.length; i++) {

            mail = mailServices[i].processMail(mail);

        }

        return realMailService.processMail(mail);

    }

    public RealMailService getRealMailService() {

        return this.realMailService;

    }

}

    public static class Spy implements MailService {
        private final Logger log;

        public Spy(Logger logger) {
            log = logger;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailMessage) {
                MailMessage mess = (MailMessage) mail;
                if (mess.getFrom().contains("Austin Powers") || mess.getTo().contains("Austin Powers")) {
                    log.warning("Detected target mail correspondence: from " + mess.getFrom() + " to " + mess.getTo() + " \"" + mess.getMessage() + "\"");
                } else {
                    log.log(Level.INFO, "Usual correspondence: from " + mess.getFrom() + " to " + mess.getTo());
                }
            }
            return mail;
        }
    }

    public static class Thief implements MailService {
        private int minPrice = 0;
        private int usherb = 0;

        public Thief(int minPrice) {
            this.minPrice = minPrice;
        }

        public int getStolenValue() {
            return usherb;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                Package cena = ((MailPackage) mail).getContent();
                int price = cena.getPrice();
                if (price >= minPrice) {
                    usherb += price;
                    mail = new MailPackage(mail.getFrom(), mail.getTo(), new Package("stones instead of " + cena.getContent(), 0));
                }
            }
            return mail;
        }
    }


    public static class IllegalPackageException extends RuntimeException {
    }

    public static class StolenPackageException extends RuntimeException {
    }

    public static class Inspector implements MailService {
        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                Package packdangerous = ((MailPackage) mail).getContent();
                String content = packdangerous.getContent();
                int price2 = packdangerous.getPrice();
                if (content.contains("weapons") || content.contains("banned substance")) {
                    throw new IllegalPackageException();
                }
                if (content.contains("stones instead of ") || (content.contains("stones"))) {
                    throw new StolenPackageException();
                }
            }
            return mail;
        }

    }

    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Mail_Service_4_3_7.class.getName());

        Inspector inspector = new Inspector();
        Spy spy = new Spy(logger);
        Thief thief = new Thief(10000);
        MailService variousWorkers[] = new MailService[]{spy, thief, inspector};
        UntrustworthyMailWorker worker = new UntrustworthyMailWorker(variousWorkers);

        AbstractSendable correspondence[] = {
                new MailMessage("Oxxxymiron", "Гнойный", "Я здесь чисто по фану, поглумиться над слабым\n" +
                        "Ты же вылез из мамы под мой дисс на Бабана...."),
                new MailMessage("Гнойный", "Oxxxymiron", "....Что? Так болел за Россию, что на нервах терял ганглии.\n" +
                        "Но когда тут проходили митинги, где ты сидел? В Англии!...."),
                new MailMessage("Жриновский", AUSTIN_POWERS, "Бери пацанов, и несите меня к воде."),
                new MailMessage(AUSTIN_POWERS, "Пацаны", "Го, потаскаем Вольфовича как Клеопатру"),
                new MailPackage("берег", "море", new Package("ВВЖ", 32)),
                new MailMessage("NASA", AUSTIN_POWERS, "Найди в России ракетные двигатели и лунные stones"),
                new MailPackage(AUSTIN_POWERS, "NASA", new Package("ракетный двигатель ", 2500000)),
                new MailPackage(AUSTIN_POWERS, "NASA", new Package("stones", 1000)),
                new MailPackage("Китай", "КНДР", new Package("banned substance", 99)),
                new MailPackage(AUSTIN_POWERS, "ИГИЛ (запрещенная группировка", new Package("tiny bomb", 9000)),
                new MailMessage(AUSTIN_POWERS, "Психиатр", "Помогите"),
        };

        for (AbstractSendable p : correspondence) {
            try {
                print("До:  ", p);
                Sendable sendable = worker.processMail(p);
                print("После:  ", sendable);
            } catch (StolenPackageException | IllegalPackageException e) {
                logger.log(Level.WARNING, "из: " + p.getFrom() + " куда: " + p.getTo() + " Содержимое: "
                        + (p instanceof MailMessage ? ((MailMessage) p).getMessage() : ((MailPackage) p).getContent().getContent()
                        + " Цена=" + ((MailPackage) p).getContent().getPrice()) + " Exceptions: " + e);
            }
        }
    }

    public static void print(String prefix, Sendable p) {
        System.out.println(prefix + "из: " + p.getFrom() + " куда: " + p.getTo() + " Содержимое: "
                + (p instanceof MailMessage ? ((MailMessage) p).getMessage() : ((MailPackage) p).getContent().getContent()
                + " Цена=" + ((MailPackage) p).getContent().getPrice()));
    }

//public static void main(String[] args) {
//    MailService spy = new Spy(Logger.getLogger(Class.class.getName()));
//    MailService thief = new Thief(10);
//    MailService inspector = new Inspector();
//    MailService[] msArray = {spy, thief, inspector};
//    MailMessage mail1 = new MailMessage("Romeo", "Juliet", "I love you!");
//    MailMessage mail2 = new MailMessage("Austin Powers", "James Bond", "Big secret!");
//    MailPackage mail3 = new MailPackage("Romeo", "Juliet", new Package("Flowers", 15));
//    MailPackage mail4 = new MailPackage("Romeo", "Juliet", new Package("Flowers", 25));
//    MailPackage mail5 = new MailPackage("Austin Powers", "James Bond", new Package("weapons", 5));
//
//    UntrustworthyMailWorker umw = new UntrustworthyMailWorker(msArray);
//    try {
//        umw.processMail(mail1);
//    } catch (RuntimeException re) {
//        System.out.println(re.getMessage());
//    }
//    try {
//        umw.processMail(mail2);
//    } catch (RuntimeException re) {
//        System.out.println(re.getMessage());
//    }
//    try {
//        umw.processMail(mail3);
//    } catch (RuntimeException re) {
//        System.out.println(re.getMessage());
//    }
//    try {
//        umw.processMail(mail4);
//    } catch (RuntimeException re) {
//        System.out.println(re.getMessage());
//    }
//    try {
//        umw.processMail(mail5);
//    } catch (RuntimeException re) {
//        System.out.println(re.getMessage());
//    }
//
//    System.out.println("Thief have stolen $" + ((Thief)thief).getStolenValue() + "!");
//}

    /*
    Интерфейс: сущность, которую можно отправить по почте.
    У такой сущности можно получить от кого и кому направляется письмо.
    */
    public interface Sendable {
        String getFrom();

        String getTo();
    }

    /*
Абстрактный класс,который позволяет абстрагировать логику хранения
источника и получателя письма в соответствующих полях класса.
*/
    public static abstract class AbstractSendable implements Sendable {

        protected final String from;
        protected final String to;

        public AbstractSendable(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public String getTo() {
            return to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            AbstractSendable that = (AbstractSendable) o;

            if (!from.equals(that.from)) return false;
            return to.equals(that.to);
        }

    }

    /*
Письмо, у которого есть текст, который можно получить с помощью метода `getMessage`
*/
    public static class MailMessage extends AbstractSendable {

        private final String message;

        public MailMessage(String from, String to, String message) {
            super(from, to);
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailMessage that = (MailMessage) o;

            return message != null ? message.equals(that.message) : that.message == null;
        }

    }

    /*
Посылка, содержимое которой можно получить с помощью метода `getContent`
*/
    public static class MailPackage extends AbstractSendable {
        private final Package content;

        public MailPackage(String from, String to, Package content) {
            super(from, to);
            this.content = content;
        }

        public Package getContent() {
            return content;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailPackage that = (MailPackage) o;

            return content.equals(that.content);
        }

    }

    /*
Класс, который задает посылку. У посылки есть текстовое описание содержимого и целочисленная ценность.
*/
    public static class Package {
        private final String content;
        private final int price;

        public Package(String content, int price) {
            this.content = content;
            this.price = price;
        }

        public String getContent() {
            return content;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Package aPackage = (Package) o;

            if (price != aPackage.price) return false;
            return content.equals(aPackage.content);
        }
    }

    /*
Интерфейс, который задает класс, который может каким-либо образом обработать почтовый объект.
*/
    public interface MailService {
        Sendable processMail(Sendable mail);
    }

    /*
    Класс, в котором скрыта логика настоящей почты
    */
    public static class RealMailService implements MailService {

        @Override
        public Sendable processMail(Sendable mail) {
            // Здесь описан код настоящей системы отправки почты.
            return mail;
        }
    }
}
/*
Задача интересная и сама по себе легкая, не смотря на большое условие. При решении пользовался комментариями,
из них можно полезное извлечь, но приходилось несколько раз перечитывать, чтобы искать возникающие ошибки.
Людям не знакомым,  что такое ООП и зачем оно нужно, задачу решить практически невозможно, или крайне сложно.

Хочу обратить внимание на возникшие вопросы

1. Все 4 создаваемых класса UntrustworthyMailWorker, Spy, Inspector, Thief реализуют интерфейс (implements) MailService.
Это позволяет описать метод proccessMail в каждом классе. В этом методе  будет реализована основная логика для
каждого класса.

2. Непроверяемые исключения - это RuntimeException, Error.

3. Конструктор по умолчанию есть только в  Inspector. В других классах конструкторы создаются исходя из условий
для конкретного класса:

3.1. Для  Spy в конструктор передается Logger,

3.2. UntrustworthyMailWorker - список почтовых сервисов MailService[]  (каждый из наших классов является   MailService,
 соответственно, для проверки нашей почтовой службы в этом список мы добавляем объекты наших классов spy,
 thief,inspector, и даже  untrustworthyMailWorker ),

3.3 Thief - передаем целое число(int) минимальной стоимости посылки.

4. Почти в каждом методе proccessMail необходимо делать проверку на принадлежность ( instanceof )  к конкретному классу.

5. В классе Spy, логер создавать не нужно. Достаточно его только объявить (Logger loger = null). А при проверке на
локальном компе, придется создавать свой логер и передавать его для создания объекта класса  Spy.

6. Пусть вас не пугает большое условие. Делайте все последовательно, по одному классу. Но вначале создайте те классы
и интерфейсы, которые даны по условию. Не забудьте убрать слово static, если конечно это будут внешние классы
и интерфейсы.
 */