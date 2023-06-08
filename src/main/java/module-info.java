module KyoufuAllBK {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires jlayer;
    requires org.json;
    requires org.apache.commons.io;
    requires org.apache.httpcomponents.httpclient;
    requires org.apache.httpcomponents.httpcore;

    opens neodoggy.KyoufuAllBK to javafx.fxml;
    exports neodoggy.KyoufuAllBK;
}