package com.ivliev.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class Config {

    public Config() throws FileNotFoundException {
    }

    InputStream inputStream = new FileInputStream("config.properties");
    Properties prop = new Properties();

    public String loadMinPrice(String minPrice)throws IOException{
        prop.load(inputStream);
        return prop.getProperty(minPrice);
    }
    public String loadMaxPrice(String maxPrice)throws IOException{
        prop.load(inputStream);
        return prop.getProperty(maxPrice);
    }
    public String loadMinDiagonal(String minDiagonal)throws IOException{
        prop.load(inputStream);
        return prop.getProperty(minDiagonal);
    }
    public String loadMaxDiagonal(String maxDiagonal)throws IOException{
        prop.load(inputStream);
        return prop.getProperty(maxDiagonal);
    }
}

