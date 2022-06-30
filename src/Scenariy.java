/**
 * Если ты думаешь: как решить эту задачу?
 * 1. Работать надо через СтрингБилдер, поэтому первым делом создай его.
 * 2. Начать надо с "вписания" роли в твой созданный СтрингБилдер.
 * 2.1. Помещай(через append) туда элементы массива role(с прибавлением ":" и '/n') через цикл.
 * 3. После "вписания" роли в СтрингБилдер создавай вложенный цикл, где будут проверяться совпдения элементов второго массива textLine с "вписанными" элементами первого массива(через startsWith).
 * 4. В случае совпадения( через if) помещай элемент второго массива в СтрингБилдер с заменой(через replaceFirst)  роли(так как во втором массиве уже есть название роли).
 * Сложновато получилось, но задача мозговыносная.
 */
public class Scenariy {
    public static void main(String[] args) {
        String[] roles = new String[]{
                "Городничий",
                "Аммос Федорович",
                "Артемий Филиппович",
                "Лука",
                "Лука Лукич",
                "no name"
        };
        String[] textLines = new String[]{
                "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!",
                "Лука: Господи боже! Я уронил своё пасхальное яйцо от неожиданности!"
        };
        printTextPerRole(roles, textLines);
    }

    public static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder scenarii = new StringBuilder();
        for (int i = 0; i < roles.length; i++) {
            scenarii.append(roles[i]).append(":").append("\n");

            for (int j = 0; j < textLines.length; j++) {
                if (textLines[j].startsWith(roles[i] + ":", 0)) {
//                    scenarii.append((j + 1) + textLines[j].replaceFirst(roles[i] + ": ", ") ") + "\n");
                    scenarii.append(j + 1)
                            .append(textLines[j].replaceFirst(roles[i] + ": ", ") "))
                            .append("\n");
                }
            }
            scenarii.append("\n");
        }
          System.out.println(String.valueOf(scenarii));
        return String.valueOf(scenarii);
    }
} // не удалять
//            int counterRoles = 0;
//            int counterTextLines = 0;
// trim() - отсечь на концах строки пустые символы;


