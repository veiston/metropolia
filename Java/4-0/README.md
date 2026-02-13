# 4.2 AI-assisted coding

## Program idea

This program is a simple calculator model that stores a running sum of positive integers. It supports reset, add, and reading the current value.

## Calculator class code

```java
public class Calculator {
    private int currentValue;

    /** Creates a calculator with value 0. */
    public Calculator() {
        reset();
    }

    /** Resets the calculator value to zero. */
    public void reset() {
        currentValue = 0;
    }

    /** Adds a positive integer to the current value. */
    public void add(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Negative integers are not allowed");
        }
        currentValue += number;
    }

    /** Returns the current calculator value. */
    public int getValue() {
        return currentValue;
    }
}
```

## How the class works

- `currentValue` stores the current sum.
- `reset()` sets the sum to `0`.
- `add(int number)` checks input; negative values throw `IllegalArgumentException`, positive values are added.
- `getValue()` returns the current sum.

## How GitHub Copilot was used

- I used Copilot to suggest method bodies and the first version of this explanation.
- I edited both code and text to keep them short, clear, and correct.

## README link in GitHub

https://github.com/veiston/metropolia/blob/main/Java/4-0/README.md
