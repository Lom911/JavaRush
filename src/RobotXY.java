public class RobotXY {


        public static void main(String[] args) {
            Robot robot = new Robot(0,0, Direction.DOWN);
            moveRobot(robot, -3, -4);
        }

        public enum Direction {
            UP,
            DOWN,
            LEFT,
            RIGHT
        }

        public static class Robot {
            int x;
            int y;
            Direction dir;

            public Robot (int x, int y, Direction dir) {
                this.x = x;
                this.y = y;
                this.dir = dir;
            }

            public Direction getDirection() {return dir;}

            public int getX() {return x;}

            public int getY() {return y;}

            public void turnLeft() {
                if      (dir == Direction.UP)    {dir = Direction.LEFT;}
                else if (dir == Direction.DOWN)  {dir = Direction.RIGHT;}
                else if (dir == Direction.LEFT)  {dir = Direction.DOWN;}
                else if (dir == Direction.RIGHT) {dir = Direction.UP;}
            }

            public void turnRight() {
                if      (dir == Direction.UP)    {dir = Direction.RIGHT;}
                else if (dir == Direction.DOWN)  {dir = Direction.LEFT;}
                else if (dir == Direction.LEFT)  {dir = Direction.UP;}
                else if (dir == Direction.RIGHT) {dir = Direction.DOWN;}
            }

            public void stepForward() {
                if (dir == Direction.UP)    {y++;}
                if (dir == Direction.DOWN)  {y--;}
                if (dir == Direction.LEFT)  {x--;}
                if (dir == Direction.RIGHT) {x++;}
            }
        }


    public static void moveRobot(Robot robot, int toX, int toY) {
        int rezylX = toX - robot.getX();
        int rezulY = toY - robot.getY();


        if (rezylX >= 0) {
            if (robot.getDirection() == Direction.LEFT) {
                robot.turnRight();
                robot.turnRight();
            } else if (robot.getDirection() == Direction.UP) {
                robot.turnRight();
            } else if (robot.getDirection() == Direction.DOWN) {
                robot.turnLeft();
            }

        } else {
            if (robot.getDirection() == Direction.UP) {
                robot.turnLeft();
            } else if (robot.getDirection() == Direction.DOWN) {
                robot.turnRight();
            } else if (robot.getDirection() == Direction.RIGHT) {
                robot.turnRight();
                robot.turnRight();
            }

        }
        System.out.println(robot.getDirection());
        while (robot.getX() != toX) {
            robot.stepForward();
        }
        if ((rezylX >= 0 && rezulY <= 0)) {
            robot.turnRight();
        } else if ((rezylX >= 0 && rezulY >= 0)) {
            robot.turnLeft();
        } else if ((rezylX < 0 && rezulY <= 0)) {
            robot.turnLeft();
        } else {
            robot.turnRight();
        }
        while (robot.getY() != toY) {
            robot.stepForward();
        }
    }











    }
