package com.valhala.comics.api.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.valhala.comics.api.config.ComicsCommonsConfiguration;
import com.valhala.comics.api.config.ComicsPersistenceConfiguration;
import com.valhala.comics.api.config.ComicsWebConfiguration;

public class ComicsAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { ComicsCommonsConfiguration.class, ComicsPersistenceConfiguration.class,
				ComicsWebConfiguration.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
