package com.b1a9idps.boot2versionup.controller;

import java.util.List;

import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.b1a9idps.boot2versionup.binder.JsugProps;
import com.b1a9idps.boot2versionup.binder.JsugPropsBinder;

@RestController
public class BindSampleController {

    private final Environment environment;
    private final JsugProps jsugProps;

    public BindSampleController(Environment environment, JsugProps jsugProps) {
        this.environment = environment;
        this.jsugProps = jsugProps;
    }

    @GetMapping("/bind-instance")
    public JsugPropsBinder bindExistingBean() {
        JsugPropsBinder binder = new JsugPropsBinder();
        return Binder.get(environment)
                .bind("jsug.props-binder-simple", Bindable.ofInstance(binder))
                .orElseThrow(IllegalStateException::new);
    }

    @GetMapping("/bind")
    public JsugPropsBinder bind() {
        return Binder.get(environment)
                .bind("jsug.props-binder-simple", Bindable.of(JsugPropsBinder.class))
                .orElseThrow(IllegalStateException::new);
    }

    @GetMapping("/bind-listof")
    public List<JsugPropsBinder> bindListOf() {
        return Binder.get(environment)
                .bind("jsug.props-binder", Bindable.listOf(JsugPropsBinder.class))
                .orElseThrow(IllegalStateException::new);
    }

    @GetMapping("/merging-types")
    public JsugProps mergingTypes() {
        return jsugProps;
    }
}
