package ru.job4j.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.StringJoiner;

public class Console {
    private String status = "working";
    private List<String> answers;
    private File output;

    public Console(List<String> answers, File output) {
        this.answers = answers;
        this.output = output;
    }

    public void startChat()  {
        StringJoiner chat = new StringJoiner(System.lineSeparator());
        Scanner scanner = new Scanner(System.in);
        while (!status.equalsIgnoreCase("exit")) {
            System.out.println("Give me a question");
            String question = scanner.nextLine();
            chat.add("User " + question);
            if (!question.equalsIgnoreCase("exit")) {
                if (!question.equalsIgnoreCase("stop")) {
                    String botAnswer = phraseGenerator();
                    System.out.println(botAnswer);
                    chat.add("Bot " + botAnswer);
                } else {
                    System.out.println("If you want to talk say continue");
                    status = "stop";
                    while (!status.equalsIgnoreCase("working")) {
                        question = scanner.nextLine();
                        chat.add("User " + question);
                        if (question.equalsIgnoreCase("continue")) {
                            status = "working";
                        } else if (question.equalsIgnoreCase("exit")) {
                            status = "exit";
                            break;
                        }
                    }
                }
            } else {
                status = "exit";
                break;
            }
        }
        write(chat.toString());
    }

    public void write(String source) {
     try (BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
       writer.write(source);
     } catch (Exception e) {
         e.printStackTrace();
     }
    }

    public String phraseGenerator() {
        return answers.get(new Random().nextInt(answers.size()));
    }

    public static void main(String[] args) {
        File chat = new File("./chapter_002/src/main/resources/chat.txt");
        Console console = new Console(List.of("Hello", "I don`t know", "Maybe"), chat);
        console.startChat();
    }
}
