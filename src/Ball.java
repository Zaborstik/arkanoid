package src;

public class Ball extends BaseObject{
    private double speed;
    private double direction;
    private double dx;
    private double dy;
    private boolean isFrozen;

    public Ball(double dx, double dy, double speed, double direction) {
        super(dx, dy, 1);
        this.speed = speed;
        this.direction = direction;
        this.dx = dx;
        this.dy = dy;
        this.isFrozen = true;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDirection() {
        return direction;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setDirection(double direction) {
        this.direction = direction;
        double angle = Math.toRadians(direction);
        dx = Math.cos(angle)*speed;
        dy = -Math.sin(angle)*speed;
    }

    public void checkRebound(int minx, int maxx, int miny, int maxy){
        if (x < minx) {
            x = minx + (minx - x);
            dx = -dx;
        }

        if (x > maxx) {
            x = maxx - (x - maxx);
            dx = -dx;
        }

        if (y < miny) {
            y = miny + (miny - y);
            dy = -dy;
        }

        if (y > maxy) {
            y = maxy - (y - maxy);
            dy = -dy;
        }
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public void start(){
        this.setDirection(direction);
        this.isFrozen = false;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.setPoint(x, y, 'O');
    }

    @Override
    public void move() {
        if (!isFrozen){
            x = x+dx;
            y = y+dy;

            checkRebound(1, Arkanoid.game.getWidth(), 1, Arkanoid.game.getHeight() + 5);
        }
    }

}
