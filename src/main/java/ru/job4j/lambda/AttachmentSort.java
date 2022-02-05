package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );
        Comparator cmpSize = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                return Integer.compare(left.getSize(), right.getSize());
            }
        };
        attachments.sort(cmpSize);
        System.out.println(attachments);

        Comparator cmpName = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                return left.getName().compareTo(right.getName());
            }
        };

        attachments.sort(cmpName);
        System.out.println(attachments);

        /**
         * Анонимные классы которые мы создали ранее можно переписать в лямбда выражение
         */
        Comparator<Attachment> cmpText = (left, right) -> right.getName().compareTo(left.getName());
        Comparator<Attachment> cmpDescSize = (left, right) -> Integer.compare(right.getSize(), left.getSize());
        attachments.sort(cmpDescSize);
        System.out.println(attachments);
        attachments.sort(cmpText);
        System.out.println(attachments);
    }
}