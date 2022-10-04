package src;

public class Stand extends BaseObject{
    private static int[][] matrix = {
            {1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
    };
    private double speed;
    private double direction;
    public Stand(double x, double y) {
        super(x, y, 3);
        this.speed = 1;
        this.direction = 0;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDirection() {
        return direction;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawMatrix(x - radius + 1, y, matrix, 'M');
    }

    @Override
    public void move() {
        x = direction*speed + x;

        checkBorders(radius, Arkanoid.game.getWidth() - radius + 1, 1, Arkanoid.game.getHeight() + 1);
    }

    public void moveLeft(){
        direction = -1;
    }
    public void moveRight(){
        direction = 1;
    }
}
