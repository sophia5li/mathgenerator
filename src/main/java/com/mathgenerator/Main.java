package com.mathgenerator;

import com.mathgenerator.controller.GuessGameController;
import com.mathgenerator.controller.LoginController;
import com.mathgenerator.controller.MathQuestionController;
import com.mathgenerator.controller.QuestionGradeController;
import com.mathgenerator.dao.UserDAO;
import com.mathgenerator.module.User;
import io.dropwizard.Application;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

import java.util.Map;

public class Main extends Application<ApplicationConfiguration> {
    private final HibernateBundle<ApplicationConfiguration> hibernateBundle =
            new HibernateBundle<ApplicationConfiguration>(User.class) {
                @Override
                public PooledDataSourceFactory getDataSourceFactory(ApplicationConfiguration configuration) {
                    return configuration.getDataSourceFactory();
                }
            };

    public static void main(String[] args) throws Exception {
        new Main().run(args);
    }

    @Override
    public void run(ApplicationConfiguration configuration, Environment environment) throws Exception {
        environment.jersey().register(new LoginController(new UserDAO(hibernateBundle.getSessionFactory())));
        environment.jersey().register(new GuessGameController());
        environment.jersey().register(new MathQuestionController());
        environment.jersey().register(new QuestionGradeController());
        System.out.println(configuration.getName());
    }

    @Override
    public void initialize(Bootstrap<ApplicationConfiguration> bootstrap){
        bootstrap.addBundle(hibernateBundle);
        bootstrap.addBundle(new ViewBundle<ApplicationConfiguration>() {
            @Override
            public Map<String, Map<String, String>> getViewConfiguration(ApplicationConfiguration configuration){
                return configuration.getViewRendererConfiguration();
            }
        });
    }


}