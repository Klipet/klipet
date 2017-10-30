package com.company;


import java.util.*;
import java.util.regex.Pattern;

public class SimpleBot {
    final String[] COMMON_PHRECEC = {
            "Привнт, что вас интересует.",
            "Вот и я товоже мнения.",
            "Приятно познакомится."};
    final String[] ELUSUVE_ANSWERS = {
            "Я не уверен что могу помочь!",
            "Я бот и не умею читать мысли.",
            "Данный запрос сложен для меня."
    };
    final Map<String, String> PATERNS_OF_ANALISYS = new HashMap<String, String>() {{
        //приветствие
        put("привет", "hello");
        put("здрасти", "hello");
        put("добрый день", "hello");
        //Кто
        put("что тебе надо", "whoo");
        // да
        put("да", "yes");
        put("согласен", "yes");
        // имя
        put("как зовут", "name");
        put("твоё имя", "name");
        put("кто ты", "name");
        put("есть имя", "name");
        // чем помочь
        put("помоги мне", "help");
        put("мне нужна помошь", "help");
        // дата
        put("какой день", "date");
        put("скока время", "date");
        put("какое число", "date");
        // пока
        put("удачи", "by");
        put("пока", "by");
        put("доскорых встреч", "by");
        // прикол расиста
        put("ты черный", "rasizm");
        put("ты белый", "rasizm");
        put("ты азиат", "rasizm");
        put("какой внешности", "you");
    }};
    final Map<String, String> ENSWER_BY_PATTENS = new HashMap<String, String>() {{
        put("hello", "Привет, что вас интересует.");
        put("whoo", "Я новая Машина по захвату Планеты Земля :)");
        put("yes", "И я тогоже мнения.");
        put("name", "Chatter");
        put("by", "Пока");
        put("help", "Сам решай свои проблемы");
        put("rasizm", "Я выше вах всех!!!");
        put("you", "Я могу быть кем угодно, но не тобой");
    }};
    Random rondom;
    Pattern pattern;
    Date date;

    SimpleBot() {
        rondom = new Random();
        date = new Date();
    }

    String sayInReturn(String gsm, boolean si) {
         String say = (gsm.trim().endsWith("?"))?
                 COMMON_PHRECEC [rondom.nextInt(COMMON_PHRECEC.length)]:
                 ELUSUVE_ANSWERS [rondom.nextInt(ELUSUVE_ANSWERS.length)];
        if (si) {
            String message =
                    String.join(" ", gsm.toLowerCase().split("[ { , | . } ? ] +"));
            // шаблон для анализа
            for (Map.Entry<String, String> o : PATERNS_OF_ANALISYS.entrySet()) {
                pattern = Pattern.compile(o.getKey());
                if (pattern.matcher(message).find())
                    if (o.getValue().equals("date")) return date.toString();
                    else return ENSWER_BY_PATTENS.get(o.getValue());
            }
        }
        return say;
    }
}



