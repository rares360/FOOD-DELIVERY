package dao;

import model.User;
import model.products.MenuItem;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileWrite {
    public FileWrite() {
    }
    public Set<MenuItem> importMenu(String file){
        Set<MenuItem> menuItemSet=new HashSet<>();
        try{
            Stream<String> stringStream= Files.lines(Paths.get("src\\" + file));
            menuItemSet=stringStream.skip(1)
                    .distinct().map(x->x.split(","))
                    .map(x->new MenuItem(x[0],Double.parseDouble(x[1]), Double.parseDouble(x[2]), Double.parseDouble(x[3]), Double.parseDouble(x[4]), Double.parseDouble(x[5]), Double.parseDouble(x[6])))
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return menuItemSet;
    }
}
