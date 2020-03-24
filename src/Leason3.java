import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Leason3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = "Мама мыла раму! Я ходил. Кино было не очень интересное? Да совсем скуката.\n" +
                "ты пойдешь в кино? нет.\n" +
                "Шла Саша по шоше и сосала сущку. Это было не смешно! Хватит!\n";
        int op = 0;
        while (op != 4) {
            try {
                System.out.println("Выберите операцию: \n1. Отсортировать абзацы по количеству предложений;\n" +
                        "2. В каждом предложении отсортировать слова по длине;\n" +
                        "3. Отсортировать лексамы;\n4. Выйти из программы.");
                String operation = scanner.next();
                op = Integer.parseInt(operation);
                switch (op) {
                    case 1:sortAbzac(text);
                        break;
                    case 2:sortWords(text);
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Ошибка ввода!");
                }
            } catch (Exception ex) {
                System.out.println("Ошибка ввода!");
            }

        }
    }

    private static void sortAbzac(String text){
        int number=0;
        int number2=0;
        String[]  abzac=text.split("\\w*\\n");
        int i=0;
        while (i<abzac.length-1){
            Pattern pattern=Pattern.compile("[.!?]");
            Matcher matcher=pattern.matcher(abzac[i]);
            Matcher matcher2=pattern.matcher(abzac[i+1]);
            while (matcher.find()){
                number++;
            }
            while (matcher2.find()){
                number2++;
            }
            if (number>number2){
                String temp=abzac[i];
                abzac[i]=abzac[i+1];
                abzac[i+1]=temp;
                if (i>0) i--;
            }else i++;
        }
        System.out.println("-------------------------------------------------------------");
        for (String j:abzac){
            System.out.println(j);;
        }
        System.out.println("-------------------------------------------------------------");
    }

    private static void sortWords(String text){
        String[]  abzac=text.split("\\w*\\n");
        for (String i:abzac){
            String[] words= i.split("\\s*([\\s.,!?])\\s*");
            int j=0;
            while(j<words.length-1){
                if (words[j].length()>words[j+1].length()){
                    String temp=words[j];
                    words[j]=words[j+1];
                    words[j+1]=temp;
                    if (j>0) j--;
                }else j++;
            }
            for (String q:words) {
                System.out.print(q+" ");
            }
            System.out.println();;
        }

    }
}
