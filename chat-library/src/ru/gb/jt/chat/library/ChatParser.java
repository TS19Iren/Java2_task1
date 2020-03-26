package ru.gb.jt.chat.library;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Обработчик команд из чата и перевод в человеческий вид
 */
public class ChatParser {
    public static String parseCommand(String msg) {
        if (msg.startsWith(Library.TYPE_BROADCAST)) {
            //блок рассылки
            return getBroadcastMsg(msg);
        }
        if (msg.startsWith(Library.AUTH_ACCEPT)) {
            return getAuthAcceptMsg(msg);
        }
        if(msg.startsWith(Library.AUTH_DENIED))
            return "Доступ запрещен";

        return msg;
    }

    private static String getAuthAcceptMsg(String sourceMsg) {
        String[] split = sourceMsg.replace(Library.AUTH_ACCEPT, "").split(Library.DELIMITER);
        return String.format("Вы вошли как %s", split[1]);
    }

    private static String getBroadcastMsg(String sourceMsg) {
        //±1585158008399±Server±ivan-igorevich connected
        String[] split = sourceMsg.replace(Library.TYPE_BROADCAST, "").split(Library.DELIMITER);
        String time = new SimpleDateFormat("dd.MM.yyyy HH:mm").format(new Date(Long.parseLong(split[1])));
        //System.out.println(split);
        String typeOfInformer = split[2];
        String brdctMsg = split[3];
        return String.format("Сообщение от %s в %s: %s", typeOfInformer, time, brdctMsg);
    }
}
