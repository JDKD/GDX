package com.jdkd.academy.utils.validators;

import com.badlogic.gdx.Gdx;
import com.jdkd.academy.world.AcademyFactory;

public class FileValidator {

    public static boolean doesFileExist(String name){
        return Gdx.files.internal(AcademyFactory.getInstance().getSaveFileName(name)).exists();
    }

}
