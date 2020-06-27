package ru.gik.springFrame.lesson1.camera;

import ru.gik.springFrame.lesson1.cameraRoll.CameraRoll;

public interface Camera {
    void doPhotograph();

    void setCameraRoll(CameraRoll cameraRoll);

    CameraRoll getCameraRoll();

    void breaking();

    boolean isBroken();
}
