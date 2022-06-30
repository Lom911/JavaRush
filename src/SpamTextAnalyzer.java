public class SpamTextAnalyzer {
    public static void main(String[] args) {

    }

    /************************ TELO ***************************************/
    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {

        return Label.OK;
    }

    abstract class KeywordAnalyzer implements TextAnalyzer  {
       protected abstract String[] getKeywords();
       protected abstract Label getLabel();

        @Override
        public Label processText(String text) {
            String[] keywords = getKeywords();
            return Label.OK;
        }
    }

    class SpamAnalyzer extends KeywordAnalyzer {
        private String[] keywords;
        public SpamAnalyzer (String[] keywords){
            this.keywords = keywords;
        }

        @Override
        protected String[] getKeywords() {
            return new String[0];// смотри условие задачи (.var)
        }

        @Override
        protected Label getLabel() {
            return Label.SPAM;
        }
    }

    class NegativeTextAnalyzer extends KeywordAnalyzer {

    }
    class TooLongTextAnalyzer implements TextAnalyzer{
        private int maxLength;
        public TooLongTextAnalyzer (int maxLength){
            this.maxLength = maxLength;
        }

    }


    /*********************************************/
    interface TextAnalyzer {
        Label processText(String text);
    }

    enum Label {
        SPAM, NEGATIVE_TEXT, TOO_LONG, OK
    }

} //  end

