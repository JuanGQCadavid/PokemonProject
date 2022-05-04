package com.projects.pokemon.commands;

public interface ICommand <T>{
    ICommand execute();
    T getResult();
}
