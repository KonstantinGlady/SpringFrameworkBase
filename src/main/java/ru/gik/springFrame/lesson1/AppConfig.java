package ru.gik.springFrame.lesson1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.gik.springFrame.lesson1.HelloMan.HelloMan;
import ru.gik.springFrame.lesson1.HelloMan.HelloManImplement;
import ru.gik.springFrame.lesson1.camera.Camera;
import ru.gik.springFrame.lesson1.camera.CameraImpl;
import ru.gik.springFrame.lesson1.cameraRoll.CameraRoll;
import ru.gik.springFrame.lesson1.cameraRoll.ColorCameraRoll;

@Configuration
@ComponentScan("ru.gik.springFrame.lesson1")
public class AppConfig {
    @Bean(name = "cameraRoll")
    public CameraRoll cameraRoll() {
        return new ColorCameraRoll();
    }

    @Bean(name = "camera")
    public Camera camera(CameraRoll cameraRoll) {
        Camera camera = new CameraImpl();
        camera.setCameraRoll(cameraRoll);
        return camera;
    }

    @Bean("helloMan")
    public HelloMan helloMan(@Value("Ivan") String name) {
        HelloMan helloMan = new HelloManImplement();
        return helloMan;
    }
}
