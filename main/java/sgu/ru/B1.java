package main.java.sgu.ru;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Scanner;

public class B1 {
  public static void main(String[] args) {
    System.out.println("\nДанная программа является простым калькулятором");
    System.out.println("\nДля завершения введите пустую строку");

    Scanner scanner = new Scanner(System.in);
    String[] params;
    Boolean go = true;

    while (go) {
      System.out.println("\nВведите параметры операции в виде: <a b operation>");
      System.out.println("Список допустимых операций: ADD, SUB, MUL, DIV, REM, POW");

      System.out.print("\n--> ");
      params = scanner.nextLine().split("\\s+");
      
      if (params[0].isEmpty()) {
        System.out.println("\nПрограмма прекращает свою работу");
        go = false;
        break;
      } else if (params.length != 3) {
        System.out.println("\nНеверное количество параметров! Введите заново!");
        continue;
      }

      try {
        BigInteger num1 = new BigInteger(params[0]);
        BigInteger num2 = new BigInteger(params[1]);
        String operator = params[2].toUpperCase();

        BigInteger result = execute(num1, num2, operator);
        System.out.println("\n<-- Результат операции: " + result.toString());
      } catch (NumberFormatException try_bigdecimal) {
        try {
          BigDecimal num1 = new BigDecimal(params[0]);
          BigDecimal num2 = new BigDecimal(params[1]);
          String operator = params[2].toUpperCase();

          BigDecimal result = execute(num1, num2, operator);
          System.out.println("\n<-- Результат операции: " + result.toString());
        } catch (ArithmeticException cant_execute) {
          System.out.println("\nНевозможно выполнить операцию!\n" + cant_execute.getMessage());
        } catch (NumberFormatException invalid_params) {
          System.out.println("\nНевозможно выполнить операцию!\n" + invalid_params.getMessage());
        }
      } catch (ArithmeticException cant_execute) {
        System.out.println("\nНевозможно выполнить операцию!\n" + cant_execute.getMessage());
      }
    }

    scanner.close();
  }

  private static BigDecimal fastPow(BigDecimal base, int pow) {
    if (base.compareTo(BigDecimal.ZERO) == 0 || base.compareTo(BigDecimal.ONE) == 0) {
      return base;
    } else if (pow == 0) {
      return BigDecimal.ONE;
    } else if (pow == 1) {
      return base;
    } else if (pow == -1) {
      return BigDecimal.ONE.divide(base, RoundingMode.HALF_EVEN);
    }

    BigDecimal multiplier = base;
    BigDecimal product = BigDecimal.ONE;
    int absPow = Math.abs(pow);

    while (absPow != 0) {
      while ((absPow & 1) == 0) {
        multiplier = multiplier.multiply(multiplier).setScale(13, RoundingMode.HALF_EVEN);
        absPow >>= 1;
      }
      product = product.multiply(multiplier).setScale(13, RoundingMode.HALF_EVEN);
      absPow -= 1;
    }

    return (pow < 0) ? BigDecimal.ONE.divide(product, RoundingMode.HALF_EVEN) : product;
  }

  private static BigInteger execute(BigInteger num1, BigInteger num2, String operator) {
    return switch (operator) {
      case "ADD" -> num1.add(num2);
      case "SUB" -> num1.subtract(num2);
      case "MUL" -> num1.multiply(num2);
      case "DIV" -> num1.divide(num2);
      case "REM" -> num1.remainder(num2);
      case "POW" -> {
        if (num2.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) <= 0) {
          yield num1.pow(num2.intValue());
        } else {
          throw new ArithmeticException("\nСтепень слишком велика");
        }
      }
      default -> throw new ArithmeticException("\nНеверный тип операции");
    };
  }

  private static BigDecimal execute(BigDecimal num1, BigDecimal num2, String operator) {
    return switch (operator) {
      case "ADD" -> num1.add(num2);
      case "SUB" -> num1.subtract(num2);
      case "MUL" -> num1.multiply(num2);
      case "DIV" -> num1.divide(num2);
      case "REM" -> num1.remainder(num2);
      case "POW" -> {
        if (num1.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0
            && num2.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0) {
          if (num2.compareTo(BigDecimal.valueOf(Integer.MAX_VALUE)) <= 0) {
            yield fastPow(num1, num2.intValue());
          } else {
            throw new ArithmeticException("\nСтепень слишком велика");
          }
        } else {
          throw new ArithmeticException("\nПараметры должны быть целочисленными");
        }
      }
      default -> throw new ArithmeticException("\nНеверный тип операции");
    };
  }
}