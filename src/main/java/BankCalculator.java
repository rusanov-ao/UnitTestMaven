

public class BankCalculator {


    public int pow(int a) {
        int result = a * a;
        return result;
    }

    public int abs(int a) {
        int result = a > 0 ? a : a * -1;
        return result;
    }

    public int procent(int a, int b) {
        int result = a / 100 * b;
        return result;
    }

    public int comparison(int a, int b) {
        int result;
        if (a > b) {
            result = 1;
        } else if (a < b) {
            result = -1;
        } else {
            result = 0;
        }
        return result;
    }

    public int divideAndPow(int a, int b) {
        int result = (a / b) * (a / b);
        return result;
    }


}