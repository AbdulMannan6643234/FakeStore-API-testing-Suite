package dropdown;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import Base.BaseTests;
import pages.DropDown;
public class DropDownTest extends BaseTests {

    @Test
    public void testSelectOption(){
    DropDown dropdownpage = homepage.clickDropDown();
    String Option = "Option 1";
    dropdownpage.selectFromDropDown(Option);
    List<String> selectedOptions = dropdownpage.getSelectedOptions();
    assertEquals(selectedOptions.size(), 1, "Incorrect Number of Selections");
    assertTrue(selectedOptions.contains(Option), "Option not Selected");
}

}
