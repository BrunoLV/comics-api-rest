package com.valhala.comics.api.initializer;

import com.valhala.comics.api.config.ComicsAspectConfiguration;
import com.valhala.comics.api.config.ComicsCommonsConfiguration;
import com.valhala.comics.api.config.ComicsPersistenceConfiguration;
import com.valhala.comics.api.config.ComicsWebConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by bruno on 09/05/16.
 */
public class ComicsAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ComicsCommonsConfiguration.class, ComicsAspectConfiguration.class, ComicsPersistenceConfiguration.class, ComicsWebConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
