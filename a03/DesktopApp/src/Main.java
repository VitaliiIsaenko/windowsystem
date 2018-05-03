package com.company;

import java.awt.Color;

public class Main {

    public static void main(String[] args) {
        WindowSystem ws = new WindowSystem(600,600);

        WindowManager wm = new WindowManager(ws);
        wm.addSimpleWindow(200,200);
        wm.addSimpleWindow(200,200);
        wm.addSimpleWindow(200,200);

    }
}
