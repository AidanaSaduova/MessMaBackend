import com.google.inject.AbstractModule;

import controllers.*;

public class Module extends AbstractModule {

    @Override
    protected void configure() {
        bind(AdminsApiControllerImpInterface.class).to(AdminsApiControllerImp.class);
        bind(DevelopersApiControllerImpInterface.class).to(DevelopersApiControllerImp.class);
    }
}