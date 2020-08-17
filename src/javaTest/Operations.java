package javaTest;


import java.math.BigInteger;
import java.util.List;

public class Operations {
    private final int r=10;
    private Operand operandOne;
    private Operand operandTwo;
    private String operations;
//конструктор класса
    public Operations(String expression) {

        String[] split;
        if (expression.contains("+"))
        {
            split = expression.split(" ");
            if (split.length==3) {
                this.operandOne = new Operand(split[0]);
                this.operandTwo = new Operand(split[2]);
                this.operations = split[1];
            }
        }else if (expression.contains("-")){
            split = expression.split(" ");
            if (split.length==3) {
                this.operandOne = new Operand(split[0]);
                this.operandTwo = new Operand(split[2]);
                this.operations = split[1];
            }
        }else if (expression.contains("*")){
            split = expression.split(" ");
            if (split.length==3) {
                this.operandOne = new Operand(split[0]);
                this.operandTwo = new Operand(split[2]);
                this.operations = split[1];
            }
        }else if (expression.contains("/")){
            split = expression.split(" ");
            if (split.length==3) {
                this.operandOne = new Operand(split[0]);
                this.operandTwo = new Operand(split[2]);
                this.operations = split[1];
            }
        }

    }

    /*
    * Выполнеине всех необходимых арифметических операций с числами
    * */
    public String    performOperations() throws Exception {
        BigInteger a;
        BigInteger b;
        if (checkNumbers()==0)
        {
            a =new BigInteger(operandOne.getOperands());
            b = new BigInteger(operandTwo.getOperands());
            if (operations.equals("+")){
                return a.add(b).toString();
            }if (operations.equals("-")){
                return a.subtract(b).toString();
            }if (operations.equals("*")){
                return a.multiply(b).toString();
            }if (operations.equals("/")){
                return a.divide(b).toString();
            }

            return String.valueOf(Integer.valueOf(a+operations+b));
        } else if (checkNumbers()==1)
        {
            a = new BigInteger(String.valueOf(romanToArabic(Roman.valueOf(operandOne.getOperands()).name()))) ;
            b = new BigInteger(String.valueOf(romanToArabic(Roman.valueOf(operandTwo.getOperands()).name()))) ;
            if (a.compareTo(BigInteger.valueOf(r))<=0&&b.compareTo(BigInteger.valueOf(r))<=0) {
                if (operations.equals("+")){
                    return arabicToRoman(Integer.parseInt(a.add(b).toString()));
                }
                if (operations.equals("-")){
                    return arabicToRoman(Integer.parseInt(a.subtract(b).toString()));
            }
                if (operations.equals("*")){
                    return arabicToRoman(Integer.parseInt(a.multiply(b).toString()));
                }
                if (operations.equals("/")){
                    return arabicToRoman(Integer.parseInt(a.divide(b).toString()));
                }
            } else {
                throw new Exception();
            }
        }
        throw new Exception();
    }
    private int checkNumbers(){
        if (this.operandOne.isIntegers()&& this.operandTwo.isIntegers()){
            return 0;
        }else
            if (this.operandTwo.isRoman() && this.operandOne.isRoman()){
            return 1;
        }
        else return -1;

    }
    /*
    Преобразование с арабсокй системы счисления в Римскую
    * */
    public static String arabicToRoman(int number) {
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " is not in range (0,4000]");
        }
        List<Roman> romanNumerals = Roman.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            Roman currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getNumber() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getNumber();
            } else {
                i++;
            }
        }

        return sb.toString();
    }

    /*
    * Преоблазование с римской системы счислеиня в арабскую
    * */
    public static int romanToArabic(String input) {
        String romanNumeral = input.toUpperCase();
        int result = 0;

        List<Roman> romanNumerals = Roman.getReverseSortedValues();

        int i = 0;

        while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
            Roman symbol = romanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getNumber();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (romanNumeral.length() > 0) {
            throw new IllegalArgumentException(input + " cannot be converted to a Roman Numeral");
        }

        return result;
    }

}

