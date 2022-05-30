import java.util.Scanner;

class Main1 {

    public static void main(String[] args) throws Exception {

        System.out.println("ƒобро пожаловать в приложение  алькул€тор!\nƒл€ јрабской системы счислени€ введите через пробел значени€ от 1 до 10: \nƒл€ –имской системы счислени€ введите через пробел значени€ от I до X: ");
        Scanner sc = new Scanner(System.in);
        String number = calc(sc.nextLine());
        System.out.println(number);
    }

    public static String calc(String input) throws Exception {
        String[] separation = input.split(" ");
        String[] arab = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] rom = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "L", "C"};
        String[] operation = {"+", "-", "*", "/"};
        String Result = null;
        String resultRom1 = null;
        String resultRom10 = null;
        int arab1 = 0, arab2 = 0;
        int rom1 = 0, rom2 = 0;
        int num1 = 0, num2 = 0;
        int calculation = 0;
        boolean Roman = false;
        if (separation.length != 3) {
            throw new Exception("т.к. формат математической операции не удовлетвор€ет заданию - два операнда и один оператор (+, -, /, *)");
        }
        for (int a = 0; a < 10; a++) {
            if (true == arab[a].equals(separation[0])) {
                num1 = arab1 = a + 1;
                break;
            } else if (true != arab[a].equals(separation[0])) {
                if (a == 9) {
                    arab1 = 0;
                }
            }
        }
        for (int b = 0; b < 10; b++) {
            if (true == arab[b].equals(separation[2])) {
                num2 = arab2 = b + 1;
                break;
            } else if (true != arab[b].equals(separation[2])) {
                if (b == 9) {
                    arab2 = 0;
                }
            }
        }
        for (int r = 0; r < 10; r++) {
            if (true == rom[r].equals(separation[0])) {
                num1 = rom1 = r + 1;
                break;
            } else if (true != rom[r].equals(separation[0])) {
                if (r == 9) {
                    rom1 = 0;
                }
            }
        }
        for (int m = 0; m < 10; m++) {
            if (true == rom[m].equals(separation[2])) {
                num2 = rom2 = m + 1;
                break;
            } else if (true != rom[m].equals(separation[2])) {
                if (m == 9) {
                    rom2 = 0;
                }
            }
        }
        if (arab1 == 0) { // 2 + (VI)
            if (rom1 == 0) // --- VI
                throw new Exception("т.к. первое число введено не верно.");
            if (arab2 > 0)  // 6
                throw new Exception("т.к. используютс€ одновременно разные системы счислени€");
        }
        if (arab2 == 0) { // VII
            if (rom2 == 0) //
                throw new Exception("т.к. второе число введено не верно.");
            if (arab1 > 0) // 2 + VII
                throw new Exception("т.к. используютс€ одновременно разные системы счислени€");
        }
        if (rom1 > 0) { // если римска€ больше нул€, то
            if (rom2 > 0) {
                Roman = true;
            }
        }
        if (Roman != true) {
            num1 = arab1;
            num2 = arab2;
        } else {
            num1 = rom1;
            num2 = rom2;
        }
        switch (separation[1]) {
            case "+": calculation = num1 + num2;
                break;
            case "-": calculation = num1 - num2;
                break;
            case "*": calculation = num1 * num2;
                break;
            case "/": calculation = num1 / num2;
                break;
            default:
                throw new Exception("¬ведено неверное значение операции");
        }
        if (Roman == false) {
            Result = Integer.toString(calculation);
        } else {
            if (calculation < 1) {
                throw new Exception("¬ римской системе счислени€ не может быть значени€ меньше I");
            } else {
                if (calculation == 100) {
                    Result = rom[11];
                } else {
                    int R10 = calculation / 10;
                    switch (R10) {
                        case 1:
                            resultRom10 = "X";
                            break;
                        case 2:
                            resultRom10 = "XX";
                            break;
                        case 3:
                            resultRom10 = "XXX";
                            break;
                        case 4:
                            resultRom10 = "XL";
                            break;
                        case 5:
                            resultRom10 = "L";
                            break;
                        case 6:
                            resultRom10 = "LX";
                            break;
                        case 7:
                            resultRom10 = "LXX";
                            break;
                        case 8:
                            resultRom10 = "LXXX";
                            break;
                        case 9:
                            resultRom10 = "XC";
                            break;
                        default:
                            resultRom10 = "";
                            break;
                    }
                    int R1 = calculation % 10;
                    switch (R1) {
                        case 1:
                            resultRom1 = "I";
                            break;
                        case 2:
                            resultRom1 = "II";
                            break;
                        case 3:
                            resultRom1 = "III";
                            break;
                        case 4:
                            resultRom1 = "IL";
                            break;
                        case 5:
                            resultRom1 = "V";
                            break;
                        case 6:
                            resultRom1 = "VI";
                            break;
                        case 7:
                            resultRom1 = "VII";
                            break;
                        case 8:
                            resultRom1 = "VIII";
                            break;
                        case 9:
                            resultRom1 = "IX";
                            break;
                        default:
                            resultRom1 = "";
                            break;
                    }
                    Result = resultRom10 + resultRom1;
                }
            }
        } return Result;
    }
}