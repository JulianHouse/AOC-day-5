package org.example;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

public class Main {

    @Test
    public void part1() throws FileNotFoundException {
        List<Stack<String>> stackList = getStackList();
        readFileAndDecideWhichPopToExecute(false, stackList);

//Show top crates
        for (Stack<String> stringStack : stackList) {
            System.out.println(stringStack.peek());
        }
    }


    @Test
    public void part2() throws FileNotFoundException {
        List<Stack<String>> stackList = getStackList();
        readFileAndDecideWhichPopToExecute(true, stackList);

//Show top crates
        for (Stack<String> stringStack : stackList) {
            System.out.println(stringStack.peek());
        }
    }

    public void readFileAndDecideWhichPopToExecute(boolean executeReversePopstack, List<Stack<String>> stackList) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream("src/main/resources/input.txt");
        Scanner sc = new Scanner(inputStream);

        while (sc.hasNext()) {
            String str = sc.nextLine();
            String str2;
            String str3;
            String str4;

            str2 = str.replaceAll("move ", "");
            str3 = str2.replaceAll(" from ", "-");
            str4 = str3.replaceAll(" to ", "-");

            int move = Integer.parseInt(str4.split("-")[0]);
            int from = Integer.parseInt(str4.split("-")[1]);
            int to = Integer.parseInt(str4.split("-")[2]);

            if (executeReversePopstack) {
                reversePopStack(stackList, move, from, to);
            } else {
                popStack(stackList, move, from, to);
            }
        }
    }

    public void reversePopStack(List<Stack<String>> stackList, int move, int from, int to) {
        Stack<String> temporaryStack = new Stack<>();
        for (int i = 0; i < move; i++) {
            Stack<String> stringStackFrom = stackList.get(from - 1);
            String stringToBeMoved = stringStackFrom.pop();
            temporaryStack.push(stringToBeMoved);
        }
        for (int i = 0; i < move; i++) {
            String stringToBeMoved = temporaryStack.pop();
            Stack<String> stringStackTo = stackList.get(to - 1);
            stringStackTo.push(stringToBeMoved);
        }
    }

    public void popStack(List<Stack<String>> stackList, int move, int from, int to) {
        for (int i = 0; i < move; i++) {
            Stack<String> stringStackTo = stackList.get(to - 1);
            Stack<String> stringStackFrom = stackList.get(from - 1);
            String stringToBeMoved = stringStackFrom.pop();
            stringStackTo.push(stringToBeMoved);
        }
    }

    public Stack<String> stackFiller(String[] content) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < content.length; i++) {
            stack.push(content[i]);
        }
        return stack;
    }

    private List<Stack<String>> getStackList() {
        String[] content1 = {"B", "V", "S", "N", "T", "C", "H", "Q"};
        String[] content2 = {"W", "D", "B", "G"};
        String[] content3 = {"F", "W", "R", "T", "S", "Q", "B"};
        String[] content4 = {"L", "G", "W", "S", "Z", "J", "D", "N"};
        String[] content5 = {"M", "P", "D", "V", "F"};
        String[] content6 = {"F", "W", "J"};
        String[] content7 = {"L", "N", "Q", "B", "J", "V"};
        String[] content8 = {"G", "T", "R", "C", "J", "Q", "S", "N"};
        String[] content9 = {"J", "S", "Q", "C", "W", "D", "M"};

        List<Stack<String>> stackList = new ArrayList<>();

        stackList.add(stackFiller(content1));
        stackList.add(stackFiller(content2));
        stackList.add(stackFiller(content3));
        stackList.add(stackFiller(content4));
        stackList.add(stackFiller(content5));
        stackList.add(stackFiller(content6));
        stackList.add(stackFiller(content7));
        stackList.add(stackFiller(content8));
        stackList.add(stackFiller(content9));
        return stackList;

        Collections.frequency()

    }





}

