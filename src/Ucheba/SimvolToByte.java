package Ucheba;

public class SimvolToByte {
    public static void main(String[] args) throws Exception{
        int i=0;
        while (i<2){ //по хорошему тут нужно просто написать while (true)-будет бесконечный цикл,
            // но он выведет лишнюю информацию... т.е. число 10, помните вводить нужно заглавную "Ы"
            int byteIn = System.in.read();
            System.out.println(byteIn);
            i++;
            System.out.println( "A" + ('\t' + '\u0003') );

            System.out.println( "A" + 12 );

            System.out.println( 'A' + "12" );

            System.out.println( 'А' + '1' + "2" );
        }
    }
}
