package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball ball = new Ball();
        Hare hare = new Hare();
        Wolf wolf = new Wolf();
        Fox fox = new Fox();
        hare.tryEat(ball);
        ball.escape(hare);
        wolf.tryEat(ball);
        ball.escape(wolf);
        fox.tryEat(ball);
        ball.died(fox);
    }
}
