package br.com.loja.relatorio.enuns;

import org.springframework.context.ApplicationContext;

public enum AppContext {

    INSTANCE;

    public static AppContext getInstance() {
        return INSTANCE;
    }

    private ApplicationContext applicationContext;

    @SuppressWarnings("squid:S3066")
    public void setContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    /**
     * @return
     */
    public ApplicationContext getContext() {
        return applicationContext;
    }
}
