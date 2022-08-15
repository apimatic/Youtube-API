/*
 * YoutubeSearchLib
 *
 * This file was automatically generated by APIMATIC v3.0 ( https://www.apimatic.io ).
 */

package com.googleapis.www;

import com.googleapis.www.controllers.SimpleListSearchController;
import com.googleapis.www.http.client.HttpCallback;
import com.googleapis.www.http.client.HttpClient;
import com.googleapis.www.http.client.HttpClientConfiguration;
import com.googleapis.www.http.client.OkClient;
import com.googleapis.www.http.client.ReadonlyHttpClientConfiguration;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Gateway class for the library.
 * This class acts as a factory for Controllers.
 * It holds the state of the SDK.
 */
public final class YoutubeSearchClient implements Configuration {

    /**
     * Private store for controllers.
     */
    private SimpleListSearchController simpleListSearch;

    /**
     * Current API environment.
     */
    private final Environment environment;

    /**
     * The HTTP Client instance to use for making HTTP requests.
     */
    private final HttpClient httpClient;

    /**
     * Http Client Configuration instance.
     */
    private final ReadonlyHttpClientConfiguration httpClientConfig;

    /**
     * Map of authentication Managers.
     */
    private Map<String, AuthManager> authManagers;

    /**
     * Callback to be called before and after the HTTP call for an endpoint is made.
     */
    private final HttpCallback httpCallback;

    private YoutubeSearchClient(Environment environment, HttpClient httpClient,
            ReadonlyHttpClientConfiguration httpClientConfig, Map<String, AuthManager> authManagers,
            HttpCallback httpCallback) {
        this.environment = environment;
        this.httpClient = httpClient;
        this.httpClientConfig = httpClientConfig;
        this.httpCallback = httpCallback;

        this.authManagers = (authManagers == null) ? new HashMap<>() : new HashMap<>(authManagers);


        simpleListSearch = new SimpleListSearchController(this, this.httpClient, this.authManagers,
                this.httpCallback);
    }

    /**
     * Shutdown the underlying HttpClient instance.
     */
    public static void shutdown() {
        OkClient.shutdown();
    }

    /**
     * Get the instance of SimpleListSearchController.
     * @return simpleListSearch
     */
    public SimpleListSearchController getSimpleListSearchController() {
        return simpleListSearch;
    }

    /**
     * Current API environment.
     * @return environment
     */
    public Environment getEnvironment() {
        return environment;
    }

    /**
     * The HTTP Client instance to use for making HTTP requests.
     * @return httpClient
     */
    private HttpClient getHttpClient() {
        return httpClient;
    }

    /**
     * Http Client Configuration instance.
     * @return httpClientConfig
     */
    public ReadonlyHttpClientConfiguration getHttpClientConfig() {
        return httpClientConfig;
    }

    /**
     * The timeout to use for making HTTP requests.
     * @deprecated This method will be removed in a future version. Use
     *             {@link #getHttpClientConfig()} instead.
     *
     * @return timeout
     */
    @Deprecated
    public long timeout() {
        return httpClientConfig.getTimeout();
    }

    /**
     * Get base URI by current environment.
     * @param server Server for which to get the base URI
     * @return Processed base URI
     */
    public String getBaseUri(Server server) {
        Map<String, SimpleEntry<Object, Boolean>> parameters = new HashMap<>();
        StringBuilder baseUrl = new StringBuilder(environmentMapper(environment, server));
        ApiHelper.appendUrlWithTemplateParameters(baseUrl, parameters);
        return baseUrl.toString();
    }

    /**
     * Get base URI by current environment.
     * @return Processed base URI
     */
    public String getBaseUri() {
        return getBaseUri(Server.SERVER_1);
    }

    /**
     * Base URLs by environment and server aliases.
     * @param environment Environment for which to get the base URI
     * @param server Server for which to get the base URI
     * @return base URL
     */
    private static String environmentMapper(Environment environment, Server server) {
        if (environment.equals(Environment.PRODUCTION)) {
            if (server.equals(Server.SERVER_1)) {
                return "https://www.googleapis.com/youtube/v3";
            }
        }
        return "https://www.googleapis.com/youtube/v3";
    }

    /**
     * Converts this YoutubeSearchClient into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "YoutubeSearchClient [" + "environment=" + environment + ", httpClientConfig="
                + httpClientConfig + ", authManagers=" + authManagers + "]";
    }

    /**
     * Builds a new {@link YoutubeSearchClient.Builder} object.
     * Creates the instance with the state of the current client.
     * @return a new {@link YoutubeSearchClient.Builder} object
     */
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.environment = getEnvironment();
        builder.httpClient = getHttpClient();
        builder.authManagers = authManagers;
        builder.httpCallback = httpCallback;
        builder.httpClientConfig(configBldr -> configBldr =
                ((HttpClientConfiguration) httpClientConfig).newBuilder());
        return builder;
    }

    /**
     * Class to build instances of {@link YoutubeSearchClient}.
     */
    public static class Builder {

        private Environment environment = Environment.PRODUCTION;
        private HttpClient httpClient;
        private Map<String, AuthManager> authManagers = null;
        private HttpCallback httpCallback = null;
        private HttpClientConfiguration.Builder httpClientConfigBuilder =
                new HttpClientConfiguration.Builder();


        /**
         * Current API environment.
         * @param environment The environment for client.
         * @return Builder
         */
        public Builder environment(Environment environment) {
            this.environment = environment;
            return this;
        }

        /**
         * The timeout to use for making HTTP requests.
         * @deprecated This method will be removed in a future version. Use
         *             {@link #httpClientConfig(Consumer) httpClientConfig} instead.
         * @param timeout must be greater then 0.
         * @return Builder
         */
        @Deprecated
        public Builder timeout(long timeout) {
            this.httpClientConfigBuilder.timeout(timeout);
            return this;
        }

        /**
         * HttpCallback.
         * @param httpCallback Callback to be called before and after the HTTP call.
         * @return Builder
         */
        public Builder httpCallback(HttpCallback httpCallback) {
            this.httpCallback = httpCallback;
            return this;
        }

        /**
         * Setter for the Builder of httpClientConfiguration, takes in an operation to be performed
         * on the builder instance of HTTP client configuration.
         * 
         * @param action Consumer for the builder of httpClientConfiguration.
         * @return Builder
         */
        public Builder httpClientConfig(Consumer<HttpClientConfiguration.Builder> action) {
            action.accept(httpClientConfigBuilder);
            return this;
        }

        /**
         * Builds a new YoutubeSearchClient object using the set fields.
         * @return YoutubeSearchClient
         */
        public YoutubeSearchClient build() {
            HttpClientConfiguration httpClientConfig = httpClientConfigBuilder.build();
            httpClient = new OkClient(httpClientConfig);

            return new YoutubeSearchClient(environment, httpClient, httpClientConfig, authManagers,
                    httpCallback);
        }
    }
}