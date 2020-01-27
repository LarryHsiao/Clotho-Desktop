module atropos {
    requires javafx.controls;
    requires java.desktop;
    requires kotlin.stdlib;
    requires clotho;
    opens com.larryhsiao.clotho.desktop to org.testfx.junit5;
    exports com.larryhsiao.clotho.desktop;
}