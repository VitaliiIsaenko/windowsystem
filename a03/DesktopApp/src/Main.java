package com.company;

import java.awt.Color;

public class Main {

    public static void main(String[] args) {
        WindowSystem ws = new WindowSystem(600,600);

        WindowManager wm = new WindowManager(ws);
        wm.addSimpleWindow(500,200,"Window 1");
        wm.addSimpleWindow(400,200,"Window 2");
        wm.addSimpleWindow(200,200,"Window 3");


    }
}
