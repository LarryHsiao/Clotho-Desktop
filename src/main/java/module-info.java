module atropos {
    requires javafx.web;
    requires javafx.controls;
    requires java.desktop;
    requires kotlin.stdlib;
    requires clotho;
    opens com.larryhsiao.atropos to org.testfx.junit5;
    exports com.larryhsiao.atropos;
}