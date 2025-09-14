package HoverTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import Base.BaseTests;
public class hoverTest extends BaseTests {
    @Test
    public void TestHover(){
        var hoverpage = homepage.clickonHover();
        var Figurecaption = hoverpage.hoveroverfigure(1);
        assertTrue(Figurecaption.isCaptionDisplayed(), "Caption not displayed");
        assertEquals(Figurecaption.getTitle(), "name: user1","caption title incorrect");
        assertEquals(Figurecaption.getLinktext(),"View profile", "Caption Link Text Is Incorrect");
        assertTrue(Figurecaption.getlink().endsWith("/users/1"),"Link incorrect");
    }
}
