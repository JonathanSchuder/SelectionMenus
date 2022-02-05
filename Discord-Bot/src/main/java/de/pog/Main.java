package de.pog;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static JDA shardMan;
    public static JDABuilder builder;
    public static String prefix = "!";

    public static void main(String[] args) throws LoginException {

        builder = JDABuilder.createDefault("Dein Token");

        builder.addEventListeners(new Command());
        builder.addEventListeners(new MakeSelection());

        shardMan = builder.build();

        System.out.println("[Bot] Online!");
    }
}
