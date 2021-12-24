
package com.reactlibrary;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.facebook.react.ReactPackage;
import com.facebook.react.TurboReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;

public class AlipayPackage extends TurboReactPackage implements ReactPackage {
    @Override
    public NativeModule getModule(String name, ReactApplicationContext reactContext) {
        switch (name) {
            case AlipayModule.NAME:
                return new AlipayModule(reactContext);
            default:
                throw new IllegalArgumentException("cannot find native module: " + name);
        }
    }

    @Override
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        Class<? extends NativeModule>[] moduleList = new Class[]{
            AlipayModule.class
        };

        final Map<String, ReactModuleInfo> reactModuleInfoMap = new HashMap<>();
        for (Class<? extends NativeModule> moduleClass : moduleList) {
            ReactModule reactModule = moduleClass.getAnnotation(ReactModule.class);

            reactModuleInfoMap.put(
                reactModule.name(),
                new ReactModuleInfo(
                    reactModule.name(),
                    moduleClass.getName(),
                    true,
                    reactModule.needsEagerInit(),
                    reactModule.hasConstants(),
                    reactModule.isCxxModule(),
                    TurboModule.class.isAssignableFrom(moduleClass)));
        }

        return () -> reactModuleInfoMap;
    }
}
