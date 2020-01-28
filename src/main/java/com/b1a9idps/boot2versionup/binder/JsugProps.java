package com.b1a9idps.boot2versionup.binder;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties("jsug.props")
@ConstructorBinding
public class JsugProps {

    private final List<Jsug> list;

    public List<Jsug> getList() {
        return list;
    }

    public JsugProps(List<Jsug> list) {
        this.list = list;
    }

    public static class Jsug {
        private String name;
        private String theme;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTheme() {
            return theme;
        }

        public void setTheme(String theme) {
            this.theme = theme;
        }
    }
}
