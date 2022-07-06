package KATA_23;

public class Solution {
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
            scenarii.append(roles[i])
                    .append(":")
                    .append("\n");

            for (int j = 0; j < textLines.length; j++) {
                if (textLines[j].startsWith(roles[i] + ":", 0)) {
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
} // End
