package ru.job4j.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        JSONReport report = new JSONReport();
        String text = report.generate("name", "body");
        System.out.println(text);
        System.out.println();
        HtmlReport report2 = new HtmlReport();
        String text2 = report2.generate("name", "body");
        System.out.println(text2);
    }
}