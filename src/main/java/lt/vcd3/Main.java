package lt.vcd3;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static int sumOfDigits(int x) {

        if (x == 0) {
            return 0;
        }

        return (x % 10) + sumOfDigits(x / 10);
    }

    public static void main(String[] args) {
        int number = 1342;

        System.out.println(sumOfDigits(number));
    }
}
