package ru.gik.springFrame.lesson1.camera;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.gik.springFrame.lesson1.cameraRoll.CameraRoll;

@Component("camera")
@Scope("prototype")// создает какждый раз новый объект
public class CameraImpl implements Camera {
    @Autowired
    @Qualifier("cameraRoll") //жестко задаем переменную для ситуаций когда может найте несколько
    private CameraRoll cameraRoll;

    @Value("false")
    private boolean broken;

    public void doPhotograph() {
        if (isBroken()) {
            System.out.println("camera is broken!");
            return;
        }
        System.out.println("click!");

    }

    @Autowired(required = false)
    //без задания привязки в файле xml или в Appconfig (required - не обязательное есле не найденно то игнор
    public void setCameraRoll(CameraRoll cameraRoll) {
        this.cameraRoll = cameraRoll;
    }

    public CameraRoll getCameraRoll() {
        return cameraRoll;
    }

    public void breaking() {
        this.broken = true;
    }

    public boolean isBroken() {
        return broken;
    }
}
