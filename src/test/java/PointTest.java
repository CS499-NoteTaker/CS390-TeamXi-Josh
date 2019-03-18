import GameLogic.Components.Point;
import org.junit.*;

public class PointTest {
    private Point p;
    @Before
    public void setUp(){
         p = new Point(1, 2);
    }

    @Test
    public void testCoordinates(){
        boolean cords = p.invalidCoordinates(-20, 20);
        Assert.assertTrue(cords);
    }

    @Test
    public void testCoordinates2(){
        boolean cords = p.invalidCoordinates(0, 19);
        Assert.assertFalse(cords);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testCreation(){
       Point po = new Point(-1, -2);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testCreation1(){
        Point poi = new Point(-1, 0);
    }

    @Test
    public void testIsOccupied(){
        Assert.assertFalse(p.isOccupied());
    }

    @Test
    public void testOccupation(){
        p.setOccupied();
        Assert.assertTrue(p.isOccupied());
    }

    @Test
    public void testOccupation2(){
        p.setOccupied(); //set to true
        p.setOccupied(); //set to false
        Assert.assertFalse(p.isOccupied());
    }

    @Test
    public void testGetX(){
        Assert.assertEquals(1, p.getX());
    }

    @Test
    public void testGetY(){
        Assert.assertEquals(2, p.getY());
    }

    @Test
    public void testSetY(){
        p.setY(3);
        Assert.assertEquals(3, p.getY());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testSetY1(){
        p.setY(-1);
    }

    @Test
    public void testSetX(){
        p.setX(4);
        Assert.assertEquals(4, p.getX());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testSetX1(){
        p.setX(-6);
    }


}
