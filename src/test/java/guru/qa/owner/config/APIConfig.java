package guru.qa.owner.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:api.properties"})
public interface APIConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("baseUrl")
    String baseUrl();

    @Key("token")
    @DefaultValue("token")
    String token();
}

