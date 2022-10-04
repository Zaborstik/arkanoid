package com.javarush.task.task24.task2413;

import java.util.List;

public class Arkanoid {
    private int width;
    private int height;
    private Ball ball;
    private Stand stand;
    private List<Brick> bricks;
    private boolean isGameOver;
    public static Arkanoid game;

    public Arkanoid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Ball getBall() {
        return ball;
    }

    public Stand getStand() {
        return stand;
    }

    public List<Brick> getBricks() {
        return bricks;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public void setStand(Stand stand) {
        this.stand = stand;
    }

    public void setBricks(List<Brick> bricks) {
        this.bricks = bricks;
    }

    public void run(){}

    public void checkBricksBump(){
        for (int i = 0; i < bricks.size(); i++) {
            if (bricks.get(i).intersects(ball)){
                ball.setDirection(Math.random()*360);
                bricks.remove(i);
                i--;
            }
        }
    }

    public void checkStandBump(){
        if (stand.intersects(ball)){
            ball.setDirection((Math.random()-0.5)*20+90);
        }
    }

    public void checkEndGame(){
        if (ball.y>height){
            isGameOver = true;
        }
    }

    public void move(){
        ball.move();
        stand.move();
    }

    public void draw(Canvas canvas){
        ball.draw(canvas);
        stand.draw(canvas);
        for (Brick brick:
             bricks) {
            brick.draw(canvas);
        }
    }

    public static void main(String[] args) {
    }
}
