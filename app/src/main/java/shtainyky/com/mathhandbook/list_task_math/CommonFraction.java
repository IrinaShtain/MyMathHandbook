package shtainyky.com.mathhandbook.list_task_math;

public class CommonFraction {

    private int integerPart;
    private int numerator;
    private int denominator;

    public CommonFraction(int integerPart, int numerator, int denominator) {
        this.integerPart = integerPart;
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getIntegerPart() {
        return integerPart;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setIntegerPart(int integerPart) {
        this.integerPart = integerPart;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

     public static CommonFraction addingFractions(CommonFraction summandOne, CommonFraction summandTwo)
    {
        int commonDenominator = leastCommonDenominator(summandOne.getDenominator(), summandTwo.getDenominator());
        if (commonDenominator == 0)return null;
        int additionalMultiplier1 = commonDenominator/summandOne.getDenominator();
        int additionalMultiplier2 = commonDenominator/summandTwo.getDenominator();
        int newNumenator = additionalMultiplier1 * summandOne.getNumerator() + additionalMultiplier2 * summandTwo.getNumerator();
        int newIngegerPart = summandOne.getIntegerPart() + summandTwo.getIntegerPart();

        return wrightFraction(new CommonFraction(newIngegerPart, newNumenator, commonDenominator));
    }

    public static CommonFraction subtractingFractions (CommonFraction minuend, CommonFraction subtrahend){
        int commonDenominator = leastCommonDenominator(minuend.getDenominator(), subtrahend.getDenominator());
        if (commonDenominator == 0)return null;
        int additionalMultiplier1 = commonDenominator/minuend.getDenominator();
        int additionalMultiplier2 = commonDenominator/subtrahend.getDenominator();
        int minuendNumerator = additionalMultiplier1 * minuend.getNumerator();
        int subtrahendNumerator = additionalMultiplier2 * subtrahend.getNumerator();
        int newNumenator;
        int newIngegerPart;
        if (minuendNumerator > subtrahendNumerator) {
            newNumenator = minuendNumerator - subtrahendNumerator;
            newIngegerPart = minuend.getIntegerPart() - subtrahend.getIntegerPart();
        }
        else {
            if (minuend.getIntegerPart() - 1 >= subtrahend.getIntegerPart())
            {
                newNumenator = minuendNumerator + commonDenominator - subtrahendNumerator;
                newIngegerPart = minuend.getIntegerPart() - 1 - subtrahend.getIntegerPart();
            }
            else
            {
                newIngegerPart = -(subtrahend.getIntegerPart() - minuend.getIntegerPart());
                if (newIngegerPart == 0)
                    newNumenator =  -(subtrahendNumerator - minuendNumerator);
                else
                    newNumenator = subtrahendNumerator - minuendNumerator;
            }
        }
        return wrightFraction(new CommonFraction(newIngegerPart, newNumenator, commonDenominator));
    }

    public static CommonFraction multiplyingFractions (CommonFraction multiplierOne, CommonFraction multiplierTwo) {
        CommonFraction multOne, multTwo;
        multOne = wrongFraction(multiplierOne);
        multTwo = wrongFraction(multiplierTwo);
        int newNumenator = multOne.getNumerator() * multTwo.getNumerator();
        int newgDenominator = multOne.getDenominator() * multTwo.getDenominator();

     return wrightFraction(new CommonFraction(0, newNumenator, newgDenominator));
    }

    public static CommonFraction dividingFractions (CommonFraction dividend, CommonFraction divider)
    {
        CommonFraction multOne, multTwo;
        multOne = wrongFraction(dividend);
        multTwo = wrongFraction(divider);
        int newNumenator = multOne.getNumerator() * multTwo.getDenominator();
        int newgDenominator = multOne.getDenominator() * multTwo.getNumerator();

        return wrightFraction(new CommonFraction(0, newNumenator, newgDenominator));
    }

    private static int leastCommonDenominator(int oneNumber, int twoNumber)
    {
        if (oneNumber == 0 || twoNumber == 0)return 0;
        int res = 1;
        double var1 = (double) oneNumber/twoNumber;
        double var2 = (double)twoNumber/oneNumber;
        if (var1 % 1 == 0)
            return oneNumber;
        else
        if (var2 % 1 == 0)
            return twoNumber;
        else
        for (int i = 1; i < twoNumber ; i++) {
            res = i * oneNumber;
            if ((double)res/twoNumber % 1 == 0)
                return res;
        }
        return oneNumber*twoNumber;
    }
    public static CommonFraction wrightFraction(CommonFraction fractions)
    {
        int intPart = 0;
        int remainder = 0;
        if (fractions.getNumerator() == fractions.getDenominator()) {
            intPart = 1 + fractions.getIntegerPart();
            fractions.setIntegerPart(intPart);
            fractions.setNumerator(0);
            fractions.setDenominator(0);
        }

        if (fractions.getNumerator() > fractions.getDenominator())
        {
            intPart = fractions.getNumerator()/fractions.getDenominator();
            intPart = fractions.getIntegerPart() + intPart;
            fractions.setIntegerPart(intPart);
            remainder = fractions.getNumerator()%fractions.getDenominator();
            fractions.setNumerator(remainder);

        }
        return fractions;
    }
    public static CommonFraction wrongFraction(CommonFraction fractions)
    {
        int multOne = 1;
        if (fractions.getIntegerPart() != 0) {
            multOne = fractions.getIntegerPart() * fractions.getDenominator() + fractions.getNumerator();
            fractions.setNumerator(multOne);
            fractions.setIntegerPart(0);
        }
        return fractions;
    }
    public static CommonFraction reducingFraction(CommonFraction fractions)
    {
        int num = fractions.getNumerator();
        int den = fractions.getDenominator();
        if (num < den)
        {
            for (int i = num; i > 1 ; i--) {
                if ((num % i == 0)&&(den % i == 0))
                {
                    num = num / i;
                    den = den / i;
                    break;
                }
            }
        }
        else
        {
            for (int i = den; i > 1 ; i--) {
                if ((num % i == 0)&&(den % i == 0))
                {
                    num = num / i;
                    den = den / i;
                    break;
                }
            }
        }
        fractions.setNumerator(num);
        fractions.setDenominator(den);
        return wrightFraction(fractions);
    }
    public static String comparingFractions (CommonFraction fractionOne, CommonFraction fractionTwo)
    {
        CommonFraction fraction = subtractingFractions(fractionOne, fractionTwo);
        if ((fraction.getIntegerPart() == 0) &&(fraction.getNumerator() == 0))
            return "=";
        if (fraction.getIntegerPart() > 0) return ">";
        if (fraction.getIntegerPart() < 0) return "<";
        if ((fraction.getIntegerPart() == 0) &&(fraction.getNumerator() > 0)) return ">";
        if ((fraction.getIntegerPart() == 0) &&(fraction.getNumerator() < 0)) return "<";

      return ":)";
    }

}
