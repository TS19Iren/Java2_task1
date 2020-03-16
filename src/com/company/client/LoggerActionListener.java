package com.company.client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerActionListener implements ActionListener {
    private final Path path;
    private LocalDateTime localDateTime;
    private JTextArea log;
    private JTextField text;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    private final String fileName = "textOutput.txt";
    private StringBuilder sb = new StringBuilder();

    public LoggerActionListener(JTextArea log1, JTextField text1) throws IOException {
        this.log = log1;
        this.text = text1;
        this.path = Paths.get(fileName);
        try {
            Files.createFile(path);
        } catch (FileAlreadyExistsException e) {
            System.out.println("Файл уже существует. Игнорируем ошибку");
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (!text.getText().isEmpty()) {
            String text = "You: " + this.text.getText() + "\n";
            this.log.append(text);
            try {
                this.logToFile(text);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        text.setText(""); //после отправки текста в чат очищаем строку для ввода
    }

    private void logToFile(String text) throws IOException {
        //записать текст в файл в формате :
        //[дд.мм.гггг чч:ММ:сс]: + текст
        text = getTimeForLogText() + text;
        Files.write(path, text.getBytes(), StandardOpenOption.APPEND);
    }


    /**
     * Получение строки в формате
     * [дд.мм.гггг чч:ММ:сс]:
     *
     * @return [дд.мм.гггг чч:ММ:сс]:
     */
    private String getTimeForLogText() {
        localDateTime = LocalDateTime.now();
        //предварительно очищаем текст внутри SB
        sb.setLength(0);
        sb.append("[").append(localDateTime.format(formatter)).append("]: ");
        return sb.toString();
    }
}
