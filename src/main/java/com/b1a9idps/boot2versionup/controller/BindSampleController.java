package com.b1a9idps.boot2versionup.controller;

import java.util.List;

import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.b1a9idps.boot2versionup.binder.JsugPropsBeanBinder;
import com.b1a9idps.boot2versionup.binder.JsugPropsBinder;

@RestController
public class BindSampleController {

    private final Environment environment;
    private final JsugPropsBeanBinder jsugPropsBeanBinder;

    public BindSampleController(Environment environment, JsugPropsBeanBinder jsugPropsBeanBinder) {
        this.environment = environment;
        this.jsugPropsBeanBinder = jsugPropsBeanBinder;
    }

    @GetMapping("/bind-existing-bean")
    public JsugPropsBeanBinder bindExistingBean() {
        return Binder.get(environment)
                .bind("jsug.props-bean", Bindable.ofInstance(jsugPropsBeanBinder))
                .orElseThrow(IllegalStateException::new);
    }

    @GetMapping("/bind")
    public Integer bind() {
        return Binder.get(environment)
                .bind("jsug.props-simple", Bindable.of(Integer.class))
                .orElseThrow(IllegalStateException::new);
    }

    @GetMapping("/bind-listof")
    public List<JsugPropsBinder> bindListOf() {
        return Binder.get(environment)
                .bind("jsug.props", Bindable.listOf(JsugPropsBinder.class))
                .orElseThrow(IllegalStateException::new);
    }
}
