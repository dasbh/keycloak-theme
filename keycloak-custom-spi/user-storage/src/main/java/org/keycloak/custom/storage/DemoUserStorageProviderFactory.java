package org.keycloak.custom.storage;

import org.jboss.logging.Logger;
import org.keycloak.Config;
import org.keycloak.component.ComponentModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.provider.ProviderConfigProperty;
import org.keycloak.provider.ProviderConfigurationBuilder;
import org.keycloak.storage.UserStorageProviderFactory;

import java.util.List;

public class DemoUserStorageProviderFactory implements UserStorageProviderFactory<DemoUserStorageProvider> {

    private static final Logger log = Logger.getLogger(DemoUserStorageProviderFactory.class);

    @Override
    public void init(Config.Scope config) {

        // this configuration is pulled from the SPI configuration of this provider in the standalone[-ha] / domain.xml
        // see setup.cli

        String someProperty = config.get("someProperty");
        log.infov("Configured {0} with someProperty: {1}", this, someProperty);
    }

    @Override
    public DemoUserStorageProvider create(KeycloakSession session, ComponentModel model) {
        // here you can setup the user storage provider, initiate some connections, etc.

        UserRepository repository = new UserRepository();

        return new DemoUserStorageProvider(session, model, repository);
    }

    @Override
    public String getId() {
        return "demo-user-provider";
    }

    @Override
    public List<ProviderConfigProperty> getConfigProperties() {

        // this configuration is configurable in the admin-console
        return ProviderConfigurationBuilder.create()
                .property()
                .name("myParam")
                .label("My Param")
                .helpText("Some Description")
                .type(ProviderConfigProperty.STRING_TYPE)
                .defaultValue("some value")
                .add()
                // more properties
                // .property()
                // .add()
                .build();
    }
}
