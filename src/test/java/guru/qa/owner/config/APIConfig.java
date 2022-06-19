package guru.qa.owner.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:api.properties"})
public interface APIConfig extends Config {

    @Key("baseUri")
    String baseUri();

    @Key("token")
    String token();
}

