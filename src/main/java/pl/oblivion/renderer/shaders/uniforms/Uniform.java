package pl.oblivion.renderer.shaders.uniforms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.GL20;

public abstract class Uniform {

    private static final int NOT_FOUND = -1;
    private static Logger logger;
    private final String name;
    private int location;

    public Uniform(String name){
        this.name = name;
        logger = initLogger();
    }

    public void storeUniformLocation(int programId){
        this.location = GL20.glGetUniformLocation(programId,this.name);
        if(this.location == NOT_FOUND){
            logger.error("Couldn't find {} for {}",this.getClass(),this.name);
        }
    }
    private Logger initLogger(){
        return LogManager.getLogger(this.getClass().getName());
    }

    int getLocation(){
        return location;
    }
}
