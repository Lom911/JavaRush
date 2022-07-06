package KATA_23;

public class SpamTextAnalyzer {
    public static void main(String[] args) {
        // инициализация анализаторов для проверки в порядке данного набора анализаторов
        String[] spamKeywords = {"spam", "bad"};
        int commentMaxLength = 40;
        TextAnalyzer[] textAnalyzers1 = {
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(commentMaxLength)
        };
        TextAnalyzer[] textAnalyzers2 = {
                new SpamAnalyzer(spamKeywords),
                new TooLongTextAnalyzer(commentMaxLength),
                new NegativeTextAnalyzer()
        };
        TextAnalyzer[] textAnalyzers3 = {
                new TooLongTextAnalyzer(commentMaxLength),
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer()
        };
        TextAnalyzer[] textAnalyzers4 = {
                new TooLongTextAnalyzer(commentMaxLength),
                new NegativeTextAnalyzer(),
                new SpamAnalyzer(spamKeywords)
        };
        TextAnalyzer[] textAnalyzers5 = {
                new NegativeTextAnalyzer(),
                new SpamAnalyzer(spamKeywords),
                new TooLongTextAnalyzer(commentMaxLength)
        };
        TextAnalyzer[] textAnalyzers6 = {
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(commentMaxLength),
                new SpamAnalyzer(spamKeywords)
        };
        // тестовые комментарии
        String[] tests = new String[8];
        tests[0] = "This comment is so good.";                            // OK
        tests[1] = "This comment is so Loooooooooooooooooooooooooooong."; // TOO_LONG
        tests[2] = "Very negative comment !!!!=(!!!!;";                   // NEGATIVE_TEXT
        tests[3] = "Very BAAAAAAAAAAAAAAAAAAAAAAAAD comment with :|;";    // NEGATIVE_TEXT or TOO_LONG
        tests[4] = "This comment is so bad....";                          // SPAM
        tests[5] = "The comment is a spam, maybeeeeeeeeeeeeeeeeeeeeee!";  // SPAM or TOO_LONG
        tests[6] = "Negative bad :( spam.";                               // SPAM or NEGATIVE_TEXT
        tests[7] = "Very bad, very neg =(, very ..................";      // SPAM or NEGATIVE_TEXT or TOO_LONG
        TextAnalyzer[][] textAnalyzers = {textAnalyzers1, textAnalyzers2, textAnalyzers3,
                textAnalyzers4, textAnalyzers5, textAnalyzers6};
        SpamTextAnalyzer testObject = new SpamTextAnalyzer();
        int numberOfAnalyzer; // номер анализатора, указанный в идентификаторе textAnalyzers{№}
        int numberOfTest = 0; // номер теста, который соответствует индексу тестовых комментариев
        for (String test : tests) {
            numberOfAnalyzer = 1;
            System.out.print("test #" + numberOfTest + ": ");
            System.out.println(test);
            for (TextAnalyzer[] analyzers : textAnalyzers) {
                System.out.print(numberOfAnalyzer + ": ");
                System.out.println(testObject.checkLabels(analyzers, test));
                numberOfAnalyzer++;
            }
            numberOfTest++;
        }
    }

    /************************ TELO ***************************************/
    public static Label checkLabels(TextAnalyzer[] analyzers, String text) { //static
        for (int i = 0; i < analyzers.length; i++) {
            if (analyzers[i].processText(text) != Label.OK) {
                return analyzers[i].processText(text);
            }
        }
        return Label.OK;
    }

    public static abstract class KeywordAnalyzer implements TextAnalyzer { //static
        protected abstract String[] getKeywords();

        protected abstract Label getLabel();

//        @Override// под вопросом
        public Label processText(String text) {
            String[] keywords = getKeywords();
            for (String keyword : keywords) {
                if (text.contains(keyword)) {
                    return getLabel();
                }
            }
            return Label.OK;
        }
    }

    /**********/
    public static class SpamAnalyzer extends KeywordAnalyzer { //static, implements TextAnalyzer
        private String[] keywords;

        public SpamAnalyzer(String[] keywords) {
            this.keywords = keywords;
        }

        @Override
        protected String[] getKeywords() {
            return keywords;
        }

        @Override
        protected Label getLabel() {
            return Label.SPAM;
        }
    }

    public static class NegativeTextAnalyzer extends KeywordAnalyzer{ //static implements TextAnalyzer
        private String [] keywords2 = {":(","=(",":|"};

//        private Label label;

//        public NegativeTextAnalyzer () {
//
//            this.keywords = new String[3];
//            this.keywords[0] = ":(";
//            this.keywords[1] = "=(";
//            this.keywords[2] = ":|";
//            label = Label.NEGATIVE_TEXT;
//        }


        @Override
        protected String[] getKeywords() {
            return keywords2;
        }

        @Override
        protected Label getLabel() {
            return Label.NEGATIVE_TEXT;
        }
    }

    public static class TooLongTextAnalyzer implements TextAnalyzer { //static
        private int maxLength;

        public TooLongTextAnalyzer(int maxLength2) {
            this.maxLength = maxLength2;
        }

        @Override
        public Label processText(String text) {
            if (text.length() > maxLength) {
                return Label.TOO_LONG;
            }
            return Label.OK;
        }
    }



    interface TextAnalyzer {
        Label processText(String text);
    }

    enum Label {
        SPAM, NEGATIVE_TEXT, TOO_LONG, OK
    }

} //  end

