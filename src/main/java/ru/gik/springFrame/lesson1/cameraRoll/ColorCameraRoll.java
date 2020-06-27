package ru.gik.springFrame.lesson1.cameraRoll;

import org.springframework.stereotype.Component;

@Component("cameraRoll")
public class ColorCameraRoll implements CameraRoll {
    public void processing() {
        System.out.println("-1 click color");
    }
}
