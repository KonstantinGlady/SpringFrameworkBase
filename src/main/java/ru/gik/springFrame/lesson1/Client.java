package ru.gik.springFrame.lesson1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gik.springFrame.lesson1.camera.Camera;

public class Client {
    public static void main(String[] args) {
       // ApplicationContext context = new ClassPathXmlApplicationContext("config.xml"); // настройки из файла xml
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);// или задаем настройки в классе
        Camera camera = context.getBean("camera", Camera.class);
        camera.doPhotograph();
        camera.breaking();
        camera = context.getBean("camera", Camera.class);// создаст по умолчанию singleton что бы разные объекты создавал добавим классу @Scope("prototype")
        camera.doPhotograph();
    }
}
